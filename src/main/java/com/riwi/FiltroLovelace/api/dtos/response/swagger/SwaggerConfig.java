package com.riwi.FiltroLovelace.api.dtos.response.swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;



@Configuration
@OpenAPIDefinition(info = @Info(contact = @Contact(name = "Juan esteban patiño", url = "https://github.com/juanpava1020", email = "jepv1020@gmail.com"), title = "Documentation: filtroLovelace", version = "1.0.0"))
    @Server(description = "Local ENV", url = "http://localhost:8080/api/v1")

public class SwaggerConfig {

}
