package com.example.courseProjectSpring.Repository;

import com.example.courseProjectSpring.Model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
