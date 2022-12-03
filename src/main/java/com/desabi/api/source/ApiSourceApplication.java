package com.desabi.api.source;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSourceApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer() {
		return builder -> builder.serializerByType(ObjectId.class, new ToStringSerializer());
	}
}
