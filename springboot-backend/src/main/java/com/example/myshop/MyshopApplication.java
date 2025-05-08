package com.example.myshop;

import com.example.myshop.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyshopApplication.class, args);
	}

	@Bean
	CommandLineRunner createAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User user = new User();
				user.setUsername("admin");
				user.setPassword(passwordEncoder.encode("admin123"));
				user.setEnabled(true);
				userRepository.save(user);
				System.out.println("✅ Admin user created.");
			} else {
				System.out.println("ℹ️ Admin already exists.");
			}
		};
	}
}
