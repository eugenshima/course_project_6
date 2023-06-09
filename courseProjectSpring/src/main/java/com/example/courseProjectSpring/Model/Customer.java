package com.example.courseProjectSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    //private Long user_id;
//    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

//    @OneToMany()
//    private Set<Order> orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Role role;

    public Customer(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String firstName;

    private String lastName;

    private String email;

    private int budget;

    private int quantityOfOrders;



    public int getQuantityOfOrders() {
        return quantityOfOrders;
    }

    public void setQuantityOfOrders(int quantityOfOrders) {
        this.quantityOfOrders = quantityOfOrders;
    }

    public Customer(long id) {
        this.id=id;
    }

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, String email, int budget) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.budget = budget;
    }

    public Customer(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String address) {
        this.email = address;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + email + '\'' +
                ", budget=" + budget +
                '}';
    }
}
