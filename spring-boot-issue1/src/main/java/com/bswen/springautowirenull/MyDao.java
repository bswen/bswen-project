package com.bswen.springautowirenull;

import org.springframework.stereotype.Component;

/**
 * Created on 2019/7/1.
 */
@Component
public class MyDao {

    public String queryHello() {
        return "hello world spring from bswen.com";
    }
}
