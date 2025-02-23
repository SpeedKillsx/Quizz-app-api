package com.speedkillsx.quizzapp.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(
                new Info().title("QuizzApp API")
                .version("1.0")
                .description("QuizzApp API description")
                .contact(
                        new Contact()
                                .name("Speedkillsx")
                                .email("speedkillsx@gmail.com")

                )
        );
    }

}
