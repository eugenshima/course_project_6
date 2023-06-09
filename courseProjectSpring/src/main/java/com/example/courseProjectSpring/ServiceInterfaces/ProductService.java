package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    Product save(Product product);

    Product delete(Long id);

    Product edit(Product product, Long id);

    List<Product> getByBand(String band, Long id);

    List<Product> getAll();
    Optional<Product> getById(Long id);

    List<Product> getAllExcel();
}
