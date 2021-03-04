package com.bswen.sbmr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis2")
public class Redis2Property extends RedisCommonProperty {
}
