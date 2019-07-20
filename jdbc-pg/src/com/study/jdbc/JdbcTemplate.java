package com.study.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class JdbcTemplate extends AbstractJdbcTemplate{

    @Override
    public <T> T handlerResult(ResultSet resultSet) {
            StringBuilder sb = new StringBuilder();
           try {
               while (resultSet.next()){
                   int id = resultSet.getInt("id");
                   String name = resultSet.getString("name");
                   Timestamp createdTime = resultSet.getTimestamp("created_time");
                   Timestamp modifyTime = resultSet.getTimestamp("modify_time");
                   sb.append(id+" "+name+" "+ createdTime+" "+ modifyTime);
                   sb.append("\n");
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
           return (T) sb.toString();
    }

    @Override
    public <T> T handlerResult(int effect) {
        return (T) Integer.valueOf(effect);
    }

    public static void main(String[] args) {
        AbstractJdbcTemplate template = new JdbcTemplate();
//        String rs = template.execute("select id,name,created_time,modify_time from memo_group");
//        System.out.println(rs);
        Integer rs = template.execute("update memo_group set name ='hehe' where id = 2");
        System.out.println(rs);
    }
}
