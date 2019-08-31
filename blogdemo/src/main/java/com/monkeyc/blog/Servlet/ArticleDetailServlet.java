package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.entity.Article;
import com.monkeyc.blog.exception.ParameterException;
import com.monkeyc.blog.util.DbUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Article article = new Article();
        // 处理前端请求数据
        String sid = req.getParameter("id");
        Integer id = null;
        try {
            id = Integer.parseInt(sid);
        }catch (Exception e){
            throw new ParameterException("id错误（"+sid+")");
        }


        // 处理业务及数据库操作
        try {
            conn = DbUtil.getConnection();
            String sql = "select id,title,content " +
                    "from article where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs       = ps.executeQuery();
            while (rs.next()) {
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
            }
            System.out.println(article);
        }finally {
            DbUtil.close(conn,ps,rs);
        }
        return article;
    }
}
