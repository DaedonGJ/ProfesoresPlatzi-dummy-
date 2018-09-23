package com.platzi.configuration;

import java.util.Properties;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactori() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource((javax.sql.DataSource) dataSource());
		sessionFactoryBean.setPackagesToScan("com.platzi.modelo");
		sessionFactoryBean.setHibernateProperties(hibernatePropeties());
		return sessionFactoryBean;

	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/platziprofesores");
		dataSource.setUsername("platziprofesores");
		dataSource.setPassword("platziprofesores");
		
		return (DataSource) dataSource;
	}

	public Properties hibernatePropeties() {
		Properties propretier = new Properties();
		propretier.put("hibernate.dialect", "hibernate.dialect ");
		propretier.put("show_sql", "true");
		return propretier;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManagger() {
		HibernateTransactionManager  hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactori().getObject());
		return hibernateTransactionManager;
		
	}

}
