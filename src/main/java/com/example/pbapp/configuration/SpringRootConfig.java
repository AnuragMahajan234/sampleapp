
package com.example.pbapp.configuration;


import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is responsible for creating beans like service, repository etc.
 * @author anurag.mahajan
 */
@Configuration
@ComponentScan(basePackages= {"com.example.pbapp.daoimpl","com.example.pbapp.serviceimpl"}) //works only on web app on server
public class SpringRootConfig {
	//TODO : Service, DAO, DataSource, Email Sender, SMS Sender or some beans related to server logic
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pbdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setMaxTotal(2);
		dataSource.setInitialSize(1);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("select 1"); // to check the db connection
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
		
	}
}
