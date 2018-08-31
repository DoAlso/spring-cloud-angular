package com.cloud.security.service.impl;

import com.cloud.security.auth.BaseUser;
import com.cloud.security.dao.extend.UserMapperExtend;
import com.cloud.security.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author doalso
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapperExtend userMapperExtend;

    @Override
    public void createUser(UserDetails userDetails) {

    }

    @Override
    public void updateUser(UserDetails userDetails) {

    }

    @Override
    public void deleteUser(String s) {

    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String s) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BaseUser userAuth = userMapperExtend.loadUserByUsername(s);
        if(userAuth == null){
            throw new UsernameNotFoundException("用户名错误");
        }
        return userAuth;
    }
}
