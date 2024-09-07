package bo.com.bisablog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				title = "Api blog",
				description = "Evlaucioon",
				termsOfService = "bisa.com/terminos",
				version = "1.0.0",
				contact = @Contact(
						name = "Marcelo Ruiz",
						url = "www.bisa.gob.bo",
						email = "mackciber@gmail.com"
						),
				license = @License(
						name = "Marelo",
						url = "www.bisa.com.bo",
						identifier = "2.2.2.2.2.2.2"
						
						)
				),
		servers = {
				@Server(
						description = "DEV SERVER",
						url = "http://localhost:8080"
						),
				@Server(
						description = "PROD SERVER",
						url = "http://bisa.com:8080"
						)
		}
)
public class SwaggerConfig {

}
