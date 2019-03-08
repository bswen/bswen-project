package com.bswen.sbissue1.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/3/8.
 */
@Component
public class Runner1 implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(Runner1.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("runner1 started");
    }
}
