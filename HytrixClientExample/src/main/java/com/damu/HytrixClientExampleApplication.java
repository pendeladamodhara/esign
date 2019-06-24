package com.damu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableZuulProxy
public class HytrixClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HytrixClientExampleApplication.class, args);
	}

	@GetMapping("/client")
	public String getMessage() {
		System.out.println("entered into getmessage method");
		String url = "http://localhost:2018/getMessage";
		RestTemplate template = new RestTemplate();
		return template.getForEntity(url, String.class).getBody();

	}

}
