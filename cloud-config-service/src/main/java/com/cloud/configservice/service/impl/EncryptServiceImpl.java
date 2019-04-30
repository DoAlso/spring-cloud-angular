package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EncryptKeyMapper;
import com.cloud.configservice.model.EncryptKey;
import com.cloud.configservice.service.EncryptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EncryptServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/13 16:47
 */
@Service
public class EncryptServiceImpl implements EncryptService {
    @Resource
    private EncryptKeyMapper encryptKeyMapper;

    @Override
    public ResponseEntity getEncryptKeys() throws Exception {
        List<EncryptKey> encryptKeys = encryptKeyMapper.selectByExample(null);
        return ResponseEntity.success("success",encryptKeys);
    }

    @Override
    public ResponseEntity getEncryptKey(Long id) throws Exception {
        EncryptKey encryptKey = encryptKeyMapper.selectByPrimaryKey(id);
        return ResponseEntity.success("success",encryptKey);
    }

    @Override
    public ResponseEntity addEncryptKey(EncryptKey encryptKey) throws Exception {
        encryptKeyMapper.insertSelective(encryptKey);
        return ResponseEntity.success("add EncryptKey success");
    }


    @Override
    public ResponseEntity removeEncryptKey(Long id) throws Exception {
        encryptKeyMapper.deleteByPrimaryKey(id);
        return ResponseEntity.success("delete EncryptKey success");
    }

    @Override
    public ResponseEntity modifyEncryptKey(EncryptKey encryptKey) throws Exception {
        encryptKeyMapper.updateByPrimaryKeySelective(encryptKey);
        return ResponseEntity.success("update EncryptKey success");
    }
}
