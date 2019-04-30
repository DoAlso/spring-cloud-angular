package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.Project;

import java.util.List;

public interface ProjectService {

    /**
     * 查询所有的项目
     * @return
     * @throws Exception
     */
    ResponseEntity findAllProject() throws Exception;


    /**
     * 查询项目的详情
     * @param id
     * @return
     * @throws Exception
     */
    ResponseEntity findProject(Long id) throws Exception;


    /**
     * 新增项目
     * @param project
     * @param envIds
     * @return
     */
    ResponseEntity addProject(Project project, List<Long> envIds) throws Exception;


    /**
     * 删除项目
     * @param id
     * @return
     * @throws Exception
     */
    ResponseEntity removeProject(Long id) throws Exception;


    /**
     * 更新项目信息
     * @param project
     * @param envIds
     * @return
     * @throws Exception
     */
    ResponseEntity modifyProject(Project project, List<Long> envIds) throws Exception;


    /**
     * 为指定的项目添加标签
     * @param id
     * @param LabelName
     * @return
     * @throws Exception
     */
    ResponseEntity addProjectLabel(Long id, String LabelName) throws Exception;

}
