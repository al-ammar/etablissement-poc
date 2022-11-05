package fr.reservations.common.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import fr.reservations.common.configuration.controller.ControllerConfiguration;
import fr.reservations.common.configuration.datasource.DataSourceConfiguration;
import fr.reservations.common.configuration.services.ApplicationConfiguration;

@EnableAutoConfiguration
@SpringBootApplication
@Import({ ApplicationConfiguration.class, DataSourceConfiguration.class, ControllerConfiguration.class, })

public class ServicesApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplication(ServicesApplication.class).run();
	}

}
