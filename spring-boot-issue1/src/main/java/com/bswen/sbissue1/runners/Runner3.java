package com.bswen.sbissue1.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 2019/3/8.
 */
@Component
public class Runner3 implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(Runner3.class);
    Object lock = new Object();

    @Override
    //@PostConstruct
    public void run() {
        logger.debug("runner3 started");
        try {
            synchronized (lock) {
                lock.wait();
            }
            logger.debug("runner3 unlocked");
        }catch (Exception ex) {
            logger.error("",ex);
        }
    }
}
