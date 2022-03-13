package com.example.aws.datasource;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		//dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:mysql://database-1.cpsnfnvuc3nf.us-east-2.rds.amazonaws.com:3306/myDB");
        dataSourceBuilder.username("dbuser");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
		
		
	}

}
