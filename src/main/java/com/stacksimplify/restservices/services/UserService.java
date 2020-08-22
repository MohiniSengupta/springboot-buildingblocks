package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistsException{
		
		User  existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser != null) {
			throw new UserExistsException("user already exists in repository");
		}
			return userRepository.save(user);
	}
	
	// user by id
	
	public Optional<User> getUserById(long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("User Not Found in User Repository");
		return user;
	}
	
	// update user by id
	public User updateUserById(long id, User user) throws UserNotFoundException{
		
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User Not Found in User Repository, provide correct user id");
		}
		user.setUserid(id);
		return userRepository.save(user);
	}
	
	// delete user by id
	
	public void deleteUserById(long id) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User Not Found in User Repository, provide correct user id");
		}
		userRepository.deleteById(id);
	}
	
	//get user by username
	public User getUserByUsername(String username) {
		return  userRepository.findByUsername(username);
	}
}
