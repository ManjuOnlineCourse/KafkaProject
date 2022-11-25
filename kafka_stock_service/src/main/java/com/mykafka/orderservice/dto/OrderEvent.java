package com.mykafka.orderservice.dto;

import com.mykafka.orderservice.Entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
	
	private String message;
	
	private String status;
	
	private Order order;
	
}
