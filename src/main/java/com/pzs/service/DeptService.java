package com.pzs.service;

import com.pzs.pojo.Dept;

import java.util.List;

public interface DeptService {

    //查询全部部门数据
    List<Dept> list();


    void delete(Integer id) throws Exception;

    //新增部门
    void add(Dept dept);

    //根据id查询部门
    Dept select(Integer id);

    //修改部门
    void change(Dept dept);
}
