package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

/**
 * @ClassName PropertyController
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/22 17:28
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/persistent")
    public ResponseEntity propertiesFromPersistent(String project, String profile, String label) throws Exception {
        return propertyService.properTiesFromPersistent(project, profile, label);
    }

    @PostMapping("/persistent")
    public ResponseEntity saveProperties(@RequestParam("project") String project, @RequestParam("profile") String profile, @RequestParam("label") String label, @RequestBody Properties properties) throws Exception {
        return propertyService.saveProperties(project, profile, label,properties);
    }

    @PostMapping("/encrypt")
    public ResponseEntity encrypt(@RequestParam("envId") Long envId, @RequestBody String value) throws Exception {
        return propertyService.encrypt(envId,value);
    }

    @PostMapping("/decrypt")
    public ResponseEntity decrypt(@RequestParam("envId") Long envId, @RequestBody String value) throws Exception {
        return propertyService.decrypt(envId,value);
    }
}
