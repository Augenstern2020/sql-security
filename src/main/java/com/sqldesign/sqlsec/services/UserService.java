package com.sqldesign.sqlsec.services;

import com.sqldesign.sqlsec.jdbc.db;
import com.sqldesign.sqlsec.mapper.CompanyMapper;
import com.sqldesign.sqlsec.mapper.StudentMapper;
import com.sqldesign.sqlsec.mapper.UserMapper;
import com.sqldesign.sqlsec.model.Company;
import com.sqldesign.sqlsec.model.Student;
import com.sqldesign.sqlsec.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//https://stackoverflow.com/questions/24694123/nullpointerexception-on-java-mapper-with-mybatis
// spring 里面不要显示的使用 new 方法，否则不会自动装载
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CompanyMapper companyMapper;
    public boolean AddUser(User user){
        int userCnt = userMapper.isUserExist(user);
        if (userCnt > 0){
            return false;
        }
        userMapper.addUser(user);
        return true;
    }
    public boolean ValidateUser(User user){
        int cnt = userMapper.validateUser(user);
        return cnt == 0;
    }
    public boolean VerifyUser(User user){
        int cnt = userMapper.verifyUser(user);
        return cnt > 0;
    }
    public boolean IsAdmin(User user){
        try{
            System.out.println(userMapper.isAdmin(user));
            return userMapper.isAdmin(user) == 1;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
    public void UserLogin(User user){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastLoginTime = simpleDateFormat.format(new Date());
        int loginTimes = userMapper.getLoginTimes(user);
        user.setLoginTimes(++loginTimes);
        user.setLastLoginTime(lastLoginTime);
        userMapper.userLogin(user);
    }
    public boolean UpdateBasicInfo(User user){
        return userMapper.updateBasicInfo(user) == 1;
    }
    public boolean IsStudent(User user){
        return userMapper.getUserType(user).equalsIgnoreCase("student");
    }
    public boolean IsCompany(User user){
    return userMapper.getUserType(user).equalsIgnoreCase("company");
}
    public boolean IsStudentExist(User user){
        int uid = userMapper.getUid(user);
        if(uid == -1){
            return false;
        }
        user.setUid(uid);
        return studentMapper.isStudentExist(user)>0;
    }
    public boolean IsCompanyExist(User user){
        int uid = userMapper.getUid(user);
        if(uid == -1){
            return false;
        }
        user.setUid(uid);
        return companyMapper.isCompanyExist(user) > 0;
    }
    public int GetUid(User user){
        try{
            return userMapper.getUid(user);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public boolean AddStudent(Student student,User user){
    int uid = GetUid(user);
    student.setUid(uid);
    boolean alreadyExistStuInfo = IsStudentExist(user);
    boolean alreadyExistCompanyInfo = IsCompanyExist(user);
    if (alreadyExistCompanyInfo){
        System.out.println("该用户为企业用户");
        return  false;
    }
    if(!alreadyExistStuInfo){
        studentMapper.addStudent(student);
    }else{
        studentMapper.updateStudent(student);
    }
    return true;
}
    public boolean AddCompany(Company company, User user){
    int uid = GetUid(user);
    company.setUid(uid);
    boolean alreadyExistStuInfo = IsStudentExist(user);
    boolean alreadyExistCompanyInfo = IsCompanyExist(user);
    if (alreadyExistStuInfo){
        System.out.println("该用户为学生用户");
        return  false;
    }
    if(!alreadyExistCompanyInfo){
        companyMapper.addCompany(company);
    }else{
        companyMapper.updateCompany(company);
    }
    return true;
}
    public void AdminAddCompany(Company company){
        User user = GetUserByUid(company.getUid());
        if (companyMapper.isCompanyExist(user) > 0){
            companyMapper.updateCompany(company);
        }else{
            companyMapper.addCompany(company);
        }
    }
    public void AdminAddStudent(Student student){
        User user = GetUserByUid(student.getUid());
        if(studentMapper.isStudentExist(user) > 0){
            studentMapper.updateStudent(student);
        }else{
            studentMapper.addStudent(student);
        }
    }
    public int GetUidByUsername(String username){
        try{
            return userMapper.getUidByUsername(username);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public List<User> GetAllUsers(){
        return userMapper.getAllUsers();
    }
    public boolean IsUserExist(String username){
        return userMapper.isUsernameExist(username) == 1;
    }
    public int DeleteUser(User user){
        return userMapper.deleteUser(user);
    }
    public User GetUserByUid(int uid){
        return userMapper.getUserByUid(uid);
    }
    public Student GetStudentByUid(int uid){
        return studentMapper.getStudentByUid(uid);
    }
    public Company GetCompanyByUid(int uid){
        return companyMapper.getCompanyByUid(uid);
    }
}
