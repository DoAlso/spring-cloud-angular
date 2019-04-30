package com.cloud.configservice.service;


import com.cloud.configservice.common.ResponseEntity;

public interface DashboardService {
    ResponseEntity envSummary() throws Exception;
}
