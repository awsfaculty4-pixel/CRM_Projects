package com.example.demo.payload;

import jakarta.validation.constraints.*;

public class RegisterRequest {
	@NotBlank
	private String name;
	@Email
	private String email;
	private String contact;
	private String city;
	@NotBlank
	private String password;
	private String role = "USER";


	// getters and setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getContact() { return contact; }
	public void setContact(String contact) { this.contact = contact; }
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
}
