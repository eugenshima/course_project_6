package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.Order;
import com.example.courseProjectSpring.ServiceInterfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> Order(@RequestBody Order order) {
        try {
            Order savedCustomer = orderService.Save(order);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
