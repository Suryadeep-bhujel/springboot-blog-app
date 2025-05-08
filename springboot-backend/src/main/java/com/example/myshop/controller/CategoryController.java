package com.example.myshop.controller;

import com.example.myshop.dto.CategoryFilterDTO;
import com.example.myshop.model.Category;
import com.example.myshop.repository.CategoryRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> list(@ModelAttribute CategoryFilterDTO categoryFilter) {
        /*** Dynamically Setting up the page size and page  limit */
        Pageable pageable = PageRequest.of(categoryFilter.getPage()-1, categoryFilter.getLimit());

        Page<Category> pageResults;
        if(categoryFilter.getSearch() != null && !categoryFilter.getSearch().isEmpty()) {
            pageResults = categoryRepository.findByNameContainingIgnoreCase(categoryFilter.getSearch(), pageable);
        }else {
            pageResults =  categoryRepository.findAll(pageable);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("data", pageResults.getContent());
        response.put("totalItems", pageResults.getTotalElements());
        response.put("totalPages", pageResults.getTotalPages());
        response.put("currentPage", pageResults.getNumber());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Category category) {
        try {
            String baseSlug = category.getName().toLowerCase().replaceAll("[^a-z0-9]+", "-");
            String randomText = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
            String slug = baseSlug + "-" + randomText;
            category.setSlug(slug);
              Category createdCategory = categoryRepository.save(category);
             return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        }catch (Exception e){
            Map<String, String> error = new HashMap<>();
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
