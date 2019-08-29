package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.entity.Article;
import com.monkeyc.blog.exception.BussinessException;
import com.monkeyc.blog.exception.ParameterException;
import com.monkeyc.blog.util.DbUtil;
import com.monkeyc.blog.util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@WebServlet
public class ArticleAddServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //application/json数据需要使用inputstream来获取
//        String userAccount = request.getParameter("userAccount");
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");

        Article article = JSONUtil.get(request,Article.class);

        //处理数据库操作
        try{
            connection = DbUtil.getConnection();
            String sql = "insert into article(title, content, user_id) " +
                    "select ?,?,id from user " +
                    "where user.name =?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,article.getTitle());
            preparedStatement.setString(2,article.getContent());
            preparedStatement.setString(3,article.getUserAccout());

            int r = preparedStatement.executeUpdate();
            if(r > 0){
                return r;
            }else{
                throw new BussinessException("没有该用户："+article.getUserAccout());
            }

        }finally {
            DbUtil.close(connection,preparedStatement,null);
        }

    }

}
