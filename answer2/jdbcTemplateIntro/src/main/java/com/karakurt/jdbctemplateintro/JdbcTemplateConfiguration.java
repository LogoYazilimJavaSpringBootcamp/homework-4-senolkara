package com.karakurt.jdbctemplateintro;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcTemplateConfiguration {
    public static DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/world?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false");
        dataSource.setUsername("root");
        dataSource.setPassword("example");
        return dataSource;
    }
}

