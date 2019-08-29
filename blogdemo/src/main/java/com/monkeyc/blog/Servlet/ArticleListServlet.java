package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.entity.Article;
import com.monkeyc.blog.exception.ParameterException;
import com.monkeyc.blog.util.DbUtil;
import com.monkeyc.blog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet
public class ArticleListServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println(request.getParameter("key1"));
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Article> articleList = new ArrayList<>();
        String sid = request.getParameter("id");
        Integer id = null;
        try{
            id = Integer.parseInt(sid);
        }catch (NumberFormatException e){
            throw new ParameterException("id错误("+sid+")");
        }
        //处理数据库操作
        try{
            connection = DbUtil.getConnection();
            String sql = "select a.id,a.title,a.content from " +
                    " article a join user u on a.user_id = u.id where u.id = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));

                articleList.add(article);
            }
            System.out.println(articleList);
        }finally {
            DbUtil.close(connection,preparedStatement,resultSet);
        }
            return articleList;
    }

}
