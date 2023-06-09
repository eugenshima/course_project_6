package com.example.courseProjectSpring.Repository;

import com.example.courseProjectSpring.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.Band = :bandName AND p.id <> :prId")
    List<Product> findByBandName(@Param("bandName") String bandName, @Param("prId") Long id);

    Product deleteProductById(Long id);
    Product findProductById(Long id);

}
