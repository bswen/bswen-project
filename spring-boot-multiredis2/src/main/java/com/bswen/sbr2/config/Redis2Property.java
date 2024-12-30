package com.bswen.sbr2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis2")
public class Redis2Property extends RedisCommonProperty {
}
