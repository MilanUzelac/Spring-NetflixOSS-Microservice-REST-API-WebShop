package com.example.orders;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order,Long> {
    public Optional<Order> findOrderByUserId(Long userId);
}
