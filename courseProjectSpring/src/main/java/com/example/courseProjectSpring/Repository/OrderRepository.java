package com.example.courseProjectSpring.Repository;

import com.example.courseProjectSpring.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
