package com.bswen;

import com.bswen.dao.ModelRiskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 * User: bswen
 * Date: 15-7-26
 * Time: 下午10:40
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
public class MybatisApp implements CommandLineRunner {
    @Autowired
    private ModelRiskDao modelRiskDao;

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(MybatisApp.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("model risk count = "+modelRiskDao.countModelRisk());
    }
}
