package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.model.req.ProjectRequest;
import com.cloud.configservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ProjectController
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/14 17:35
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/findAll")
    public ResponseEntity findAllProject() throws Exception{
        return projectService.findAllProject();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findProject(@PathVariable("id") Long id) throws Exception {
        return projectService.findProject(id);
    }

    @PostMapping("/add")
    public ResponseEntity addProject(@RequestBody ProjectRequest projectRequest) throws Exception {
        return projectService.addProject(projectRequest.getProject(), projectRequest.getEnvIds());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeProject(@PathVariable("id") Long id) throws Exception {
        return projectService.removeProject(id);
    }

    @PutMapping("/modify")
    public ResponseEntity modifyProject(@RequestBody ProjectRequest projectRequest) throws Exception {
        return projectService.modifyProject(projectRequest.getProject(), projectRequest.getEnvIds());
    }
}
