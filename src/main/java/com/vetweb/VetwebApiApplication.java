package com.vetweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport // Releases to receive parameters as Pagination
@EnableSwagger2
public class VetwebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetwebApiApplication.class, args);
	}

}
