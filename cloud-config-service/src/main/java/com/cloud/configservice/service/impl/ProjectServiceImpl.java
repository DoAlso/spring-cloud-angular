package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ConfigCoreProperties;
import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.dao.LabelMapper;
import com.cloud.configservice.dao.ProjectEnvsMapper;
import com.cloud.configservice.dao.ProjectMapper;
import com.cloud.configservice.dto.ProjectDTO;
import com.cloud.configservice.model.*;
import com.cloud.configservice.service.PersistenceService;
import com.cloud.configservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/21 14:21
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectMapper projectMapper;
    @Autowired
    private ConfigCoreProperties properties;
    @Resource
    private ProjectEnvsMapper projectEnvsMapper;
    @Resource
    private PersistenceService persistenceService;
    @Resource
    private LabelMapper labelMapper;
    @Resource
    private EnvMapper envMapper;

    @Override
    public ResponseEntity findAllProject() throws Exception {
        List<ProjectDTO> projectDTOS = projectMapper.selectAllProject();
        return ResponseEntity.success("success",projectDTOS);
    }

    @Override
    public ResponseEntity findProject(Long id) throws Exception {
        ProjectDTO projectDTO = projectMapper.selectProjectById(id);
        return ResponseEntity.success("success",projectDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity addProject(Project project, List<Long> envIds) {
        Project pro = projectMapper.selectProjectByName(project.getName());
        //如果当前名称的项目已存在，则聚合数据
        if(pro != null){
            setProjectData(pro,envIds);
        }else {
            projectMapper.insertSelective(project);
            setProjectData(project,envIds);
        }
        return ResponseEntity.success("Add Project Success");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity removeProject(Long id) throws Exception {
        Project project = projectMapper.selectByPrimaryKey(id);
        // 级联删除配置版本的数据与实际配置存储
        persistenceService.deletePropertiesByProject(project);
        //删除项目的标签
        LabelExample example = new LabelExample();
        LabelExample.Criteria criteria = example.createCriteria();
        criteria.andProjectIdEqualTo(id);
        labelMapper.deleteByExample(example);
        //删除项目与环境的关系
        ProjectEnvsExample envsExample = new ProjectEnvsExample();
        ProjectEnvsExample.Criteria criteria1 = envsExample.createCriteria();
        criteria1.andProjectsIdEqualTo(id);
        projectEnvsMapper.deleteByExample(envsExample);
        //删除项目
        projectMapper.deleteByPrimaryKey(id);
        return ResponseEntity.success("Delete Project Success");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity modifyProject(Project project, List<Long> envIds) throws Exception {
        //先查询当前项目下所绑定的环境ID
        List<Long> oldEnvIds = projectEnvsMapper.selectEnvIdsByProjectId(project.getId());
        //取出已有环境和更新环境取交集之后的差集
        List<Long> _oldEnvIds = new ArrayList<>();
        oldEnvIds.forEach((item)-> _oldEnvIds.add(item));
        oldEnvIds.retainAll(envIds);
        _oldEnvIds.removeAll(oldEnvIds);
        //查询出差集的环境并删除该环境的所有配置数据
        if(!_oldEnvIds.isEmpty()) {
            EnvExample envExample = new EnvExample();
            EnvExample.Criteria criteria1 = envExample.createCriteria();
            criteria1.andIdIn(_oldEnvIds);
            List<Env> removeEnvs = envMapper.selectByExample(envExample);
            for (Env env : removeEnvs) {
                persistenceService.deletePropertiesByProjectAndEnv(project, env);
            }
        }
        //更新项目的信息
        projectMapper.updateByPrimaryKeySelective(project);
        //更新项目与环境的关系，逻辑是：先删除关联在创建关联
        ProjectEnvsExample envsExample = new ProjectEnvsExample();
        ProjectEnvsExample.Criteria criteria = envsExample.createCriteria();
        criteria.andProjectsIdEqualTo(project.getId());
        projectEnvsMapper.deleteByExample(envsExample);
        List<ProjectEnvs> list = new ArrayList<>();
        envIds.forEach(item->{
            ProjectEnvs projectEnvs = new ProjectEnvs();
            projectEnvs.setProjectsId(project.getId());
            projectEnvs.setEnvsId(item);
            list.add(projectEnvs);
        });
        projectEnvsMapper.batchInsert(list);
        return ResponseEntity.success("Update Project Success");
    }


    @Override
    public ResponseEntity addProjectLabel(Long id, String LabelName) throws Exception {
        Label label = new Label();
        label.setProjectId(id);
        label.setName(LabelName);
        labelMapper.insertSelective(label);
        return ResponseEntity.success("success",label);
    }

    private void setProjectData(Project project, List<Long> envIds){
        List<ProjectEnvs> list = new ArrayList<>();
        envIds.forEach(item->{
            ProjectEnvs projectEnvs = new ProjectEnvs();
            projectEnvs.setEnvsId(item);
            projectEnvs.setProjectsId(project.getId());
            list.add(projectEnvs);
        });
        //执行项目环境关联表的数据插入
        projectEnvsMapper.batchInsert(list);
        // 关联默认版本（label）
        Label label = new Label();
        label.setName(properties.getDefaultLabel());
        label.setProjectId(project.getId());
        labelMapper.insertSelective(label);
    }
}
