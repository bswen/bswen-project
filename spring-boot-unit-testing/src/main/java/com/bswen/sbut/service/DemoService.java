package com.bswen.sbut.service;

import org.springframework.stereotype.Service;

/**
 * Created by xxx on 2017-1-18.
 *
 * @author xxx
 */
@Service("demo")
public class DemoService {
    public int addCount(int add1, int add2) {
        return add1+add2;
    }
}
