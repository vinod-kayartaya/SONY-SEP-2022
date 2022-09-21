package com.sony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sony.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
