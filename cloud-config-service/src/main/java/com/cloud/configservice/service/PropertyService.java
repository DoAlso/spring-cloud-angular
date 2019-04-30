package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;

import java.util.Properties;

public interface PropertyService {

    ResponseEntity properTiesFromPersistent(String project, String profile, String label) throws Exception;


    ResponseEntity saveProperties(String project, String profile, String label, Properties properties) throws Exception;


    ResponseEntity propertiesFromConfigServer(String project, String profile, String label) throws Exception;


    ResponseEntity encrypt(Long envId, String value) throws Exception;


    ResponseEntity decrypt(Long envId, String value) throws Exception;
}
