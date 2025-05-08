package com.example.myshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/auth")
public class ApplicationController {

    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome.html";
    }

}