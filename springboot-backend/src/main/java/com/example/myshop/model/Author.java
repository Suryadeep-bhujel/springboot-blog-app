package com.example.myshop.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "oid", length = 25, nullable = false, unique = true)
    private String oid;

    private  String firstName;
    private  String lastName;
    private  String email;
    private  String phone;

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

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
