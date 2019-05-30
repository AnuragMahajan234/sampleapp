package com.example.pbapp.configuration;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestDataSource {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource dataSource = ctx.getBean(DataSource.class);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "insert into users(name,email,phone,loginname,password) values (?,?,?,?,?)";
		Object[] params = new Object[] {"Arju","arju@yash.com","123","arju","a123"};
		jdbcTemplate.update(sql, params);
		System.out.println("success");
	}

}
