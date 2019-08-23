package com.monkeyc.blog.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/blog";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "hc19970626";


    private DbUtil(){

    }
    private static volatile DataSource DATASOURCE;
    public  static DataSource getDataSource(){
        if(DATASOURCE == null){
            synchronized (DataSource.class){
                if(DATASOURCE == null){//指令重排序，可能还没有把对象赋给引用，所以可能下一个线程过来的时候引用没有指向对象
                    DATASOURCE = new MysqlDataSource();//非原子性，3步：1开辟空间，2产生对象，3赋给引用
                    ((MysqlDataSource) DATASOURCE).setUrl(URL);
                    ((MysqlDataSource) DATASOURCE).setUser(USER_NAME);
                    ((MysqlDataSource) DATASOURCE).setPassword(PASS_WORD);
                }
            }
        }
        return DATASOURCE;
    }
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //释放资源
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
