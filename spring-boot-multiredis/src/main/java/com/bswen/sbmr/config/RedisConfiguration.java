package com.bswen.sbmr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {

    @Autowired
    private Redis1Property redis1Property;

    @Autowired
    private Redis2Property redis2Property;

    @Primary
    @Bean(name = "redis1ConnectionFactory")
    public RedisConnectionFactory userRedisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(redis1Property.getHost());
        redisConnectionFactory.setPort(redis1Property.getPort());
        redisConnectionFactory.setDatabase(redis1Property.getDatabase());
        redisConnectionFactory.setPoolConfig(getPoolConfig());
        return redisConnectionFactory;
    }

    private JedisPoolConfig getPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(8);
        jedisPoolConfig.setMinIdle(1);
        jedisPoolConfig.setMaxTotal(8);
        return jedisPoolConfig;
    }

    @Bean(name = "redis1StringRedisTemplate")
    public StringRedisTemplate userStringRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        return stringRedisTemplate;
    }

    @Bean(name = "redis1RedisTemplate")
    public RedisTemplate userRedisTemplate(@Qualifier("redis1ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        //setSerializer(stringRedisTemplate);
        return stringRedisTemplate;
    }

    @Bean(name = "redis2ConnectionFactory")
    public RedisConnectionFactory roleRedisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(redis2Property.getHost());
        redisConnectionFactory.setPort(redis2Property.getPort());
        redisConnectionFactory.setDatabase(redis2Property.getDatabase());
        redisConnectionFactory.setPoolConfig(getPoolConfig());
        return redisConnectionFactory;
    }

    @Bean(name = "redis2StringRedisTemplate")
    public StringRedisTemplate roleStringRedisTemplate(@Qualifier("redis2ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        return stringRedisTemplate;
    }

    @Bean(name = "redis2RedisTemplate")
    public RedisTemplate roleRedisTemplate(@Qualifier("redis2ConnectionFactory") RedisConnectionFactory cf) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(cf);
        //setSerializer(stringRedisTemplate);
        return stringRedisTemplate;
    }

    private void setSerializer(RedisTemplate<String, String> template) {
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

}
