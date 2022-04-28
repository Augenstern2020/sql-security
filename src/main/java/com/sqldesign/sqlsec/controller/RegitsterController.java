package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.mapper.UserMapper;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class RegitsterController {
    @Autowired UserService userService;
    @RequestMapping(value="/register")
    public String register(Model model){
        return "register";
    }
    @PostMapping("/register")
    public String register(String username,String passwd,String email,String userType){
        User user = new User();
        user.setUsername(username);
        user.setPasswd(passwd);
        user.setEmail(email);
        user.setUserType(userType);
        if(userService.ValidateUser(user)){
            userService.AddUser(user);
            return "login";
        }
        return "register";
    }

}
