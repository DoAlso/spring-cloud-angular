package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.EncryptKey;

public interface EncryptService {
    /**
     * 查询所有的加密key
     * @return
     * @throws Exception
     */
    ResponseEntity getEncryptKeys() throws Exception;


    /**
     * 查看加密信息
     * @param id
     * @return
     * @throws Exception
     */
    ResponseEntity getEncryptKey(Long id) throws Exception;

    /**
     * 新增加密数据
     * @param encryptKey
     * @return
     * @throws Exception
     */
    ResponseEntity addEncryptKey(EncryptKey encryptKey) throws Exception;

    /**
     * 删除数据
     * @param id
     * @return
     * @throws Exception
     */
    ResponseEntity removeEncryptKey(Long id) throws Exception;

    /**
     * 修改数据
     * @param encryptKey
     * @return
     * @throws Exception
     */
    ResponseEntity modifyEncryptKey(EncryptKey encryptKey) throws Exception;
}
