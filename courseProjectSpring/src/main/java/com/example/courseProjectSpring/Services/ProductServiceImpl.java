package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Product;
import com.example.courseProjectSpring.Repository.ProductRepository;
import com.example.courseProjectSpring.Repository.ProductTypeRepository;
import com.example.courseProjectSpring.ServiceInterfaces.ProductService;
import com.example.courseProjectSpring.exportDataToExcel.ExcelExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductServiceImpl() {
    }

    @Transactional
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional
    @Override
    public Product save(Product product) { // TODO: 05.05.2023  связь Product и ProductType еще прописать...
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Product delete(Long id) {
        //Product product = productRepository.findProductById(id);
        return productRepository.deleteProductById(id);
    }

    @Transactional
    @Override
    public Product edit(Product newProduct, Long id) {
        Product oldProject = productRepository.findProductById(id);
        newProduct.setId(oldProject.getId());
        return productRepository.save(newProduct);
    }


    @Transactional
    @Override
    public List<Product> getByBand(String band, Long id) {
        return productRepository.findByBandName(band, id);
    }

    @Transactional
    @Override
    public Optional<Product> getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllExcel() {
        String filePath = "C:\\Users\\eugen\\OneDrive\\Рабочий стол\\Курсовой проект (6 сем)\\MyExcel.xlsx";
        List<Product> allProductExcel = productRepository.findAll();
        ExcelExporter.exportToExcel(allProductExcel, filePath);
        return allProductExcel;
    }
}
