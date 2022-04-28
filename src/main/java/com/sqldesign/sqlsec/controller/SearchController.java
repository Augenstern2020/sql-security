package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.jdbc.db;
import com.sqldesign.sqlsec.model.JobHunter;
import com.sqldesign.sqlsec.model.Recruitment;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.InfoService;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    UserService userService;
    @Autowired
    InfoService infoService;
    @RequestMapping("/search")
    public String search(HttpSession session, Model model){
        String username = (String) session.getAttribute("CURRENT_USER");
        int uid = userService.GetUidByUsername(username);
        User user = userService.GetUserByUid(uid);
        List<Recruitment> recruitments = infoService.GetAllRecruitments();
        List<JobHunter> resumes = infoService.GetAllResumes();
        System.out.println(user);
        model.addAttribute("user",user);
        model.addAttribute("recruitments",recruitments);
        model.addAttribute("resumes",resumes);
        return "search";
    }
    @RequestMapping("/getusernamebyuid")
    @ResponseBody
    public Map<String,Object> getUsernameByUid(int uid){
        Map<String,Object> map = new HashMap<>();
        String username = userService.GetUserByUid(uid).getUsername();
        map.put("username",username);
        return map;
    }

}
