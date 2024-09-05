package net.javaguides.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info=@Info(
				title = "SpringBoot RestAPI Documentation",
				description = "SpringBoot Employee Service",
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
				description = "Employee Service",
				url = "Ankit/external"
		)
)
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
	//defining spring bean
	/* @Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}*/

	//uncomment this for circuit breaker
	@Bean
public WebClient webClient(){
	return WebClient.builder().build();
}



	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
