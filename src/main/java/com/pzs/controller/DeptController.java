package com.pzs.controller;

import com.pzs.pojo.Dept;
import com.pzs.pojo.Result;

import com.pzs.service.DeptService;
import com.pzs.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理Controller
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //查询部门数据
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)    //指定请求方式为GET
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result detele(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门：{}",id);
        //调用service删除部门
        deptService.delete(id);

        return Result.success();
    }

    //新增部门信息
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询部门信息
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("根据id查询部门：{}",id);
        Dept dept = deptService.select(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result change(@RequestBody Dept dept){
        log.info("修改部门{}",dept);
        deptService.change(dept);
        return Result.success();
    }
}
