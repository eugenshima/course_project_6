package com.example.courseProjectSpring.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NameOfProduct;
    private String Band;
    private int Cost;
    private boolean isReady;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(Long id, String nameOfProduct, String band, int cost, boolean isReady, String image, ProductType productType) {
        this.id = id;
        NameOfProduct = nameOfProduct;
        Band = band;
        Cost = cost;
        this.isReady = isReady;
        this.image = image;
        this.productType = productType;
    }

    @ManyToOne
    @JsonIgnore
    private ProductType productType;

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

//    @ManyToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    private Set<Order> Order;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return NameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        NameOfProduct = nameOfProduct;
    }

    public String getBand() {
        return Band;
    }

    public void setBand(String band) {
        Band = band;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", NameOfProduct='" + NameOfProduct + '\'' +
                ", Band='" + Band + '\'' +
                ", Cost=" + Cost +
                ", isReady=" + isReady +
                '}';
    }
}
