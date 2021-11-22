package org.apache.camel.camel17202example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:camel.xml")
public class Camel17202ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Camel17202ExampleApplication.class, args);
	}

}
