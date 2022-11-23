package com.mykafka.orderservice.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mykafka.base_domains.dto.Order;
import com.mykafka.base_domains.dto.OrderEvent;
import com.mykafka.orderservice.Kafka.OrderProducer;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private OrderProducer orderProducer;
	
	
	
	public OrderController(OrderProducer orderProducer) {
		this.orderProducer = orderProducer;
	}



	@PostMapping("/create")
	public ResponseEntity<Order> createOrder(@RequestBody Order order)
	{
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent=new OrderEvent();
		orderEvent.setMessage("order status is pending state...");
		orderEvent.setOrder(order);
		orderEvent.setStatus("PENDING");
		
		orderProducer.sendMessage(orderEvent);
		
		return new ResponseEntity<Order>(order, HttpStatus.OK);
		
	}
	
}
