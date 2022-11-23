package com.my.hotel.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.hotel.Entity.Order;
import com.my.hotel.Exceptions.ResourceNotFoundException;
import com.my.hotel.Repo.OrderRepo;
import com.my.hotel.Service.OrderService;
import com.my.hotel.prPirce.ItemPrices;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo orderRepo;
	
	@Override
	public List<Order> findAll() {
		List<Order> allOrders = orderRepo.findAll();
		return allOrders;
	}

	@Override
	public Order findById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order", "orderId", id));
		return order;
	}

	@Override
	public Order saveOrder(Order order) {
		
		int tea = order.getTea()*ItemPrices.TEA;
		int coffee = order.getCoffee() * ItemPrices.COFFEE;
		
		order.setBill(coffee+tea);
		
		Order save = orderRepo.save(order);
		
		return save;
	}

}
