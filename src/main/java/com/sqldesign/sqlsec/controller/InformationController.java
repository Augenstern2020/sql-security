package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.JobHunter;
import com.sqldesign.sqlsec.model.Recruitment;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.InfoService;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.servlet.http.PushBuilder;
import java.util.List;

@Controller
public class InformationController {
    @Autowired
    InfoService infoService;
    @Autowired
    UserService userService;
    @RequestMapping("/information")
    public String information(Model model, HttpSession session){
        User user = new User();
        String username = (String) session.getAttribute("CURRENT_USER");
        int uid = userService.GetUidByUsername(username);
        user.setUsername(username);
        user.setUid(uid);
        boolean isStudent = userService.IsStudent(user);
        if(isStudent){
            List<JobHunter> allResumes = infoService.GetAllResumesByUid(uid);
            model.addAttribute("infos",allResumes);

        }else{
            List<Recruitment> allRecruitments = infoService.GetRecruitmentsByUid(uid);
            model.addAttribute("infos",allRecruitments);
        }
        model.addAttribute("student",isStudent);
        return "information";
    }
    @RequestMapping("/deleteRecruitment")
    public String deleteRecruitment(HttpSession session,int recruitId){
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        if(infoService.ValidateUidAndRecruitId(recruitId,uid)){
            infoService.DeleteRecruitment(recruitId);
        }else{
            System.out.println("die hacker!");
        }
        return "redirect:/information";
    }
    @PostMapping("/companypost")
    public String companyPost(Model model,HttpSession session,Recruitment recruitment){
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        recruitment.setUid(uid);
        infoService.AddRecruitment(recruitment);
        return "redirect:/information";
    }
    @PostMapping("/studentpost")
    public String studentPost(Model model,HttpSession session,JobHunter jobHunter){
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        jobHunter.setUid(uid);
        infoService.AddResume(jobHunter);
        return "redirect:/information";
    }
    @RequestMapping("/deleteResume")
    public String deleteResume(Model model,HttpSession session,int resumeId){
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        if(infoService.ValidateUidAndResumeId(resumeId,uid)){
            infoService.DeleteResume(resumeId);
        }else{
            System.out.println("die hacker!");
        }
        return "redirect:/information";
    }

    @RequestMapping("/studentupdate")
    public String studentUpdate(Model model,HttpSession session,JobHunter jobHunter){
        System.out.println(jobHunter);
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        if(infoService.ValidateUidAndResumeId(jobHunter.getResumeId(),uid)){
            infoService.UpdateResume(jobHunter);
        }else{
            System.out.println("die hacker!");
        }
        return "redirect:/information";
    }
    @RequestMapping("/companyupdate")
    public String companyUpdate(Model model,HttpSession session,Recruitment recruitment){
        int uid = userService.GetUidByUsername((String) session.getAttribute("CURRENT_USER"));
        if(infoService.ValidateUidAndRecruitId(recruitment.getRecruitId(),uid)){
            infoService.UpdateRecruitment(recruitment);
        }else{
            System.out.println("die hacker!");
        }
        return "redirect:/information";
    }
}
