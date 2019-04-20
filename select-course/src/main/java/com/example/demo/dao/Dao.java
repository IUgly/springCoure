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

    /**
     * 增加课程
     * @param course
     * @return
     */
    @Insert("replace into course set c_id = #{id}, classroom = #{classroom}," +
            "course = #{course}, teacher = #{teacher}, type = #{type},"+
            "sort = #{sort}, time = #{time}")
    boolean addCourse(Course course);

    /**
     * 增加学生信息
     * @param student
     * @return
     */
    @Insert("INSERT into Student(xh,xm,xb,bj,zym,yxm,nj,csrq,xjzt,mz) " +
            "VALUES(#{xh},#{xm},#{xb},#{bj},#{zym},#{yxm},#{nj},#{csrq},#{xjzt},#{mz})")
    boolean addStudent(Student student);

    /**
     * 增加选课记录
     * @param sId
     * @param cId
     * @return
     */
    @Insert("insert into Record(s_id,c_id) values(#{sId},#{cId})")
    boolean addPickCourse(@Param("sId") String sId,
                          @Param("cId") String cId);

    /**
     * 删除选课
     * @param sId
     * @param cId
     * @return
     */
    @Delete("delete from record where s_id = #{s_id} AND c_id = #{c_id}")
    boolean deleteRecord(String sId, String cId);

    /**
     * 查询已选课程
     * @param sId
     * @return
     */
    @Select("SELECT c.c_id,c.course,c.teacher,c.time,c.classroom ,c.type,c.sort " +
            "FROM course c,record r " +
            "WHERE c.c_id = r.c_id " +
            "AND r.s_id = #{sId}")
    List<Course> selectCoursesBySId(String sId);

    /**
     * 可选课程
     * @param type
     * @param sId
     * @return
     */
    @Select("SELECT * FROM course " +
            "WHERE time NOT IN " +
            "(SELECT time FROM course,record" +
            "WHERE course.c_id = record.c_id" +
            "AND record.s_id = #{sId}) " +
            "AND type = #{type}")
    Optional<List<Course>> selectCoursesByType(@Param("sId") String sId,
                                               @Param("type") String type);

}
