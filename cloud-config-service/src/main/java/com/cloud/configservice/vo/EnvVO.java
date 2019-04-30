package com.cloud.configservice.vo;

import lombok.Data;

@Data
public class EnvVO {
    private Long id;
    /**
     * 环境名
     **/
    private String name;
    /**
     * 注册中心地址，如果为空，配置中心的访问地址不使用服务名
     **/
    private String registryAddress;
    /**
     * 配置中心的访问地址（比如：http://localhost:8888/）或服务名（配置服务名的时候需要与服务发现组件配合使用）
     **/
    private String configServerName;
    /**
     * 如果配置中心设置了contextPath，那么也需要维护进来
     */
    private String contextPath = "";
}
