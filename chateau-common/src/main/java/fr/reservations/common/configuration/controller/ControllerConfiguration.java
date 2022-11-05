package fr.reservations.common.configuration.controller;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
@ComponentScan(value = "fr.reservations.controller")
public class ControllerConfiguration {

//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver multipartResolver() {
//	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//	    multipartResolver.setMaxUploadSize(500000);
//	    return multipartResolver;
//	}
	
//	@Bean
//	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customize() {
//		return factory -> {
//			factory.setContextPath("/rest");
//			factory.setPort(8086);
//			factory.addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
//		};
//	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder().group("fr.reservations").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info().title("Contrat d'interface").version("1.0.0")
						.license(new License().name("http://alaa.com")))
				.externalDocs(
						new ExternalDocumentation().description("documentation officielle").url("http://alaa.com"));
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
