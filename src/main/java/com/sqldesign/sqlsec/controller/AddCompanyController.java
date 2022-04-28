package com.sqldesign.sqlsec.controller;

import com.sqldesign.sqlsec.model.Company;
import com.sqldesign.sqlsec.model.User;
import com.sqldesign.sqlsec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddCompanyController {
    @Autowired
    private  UserService userService;

    @PostMapping("/addcompany")
    public  String addCompany(Model model, HttpSession session,String companyName,String companyAddr,String principal,String companyPhone,String companyIntro){
        User user = new User();
        Company company = new Company();
        company.setAddress(companyAddr);
        company.setCompanyName(companyName);
        company.setPrincipal(principal);
        company.setPhone(companyPhone);
        company.setCompanyIntro(companyIntro);
        user.setUsername((String)session.getAttribute("CURRENT_USER"));
        if (userService.AddCompany(company,user)){
            model.addAttribute("editSuccess",true);
            model.addAttribute("editFail",false);
        }else{
            model.addAttribute("editSuccess",false);
            model.addAttribute("editFail",true);
        }
//        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
//        if (isAdmin){
//            return "redirect:/admin";
//        }
        return "redirect:/settings";
    }
    @PostMapping("/adminaddcompany")
    public String adminAddCompany(HttpSession session,Company company){
        System.out.println("企业信息："+company);

        boolean isAdmin = (boolean) session.getAttribute("IS_ADMIN");
        if (isAdmin){
            userService.AdminAddCompany(company);
        }
        return "redirect:/admin";
    }

}
