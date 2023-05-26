package com.jwtauth.authwithjwt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtauth.authwithjwt.domain.User;
import com.jwtauth.authwithjwt.services.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private final UserService _userService;

    @GetMapping
    public ResponseEntity<List<User>> GetAllUsers() {
        return ResponseEntity.ok().body(_userService.getUsers());
    }

}