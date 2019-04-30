package com.cloud.configservice.common;

import java.io.Serializable;

/**
 * @ClassName ResponseEntity
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/2/21 17:18
 */
public class ResponseEntity<T> implements Serializable {
    public static final String SUCCESS_CODE = "0000";
    public static final String ERROR_CODE = "-1";
    private String message;
    private String code;
    private T data;

    public static <T> ResponseEntity<T> response(String code,String message,T data){
        ResponseEntity responseBody = new ResponseEntity();
        responseBody.setData(data);
        responseBody.setCode(code);
        responseBody.setMessage(message);
        return responseBody;
    }

    public static ResponseEntity response(String code,String message){
        ResponseEntity responseBody = new ResponseEntity();
        responseBody.setCode(code);
        responseBody.setMessage(message);
        return responseBody;
    }

    public static <T> ResponseEntity<T> success(String message,T data){
        return response(SUCCESS_CODE,message,data);
    }

    public static ResponseEntity success(String message){
       return response(SUCCESS_CODE,message);
    }

    public static ResponseEntity fail(String code,String message){
        return response(code, message);
    }

    public static ResponseEntity fail(String message) {
        return response(ERROR_CODE,message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
