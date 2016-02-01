package com.rohith.spring.config;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rohith.spring.dao.ContactDAO;
import com.rohith.spring.dao.ContactDAOImpl;

@Configuration
@ComponentScan(basePackages="com.rohith.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e){
			
		}
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
	    dataSource.setUsername("root");
	    dataSource.setPassword("root");
		return dataSource;
		
	}
	
	@Bean
	public ContactDAO getContactDAO(){
		return new ContactDAOImpl(getDataSource());
		
	}
}
