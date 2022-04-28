package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class EditUserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/edituser")
    // 改密码
    public String editUser(Model model,String newEmail, String newPasswd, HttpSession session){
        User user = new User();
        user.setPasswd(newPasswd);
        user.setEmail(newEmail);
        user.setUsername((String) session.getAttribute("CURRENT_USER"));
        System.out.println(user);
        if (userService.UpdateBasicInfo(user)){
            model.addAttribute("editSuccess",true);
            model.addAttribute("editFail",false);
        }else{
            model.addAttribute("editSuccess",false);
            model.addAttribute("editFail",true);
        }
        session.invalidate();
        return "settings";
    }
    public String editUser(Model model){
        System.out.println("default edituser");
        model.addAttribute("editSuccess",false);
        model.addAttribute("editFail",false);
        return "settings";
    }

}
