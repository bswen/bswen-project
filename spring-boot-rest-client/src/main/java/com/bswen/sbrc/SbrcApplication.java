package com.bswen.sbrc;

import com.bswen.sbrc.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2019/6/27.
 */
@SpringBootApplication
public class SbrcApplication {
    private static final Logger log = LoggerFactory.getLogger(SbrcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SbrcApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://localhost:8080/quote", Quote.class);
            log.info(quote.toString());
        };
    }
}
