package com.jozias.api.infra.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI config() {
        Server devServer = new Server();
        devServer.setDescription("Server URL");
        devServer.setUrl("http://localhost:8070");

        Contact contact = new Contact();
        contact.setEmail("aelciojoziasp@gmail.com");
        contact.setName("Jozias");
        contact.setUrl("https://www.linkedin.com/in/aelcio-jozias/");

        Info info = new Info()
                .title("Jozias API")
                .version("1.0")
                .contact(contact)
                .description("Jozias Api");

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}
