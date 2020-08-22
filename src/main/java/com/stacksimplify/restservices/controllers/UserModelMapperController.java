package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.dtos.UserMmDTO;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.services.UserService;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {

	
	// auto wire user service
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// get user by id
		@GetMapping("/{id}")
		public UserMmDTO getUserById(@PathVariable("id") @Min(1) long id) throws UserNotFoundException {
		
				Optional<User> userOptional = userService.getUserById(id);
				if(!userOptional.isPresent())
					throw new UserNotFoundException("User not found!!");
			
				User user = userOptional.get();
				UserMmDTO userDto = modelMapper.map(user, UserMmDTO.class);
				return userDto;
		}
}
