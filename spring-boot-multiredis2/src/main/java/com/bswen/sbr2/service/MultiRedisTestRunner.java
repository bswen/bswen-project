package com.bswen.sbr2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class MultiRedisTestRunner implements CommandLineRunner {
    private final static Logger logger = LoggerFactory.getLogger(MultiRedisTestRunner.class);

    @Autowired
    @Qualifier("redis1StringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("redis2StringRedisTemplate")
    private StringRedisTemplate stringRedis2Template;

    //@Override
    public void run(String... strings) throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        try {
            testRedis1();
            testRedis2();
        }finally {
            latch.await();
        }
    }

    private void testRedis2() {
        try {
            for (int i = 1; i < 2; i++) {
                logger.info("=====================================================================");
                logger.info("start loop redis 2:" + i);
                String key = "k" + i;
                //stringRedisTemplate.opsForValue().set(key, "value" + i);

                String primaryKeyValue = stringRedis2Template.opsForValue().get(key);

                logger.info("=====================================================================");
                logger.info(String.format("read from the redis2, key %s value is %s", key, primaryKeyValue));
            }
        }finally {

        }
    }

    private void testRedis1() {
        try {
            for (int i = 1; i < 2; i++) {
                logger.info("=====================================================================");
                logger.info("start loop redis 1:" + i);
                String key = "k" + i;
                //stringRedisTemplate.opsForValue().set(key, "value" + i);

                String primaryKeyValue = stringRedisTemplate.opsForValue().get(key);

                logger.info("=====================================================================");
                logger.info(String.format("read from the redis1, key %s value is %s", key, primaryKeyValue));
            }
        }finally {
        }
    }
}