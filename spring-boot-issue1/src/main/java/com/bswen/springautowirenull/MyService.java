package com.bswen.springautowirenull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/7/1.
 */
@Service
public class MyService {
    @Autowired
    private MyDao myDao;

    public String getHello() {
        return myDao.queryHello(); //would throw NullPointerException
    }
}
