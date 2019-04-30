package com.cloud.configservice.service.impl;

import com.cloud.configservice.common.ResponseEntity;
import com.cloud.configservice.dao.EnvMapper;
import com.cloud.configservice.dao.EnvParamMapper;
import com.cloud.configservice.dao.ProjectMapper;
import com.cloud.configservice.model.Env;
import com.cloud.configservice.service.BaseOptService;
import com.cloud.configservice.service.DashboardService;
import com.cloud.configservice.vo.DashboardEnvVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DashboardServiceImpl
 * @Description TODO
 * @Author Administrator
 * @DATE 2019/3/13 15:11
 */
@Service
public class DashboardServiceImpl implements DashboardService {
    @Resource
    private EnvMapper envMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private EnvParamMapper envParamMapper;
    @Autowired
    private BaseOptService baseOptService;

    @Override
    public ResponseEntity envSummary() throws Exception{
        List<DashboardEnvVO> result = new ArrayList<>();
        List<Env> envs = envMapper.selectByExample(null);
        for(Env env:envs){
            DashboardEnvVO vo = new DashboardEnvVO();
            vo.setId(env.getId());
            vo.setName(env.getName());
            vo.setProjects(projectMapper.findProjectByEnvId(env.getId()).size());
            vo.setParams(envParamMapper.findEnvParamByEnvId(env.getId()).size());
            vo.setConfigServers(baseOptService.configServerInfo(env));
            result.add(vo);
        }
        return ResponseEntity.success("success",result);
    }
}
