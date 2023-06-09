package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> getById(Long id);

    //Customer getById(Long id);

    Customer save(Customer customer);

    void delete(Customer customer);

    List<Customer> getAll();

}
