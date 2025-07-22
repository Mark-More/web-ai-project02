package com.itheima.comtroller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);
    /**
     * 文件上传，本地磁盘存储方案
     * @return
     */
    /*@PostMapping("/upload")
    public Result upload( String name,Integer age, MultipartFile file) throws Exception {
        log.info("接受参数：{},{},{}",name,age,file);
        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //生成新的文件名
        //获取文件后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + suffixName;
        //保存文件
        file.transferTo(new File("D:/upload/"+newFileName));
        return Result.success();

    }*/

    /**
     * 阿里云OSS存储方案
     * @return
     */
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload( MultipartFile file) throws Exception {
        log.info("文件上传：{}",file);
        //将文件交给OSS存储管理
        String url = aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("文件上传OSS，url：{}", url);
        return Result.success(url);
    }
}
