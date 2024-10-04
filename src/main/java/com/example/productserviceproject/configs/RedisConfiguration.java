package com.example.productserviceproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String,Object> createRedisTemplate(RedisConnectionFactory connectionFactory){
        //Redis is exactly like hashmap, but in our case we are storing products. Also i might store Users infuture - so make it object
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
    //So we can Autowire this RedisTemplate in any class where we want to use Redis
}
/*
if we had to make an API call to a 3rd party API, we would have to create a RestTemplate object.
Similarly, if we have to make a call to a Redis server, we would have to create a RedisTemplate object.

Note- Typicaly key as an object is not a good practice, key is something that we search with internally it should be hashed
A object as a key will be very difficult to hash. so ideally, key should be a string or Integer.
 */