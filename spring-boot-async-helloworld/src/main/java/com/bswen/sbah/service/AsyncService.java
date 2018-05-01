package com.bswen.sbah.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by xxx on 2018/4/27.
 */
@Service
public class AsyncService {
    private static Log log = LogFactory.getLog(AsyncService.class);

    @Async
    public void asyncHello() {
        log.info("hi,springboot async hello,"
                +Thread.currentThread().getName());
    }

    @Async("customFixedThreadPool")
    public void async1() {
        log.info("hi,springboot async,"
                +Thread.currentThread().getName());
    }

    @Async("customFixedThreadPool")
    public Future<String> asyncWithResult() {
        try {
            Thread.sleep(2*1000);
            log.info("hi,springboot async with return value,"
                    +Thread.currentThread().getName());
            return new AsyncResult<String>("hi springboot async");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
