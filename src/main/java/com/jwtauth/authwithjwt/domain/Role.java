package com.jwtauth.authwithjwt.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import com.jwtauth.authwithjwt.security.AuthRoles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name = AuthRoles.USER.name();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();
}