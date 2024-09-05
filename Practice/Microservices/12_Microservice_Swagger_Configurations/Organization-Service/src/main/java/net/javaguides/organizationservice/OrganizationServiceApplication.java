package net.javaguides.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info=@Info(
				title = "SpringBoot RestAPI Documentation",
				description = "SpringBoot Organization Service",
				version = "2.3.1",
				contact = @Contact(
						name = "Ankit",
						email = "Ankit@gmail.com",
						url = "https://successmee.com"
				),
				license = @License(
						name = "apache 2.0",
						url = "Ankit/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service",
				url = "Ankit/external"
		)
)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
