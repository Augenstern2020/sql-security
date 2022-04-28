package com.sqldesign.sqlsec.mapper;

import com.sqldesign.sqlsec.model.Student;
import com.sqldesign.sqlsec.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    @Select("select count(*) from sqlsec.students where uid = #{uid}")
    public int isStudentExist(User user);
    @Insert("insert into sqlsec.students (uid,stuName,sex,age,education,university,graduationTime,major,phone) values(#{uid},#{stuName},#{sex},#{age},#{education},#{university},#{graduationTime},#{major},#{phone})")
    public int addStudent(Student student);
    @Update("update sqlsec.students set stuName = #{stuName},sex = #{sex},age=#{age},education=#{education},university =#{university},graduationTime=#{graduationTime},major=#{major},phone=#{phone} where uid = #{uid}")
    public int updateStudent(Student student);
    @Select("select * from sqlsec.students where uid = #{uid}")
    public Student getStudentByUid(int uid);
}
