package com.bswen.sbmr.service;

import com.bswen.sbmr.MultiRedisApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MultiRedisTestRunner /*implements CommandLineRunner*/ {
    private final static Logger logger = LoggerFactory.getLogger(MultiRedisApplication.class);

    @Autowired
    @Qualifier("redis1StringRedisTemplate")
    private StringRedisTemplate userStringRedisTemplate;
    @Autowired
    @Qualifier("redis2StringRedisTemplate")
    private StringRedisTemplate roleStringRedisTemplate;

    //@Override
    public void run(String... strings) throws Exception {
        //CountDownLatch latch = new CountDownLatch(1);
        try {
            for (int i = 0; i < 10; i++) {
                logger.info("=====================================================================");
                logger.info("start loop " + i);
                String key = "key" + i;
                userStringRedisTemplate.opsForValue().set(key, "value" + i);
                roleStringRedisTemplate.opsForValue().set(key, "value" + (i + 1));

                String primaryKeyValue = userStringRedisTemplate.opsForValue().get(key);
                String secondaryKeyValue = roleStringRedisTemplate.opsForValue().get(key);

                logger.info("=====================================================================");
                logger.info(String.format("read from the redis1, key %s value is %s", key, primaryKeyValue));
                logger.info(String.format("read from the redis2, key %s value is %s", key, secondaryKeyValue));
            }
        }finally {
            //latch.await();
        }

        // you can also check the value with redis-cli
    }
}
