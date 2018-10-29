package com.cloud.sample.javabase.annotation;

import java.util.List;

/**
 * @ClassName PasswordUtils
 * @Description TODO
 * @Author Administrator
 * @DATE 2018/10/29 10:21
 */
public class PasswordUtils {

    @UseCase(id = 47,description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password){
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49,description = "New passwords can not equal previously used ones")
    public boolean chechForNewPassword(List<String> prevpassword, String password){
        return !prevpassword.contains(password);
    }
}
