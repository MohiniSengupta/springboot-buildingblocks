package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;

@RestController 
public class UserController {
	
	// auto wire user service
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	//create user
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	
	// get user by id
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") long id){
		return userService.getUserById(id);
		
	}
	
	//update user by id
	@PutMapping("/users/{id}")
	public User upgateUserById(@PathVariable("id") long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	//dlete user by id
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") long id) {
		userService.deleteUserById(id);
	}
	
	//get user by username
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}
}
