package com.itheima.exception;

import com.itheima.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("服务器异常：{}", e);
        return Result.error("服务器异常");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("数据异常：{}", e);
        String message = e.getMessage();
        int i =  message.indexOf("Duplicate entry");
        String errMag = message.substring(i);
        String[] arr =  errMag.split(" ");
        return Result.error(arr[2] + "已存在");
    }
}
