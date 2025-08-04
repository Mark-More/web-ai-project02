package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制层
 */
@RestController
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private EmpService empService;
    /**
     * 登录
     * @return
     */
    @PostMapping   ("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录，数据：{}", emp);
        LoginInfo info = empService.login(emp);
        if(info != null) {
            return Result.success(info);
        }else{
            return Result.error("用户名或密码错误!");
        }
    }
}
