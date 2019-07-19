package com.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyThirdJdbcCase {
    public static void main(String[] args) {
        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            //2.JDBC url协议
            //jdbc:<databaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=xxx
            String url = "jdbc:mysql://localhost:3306/memo?user=root&password=hc19970626&useSSL=false";
            Connection connection = DriverManager.getConnection(url);

            //3.
            Statement statement = connection.createStatement();

            //4.
            String sql = "delete from memo_group where id=1";

            //5.
            int effect = statement.executeUpdate(sql);

            //6.
            System.out.println(effect);

            //7.
            //resultSet.close();
            //8
            statement.close();
            //9
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
