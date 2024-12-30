package com.bswen.sbr2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class Redis2Configuration {

    @Autowired
    private Redis2Property redis2Property;

    @Primary
    @Bean(name = "redis2ConnectionFactory")
    public RedisConnectionFactory userRedisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(
                redis2Property.getHost(), redis2Property.getPort());
        return new JedisConnectionFactory(config);
    }

//    private JedisPoolConfig getPoolConfig() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxIdle(8);
//        jedisPoolConfig.setMinIdle(1);
//        jedisPoolConfig.setMaxTotal(8);
//        return jedisPoolConfig;
//    }

    @Bean(name = "redis2StringRedisTemplate")
    public StringRedisTemplate userStringRedisTemplate(@Qualifier("redis2ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        return stringRedisTemplate;
    }

    @Bean(name = "redis2RedisTemplate")
    public RedisTemplate userRedisTemplate(@Qualifier("redis2ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        //setSerializer(stringRedisTemplate);
        return stringRedisTemplate;
    }

}
