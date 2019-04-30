package com.cloud.configservice.service.impl;

import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.service.UrlMakerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UrlMakerServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/13 14:47
 */
@Service
public class UrlMakerServiceImpl implements UrlMakerService {
    private static Logger LOGGER = LoggerFactory.getLogger(UrlMakerServiceImpl.class);
    @Resource
    private EnvMapper envMapper;
    @Override
    public String configServerBaseUrl(String envName) {
        Env env = envMapper.selectEnvByName(envName);
        if (env.getRegistryAddress() == null || env.getRegistryAddress().isEmpty()) {
            LOGGER.debug("config server url : " + env.getConfigServerName());
            return env.getConfigServerName() + env.getContextPath();
        } else {
            LOGGER.error("Your env config use registry address, So you should use service discovery plugin and make sure property is not `sccs.config-server-url.enable=true`");
            throw new RuntimeException("Need use service discovery plugin");
        }
    }

    @Override
    public List<String> allConfigServerBaseUrl(String envName) {
        List<String> result = new ArrayList<>();
        result.add(configServerBaseUrl(envName));
        return result;
    }

    @Override
    public String propertiesLoadUrl(String application, String envName, String label) {
        // http://config-server/{application}/{environmentName}/{label}
        StringBuffer result = new StringBuffer();
        result.append(configServerBaseUrl(envName) + "/" + application + "/" + envName);
        if (label != null) {
            result.append("/" + label);
        }
        LOGGER.debug("propertiesLoadUrl : {}" ,result);
        return result.toString();
    }
}
