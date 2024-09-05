package net.javaguides.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//Java configuration class


@SpringBootApplication
//http://localhost:8080/swagger-ui/index.html
//genral overview of applications for swagger
@OpenAPIDefinition(
		info=@Info(
				title = "SpringBoot RestAPI Documentation",
				description = "SpringBoot RestAPI Description",
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
				description = "Practicing SpringbOOt RESTAPI",
				url = "Ankit/external"
		)
)
public class SpringbootRestfullWebservicesApplication {
	//create modelmapper bean
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebservicesApplication.class, args);
	}

}
