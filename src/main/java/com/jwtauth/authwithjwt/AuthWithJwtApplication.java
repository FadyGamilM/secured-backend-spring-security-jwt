package com.jwtauth.authwithjwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jwtauth.authwithjwt.domain.Role;
import com.jwtauth.authwithjwt.domain.User;
import com.jwtauth.authwithjwt.security.AuthRoles;
import com.jwtauth.authwithjwt.services.UserService;

@SpringBootApplication
public class AuthWithJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthWithJwtApplication.class, args);
	}

	// data seeding via injecting the UserService inside the commandLineRunner run
	// method
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(1L, AuthRoles.USER.name(), new ArrayList<>()));
			userService.saveRole(new Role(2L, AuthRoles.ADMIN.name(), new ArrayList<>()));
			userService.saveRole(new Role(3L, AuthRoles.SUPER_ADMIN.name(), new ArrayList<>()));
			userService.saveRole(new Role(4L, AuthRoles.MANAGER.name(), new ArrayList<>()));

			userService.saveUser(new User(1L, "fadyG", "fadyfady", new ArrayList<>()));
			userService.saveUser(new User(2L, "maryW", "123456789", new ArrayList<>()));
			userService.saveUser(new User(3L, "youssefAshraf", "147258369", new ArrayList<>()));
			userService.saveUser(new User(4L, "ahmedMostafa", "okaydokey", new ArrayList<>()));

			userService.addRoleToUser("fadyG", AuthRoles.ADMIN.name());
			userService.addRoleToUser("maryW", AuthRoles.USER.name());
		};
	}

}
