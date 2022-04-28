package com.sqldesign.sqlsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
//        session.removeAttribute("CURRENT_USER");
//        session.removeAttribute("IS_ADMIN");
        session.invalidate();
        model.addAttribute("logAction","登陆");
        model.addAttribute("logUrl","/login");
        model.addAttribute("signUrl","/register");
        model.addAttribute("signAction","注册");
        return "redirect:/";
    }
}
