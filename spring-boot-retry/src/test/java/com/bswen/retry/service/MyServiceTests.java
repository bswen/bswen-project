package com.bswen.retry.service;

import com.bswen.retry.service.common.MyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by xxx on 2017-1-20.
 *
 * @author xxx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyServiceTests {
    @Autowired
    private MyService myService;

    @Test
    public void testRetry1() throws MyException {
        assertTrue(myService.mayFailedCall());
        assertTrue(myService.getMayFailedCallTimes()==3);
    }
}
