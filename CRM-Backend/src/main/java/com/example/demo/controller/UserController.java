package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
	@RequestMapping("/api/users")
	public class UserController {


	@Autowired
	private UserService userService;


	// Publicly accessible for your front-end registration if token not required for POST
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
	User created = userService.register(user);
	return ResponseEntity.ok(created);
	}


	// protected endpoints (JWT) - Security filter will check token
	@GetMapping
	public List<User> getAllUsers() {
	return userService.findAll();
	}


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
	return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}


	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
	return userService.findById(id).map(existing -> {
	existing.setName(user.getName());
	existing.setCity(user.getCity());
	existing.setContact(user.getContact());
	// do not update password here unless handled carefully
	return ResponseEntity.ok(userService.save(existing));
	}).orElse(ResponseEntity.notFound().build());
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
	userService.deleteById(id);
	return ResponseEntity.ok().build();
	}

}
