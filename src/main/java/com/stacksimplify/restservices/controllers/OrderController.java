package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrdersOptional(@PathVariable Long userId) throws UserNotFoundException{
		
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return userOptional.get().getOrder();
		//List<Order> allOrders =  userOptional.get().getOrder();
		//Resources<Order> finalReources = new Resources<Order>(allOrders);
		
		//return finalReources;
	}
	
	//create order
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
	}
}
