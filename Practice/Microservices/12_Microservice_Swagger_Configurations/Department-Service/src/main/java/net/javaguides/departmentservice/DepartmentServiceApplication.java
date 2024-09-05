package net.javaguides.departmentservice;

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
				description = "SpringBoot Department Service",
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
				description = "Department Services",
				url = "Ankit/external"
		)
)
@SpringBootApplication
//No need removed in upper version
//@EnableEurekaClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
