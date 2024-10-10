package com.pzs.service.impl;


import com.pzs.aop.MyLog;
import com.pzs.mapper.DeptMapper;
import com.pzs.mapper.EmpMapper;
import com.pzs.pojo.Dept;
import com.pzs.pojo.DeptLog;
import com.pzs.service.DeptLogService;
import com.pzs.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @MyLog
    @Transactional(rollbackFor = Exception.class)  //spring事务管理
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id);
            //        int i = 1/0;
//            if(true){
//                throw new Exception("出错了。。。");
//            }
            empMapper.deleteByDeptId(id);   //根据部门ID删除该部门下的员工
        } finally {
            //不论是否有异常，最终都要执行的代码：记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是"+id+"号部门");
            //调用其他业务类中的方法
            deptLogService.insert(deptLog);
        }
    }

    @MyLog
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept select(Integer id) {
        return deptMapper.select(id);
    }

    @MyLog
    @Override
    public void change(Dept dept) {
        deptMapper.alter(dept);
    }
}
