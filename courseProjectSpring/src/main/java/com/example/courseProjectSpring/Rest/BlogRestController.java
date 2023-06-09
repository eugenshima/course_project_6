package com.example.courseProjectSpring.Rest;

import com.example.courseProjectSpring.Model.Blog;
import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Product;
import com.example.courseProjectSpring.Model.User;
import com.example.courseProjectSpring.ServiceInterfaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/blog")
public class BlogRestController {
    // TODO: 04.05.2023 помощь
    @Autowired
    private BlogService blogService;

    public BlogRestController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/all")
    public List<Blog> getAllEmployees() {
        return blogService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Blog> addBlog(@RequestBody Blog blog) {
        Blog newBlog = blogService.save(blog);
        return new ResponseEntity<Blog>(newBlog, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getBlog(@PathVariable("id") Long id) {
        //Long userId = product.getId();
        Optional<Blog> findBlog = blogService.getById(id);
        return new ResponseEntity<>(findBlog, HttpStatus.OK);
    }
}
