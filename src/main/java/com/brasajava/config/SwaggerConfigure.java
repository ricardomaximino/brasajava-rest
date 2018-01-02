package com.brasajava.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfigure {
	
	private final String title ="BrasaJava REST";
	private final String description = "Capoeira, Cavaquinho and some Programming staff";
	private final String version = "0.1.0";
	private final String termsOfServiceUrl = "TermsOfServiceUrl";
	private final String url ="http://www.brasajava.com";
	private final String email = "ricardomaximino@hotmail.com";
	private final String name = "Ricardo Maximino";
	private final String license = "Free License For Open Source Project";
	private final String licenseUrl = "http://www.license.url.com";
	
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.brasajava"))
		        .build()
		        .apiInfo(getApiInfo())
		        .pathMapping("/");        
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.version(version)
				.termsOfServiceUrl(termsOfServiceUrl)
				.contact(new Contact(name, url, email))
				.license(license)
				.licenseUrl(licenseUrl)
				.build();
	}	
	

}
