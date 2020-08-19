package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {

	// Auto wire user repository
	@Autowired
	private UserRepository userRepository;
	
	//get all users
	public List<User> getAllUsers(){
		
		// jpa provides findall method on repository in built
		return userRepository.findAll();
	}
	
	// create user 
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	// user by id
	
	public Optional<User> getUserById(long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	// update user by id
	public User updateUserById(long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	// delete user by id
	
	public void deleteUserById(long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	
	//get user by username
	public User getUserByUsername(String username) {
		return  userRepository.findByUsername(username);
	}
}
