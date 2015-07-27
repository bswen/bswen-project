package com.bswen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: bswen
 * Date: 15-7-26
 * Time: 下午10:49
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MyService implements CommandLineRunner {
    static Log log = LogFactory.getLog(MyService.class);

    @Override
    public void run(String... strings) throws Exception {
        try {
            while(true) {
                Thread.sleep(2*1000);
                log.info("I am running...");
            }
        }catch (Exception ex) {
             log.error("Error occurred.",ex);
        }
    }
}
