package com.cloud.security.dao.extend;

import com.cloud.security.auth.BaseUser;
import com.cloud.security.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapperExtend {

    /**
     * 通过用户名加载用户信息
     * @param username
     * @return
     */
    BaseUser loadUserByUsername(@Param("username") String username);


    /**
     * 根据用户ID查询用户角色列表
     * @param userId
     * @return
     */
    List<Role> getRolesByUserId(@Param("userId") Long userId);
}
