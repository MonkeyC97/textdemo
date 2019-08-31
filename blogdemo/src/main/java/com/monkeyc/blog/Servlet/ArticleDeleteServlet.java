package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.exception.BussinessException;
import com.monkeyc.blog.exception.ParameterException;
import com.monkeyc.blog.util.DbUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String ids = req.getParameter("ids");
        int[] intIds=null;
        try {
            String[] idArray = ids.split(",");
            intIds = new int[idArray.length];

            for (int i = 0; i < idArray.length; i++) {
                intIds[i] = Integer.parseInt(idArray[i]);
            }

        } catch (Exception e) {
            throw new ParameterException("请求参数异常" + ids);
        }


        // 处理业务及数据库操作
        try {
            connection = DbUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for (int i = 0; i < intIds.length; i++) {
                if (i==0){
                    sql.append("?");
                }else {
                    sql.append(",?");
                }
            }
            sql.append(")");
            System.out.println("sql="+sql);

            preparedStatement=connection.prepareStatement(sql.toString());
            for (int i = 0; i < intIds.length; i++) {
                preparedStatement.setInt(i+1,intIds[i]);
            }
            preparedStatement.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            DbUtil.close(connection, preparedStatement, resultSet);
        }
        return null;
    }
}
