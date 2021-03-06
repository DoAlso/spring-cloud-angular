package com.cloud.configservice.service.impl;


import com.cloud.configservice.common.ConfigGitProperties;
import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.dao.LabelMapper;
import com.cloud.configservice.dao.ProjectMapper;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.model.Label;
import com.cloud.configservice.model.Project;
import com.cloud.configservice.service.PersistenceService;
import com.didispace.easyutils.cmd.CmdRunner;
import com.didispace.easyutils.file.FileUtils;
import com.didispace.easyutils.file.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by 程序猿DD/翟永超 on 2018/4/24.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public class GitPersistenceService implements PersistenceService {

    private static Logger log = LoggerFactory.getLogger(GitPersistenceService.class);

    @Autowired
    private ConfigGitProperties gitProperties;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private LabelMapper labelMapper;
    @Autowired
    private EnvMapper envMapper;

    @Override
    public Properties readProperties(String application, String profile, String label) {
        // 访问Git上的存储的配置内容
        ProjectInfo projectInfo = new ProjectInfo(application, profile, label, this.gitProperties);
        Properties properties = null;
        try {
            // git clone properites from git
            CmdRunner.execute("git clone " + projectInfo.getProjectUrl() + " " + projectInfo.getDir());
            // git checkout branch(label)
            CmdRunner.execute("git checkout " + label, new File(projectInfo.getDir()));
            // load propertiesFile content
            properties = PropertiesUtils.loadProperties(projectInfo.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteDirectory(new File(projectInfo.getDir()));
        }
        return properties;
    }

    @Override
    public void deletePropertiesByEnv(Env env) {
        List<Project> projects = projectMapper.findProjectByEnvId(env.getId());
        for (Project project : projects) {
            List<Label> labels = labelMapper.selectLabelByProjectId(project.getId());
            for (Label label : labels) {
                // 删除单个配置文件
                deleteProperties(project.getName(), env.getName(), label.getName());
            }
        }
    }

    @Override
    public void deletePropertiesByProject(Project project) {
        List<Env> envs = envMapper.selectEnvByProjectId(project.getId());
        List<Label> labels = labelMapper.selectLabelByProjectId(project.getId());
        for (Env env : envs) {
            for (Label label : labels) {
                // 删除单个配置文件
                deleteProperties(project.getName(), env.getName(), label.getName());
            }
        }
    }

    @Override
    public void deletePropertiesByProjectAndEnv(Project project, Env env) {
        List<Label> labels = labelMapper.selectLabelByProjectId(project.getId());
        for (Label label : labels) {
            deleteProperties(project.getName(), env.getName(), label.getName());
        }
    }

    @Override
    public void deletePropertiesByLabel(Label label) {
        String projectName = projectMapper.selectByPrimaryKey(label.getProjectId()).getName();
        List<Env> envs = envMapper.selectEnvByProjectId(label.getProjectId());
        for (Env env : envs) {
            // 删除单个配置文件
            deleteProperties(projectName, env.getName(), label.getName());
        }
    }

    @Override
    public void deleteProperties(String application, String profile, String label) {
        log.info("delete properties git : {}, {}, {}", application, profile, label);
        // 删除某个配置文件
        ProjectInfo projectInfo = new ProjectInfo(application, profile, label, this.gitProperties);
        try {
            // git clone properites from git
            CmdRunner.execute("git clone " + projectInfo.getProjectUrl() + " " + projectInfo.getDir());

            // git checkout branch(label)
            CmdRunner.execute("git checkout " + label, new File(projectInfo.getDir()));

            // delete propertiesFile
            File file = new File(projectInfo.getPath());
            if (file.exists()) {
                file.delete();
                log.info("delete file : " + file.getAbsolutePath());
            } else {
                log.error("delete file not exist: " + projectInfo.getPath());
            }

            // commit & push
            CmdRunner.execute("git add .", new File(projectInfo.getDir()));
            CmdRunner.execute("git commit -m 'update'", new File(projectInfo.getDir()));
            CmdRunner.execute("git push", new File(projectInfo.getDir()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteDirectory(new File(projectInfo.getDir()));
        }

    }


    @Override
    public void saveProperties(String application, String profile, String label, Properties update) {
        // TODO 文件不存在的时候，自动创建
        ProjectInfo projectInfo = new ProjectInfo(application, profile, label, this.gitProperties);
        try {
            // git clone properites from git
            CmdRunner.execute("git clone " + projectInfo.getProjectUrl() + " " + projectInfo.getDir());

            // git checkout branch(label)
            CmdRunner.execute("git checkout " + label, new File(projectInfo.getDir()));

            // read propertiesFile before upddate, write properties, read propertiesFile after update
            log.debug("---------------- properties before update ----------------");
            PropertiesUtils.printProperties(projectInfo.getPath(), true);
            log.debug("---------------- properties after update ----------------");
            PropertiesUtils.printProperties(update, true);

            // store update properties
            PropertiesUtils.store(update, projectInfo.getPath(), "Write by scca, more information see : https://github.com/dyc87112/spring-cloud-config-admin");

            // commit & push
            CmdRunner.execute("git add .", new File(projectInfo.getDir()));
            CmdRunner.execute("git commit -m 'update'", new File(projectInfo.getDir()));
            CmdRunner.execute("git push", new File(projectInfo.getDir()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.deleteDirectory(new File(projectInfo.getDir()));
        }

    }

    @Override
    public void updateProfileName(String oldName, String newName) {
        // TODO 管理端修改环境名的时候，git存储需求修改存储的配置文件位置或者文件名

    }


    /**
     * 用来处理Git配置项目相关的信息
     */
    class ProjectInfo {
        /**
         * git clone的url
         */
        private String projectUrl;
        /**
         * 本地临时目录名
         */
        private String dir;
        /**
         * 要访问的文件相对路径
         */
        private String path;

        public ProjectInfo(String application, String profile, String label, ConfigGitProperties gitProperties) {
            // 组织配置项目的git地址
            this.projectUrl = gitProperties.getRepoUri().replaceFirst("\\{application\\}", application);
            String propertiesFile = gitProperties.getFilePattern()
                    .replaceFirst("\\{application\\}", application)
                    .replaceFirst("\\{profile\\}", profile);

            // 生成本地拉取配置用来修改使用的唯一目录名
            this.dir = UUID.randomUUID().toString();
            // 获取要修改文件的相对路径
            this.path = this.dir + gitProperties.getBasePath() + "/" + propertiesFile;
            log.debug("update file : " + this.path);

            // projectUrl append username & password， git clone projectUrl
            this.projectUrl = this.projectUrl.replaceFirst("http://", "http://" + gitProperties.getUsername() + ":" + gitProperties.getPassword() + "@");
            log.debug("project url : " + this.projectUrl);
        }

        public String getProjectUrl() {
            return projectUrl;
        }

        public void setProjectUrl(String projectUrl) {
            this.projectUrl = projectUrl;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
