package com.my.hotel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.hotel.Entity.Order;
import com.my.hotel.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id) {
		return new ResponseEntity<>(orderService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping("/save/")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.OK);
		
		
	}
	

}
