package com.bswen.sbissue1.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/3/8.
 */
@Component
public class Runner2 implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Runner2.class);
    @Autowired
    private Runner3 runner3;
    @Override
    public void run(String... strings) throws Exception {
        logger.debug("runner2 started");

        (new Thread(runner3)).start();
    }
}
