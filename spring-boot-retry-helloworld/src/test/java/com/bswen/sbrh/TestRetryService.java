package com.bswen.sbrh;

import com.bswen.sbrh.service.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created on 2018/5/1.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRetryService {
    @Autowired
    private RetryService retryService;

    @Test
    public void testRetryHelloWorld() {
        try {
            boolean result = retryService.mayFailMethod();
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}