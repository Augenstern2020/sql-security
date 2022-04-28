package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private  UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String login(Model model, String username, String passwd, HttpSession session){
        User user = new User();
        user.setUsername(username);
        user.setPasswd(passwd);
        System.out.println("login:"+user);
        if(userService.VerifyUser(user)){
            System.out.println("pass verify!");
            model.addAttribute("loginError",false);
            model.addAttribute("loginSuccess",true);
            session.setAttribute("CURRENT_USER",username);
            userService.UserLogin(user);
            if(userService.IsAdmin(user)){
                session.setAttribute("IS_ADMIN",true);
            }
        }else{
            model.addAttribute("loginError",true);
            model.addAttribute("loginSuccess",false);
        }
        return "login";
    }
}
