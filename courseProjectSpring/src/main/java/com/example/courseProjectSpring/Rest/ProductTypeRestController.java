package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.ProductType;
import com.example.courseProjectSpring.ServiceInterfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeRestController {
    @Autowired
    ProductTypeService productTypeService;

    @PostMapping("/add")
    public ResponseEntity<ProductType> addProductType(@RequestBody ProductType productType) {
        ProductType newProductType = productTypeService.save(productType);
        return new ResponseEntity<>(newProductType, HttpStatus.CREATED);
    }

}
