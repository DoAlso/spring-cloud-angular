package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.EnvParam;
import com.cloud.configservice.service.EnvParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName EnvParamController
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 16:34
 */
@RestController
@RequestMapping("/envParam")
public class EnvParamController {

    @Autowired
    private EnvParamService envParamService;

    @GetMapping("/findAll/{id}")
    public ResponseEntity findAllEnvParam(@PathVariable("id") Long id) throws Exception{
        return envParamService.findAllEnvParamByEnvId(id);
    }

    @GetMapping("find/{id}")
    public ResponseEntity findEnvParam(@PathVariable("id") Long id) throws Exception {
        return envParamService.findEnvParamById(id);
    }

    @PostMapping("/add")
    public ResponseEntity addEnvParam(@RequestBody EnvParam envParam) throws Exception{
        return envParamService.addEnvParam(envParam);
    }

    @PutMapping("/modify")
    public ResponseEntity modifyEnvParam(@RequestBody EnvParam envParam) throws Exception {
        return envParamService.modifyEnvParam(envParam);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeEnvParam(@PathVariable("id") Long id) throws Exception {
        return envParamService.removeEnvParam(id);
    }
}
