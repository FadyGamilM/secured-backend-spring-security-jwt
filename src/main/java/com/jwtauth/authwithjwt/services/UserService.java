package com.jwtauth.authwithjwt.services;

import java.util.List;

import com.jwtauth.authwithjwt.domain.Role;
import com.jwtauth.authwithjwt.domain.User;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}