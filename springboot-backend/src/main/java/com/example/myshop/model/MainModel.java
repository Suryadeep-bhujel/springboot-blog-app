package com.example.myshop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class MainModel {
    @Column(name = "oid", length = 25, nullable = false, unique = true)
    private String oid;
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(updatable = true)
    private LocalDateTime updatedAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (oid == null || oid.isEmpty()) {
            oid = generateOid(); // Generate once
        }
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    private String generateOid() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 25);
    }
}
