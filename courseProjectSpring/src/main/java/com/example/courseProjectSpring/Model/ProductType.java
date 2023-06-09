package com.example.courseProjectSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "productType")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isSpecial;

    private String type;

    @OneToMany
    @JsonIgnore
    private Set<Product> product;

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public ProductType() {
    }

    public ProductType(Long id, boolean isSpecial, String type) {
        this.id = id;
        this.isSpecial = isSpecial;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", isSpecial=" + isSpecial +
                ", type='" + type + '\'' +
                '}';
    }
}
