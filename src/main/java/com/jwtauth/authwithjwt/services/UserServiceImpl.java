package com.jwtauth.authwithjwt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtauth.authwithjwt.domain.Role;
import com.jwtauth.authwithjwt.domain.User;
import com.jwtauth.authwithjwt.repositories.RoleRepo;
import com.jwtauth.authwithjwt.repositories.UserRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo _userRepo;

    @Autowired
    private final RoleRepo _roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("save a new user with username : {} in database", user.getUsername());
        return _userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save a new role with role name : {} in database", role.getName());
        return _roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("add a role {} to user {}", roleName, username);
        var role = _roleRepo.findByRoleName(roleName);
        var user = _userRepo.findUserByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetch user from databsae with username : {}", username);
        return _userRepo.findUserByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("fetch all users from database");
        return _userRepo.findAll();
    }

}