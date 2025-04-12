package com.wuzengrui.mapper;

import com.wuzengrui.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
//    @Select("select * from emp")
//    public List<Emp> list();

    @Delete("delete from emp where id= #{id}")
    public int delete(Integer id);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp values (null,#{username},#{password},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime});")
    public int insert(Emp emp);

//    @Update("update emp set name=#{name},username=#{username},gender=#{gender},job=#{job}," +
//            "dept_id=#{deptId},update_time=now(),image=#{image} where id = #{id}")
//    public void update(Emp emp);
        public void update(Emp emp);
//    @Select("select * from emp where id = #{id}")
//    public Emp getEmpById(Integer id);

//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getEmpById(Integer id);

//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getEmpById(Integer id);
    @Select("select * from emp where id = #{id}")
    public Emp getEmpById(Integer id);

//    @Select("select * from emp where name like '%${name}%'  and" +
//            " gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

//    @Select("select * from emp where name like concat('%',#{name},'%')  and" +
//            " gender = #{gender} and entrydate between #{begin} and #{end} order by update_time desc")
//    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

    public List<Emp> list(String name, short gender, LocalDate begin, LocalDate end);

    //批量删除员工
    public void deleteEmpById(List<Integer> ids);

}
