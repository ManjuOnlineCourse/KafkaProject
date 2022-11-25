package com.mykafka.orderservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mykafka.orderservice.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
