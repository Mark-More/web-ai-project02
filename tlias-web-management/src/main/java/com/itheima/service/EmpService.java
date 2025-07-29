package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * @return
     */
//    PageResult<Emp> page(Integer page, Integer pageSize,String name, Integer gender,
//                     LocalDate begin, LocalDate end);

    /**
     * 分页查询
     * @param empQueryParam
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     * @param emp
     */
    void save(Emp emp) throws Exception;

    /**
     * 删除员工信息
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 员工信息查询
     * @param id
     * @return
     */
    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
}
