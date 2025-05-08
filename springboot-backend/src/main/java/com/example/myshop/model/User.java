package com.example.myshop.model;

import jakarta.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private boolean enabled;
    public void setId(Long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public void setPassword(String password) {
        this.password = password;
    }

//    public User() {}
}
