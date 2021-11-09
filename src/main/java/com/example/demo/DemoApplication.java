package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static class environHolder {
		@Autowired
		private Environment env;
	}

	public static void main(String[] args) {
		HashMap<String, Object> props = new HashMap<>();
		int port = Integer.parseInt(System.getenv().get("PORT"));
		System.out.println(port);
		props.put("server.port", port);

		new SpringApplicationBuilder()
				.sources(DemoApplication.class)
				.properties(props)
				.run(args);
//		SpringApplication.run(DemoApplication.class, args);
	}

}