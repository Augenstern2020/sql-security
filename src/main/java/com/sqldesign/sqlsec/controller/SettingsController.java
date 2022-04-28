package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.jdbc.db;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SettingsController {
    @Autowired
    private UserService userService;

    @RequestMapping("/settings")
    public String settings(HttpSession session, Model model) {
        User user = new User();
        user.setUsername((String) session.getAttribute("CURRENT_USER"));

        if (userService.IsStudent(user)) {
            model.addAttribute("student", true);
            model.addAttribute("company", false);
        } else {
            model.addAttribute("student", false);
            model.addAttribute("company", true);
        }
        return "settings";
    }
}