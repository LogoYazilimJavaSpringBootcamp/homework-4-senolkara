package com.karakurt.jdbcintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;

@SpringBootApplication
public class JdbcIntroApplication {

    private static final DbHelper dbHelper = new DbHelper();
    private static Connection connection = null;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) throws SQLException {
        //SpringApplication.run(JdbcIntroApplication.class, args);

        selectDemo();
        //insertDemo();
        //updateDemo();
        //deleteDemo();
    }

    public static void selectDemo() throws SQLException {
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from provinces");
            ArrayList<Provinces> provincesArrayList = new ArrayList<>();
            while (resultSet.next()){
                provincesArrayList.add(new Provinces(
                        resultSet.getLong("id"),
                        resultSet.getString("u_id"),
                        resultSet.getString("number_plate"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("city_or_not")
                ));
            }
            System.out.println(provincesArrayList.size());
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void insertDemo() throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "insert into provinces(u_id, number_plate, name, city_or_not) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "8888888888");
            preparedStatement.setString(2, "88");
            preparedStatement.setString(3, "DENEMEIL888");
            preparedStatement.setBoolean(4, false);
            int result = preparedStatement.executeUpdate();
            if (result == 1)
                System.out.println("data inserted");
            else
                System.out.println("data not inserted");
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public static void updateDemo() throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "update provinces set number_plate=?, name=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"90");
            preparedStatement.setString(2,"DENEMEIL90");
            preparedStatement.setInt(3,1000);
            int result = preparedStatement.executeUpdate();
            if (result == 1)
                System.out.println("data updated");
            else
                System.out.println("data not updated");
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

    public static void deleteDemo() throws SQLException {
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from provinces where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,1000);
            int result = preparedStatement.executeUpdate();
            if (result == 1)
                System.out.println("data deleted");
            else
                System.out.println("data not deleted");
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            preparedStatement.close();
            connection.close();
        }
    }

}
