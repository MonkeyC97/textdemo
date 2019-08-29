package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.entity.Article;
import com.monkeyc.blog.exception.BussinessException;
import com.monkeyc.blog.util.DbUtil;
import com.monkeyc.blog.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArticleUpdateServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article = JSONUtil.get(request,Article.class);

        //处理数据库操作
        try{
            connection = DbUtil.getConnection();
            String sql ="update article set title=?,content=? where id=?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setInt(3,article.getId());

            int r = preparedStatement.executeUpdate();
            if(r > 0){
                return r;
            }else{
                throw new BussinessException("没有该文章："+article.getUserId());
            }

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            DbUtil.close(connection,preparedStatement,resultSet);
        }

    }

}
