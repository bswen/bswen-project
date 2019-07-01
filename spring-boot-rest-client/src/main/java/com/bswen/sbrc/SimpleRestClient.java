package com.bswen.sbrc;

import com.bswen.sbrc.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class SimpleRestClient {
	private static final Logger log = LoggerFactory.getLogger(SimpleRestClient.class);


	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://localhost:8080/quote", Quote.class);
		log.info(quote.toString());
	}
}
