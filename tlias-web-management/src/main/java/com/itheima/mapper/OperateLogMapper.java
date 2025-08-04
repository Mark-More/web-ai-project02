package com.itheima.mapper;

import com.itheima.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    // 插入操作日志
    @Insert("insert into operate_log(operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time)" +
            " values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{operateParams}, #{returnValue}, #{costTime})")
    void insertLog(OperateLog operateLog);

}
