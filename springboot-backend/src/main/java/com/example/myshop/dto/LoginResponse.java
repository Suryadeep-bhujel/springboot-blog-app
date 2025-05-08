package com.example.myshop.dto;

public class LoginResponse {
    private String token;
    private String username;
    private boolean enabled;

    // You can add more fields as needed (id, roles, etc.)

    public LoginResponse(String token, String username, boolean enabled) {
        this.token = token;
        this.username = username;
        this.enabled = enabled;
    }

    // Getters and Setters (or use Lombok @Data)
    public String getToken() { return token; }
    public String getUsername() { return username; }
    public boolean isEnabled() { return enabled; }
}
