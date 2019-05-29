package com.bswen.sbah.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by xxx on 2018/4/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsyncService {
    @Autowired
    private AsyncService asyncService;
    private static CountDownLatch latch = new CountDownLatch(1);

    //run after every testcase, wait for at most 2 seconds and then exit.
    //You would not see the result print out if remove this method
    @After
    public void waitForResult() {
        try {
            latch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAsyncHello() {
        asyncService.asyncHello();
    }

    @Test
    public void testHelloWorld() {
        asyncService.async1();
    }

    @Test
    public void testAsyncWithFuture() {
        Future<String> result = asyncService.asyncWithResult();
        try {
            assertTrue(result.get().equals("hi springboot async"));
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
