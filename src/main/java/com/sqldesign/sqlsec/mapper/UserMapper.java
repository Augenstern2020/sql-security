package com.sqldesign.sqlsec.mapper;

import com.sqldesign.sqlsec.model.Company;
import com.sqldesign.sqlsec.model.Student;
import com.sqldesign.sqlsec.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

//import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from sqlsec.users")
    public List<User> getAllUsers();
    @Insert("insert into sqlsec.users (username,passwd,email,userType,loginTimes,isAdmin) values(#{username},#{passwd},#{email},#{userType},0,0)")
    public int addUser(User user);
    @Select("select count(*) from sqlsec.users where username = #{username}")
    public int validateUser(User user);
    @Select("select count(*) from sqlsec.users  where username = #{username} and passwd = #{passwd}")
    public int verifyUser(User user);
    @Select("select isAdmin from sqlsec.users where username = #{username}")
    public int isAdmin(User user);
    @Select("select loginTimes from sqlsec.users where username = #{username} and passwd = #{passwd}")
    public int getLoginTimes(User user);
    @Update("update sqlsec.users set loginTimes = #{loginTimes},lastLoginTime=#{lastLoginTime} where username = #{username} and passwd = #{passwd}")
    public int userLogin(User user);
    @Update("update sqlsec.users set email = #{email},passwd=#{passwd} where username = #{username}")
    public int  updateBasicInfo(User user);
    @Select("select userType from sqlsec.users where username = #{username}")
    public String getUserType(User user);
    // what if return null??
    @Select("select uid from sqlsec.users where username = #{username}")
    public  int getUid(User user);
    @Select("select uid from sqlsec.users where username = #{username}")
    public int getUidByUsername(String username);
    @Update("update sqlsec.users set username=#{username},passwd=#{passwd},email=#{email},loginTimes=#{loginTimes},lastLoginTime=#{lastLoginTime},userType=#{userType},isAdmin=#{isAdmin} where uid=#{uid}")
    public int editUser(User user);
    @Select("select count(*) from sqlsec.users where username=#{username}")
    public int isUsernameExist(String username);
    @Delete("delete from sqlsec.users where uid = #{uid}")
    public int deleteUser(User user);
    @Select("select * from sqlsec.users where uid = #{uid}")
    public User getUserByUid(int uid);
    @Select("select count(*) from sqlsec.users where username = #{username}")
    public int isUserExist(User user);
}
