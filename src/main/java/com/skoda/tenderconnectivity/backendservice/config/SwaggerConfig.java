package com.skoda.tenderconnectivity.backendservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI defineOpenApi() {


        var information = new Info()
                .title("Connectivity Service Backend")
                .version("1.0");
        return new OpenAPI().info(information);

    }
}
