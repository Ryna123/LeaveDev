package com.kh.coocon.lmsapp.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

import com.kh.coocon.lmsapp.configuration.security.RoleToUserProfileConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.kh.coocon.lmsapp" })
public class LMSConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	RoleToUserProfileConverter roleToUserProfileConverter;
	
	@Bean
	public ResourceBundleViewResolver bundleResolver(){
		ResourceBundleViewResolver resolver = new ResourceBundleViewResolver();
		resolver.setOrder(1);
		resolver.setBasename("file");
		return resolver;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setOrder(2);
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	       org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
	       multipartResolver.setMaxUploadSize(2097152);
	       return multipartResolver;
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://ec2-54-83-202-64.compute-1.amazonaws.com:5432/d52hue0higch0t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
//		dataSource.setUsername("jvqiqzwlgblztv");
		dataSource.setPassword("f_j9jAsT9C_WzHwVDrGYj1_3op");
		dataSource.setUrl("jdbc:postgresql://192.168.178.30:5432/lmsdb");
	//	dataSource.setUrl("jdbc:postgresql://localhost:5432/lmsdb");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		return dataSource;
	}
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(roleToUserProfileConverter);
	}
	
}
