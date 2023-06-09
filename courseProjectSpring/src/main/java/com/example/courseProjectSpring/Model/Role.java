package com.example.courseProjectSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String UserRole;


    @OneToOne
    private Customer customer;

    public Role(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    //    @OneToOne
//    @JoinColumn(name ="customer_id")
//    private Customer customer;

    /*public Role(User userRole) {
        this.userRole = userRole;
    }*/

//    public Role(Customer customer) {
//        this.customer = customer;
//    }

    public Role(Long id) {
        this.id = id;
        this.UserRole = "Customer";
    }

    public Role() {
        this.UserRole = "Customer";
    }


    public Role(Long id, String userRole) {
        this.id = id;
        UserRole = userRole;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", UserRole='" + UserRole + '\'' +
                '}';
    }
}
