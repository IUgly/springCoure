package com.example.demo.dao;

import com.example.demo.vo.Course;
import com.example.demo.vo.Record;
import com.example.demo.vo.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 * @author kuangjunlin
 */
@Mapper
@Component
public interface Dao {

    @Insert("replace into course set c_id = #{id}, classroom = #{classroom}," +
            "course = #{course}, teacher = #{teacher}, type = #{type},"+
            "sort = #{sort}, time = #{time}")
    boolean addCourse(Course course);

    @Insert("INSERT into Student(xh,xm,xb,bj,zym,yxm,nj,csrq,xjzt,mz) " +
            "VALUES(#{xh},#{xm},#{xb},#{bj},#{zym},#{yxm},#{nj},#{csrq},#{xjzt},#{mz})")
    boolean addStudent(Student student);

    @Insert("insert into Record(s_id,c_id) values(#{sId},#{cId})")
    boolean addPickCourse(@Param("sId") String sId,@Param("cId") String cId);

    @Delete("delete from record where s_id = #{s_id} AND c_id = #{c_id}")
    boolean deleteStudent(String sId, String cId);

    @Select("select * from record where s_id = #{sId}")
    Optional<List<Student>> selectCoursesBySId(String sId);

    @Select("select * from course where type = #{type}")
    Optional<List<Course>> selectCoursesByType(String type);


}
