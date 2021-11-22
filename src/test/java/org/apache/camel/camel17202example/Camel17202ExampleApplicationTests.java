package org.apache.camel.camel17202example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class Camel17202ExampleApplicationTests {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test 
	void test1() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/camel/test1",
				String.class)).isEqualTo("api-one");
	}
	@Test 
	void test2() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/camel/test2",
				String.class)).isEqualTo("api-two");
	}
}
