package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Order;
import com.example.courseProjectSpring.Model.Product;

import java.util.List;

public interface OrderService {
    Order Save(Order order);

    Order delete(Long id);

    Order edit(Order order, Long id);

    List<Order> getAll();
}
