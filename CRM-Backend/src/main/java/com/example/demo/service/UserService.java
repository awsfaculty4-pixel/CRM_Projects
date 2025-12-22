package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;


	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


	public User register(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	return userRepository.save(user);
	}


	public Optional<User> findByEmail(String email) { return userRepository.findByEmail(email); }


	public List<User> findAll() { return userRepository.findAll(); }


	public Optional<User> findById(Long id) { return userRepository.findById(id); }


	public User save(User user) { return userRepository.save(user); }


	public void deleteById(Long id) { userRepository.deleteById(id); }


	public boolean checkPassword(User user, String rawPassword) {
	return passwordEncoder.matches(rawPassword, user.getPassword());
	}
}

