package com.mykafka.orderservice.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mykafka.orderservice.Entity.Order;
import com.mykafka.orderservice.Service.OrderService;
import com.mykafka.orderservice.dto.OrderEvent;

@Service
public class OrderConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

	@Autowired
	private OrderService orderService;
	
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(OrderEvent event) {

		LOGGER.info(String.format("Order Recive => %s", event.toString()));
		
		System.out.println(event.getOrder());
		
		Order order=new Order();
		order.setName(event.getOrder().getName());
		order.setPrice(event.getOrder().getPrice());
		order.setQty(event.getOrder().getQty());
		order.setOrderId(event.getOrder().getOrderId());
		
		//Save the order event into database
		Order saveOrder = orderService.saveOrder(order);
		System.out.println(saveOrder);
	}

}
