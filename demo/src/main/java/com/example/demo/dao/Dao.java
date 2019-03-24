package com.example.demo.dao;

import com.example.demo.vo.Record;
import com.example.demo.vo.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper
@Component
public interface Dao {

    @Insert("Insert into student set name = #{name}, student_id = #{student_id}," +
            "college = #{college}, password = #{password}")
    Boolean addStudent(Student student);

    @Delete("delete from student where student_id = #{student_id}")
    Boolean deleteStudent(String student_id);

    @Update("update student set name = #{name} where student_id = #{student_id}")
    Boolean updateUserName(Student student);

    @Select("select * from student")
    List<Student> selectStudents();

    @SelectProvider(type = SqlBuilder.class, method = "buildTableSize")
    Integer tableSize(String tableName);

    class SqlBuilder {
        public static String buildTableSize(final String tableName) {
            String sql = "select count(*) from " +tableName;
//            String sql = new SQL(){{
//                SELECT("count(*)");
//                FROM(tableName);
//            }}.toString();
            System.out.println(sql);
            return sql;
        }
    }

    @Insert("insert into record set title = #{title}, start_time = #{start_time}," +
            "addway = #{add_way}, status = #{status}, uid = #{student_id}, " +
            "hours = #{hours}, content = #{content}")
    @Options(useGeneratedKeys=true, keyColumn="student_id")
    void insertUserAndReturnId(Record record);

    @Select("select passive_students as jsonArray,invited_student_id as student_id " +
            "from invited_record " +
            "where invited_student_id = #{student_id}")
    @Results({@Result(column="passive_students",property="passive_students", typeHandler = com.example.demo.bean.JsonTypeHandler.class)})
    List<Record> selectInvitedRecordList(String student_id);
}
