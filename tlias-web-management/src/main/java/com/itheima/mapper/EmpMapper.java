package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 *员工信息
 */
@Mapper
public interface EmpMapper {

    //------------------原始分页查询实现-------------
    /**
     * 查询员工总记录数
     * @return
     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();

    /**
     * 分页查询
     * @return
     */
//    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id " +
//            "order by d.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);


    //---------------------pageHeelper分页查询实现------------------
    /**
     * 查询员工总记录数
     * @return
     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long count();

    /**
     * 分页查询
     * @return
     */
//    @Select("select e.*, d.name from emp e left join dept d on e.dept_id = d.id order by d.update_time desc")
//    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    /**
     * 条件查询员工信息
     * @param empQueryParam
     * @return
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 新增员工基本信息
     * @param emp
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")//获取到生成的主键 -- 主键返回
    @Insert("insert into emp(username, password,name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)" +
            " values (#{username},#{password},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
