package com.example.myshop.controller;

import com.example.myshop.model.Blog;
import com.example.myshop.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/list")
    public List<Blog> list() {
        return blogRepository.findAll();
    }
}
