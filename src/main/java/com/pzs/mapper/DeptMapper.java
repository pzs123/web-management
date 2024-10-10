package com.pzs.mapper;

import com.pzs.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface DeptMapper {

    //查询全部部门数据
    @Select("select * from dept")
    List<Dept> list();

    //根据id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //新增部门
    @Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //根据id查询部门
    @Select("select * from dept where id = #{id}")
    Dept select(Integer id);

    //修改部门
    @Update("update dept t set t.name = #{name} where t.id = #{id}")
    void alter(Dept dept);

}
