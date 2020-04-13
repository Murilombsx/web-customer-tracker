package com.luv2code.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();		
		managerFactoryBean.setJpaVendorAdapter(vendorAdapter);		
		managerFactoryBean.setDataSource(this.configurateDataSource());		
		managerFactoryBean.setJpaProperties(this.configurateProperties());		
		managerFactoryBean.setPackagesToScan("com.luv2code.entity");
		
		return managerFactoryBean;		
	}
	
	@Bean
	public JpaTransactionManager transacionManager(EntityManagerFactory managerFactory) {
		return new JpaTransactionManager(managerFactory);
	}
	
	private DriverManagerDataSource configurateDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		return dataSource;
	}
	
	private Properties configurateProperties(){
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return props;
	}
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
}