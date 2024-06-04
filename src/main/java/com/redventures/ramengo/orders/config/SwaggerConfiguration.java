package com.redventures.ramengo.orders.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("ramengo-orders")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("RamenGO Orders")
                        .version("1.0.0")
                        .description("Documentation RamenGO"));
    }
}
