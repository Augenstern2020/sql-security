package com.sqldesign.sqlsec.config;

import com.sqldesign.sqlsec.interceptor.AdminInterceptor;
import com.sqldesign.sqlsec.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/logout","/register","/js/**","/img/**","/css/**","/getUserInfo");
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/logout","/register","/js/**","/img/**","/css/**","/settings","/information","/deleteRecruitment","/companypost","/studentpost","/deleteResume","/studentupdate","/companyupdate","/edituser","/addcompany","/addstudent","/search","/getusernamebyuid","/getuserinfo","/getUserInfo");
    }
}
