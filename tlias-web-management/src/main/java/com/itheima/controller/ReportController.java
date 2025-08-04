package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;

import com.itheima.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/report")
public class ReportController {
    private static final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;
    /**
     * 统计员工职位人数信息
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("查询员工职位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }
    /**
     * 统计员工性别人数信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("查询员工性别数据");
        List<Map<String, Object>> genderList =  reportService.getEmpGenderData();
        return Result.success(genderList);
    }
}
