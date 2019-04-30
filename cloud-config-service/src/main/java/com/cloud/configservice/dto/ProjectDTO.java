package com.cloud.configservice.dto;

import com.cloud.configservice.model.Env;
import com.cloud.configservice.model.Label;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProjectDTO
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/21 14:24
 */
@Data
public class ProjectDTO {
    private Long id;
    private String name;
    private List<Env> envs;
    private List<Label> labels;
}
