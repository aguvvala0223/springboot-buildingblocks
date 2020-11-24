package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {

		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return user.get().getOrders();
	}

	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException {

		Optional<User> userOptional = userRepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);

	}

	@GetMapping("/{userId}/orders/{orderId}")
	public Order getOrderByOrderId(@PathVariable Long userId, @PathVariable Long orderId) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found in DB");
		}
	
		User user = userOptional.get();
		List<Order> listOfOrders=user.getOrders();
        for (Order order : listOfOrders) {
        	if (orderId.equals(order.getOrderId())) {
        		return order;
        	}
        }
        return null;

	}

}
