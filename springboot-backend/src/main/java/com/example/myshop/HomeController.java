package com.example.myshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    private  String appName;
    @Value("${app.env}")
    private String appEnv;

    @RequestMapping("/")
    public  String index(){
        System.out.println(appName);
        System.out.println(appEnv+" App ENV");
        return "index.html";
    }
}
