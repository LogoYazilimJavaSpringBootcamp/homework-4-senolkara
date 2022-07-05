package com.karakurt.jdbctemplateintro;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class JdbcTemplateIntroApplication {

    private static final DataSource dataSource = JdbcTemplateConfiguration.getDataSource();
    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

    public static void main(String[] args) {
        //SpringApplication.run(JdbcTemplateIntroApplication.class, args);

        selectDemo();
        //insertDemo();
        //updateDemo();
        //deleteDemo();
    }

    public static void selectDemo(){
        String sql = "select * from provinces";
        List<Provinces> provincesList = jdbcTemplate.query(sql, new ProvincesMapper());

        for (Provinces province:provincesList){
            System.out.println("ID: " + province.getId());
            System.out.println("UID: " + province.getUId());
            System.out.println("Number Plate: " + province.getNumberPlate());
            System.out.println("Name: " + province.getName());
            System.out.println("City Or Not: " + province.getCityOrNot());
            System.out.println("-------------------------------------");
        }
    }

    public static void insertDemo(){
        String sql = "insert into provinces(u_id, number_plate, name, city_or_not) values (?,?,?,?)";
        int result = jdbcTemplate.update(sql,"9999999","99","DENEMEIL99",true);
        if (result > 0)
            System.out.println("data inserted...");
        else
            System.out.println("data not inserted...");
    }

    public static void updateDemo(){
        String sql = "update provinces set number_plate=?, name=? where id=?";
        int result = jdbcTemplate.update(sql,"90","DENEMEIL90",1000);
        if (result > 0)
            System.out.println("data updated...");
        else
            System.out.println("data not updated...");
    }

    public static void deleteDemo(){
        String sql = "delete from provinces where id=?";
        int result = jdbcTemplate.update(sql,1000);
        if (result > 0)
            System.out.println("data deleted...");
        else
            System.out.println("data not deleted...");
    }

}
