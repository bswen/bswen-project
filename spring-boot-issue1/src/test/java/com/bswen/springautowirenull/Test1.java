package com.bswen.springautowirenull;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by xxx on 2017-1-18.
 *
 * @author xxx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1 {

    @Test(expected = NullPointerException.class)
    public void testNull() {
        MyService myService = new MyService();
        myService.getHello();
    }

    @Test
    public void testNotNull() {
        assertTrue(myService.getHello()!=null);
    }

    @Autowired
    private MyService myService;
}
