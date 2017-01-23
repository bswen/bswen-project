package com.bswen.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created with IntelliJ IDEA.
 * User: bswen
 * Date: 15-7-26
 * Time: 下午10:40
 * To change this template use File | Settings | File Templates.
 */
@EnableRetry
@SpringBootApplication
public class MyApp {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MyApp.class, args);
    }
}
