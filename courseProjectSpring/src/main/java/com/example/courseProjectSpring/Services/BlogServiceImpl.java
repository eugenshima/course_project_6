package com.example.courseProjectSpring.Services;

import com.example.courseProjectSpring.Model.Blog;
import com.example.courseProjectSpring.Model.Customer;
import com.example.courseProjectSpring.Model.Product;
import com.example.courseProjectSpring.Repository.BlogRepository;
import com.example.courseProjectSpring.ServiceInterfaces.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Transactional
    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Transactional
    @Override
    public List<Blog> getAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        return blogRepository.findAll();
    }
    @Transactional
    @Override
    public Optional<Blog> getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return blogRepository.findById(id);
    }
}
