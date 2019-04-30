package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.Env;

public interface EnvService {

    /**
     * 查询所有的环境信息
     * @return
     */
    ResponseEntity getEnvs() throws Exception;

    /**
     * 查询环境详情
     * @param id
     * @return
     */
    ResponseEntity getEnv(Long id) throws Exception;


    /**
     * 新增
     * @param env
     * @return
     */
    ResponseEntity addEnv(Env env) throws Exception;


    /**
     * 删除，同时级联删除该环境下的所有配置
     * @param id
     * @return
     */
    ResponseEntity removeEnv(Long id) throws Exception;


    /**
     * 更新
     * @param env
     * @return
     */
    ResponseEntity modifyEnv(Env env) throws Exception;


    /**
     * 模糊查询所有的环境
     * @param name
     * @return
     * @throws Exception
     */
    ResponseEntity findEnvsLikeName(String name) throws Exception;

}
