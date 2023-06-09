package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.ServiceInterfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@RequestMapping(value = "{is}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/byid")
    public ResponseEntity<?> getCustomer(@RequestBody Customer customer1) {
        if (customer1 == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        long customerId = customer1.getId();
        Optional<Customer> customer = this.customerService.getById(customerId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }
    @PostMapping("/edit")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer) {
        Customer customer1 = new Customer();
        Optional<Customer> getCustomer = customerService.getById(customer.getId());
//        customer1.setFirstName(customer.getFirstName());
//        customer1.setLastName(customer.getLastName());
//        customer1.setBudget(customer.getQuantityOfOrders());
//        customer1.setEmail(customer.getEmail());
//        customer1.setQuantityOfOrders(customer.getQuantityOfOrders());
        //customer1.setUser(getCustomer);
        Customer editedCustomer = customerService.save(customer1);

        return new ResponseEntity<>(editedCustomer, HttpStatus.OK);
    }
//    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer) {
//        HttpHeaders headers = new HttpHeaders();
//
//        if (customer == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        this.customerService.save(customer);
//        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
//    }

    /*@GetMapping("/all")
    public  List<Customer> getAllCustomers() {
        return customerService.getAll();
        //return new ResponseEntity<>(customers, HttpStatus.OK);
    }*/



    @GetMapping("/all")
    public List<Customer> getAllEmployees() {
        return customerService.getAll();
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Customer customer) {
//        customerService.delete(customer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<Customer> saveCustomerWithRelations(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.save(customer);
            return ResponseEntity.ok(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /*@PostMapping("/add")
    public ResponseEntity<Customer> addPerson(@RequestBody Customer customer) {
        Customer newPerson = customerService.save(customer);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }*/


}

