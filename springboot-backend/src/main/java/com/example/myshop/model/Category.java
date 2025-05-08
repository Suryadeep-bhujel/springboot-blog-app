package com.example.myshop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "oid", length = 25, nullable = false, unique = true)
    private String oid;

    @Column(name = "slug", nullable = false, unique = true, length = 150)
    private String slug;

    private String name;
    private String description;

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
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public Long getId() {
        return id;
    }
    public  String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
}
