package com.example.demo.dao;

import com.example.demo.vo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentDao {
    @Insert("insert into student set student_id =#{student_id}," +
            "name = #{name}, college = #{college}, password =#{password}")
    Boolean addStudent(Student student);

    @Select("select * from student")
    List<Student> selectUsers();
}
