package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.dao.ProjectEnvsMapper;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.model.ProjectEnvsExample;
import com.cloud.configservice.service.EnvService;
import com.cloud.configservice.service.PersistenceService;
import com.cloud.configservice.vo.EnvVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnvServiceImpl implements EnvService {
    @Resource
    private EnvMapper envMapper;
    @Resource
    private ProjectEnvsMapper projectEnvsMapper;
    @Resource
    private PersistenceService persistenceService;
    @Override
    public ResponseEntity getEnvs() throws Exception {
        List<Env> envs = envMapper.selectByExample(null);
        List<EnvVO> result = new ArrayList<>();
        for(Env env:envs){
            EnvVO envVO = new EnvVO();
            BeanUtils.copyProperties(env,envVO);
            result.add(envVO);
        }
        return ResponseEntity.success("success",result);
    }

    @Override
    public ResponseEntity getEnv(Long id) throws Exception {
        Env env = envMapper.selectByPrimaryKey(id);
        if(env == null){
            return ResponseEntity.fail("Env not exist");
        }
        EnvVO envVO = new EnvVO();
        BeanUtils.copyProperties(env,envVO);
        return ResponseEntity.success("success",envVO);
    }

    @Override
    public ResponseEntity addEnv(Env env) throws Exception {
        envMapper.insertSelective(env);
        return ResponseEntity.success("add Env success");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity removeEnv(Long id) throws Exception {
        //删除环境时删除环境与项目的关联
        ProjectEnvsExample example = new ProjectEnvsExample();
        ProjectEnvsExample.Criteria criteria = example.createCriteria();
        criteria.andEnvsIdEqualTo(id);
        projectEnvsMapper.deleteByExample(example);
        //删除环境对应的配置信息
        Env env = envMapper.selectByPrimaryKey(id);
        persistenceService.deletePropertiesByEnv(env);
        //删除环境信息
        envMapper.deleteByPrimaryKey(id);
        return ResponseEntity.success("delete Env success");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResponseEntity modifyEnv(Env env) throws Exception {
        Env oldEnv = envMapper.selectByPrimaryKey(env.getId());
        if(!oldEnv.getName().equals(env.getName())){
            // 环境名称有修改，如果不是db存储，其他的存储还要更新持久化内容
            persistenceService.updateProfileName(oldEnv.getName(), env.getName());
        }
        envMapper.updateByPrimaryKeySelective(env);
        return ResponseEntity.success("update Env success");
    }

    @Override
    public ResponseEntity findEnvsLikeName(String name) throws Exception {
        List<Env> envs = envMapper.selectEnvsByName(name);
        return ResponseEntity.success("success",envs);
    }
}
