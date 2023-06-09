package com.example.courseProjectSpring.ServiceInterfaces;

import com.example.courseProjectSpring.Model.Blog;
import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Blog save(Blog blog);
    List<Blog> getAll();
    Optional<Blog> getById(Long id);
}
