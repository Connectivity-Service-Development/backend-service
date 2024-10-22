package com.skoda.tenderconnectivity.backendservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi() {
        Contact myContact = new Contact();
        myContact.setName("To Be Defined");
        myContact.setEmail("tbd@gmail.com");

        Info information = new Info()
                .title("Sample API")
                .version("1.0")
                .description("This API exposes sample endpoint to demonstrate swagger-ui.")
                .contact(myContact);
        return new OpenAPI().info(information);

    }
}