package com.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.entity.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Order saveOrder(Order order) {
		
		//restTemplate.postForEntity("paymenr", Pay.class, null);
		return orderRepository.save(order);
	}
	
}
