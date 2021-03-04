package com.bswen.sbmr.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MyMessageReceiver {
    private static Log log = LogFactory.getLog(MyMessageReceiver.class);

    public void receiveMessage(String message) {
        log.info("got message "+message);
    }
}
