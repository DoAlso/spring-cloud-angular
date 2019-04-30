package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.EncryptKey;
import com.cloud.configservice.service.EncryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName EncryptKeyController
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/13 16:40
 */
@RestController
@RequestMapping("/encrypt")
public class EncryptKeyController {

    @Autowired
    private EncryptService encryptService;

    @GetMapping("/findAll")
    public ResponseEntity getEncryptKeys() throws Exception{
        return encryptService.getEncryptKeys();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getEncryptKey(@PathVariable("id") Long id) throws Exception{
        return encryptService.getEncryptKey(id);
    }

    @PostMapping("/add")
    public ResponseEntity addEncryptKey(@RequestBody EncryptKey encryptKey) throws Exception {
        return encryptService.addEncryptKey(encryptKey);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeEncryptKey(@PathVariable("id") Long id) throws Exception {
        return encryptService.removeEncryptKey(id);
    }

    @PutMapping("/modify")
    public ResponseEntity modifyEncryptKey(@RequestBody EncryptKey encryptKey) throws Exception {
        return encryptService.modifyEncryptKey(encryptKey);
    }
}
