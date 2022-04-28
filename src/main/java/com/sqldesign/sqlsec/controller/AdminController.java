package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.*;
import com.sqldesign.sqlsec.services.InfoService;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private InfoService infoService;
    @RequestMapping("/admin")
    public String manager(Model model, HttpSession session){

        List<User> users = userService.GetAllUsers();
        List<Recruitment> recruitments = infoService.GetAllRecruitments();
        List<JobHunter> resumes = infoService.GetAllResumes();
        model.addAttribute("users",users);
        model.addAttribute("resumes",resumes);
        model.addAttribute("recruitments",recruitments);
        return "admin";
    }
    @RequestMapping("/deleteuser")
    public String deleteUse(Model model,User user,HttpSession session){
        String username = (String) session.getAttribute("CURRENT_USER");
        if(userService.IsUserExist(username)){
            userService.DeleteUser(user);
        }
        return "redirect:/admin";
    }
    @RequestMapping("/getstudentinfo")
    @ResponseBody
    public Student getStudentInfo(HttpSession session, int uid){
        // 管理员校验，防止信息泄漏
        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            return userService.GetStudentByUid(uid);
        }
        return null;
    }
    @RequestMapping("/getcompanyinfo")
    @ResponseBody
    public Company getCompanyInfo(HttpSession session,int uid){
        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            return userService.GetCompanyByUid(uid);
        }
        return null;
    }
    @RequestMapping("/adduser")
    public String addUser(HttpSession session,User user){
        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            userService.AddUser(user);
        }
        return "redirect:/admin";
    }
    @RequestMapping("/getuserbyuid")
    @ResponseBody
    public User getUserByUid(HttpSession session,int uid){
        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            return userService.GetUserByUid(uid);
        }
        return null;
    }
    @RequestMapping("/deleteresume")
    public String deleteresume(HttpSession session,int resumeId){
        infoService.DeleteResume(resumeId);
        return "redirect:/admin";
    }
    @RequestMapping("/deleterecruitment")
    public String deleterecruitment(HttpSession session,int recruitId){
        infoService.DeleteRecruitment(recruitId);
        return "redirect:/admin";
    }
    @RequestMapping("/adminupdatestudent")
    public String adminUpdateStudent(Model model,HttpSession session,JobHunter jobHunter){
        infoService.UpdateResume(jobHunter);
        return "redirect:/admin";
    }
    @RequestMapping("/adminupdatecompany")
    public String adminUpdateCompany(Model model,HttpSession session,Recruitment recruitment){
        infoService.UpdateRecruitment(recruitment);
        return "redirect:/admin";
    }
    @RequestMapping("/addresume")
    public String addResume(Model model,HttpSession session,String username,String resume){
        int uid = userService.GetUidByUsername(username);
        JobHunter jobHunter = new JobHunter();
        jobHunter.setUid(uid);
        jobHunter.setResume(resume);
        if (uid != -1){
            infoService.AddResume(jobHunter);
        }
        return "redirect:/admin";
    }
    @RequestMapping("/addrecruitment")
    public String addRecruitment(Model model,HttpSession session,String username,String position,int peopleNum,String requirement){
        int uid = userService.GetUidByUsername(username);
        System.out.println(uid);
        if (uid == -1){
            return "redirect:/admin";
        }
        Recruitment recruitment = new Recruitment();
        recruitment.setUid(uid);
        recruitment.setPeopleNum(peopleNum);
        recruitment.setPosition(position);
        recruitment.setRequirement(requirement);
        System.out.println(recruitment);
        infoService.AddRecruitment(recruitment);
        return "redirect:/admin";
    }
}
