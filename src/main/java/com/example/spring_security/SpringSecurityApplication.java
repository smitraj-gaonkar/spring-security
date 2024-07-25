package com.example.spring_security;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.spring_security.entities.*;
import com.example.spring_security.service.*;

@SpringBootApplication
// @SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) //To disable spring security
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

      @Bean
      CommandLineRunner initData(UserService userService) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String encodedPassword = new BCryptPasswordEncoder().encode("pass");

            // Create roles
            Role userRole = userService.createRole("USER");
            Role adminRole = userService.createRole("ADMIN");

            // Create users with roles
            Set<Role> roles1 = new HashSet<>();
            roles1.add(userRole);
            roles1.add(adminRole);
            userService.createUserWithRoles("Smith", encodedPassword, sdf.parse("24-07-2024"), roles1);

            Set<Role> roles2 = new HashSet<>();
            roles2.add(userRole);
            userService.createUserWithRoles("John", encodedPassword, sdf.parse("25-07-2024"), roles2);
            };     
      }

	


}
