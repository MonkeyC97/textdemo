package com.study.jdbc;

import java.sql.*;

public class JdbcAuto_closed {
    public static void main(String[] args) {

        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            //2.JDBC url协议
            //jdbc:<databaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=xxx
            String url = "jdbc:mysql://localhost:3306/memo?user=root&password=hc19970626&useSSL=false";
            //4.
            String sql = "select * from memo_group;";
            //try-with-resource关闭结果集，命令，连接
            try(Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                ){
                //6.
                while(resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Timestamp createdTime = resultSet.getTimestamp("created_time");
                    Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                    System.out.println(id+" "+name+" "+ createdTime+" "+ modifyTime);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
