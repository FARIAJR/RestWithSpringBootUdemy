package br.com.projects.udemy.java.config;

import java.awt.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("br.com.projects"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("title", "description", "version", "termsOfServiceUrl", "contactName", "license", "licenseUrl");
				
				
//				ApiInfo(
//				"RESTFul API with SpringBoot",
//				"Description", 
//				"version v1", 
//				"termsOfServiceUrl", 
//				new Contact("Luiz Faria Jr", "google.com", "luiz.fariajr@outlook.com"),
//				"license", 
//				new List());
	}
}
