package com.itheima.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 环绕通知：拦截 com.itheima.controller 包下标注 @Log 的方法
     */
    @Around("@annotation(com.itheima.anno.Log)")
    public Object logOpration(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        //执行目标方法
        Object result = joinPoint.proceed();

        //计算耗时
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        //构筑日志实体
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getCurrentEmpId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setOperateParams(Arrays.toString(joinPoint.getArgs()));
        olog.setReturnValue(result != null ? result.toString() : "void");
        olog.setCostTime(costTime);

        log.info("操作日志：{}", olog);

        //保存日志
        operateLogMapper.insertLog(olog);
        return result;

    }

    private Integer getCurrentEmpId() {
        return 1;
    }

}