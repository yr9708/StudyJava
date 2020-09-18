package com.mvc.update.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration // = applicationContext.xml 
//spring bean configuration 하는 역할을 한다.
@PropertySource("classpath:sqls/db.properties") // = <context:property-placeholder>(db.properties가져오는 것)
public class ApplicationConfig {
	
	@Value("${oracle.driver}")
	private String driver;
	
	@Value("${oracle.url}")
	private String url;
	
	@Value("${oracle.username}")
	private String username;
	
	@Value("${oracle.password}")
	private String password;
	
	//javax.sql 을 가져와야한다 db랑 연결할거니깐
	@Bean // dataSource 메소드를 호출하면 dataSource가 return된다.
	public DataSource dataSource() { // = <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		// DataSource로 리턴받는 이유는 DriverManagerDataSource가 상속받았기 때문이다.
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver); // @Value("${oralce.driver}) 라고 해도 됨// bean의 property는 set과 같다.
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		return new JdbcTemplate(dataSource()); 
		/*
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	
		바로 dataSource 메소드를 호출해주면 된다.(생성자처럼)
		원래는
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDateSource(dataSource()); 
		return jdbcTemplate;
		해줘야하는게 맞음. setter처럼
		
		
		 */
	}
}
