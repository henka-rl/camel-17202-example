/**
 * 
 */
package org.apache.camel.camel17202example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author henka
 *
 */
@Component
public class APIRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("servlet:/test1")
			.setHeader("email", constant("user@test.com"))
			.to("api-one:GetUser?bridgeEndpoint=true");

		from("servlet:/test2")
			.setHeader("email", constant("user@test.com"))
			.to("api-two:GetUser?bridgeEndpoint=true");
		
		from("undertow:http://localhost:8081/api/users?matchOnUriPrefix=true")
			.log("api-one")
			.setBody(constant("api-one"));

		from("undertow:http://localhost:8082/api/users?matchOnUriPrefix=true")
			.log("api-two")
			.setBody(constant("api-two"));
		

	}

}
