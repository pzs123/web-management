package com.pzs.service;

import com.pzs.pojo.Emp;
import com.pzs.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //登录
    Emp login(Emp emp);

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

//    批量删除
    void delete(List<Integer> ids);

    //新增员工
    void save(Emp emp);

    //查询员工
    Emp getById(Integer id);

    void update(Emp emp);
}
