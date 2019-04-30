package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.EnvParam;

public interface EnvParamService {

    /**
     * 查询指定环境下的
     * 环境参数
     * @param envId
     * @return
     * @throws Exception
     */
    ResponseEntity findAllEnvParamByEnvId(Long envId) throws Exception;


    /**
     * 查询环境参数的详细信息
     * @param id
     * @return
     * @throws Exception
     */
    ResponseEntity findEnvParamById(Long id) throws Exception;


    /**
     * 新增环境参数
     * @param envParam
     * @return
     * @throws Exception
     */
    ResponseEntity addEnvParam(EnvParam envParam) throws Exception;


    /**
     * 更新环境参数
     * @param envParam
     * @return
     * @throws Exception
     */
    ResponseEntity modifyEnvParam(EnvParam envParam) throws Exception;


    /**
     * 删除环境参数
     * @param envParamId
     * @return
     * @throws Exception
     */
    ResponseEntity removeEnvParam(Long envParamId) throws Exception;
}


