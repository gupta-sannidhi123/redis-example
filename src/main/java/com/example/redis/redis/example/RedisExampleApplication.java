package com.example.redis.redis.example;

import com.example.redis.redis.example.entity.Product;
import com.example.redis.redis.example.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
@EnableCaching
public class RedisExampleApplication {

    @Autowired
    public ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(RedisExampleApplication.class, args);
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productDao.save(product);
    }

    @GetMapping
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @GetMapping("{id}")
    public Product findById(@PathVariable int id) {
        return productDao.findProductById(id);
    }

    @DeleteMapping("{id}")
    public String deleteById(int id) {
       return productDao.deleteProduct(id);

    }

}
