package cat.itacademy.barcelonactiva.serrano.victor.s05.t01.n02;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class S05T01N02SerranoVictorApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Spring Boot API")
						.version("0.1")
						.description("API Spring Boot con Swagger - Floristeria")
						.termsOfService("http://swagger.io/terms")
						.license(new License().name
								("Apache Toncat 9.0.78").url("http://springdoc.org")));
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(S05T01N02SerranoVictorApplication.class, args);
	}

}
