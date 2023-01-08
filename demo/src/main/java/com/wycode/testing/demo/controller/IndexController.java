package com.wycode.testing.demo.controller;

import com.wycode.testing.demo.daos.UserDao;
import com.wycode.testing.demo.model.UserReg;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/")
    public String Index(){
        return "index";
    }
    @GetMapping("/login")
    public String Login(){
        return "login";
    }
    @RequestMapping("/success")
    public String Success(){ return "success";}
    @PostMapping("/login")
    public String postLogin(HttpServletRequest request){
        String email,password,page="login";
        email=request.getParameter("email");
        password=request.getParameter("password");
        List<UserReg> userRegList=userDao.findAll();
        for (UserReg userReg : userRegList){
            if(userReg.getEmail().equals(email) && userReg.getPass().equals(password)){
                page="success";
            }
        }
        return page;
    }

    @GetMapping("/register")
    public String Register(){
        return "register";
    }

    @PostMapping("register")
    public String postReg(HttpServletRequest request){
        String email=request.getParameter("email");
        String pass=request.getParameter("password");

        userDao.save(new UserReg(email,pass));
        System.out.printf("email = %s , password = %s",email,pass);

        return "index";
    }
}
