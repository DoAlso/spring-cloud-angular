package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.event.PropertyChangeEvent;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.service.BaseOptService;
import com.cloud.configservice.service.PersistenceService;
import com.cloud.configservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @ClassName PropertyServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/22 16:57
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private ApplicationContext applicationContext;
    @Resource
    private PersistenceService persistenceService;
    @Resource
    private BaseOptService baseOptService;
    @Resource
    private EnvMapper envMapper;

    @Override
    public ResponseEntity properTiesFromPersistent(String project, String profile, String label) throws Exception {
        Properties properties = persistenceService.readProperties(project, profile, label);
        return ResponseEntity.success("success",properties);
    }

    @Override
    public ResponseEntity saveProperties(String project, String profile, String label, Properties properties) throws Exception {
        persistenceService.saveProperties(project, profile, label, properties);
        applicationContext.publishEvent(new PropertyChangeEvent(this,profile));
        return ResponseEntity.success("save properties success");
    }

    @Override
    public ResponseEntity propertiesFromConfigServer(String project, String profile, String label) throws Exception {
        Environment environment = baseOptService.getProperties(project, profile, label);
        return ResponseEntity.success("success",environment);
    }

    @Override
    public ResponseEntity encrypt(Long envId, String value) throws Exception {
        Env env = envMapper.selectByPrimaryKey(envId);
        String result = baseOptService.encrypt(value,env);
        return ResponseEntity.success("success",result);
    }

    @Override
    public ResponseEntity decrypt(Long envId, String value) throws Exception {
        Env env = envMapper.selectByPrimaryKey(envId);
        String result = baseOptService.decrypt(value,env);
        return ResponseEntity.success("success",result);
    }
}
