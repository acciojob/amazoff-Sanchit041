package com.driver;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository orderRepository = new OrderRepository();
}
