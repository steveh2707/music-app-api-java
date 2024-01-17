package com.stephenhanna.trebleapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${treble.openapi.dev-url}")
    private String devUrl;

    @Value("${treble.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development Environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production Environment");

        Contact contact = new Contact();
        contact.setEmail("stephen@stephenhanna.com");
        contact.setName("Stephen Hanna");
        contact.setUrl("https://stephenhanna.com");

        Info info = new Info()
                .title("Treble API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage Treble app")
                .termsOfService("stephen@stephenhanna.com");

        return new OpenAPI()
                .info(info)
                .servers(List.of(devServer, prodServer));
    }
}
