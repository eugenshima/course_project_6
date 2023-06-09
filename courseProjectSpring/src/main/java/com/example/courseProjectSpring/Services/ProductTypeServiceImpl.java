package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.ProductType;
import com.example.courseProjectSpring.Repository.ProductTypeRepository;
import com.example.courseProjectSpring.ServiceInterfaces.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Transactional
    @Override
    public ProductType save(ProductType productType) {

        return productTypeRepository.save(productType);
    }


}
