package fr.reservations.common.configuration.datasource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

//@EnableTransactionManagement
@EnableJpaRepositories("fr.reservations.dao.repository")
@EntityScan(basePackages = "fr.reservations.dao.entity")
@Configuration
public class DataSourceConfiguration {

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		localContainerEntityManagerFactoryBean.setDataSource(dataSource());
//		localContainerEntityManagerFactoryBean.setPersistenceUnitName("persitent");
//		localContainerEntityManagerFactoryBean.setPackagesToScan("fr.reservations.persistence.entity");
//		return localContainerEntityManagerFactoryBean;
//	}
//
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//		return transactionManager;
//	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public HikariDataSource dataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
}
