package com.cloud.configservice.model.req;

import com.cloud.configservice.model.Project;
import lombok.Data;

import java.util.List;

/**
 * @ClassName ProjectRequest
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/27 14:09
 */
@Data
public class ProjectRequest {
    private Project project;
    private List<Long> envIds;
}
