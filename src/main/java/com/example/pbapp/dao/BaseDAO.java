package com.example.pbapp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//Note : Not a spring managed object. Do not user @Service, @Repository, @Component annotation here.
//User should not be able to create its object, it is specifically used at the time of when datasource is needed in DAO
public class BaseDAO extends NamedParameterJdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource) {
		//we named it as 2 because it is a final method in JdbcDaoSupport
		super.setDataSource(dataSource);
	}
}
