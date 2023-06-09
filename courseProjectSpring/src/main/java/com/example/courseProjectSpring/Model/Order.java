package com.example.courseProjectSpring.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "myOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int totalPrice;

    private int quantity;

    private boolean confirmation;

    @ManyToMany()
    private Set<Product> product;



    public Order() {
    }

    public Order(Long id, int totalPrice, int quantity, boolean confirmation) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.confirmation = confirmation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", confirmation=" + confirmation +
                '}';
    }
}
