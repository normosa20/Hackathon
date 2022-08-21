package com.hackathon.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.app.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
