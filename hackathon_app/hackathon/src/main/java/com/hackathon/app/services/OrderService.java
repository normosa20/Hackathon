package com.hackathon.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.app.models.Order;
import com.hackathon.app.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo;
	
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}
	
}
