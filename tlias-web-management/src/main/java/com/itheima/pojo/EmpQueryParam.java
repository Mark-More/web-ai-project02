package com.itheima.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page = 1;//页码
    private Integer pageSize = 10;//每页显示数量
    private String name;// 姓名
    private Integer gender;// 性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//入职时间的开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//入职时间结束时间

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public EmpQueryParam(Integer page, LocalDate end, LocalDate begin, Integer gender, String name, Integer pageSize) {
        this.page = page;
        this.end = end;
        this.begin = begin;
        this.gender = gender;
        this.name = name;
        this.pageSize = pageSize;
    }
}
