package com.example.userservice;

import com.example.userservice.Domain.Role;
import com.example.userservice.Domain.User;
import com.example.userservice.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "John Doe", "johndoe", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "willsmith", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jimcarry", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "Arnold", "arnold", "12345", new ArrayList<>()));

            userService.addRoleToUser("johndoe", "ROLE_USER");
            userService.addRoleToUser("johndoe", "ROLE_ADMIN");
            userService.addRoleToUser("willsmith", "ROLE_MANAGER");
            userService.addRoleToUser("jimcarry", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_ADMIN");
            userService.addRoleToUser("arnold", "ROLE_USER");
        };
    }

}
