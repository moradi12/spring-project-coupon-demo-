package Openconnection.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {


    /**
     * Define OpenAPI documentation bean
     *
     * @return OpenAPI object representing the API documentation
     */
    @Bean
    public OpenAPI defineOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Coupon api for development");

        Contact myContact = new Contact();
        myContact.setName("Tamir");
        myContact.setEmail("Tamir @gmail.com");

        Info info = new Info()
                .title("Coupon Management System API")
                .version("1.0")
                .description("This API exposes endpoints to manage Coupons")
                .contact(myContact);

        return new OpenAPI().info(info).servers(List.of(server));

    }
}