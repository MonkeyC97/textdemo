package com.study.jdbc;

import java.sql.*;

/**
 *采用模版设计模式
 */

public abstract class AbstractJdbcTemplate {
    /*
        不变的：
        1.加载驱动
        2.获取连接
        3.创建命令
        4.关闭(结果，命令连接)

        变的
        1. SQL语句
        2. 执行命令
        3. 处理结果
        a.select
        b.insert update delete

     */
    public <T> T execute(String sql){
        this.loadDriver();
        this.createConnection();
        this.createStatement();
        Object t;
        //执行sql
        if(sql.trim().toUpperCase().startsWith("SELECT")){
            this.resultSet = this.executeQuery(sql);
            //处理结果
            t = this.handlerResult(resultSet);
        }else{
            int effect = this.executeUpdate(sql);
            t =  this.handlerResult(effect);
        }
        //处理结果
        this.close();
        return (T) t;
    }
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    //1 加载驱动
    private void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2 创建链接
    private void createConnection(){
        String url = "jdbc:mysql://localhost:3306/memo?user=root&password=hc19970626&useSSL=false";
        try {
             connection = DriverManager.getConnection(url,"root","hc19970626");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //3 创建命令
    private void createStatement(){
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int executeUpdate(String sql){
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private ResultSet executeQuery(String sql){
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //处理结果
    public abstract<T> T handlerResult(ResultSet resultSet);
    public abstract<T> T handlerResult(int effect);
    //关闭资源
    private void close(){
        if(this.resultSet != null){
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.statement != null){
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.connection != null){
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
