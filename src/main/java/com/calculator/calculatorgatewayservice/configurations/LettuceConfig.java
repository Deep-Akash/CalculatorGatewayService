package com.calculator.calculatorgatewayservice.configurations;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by akashdeepnew on 27/12/18.
 */
//@Configuration
public class LettuceConfig {

//    @Bean(destroyMethod = "shutdown")
//    ClientResources clientResources() {
//        return DefaultClientResources.create();
//    }
//
//    @Bean(destroyMethod = "shutdown")
//    RedisClient redisClient(ClientResources clientResources) {
//        return RedisClient.create(clientResources, RedisURI.create("127.0.0.1", 6379));
//    }
//
//    @Bean(destroyMethod = "close")
//    StatefulRedisConnection<String, String> connection(RedisClient redisClient) {
//        return redisClient.connect();
//    }
}
