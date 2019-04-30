package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.service.EnvService;
import com.cloud.configservice.vo.EnvVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/env")
public class EnvController {

    @Autowired
    private EnvService envService;

    @GetMapping("/findAll")
    public ResponseEntity findAllEnv() throws Exception{
        return envService.getEnvs();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findEnv(@PathVariable("id") Long id) throws Exception{
        return envService.getEnv(id);
    }

    @PostMapping("/add")
    public ResponseEntity addEnv(@RequestBody EnvVO envVO) throws Exception{
        Env env = new Env();
        BeanUtils.copyProperties(envVO,env);
        return envService.addEnv(env);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeEnv(@PathVariable("id") Long id) throws Exception{
        return envService.removeEnv(id);
    }

    @PutMapping("/modify")
    public ResponseEntity modifyEnv(@RequestBody EnvVO envVO) throws Exception{
        Env env = new Env();
        BeanUtils.copyProperties(envVO,env);
        return envService.modifyEnv(env);
    }

    @GetMapping("/findLinkName")
    public ResponseEntity findEnvsLikeName(@RequestParam("name") String name) throws Exception {
        return envService.findEnvsLikeName(name);
    }
}
