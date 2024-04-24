package com.example.redis.redis.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash("Product") //to store as hash in redis
public class Product implements Serializable {
    @Id
    private int id;
    private String name;
    private int age;
    private long price;

}
