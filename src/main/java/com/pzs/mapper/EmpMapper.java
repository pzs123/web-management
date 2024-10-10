package com.pzs.mapper;

import com.pzs.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp selectLogin(Emp emp);

    /*
    //查询总记录数
    @Select("select count(*) from emp")
    Long count();

    //分页查询获取列表数据
    @Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> page(@Param("start") Integer start,@Param("pageSize") Integer pageSize);
     */

    //员工信息查询
    //@Select("select * from emp")
    public List<Emp> list(@Param("name") String name, @Param("gender") Short gender, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    //批量删除
    void delete(@Param("ids") List<Integer> ids);

    //新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) VALUES " +
            "(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据id查询
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id = #{id}")
    Emp select(Integer id);

    //动态更新员工数据
    void update(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
