package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EnvParamMapper;
import com.cloud.configservice.model.EnvParam;
import com.cloud.configservice.service.EnvParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EnvParamServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 16:48
 */
@Service
public class EnvParamServiceImpl implements EnvParamService {
    @Resource
    private EnvParamMapper envParamMapper;

    @Override
    public ResponseEntity findAllEnvParamByEnvId(Long envId) throws Exception {
        List<EnvParam> result = envParamMapper.findEnvParamByEnvId(envId);
        return ResponseEntity.success("success",result);
    }

    @Override
    public ResponseEntity findEnvParamById(Long id) throws Exception {
        EnvParam envParam = envParamMapper.selectByPrimaryKey(id);
        return ResponseEntity.success("success",envParam);
    }

    @Override
    public ResponseEntity addEnvParam(EnvParam envParam) throws Exception {
        envParamMapper.insertSelective(envParam);
        return ResponseEntity.success("Add EnvParam Success");
    }

    @Override
    public ResponseEntity modifyEnvParam(EnvParam envParam) throws Exception {
        envParamMapper.updateByPrimaryKeySelective(envParam);
        return ResponseEntity.success("Update EnvParam Success");
    }

    @Override
    public ResponseEntity removeEnvParam(Long envParamId) throws Exception {
        envParamMapper.deleteByPrimaryKey(envParamId);
        return ResponseEntity.success("Delete EnvParam Success");
    }
}
