package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.Student;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
@Controller
public class AddStuController {
    @Autowired
    private  UserService userService;
    @PostMapping("/addstudent")
    //增加用户信息
    public  String addStudent(Model model, HttpSession session, String stuName, String sex, String education, String university, String major, String stuPhone, int age, String graduationTime) throws Exception{
        Student student = new Student();
        User user = new User();
        user.setUsername((String) session.getAttribute("CURRENT_USER"));
        student.setAge(age);
        student.setEducation(education);
        student.setMajor(major);
        student.setPhone(stuPhone);
        student.setUniversity(university);
        student.setSex(sex);
        student.setStuName(stuName);
        student.setGraduationTime(graduationTime);
        System.out.println("studentInfo"+student);
        if(userService.AddStudent(student,user)){
            model.addAttribute("editSuccess",true);
            model.addAttribute("editFail",false);
        }else{
            model.addAttribute("editSuccess",false);
            model.addAttribute("editFail",true);
        }
        return "redirect:/settings";
    }
    @PostMapping("/adminaddstudent")
    public String AdminAddStudent(HttpSession session,Student student){
        System.out.println("学生信息："+student);
        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            userService.AdminAddStudent(student);
        }
        return "redirect:/admin";

    }
}
