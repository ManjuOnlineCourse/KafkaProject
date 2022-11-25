package com.mykafka.orderservice.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykafka.orderservice.Entity.Order;
import com.mykafka.orderservice.Service.OrderService;
import com.mykafka.orderservice.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Order saveOrder(Order order) {
		Order save = orderRepo.save(order);
		return save;
	}

}
