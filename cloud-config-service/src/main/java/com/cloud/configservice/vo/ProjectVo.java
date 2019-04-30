package com.cloud.configservice.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProjectVo
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 18:08
 */
@Data
public class ProjectVo {
    private Long id;
    private String name;
    List<Long> envIds;
}
