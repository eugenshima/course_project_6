package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Role;
import com.example.courseProjectSpring.Model.User;
import com.example.courseProjectSpring.Repository.CustomerRepository;
import com.example.courseProjectSpring.ServiceInterfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public Optional<Customer> getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return customerRepository.findById(id);
    }

   /* @Override
    public Customer editCustomerInfo(Customer customer) {
        return customerRepository.save(customer);
    }*/

    @Transactional
    @Override
    public Customer save(Customer customer) {
        User user = new User();
        user.setCustomer(customer);
        customer.setUser(user);
        Role role = new Role();
        role.setCustomer(customer);
        customer.setRole(role);
        return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void delete(Customer customer) {
        //  log.info("IN CustomerServiceImpl delete {}");
        customerRepository.delete(customer);
    }

    @Transactional
    @Override
    public List<Customer> getAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        return customerRepository.findAll();
    }

}
