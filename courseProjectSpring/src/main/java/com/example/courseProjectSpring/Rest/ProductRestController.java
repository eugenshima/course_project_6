package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.Product;
import com.example.courseProjectSpring.ServiceInterfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    ProductService productService;


    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    public ProductRestController() {
    }



    @GetMapping("/All")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id) {
        //Long userId = product.getId();
        Optional<Product> findProduct = productService.getById(id);
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProduct(@PathVariable("id") Long id,@RequestBody Product product) {
        Product editedProduct = productService.edit(product, id); // TODO: 05.05.2023 edit у меня тут
        return new ResponseEntity<>(editedProduct, HttpStatus.ACCEPTED);
    }

    @GetMapping("/byband/{band}/{id}")
    public ResponseEntity<?> getProductsByBand(@PathVariable("band") String band, @PathVariable("id") Long id) {
        List<Product> findProduct = productService.getByBand(band, id);
        return new ResponseEntity<>(findProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        Product newProduct = productService.delete(id);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @GetMapping("/AllExcel")
    public List<Product> getAllExcel() {
        return productService.getAllExcel();
    }


    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }
}
