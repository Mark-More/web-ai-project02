package com.itheima.pojo;

import lombok.Data;

import java.util.List;

/**
 * 分页查询结果封装
 */
@Data
public class PageResult<T> {
    private Long total; //总记录数
    private List<T> rows; //当前页数据
}
