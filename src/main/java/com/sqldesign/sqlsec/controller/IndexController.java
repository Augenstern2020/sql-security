package com.sqldesign.sqlsec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping("")
    public String index(Model model, HttpSession session){
        if(session.getAttribute("CURRENT_USER") != null){
            model.addAttribute("logUrl","/logout");
            model.addAttribute("logAction","登出");
            model.addAttribute("signUrl","/settings");
            model.addAttribute("signAction","设置");
        }else{
            model.addAttribute("logUrl","/login");
            model.addAttribute("logAction","登陆");
            model.addAttribute("signUrl","/register");
            model.addAttribute("signAction","注册");
        }
        return "index";
    }
}
