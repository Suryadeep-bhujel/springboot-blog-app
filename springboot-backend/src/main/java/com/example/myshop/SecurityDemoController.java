package com.example.myshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class SecurityDemoController {
    @GetMapping("/public")
    public String publicMethod() {
        return "This is a public method";
    }

    @GetMapping("/admin")
    public String adminMethod() {
        return "This is a admin method";
    }
    @GetMapping("/user")
    public String userMethod() {
        return "This is a user method";
    }
}
