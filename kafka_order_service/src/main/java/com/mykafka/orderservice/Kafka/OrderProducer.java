package com.mykafka.orderservice.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.mykafka.orderservice.dto.OrderEvent;



@Service
public class OrderProducer {
	
	private NewTopic topic;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;

	public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(OrderEvent event) {
		
		LOGGER.info(String.format("Oder Event => %s", event.toString()));
		
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build(); 
		
		ListenableFuture<SendResult<String, OrderEvent>> future = kafkaTemplate.send(message);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, OrderEvent>>() {

			@Override
	        public void onSuccess(SendResult<String, OrderEvent> result) {
	            System.out.println("Sent message=[" + message + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            System.out.println("Unable to send message=[" 
	              + message + "] due to : " + ex.getMessage());
	        }
		});
	}
}
