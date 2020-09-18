package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration 
@EnableWebMvc // Enables the Spring MVC = <annotation-driven />
@ComponentScan("com.mvc.update") // <context:component-scan base-package="com.mvc.update" />
public class ServletConfig implements WebMvcConfigurer {
	
	@Override //<resources mapping="/resources/**" location="/resources/" />
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean 
	public InternalResourceViewResolver getViewResolver() {
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		return new InternalResourceViewResolver(prefix,suffix);
	}
	/*
	 <beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	setter로 넣어도 되는데 코드수를 줄이기 위해서 바로 생성자로 prefix랑 suffix 넣어줌
	
	 */
}
