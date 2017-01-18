package com.bswen.sbut.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xxx on 2017-1-18.
 *
 * @author xxx
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoServiceTests {
    @Autowired
    private DemoService demoService;

    @Test
    public void testAddCount() {
        assertThat(demoService.addCount(1,1)).isEqualTo(2);
    }
}
