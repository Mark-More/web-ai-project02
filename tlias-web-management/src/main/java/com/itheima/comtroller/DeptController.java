package com.itheima.comtroller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RequestMapping(value = "/depts")
@RestController
public class DeptController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);//固定的


    @Autowired
    private DeptService deptService;

    /**
     * 获取部门数据
     */
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)//method：指定请求方式
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门数据 - 方式一：使用HttpServletRequest对象获取参数
     */
//    @DeleteMapping(value = "/depts")
//    public Result delete(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("根据id删除部门数据：" + id);
//        return Result.success();
//    }
    /**
     * 删除部门数据 - 方式二：使用@RequestParam注解获取参数
     *注意事项：一旦声明了@RequestParam注解，该参数在请求时必须传递，如果不传递将会报错（默认 required 为 true）
     */
//    @DeleteMapping(value = "/depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
//        System.out.println("根据id删除部门数据：" + deptId);
//        return Result.success();
//    }
    /**
     * 删除部门数据 - 方式三：省略@RequestParam注解（前端传递的参数名称必须和形参名称一致）[推荐]
     */
    @DeleteMapping
    public Result delete(Integer id) {
//        System.out.println("根据id删除部门数据：" + id);
        log.info("根据id删除部门数据：{}",id );
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门数据
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("新增部门数据：" + dept);
        log.info("新增部门数据：{}" , dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门数据
     */
//    @GetMapping(value = "/depts/{id}")
//    public Result getInfo(@PathVariable("id") Integer deptId) {
//        System.out.println("根据id查询部门数据：" + deptId);
//        return Result.success();
//    }
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable Integer id) {
//        System.out.println("根据id查询部门数据：" + id);
        log.info("根据id查询部门数据：{}" , id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }


    /**
     * 修改部门数据
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改部门数据：" + dept);
        log.info("修改部门数据：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
