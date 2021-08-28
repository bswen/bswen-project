package sba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: bswen
 * Date: 15-7-26
 * Time: 下午10:40
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@ImportResource({"classpath*:applicationContext.xml"})
public class MyApp {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(MyApp.class, args);

//        ApplicationContext applicationContext = SpringApplication.run(MyApp.class, args);
//        for (String name : applicationContext.getBeanDefinitionNames()) {
//            System.out.println(name);
//        }
    }
}
