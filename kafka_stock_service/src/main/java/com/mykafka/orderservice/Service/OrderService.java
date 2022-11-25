package com.mykafka.orderservice.Service;

import com.mykafka.orderservice.Entity.Order;

public interface OrderService {
	
	public Order saveOrder(Order order);

}
