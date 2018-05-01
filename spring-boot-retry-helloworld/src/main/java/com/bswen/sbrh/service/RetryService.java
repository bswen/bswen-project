package com.bswen.sbrh.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * Created by xxx on 2018/5/1.
 */
@Component
public class RetryService {
    private static Log log = LogFactory.getLog(RetryService.class);
    private int retryTimes = 0;

    @Retryable
    public boolean mayFailMethod() throws Exception {
        retryTimes++;
        log.info("do mayFailMethod "+retryTimes);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        if(retryTimes<3) {
            throw new Exception("failed");
        }else {
            log.info("mayFailMethod success");
            return true;
        }
    }
}
