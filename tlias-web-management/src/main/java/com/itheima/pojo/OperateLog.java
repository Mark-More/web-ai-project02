package com.itheima.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperateLog {
    private String id;//ID
    private Integer operateEmpId;//操作员工ID
    private LocalDateTime operateTime;//操作时间
    private String className;//操作类名
    private String methodName;//操作方法名
    private String operateParams;//操作参数
    private String returnValue;//返回值
    private Long costTime;//操作耗时
}
