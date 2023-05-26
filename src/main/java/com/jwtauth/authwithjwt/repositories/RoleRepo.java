package com.jwtauth.authwithjwt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jwtauth.authwithjwt.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query(value = "SELECT * FROM roles WHERE name = ?1", nativeQuery = true)
    Role findByRoleName(String roleName);
}