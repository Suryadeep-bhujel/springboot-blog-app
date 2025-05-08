package com.example.myshop.repository;

import com.example.myshop.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Page<Category> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
