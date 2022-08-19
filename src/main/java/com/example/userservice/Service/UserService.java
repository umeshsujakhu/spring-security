package com.example.userservice.Service;

import com.example.userservice.Domain.Role;
import com.example.userservice.Domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
