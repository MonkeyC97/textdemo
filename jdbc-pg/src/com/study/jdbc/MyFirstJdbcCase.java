package com.study.jdbc;

import java.sql.*;

/**
 * 查询数据库数据
 */
public class MyFirstJdbcCase {
    /**
     * 1.加载数据库的JDBC驱动（JDBCAPI）
     * 2.创建链接
     * 3.创建命令
     * 4.准备SQL语句
     * 5.执行SQL
     * 6.处理结果
     * 7.关闭结果
     * 8.关闭命令
     * 9.关闭连接
     *
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.加载JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            //2.JDBC url协议
            //jdbc:<databaseType>://host:port/<databaseName>?user=xxx&password=xxx
            //jdbc:mysql://127.0.0.1:3306/memo?user=root&password=xxx
            String url = "jdbc:mysql://localhost:3306/memo?user=root&password=hc19970626&useSSL=false";
            connection = DriverManager.getConnection(url);

            //3.
            statement = connection.createStatement();

            //4.
            String sql = "select * from memo_group;";

            //5.
            resultSet = statement.executeQuery(sql);

            //6.
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp createdTime = resultSet.getTimestamp("created_time");
                Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                System.out.println(id+" "+name+" "+ createdTime+" "+ modifyTime);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.
            if(connection != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //8
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //9
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
