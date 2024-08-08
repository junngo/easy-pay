package com.ewallet.membership;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;


@Configuration
public class OpenApiConfig {
	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder()
			.group("public")
			.pathsToMatch("/**")
			.build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("E-Wallet Membership API")
				.version("1.0")
				.description("API documentation for E-Wallet Membership")
				.contact(new Contact()
					.name("Support Team")
					.email("support@ewallet.com")
				)
			);
	}
}
