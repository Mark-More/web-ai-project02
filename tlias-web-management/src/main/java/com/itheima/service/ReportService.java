package com.itheima.service;

import com.itheima.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计员工职位人数信息
     * @return
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别人数信息
     * @return
     */
    List<Map<String, Object>> getEmpGenderData();
}
