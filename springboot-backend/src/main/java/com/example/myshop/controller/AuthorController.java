package com.example.myshop.controller;

import com.example.myshop.model.Author;
import com.example.myshop.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/list")
    public List<Author> list() {
        return authorRepository.findAll();
    }

    @PostMapping("/save")
    public Author save(@RequestBody Author author) {
        return authorRepository.save(author);
    }
}
