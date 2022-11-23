package com.my.hotel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.hotel.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
