package com.cloud.configservice.controller;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DashboardController
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/13 11:52
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/envSummary")
    public ResponseEntity envSummary() throws Exception{
        return dashboardService.envSummary();
    }
}
