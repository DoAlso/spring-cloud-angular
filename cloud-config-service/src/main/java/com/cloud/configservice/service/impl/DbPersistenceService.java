package com.cloud.configservice.service.impl;

import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.dao.LabelMapper;
import com.cloud.configservice.dao.ProjectMapper;
import com.cloud.configservice.dao.PropertyMapper;
import com.cloud.configservice.model.*;
import com.cloud.configservice.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;

/**
 * Created by 程序猿DD/翟永超 on 2018/4/24.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
public class DbPersistenceService implements PersistenceService {
    private static Logger log = LoggerFactory.getLogger(DbPersistenceService.class);

    @Autowired
    private PropertyMapper propertyMapper;
    @Autowired
    private EnvMapper envMapper;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public Properties readProperties(String application, String profile, String label) {
        // 查询要保存配置的坐标
        Properties properties = new Properties();
        for (Property property : propertyMapper.selectPropertyByNames(application, profile, label)) {
            properties.put(property.getpKey(), property.getpValue());
        }
        return properties;
    }

    @Override
    public void deletePropertiesByEnv(Env env) {
        // 删除某个环境下的所有配置
        PropertyExample example = new PropertyExample();
        PropertyExample.Criteria criteria = example.createCriteria();
        criteria.andEnvIdEqualTo(env.getId());
        int rows = propertyMapper.deleteByExample(example);
        log.info("delete env [{}] property rows {}",env.getName() , rows);
    }

    @Override
    public void deletePropertiesByProject(Project project) {
        PropertyExample example = new PropertyExample();
        PropertyExample.Criteria criteria = example.createCriteria();
        criteria.andProjectIdEqualTo(project.getId());
        int rows = propertyMapper.deleteByExample(example);
        log.info("delete project [{}] property rows {}", project.getName(), rows);
    }

    @Override
    public void deletePropertiesByProjectAndEnv(Project project, Env env) {
        PropertyExample example = new PropertyExample();
        PropertyExample.Criteria criteria = example.createCriteria();
        criteria.andEnvIdEqualTo(env.getId());
        criteria.andProjectIdEqualTo(project.getId());
        int rows = propertyMapper.deleteByExample(example);
        log.info("delete project [{}] in env [{}] property rows {}", project.getName(), env.getName(), rows);
    }

    @Override
    public void deletePropertiesByLabel(Label label) {
        PropertyExample example = new PropertyExample();
        PropertyExample.Criteria criteria = example.createCriteria();
        criteria.andLabelIdEqualTo(label.getId());
        int rows = propertyMapper.deleteByExample(example);
        log.info("delete label [{}] property rows {}", label.getName(), rows);
    }

    @Override
    @Transactional
    public void deleteProperties(String application, String profile, String label) {
        // 1. 删除原来的配置
        int rows = propertyMapper.deletePropertyByNames(application, profile, label);
        log.info("delete {}-{}-{} property rows {}", application, profile, label, rows);
    }

    @Override
    @Transactional
    public void saveProperties(String application, String profile, String label, Properties update) {
        // 查询要保存配置的坐标
        Env e = envMapper.selectEnvByName(profile);
        Project p = projectMapper.selectProjectByName(application);
        Label l = labelMapper.selectLabelByNameAndProjectId(label, p.getId());
        // 1. 删除原来的配置
        int rows = propertyMapper.deletePropertyByNames(application, profile, label);
        log.info("delete {}-{}-{} property rows {}", application, profile, label, rows);
        // 2. 保存新的配置
        for (String name : update.stringPropertyNames()) {
            Property property = new Property();
            property.setpKey(name);
            property.setpValue(update.getProperty(name));
            property.setEnvId(e.getId());
            property.setProjectId(p.getId());
            property.setLabelId(l.getId());
            propertyMapper.insertSelective(property);
        }
        log.info("add {}-{}-{} rows {}", application, profile, label, update.size());
    }

    @Override
    public void updateProfileName(String oldName, String newName) {
        // do nothing
    }

}
