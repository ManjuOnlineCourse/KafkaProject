package com.my.hotel.Service;

import java.util.List;

import com.my.hotel.Entity.Order;


public interface OrderService {
	public List<Order> findAll();
	public Order findById(Long id);
	public Order saveOrder(Order order);
	
}
