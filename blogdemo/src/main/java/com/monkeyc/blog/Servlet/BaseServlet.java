package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.entity.JSON;
import com.monkeyc.blog.exception.ParameterException;
import com.monkeyc.blog.exception.SystemException;
import com.monkeyc.blog.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        JSON result = new JSON();
        Object data = null;
        try {
            data = process(request,response);
            result.setSuccess(true);
            result.setCode("200");
            result.setMessage("操作成功");
            result.setData(data);
        } catch (Exception e) {
//            if(ParameterException.class.isAssignableFrom(e.getClass())){
            e.printStackTrace();
//
//            }
            if(e instanceof ParameterException){
                result.setCode(((ParameterException)e).getCode());
            }
            else if(e instanceof SystemException){
                result.setCode(((SystemException) e).getCode());
                result.setMessage(e.getMessage());
            }
            else{
                result.setCode("500");
                result.setMessage("服务器错误");
            }
        }
        //处理不了的，往上抛
        response.getWriter().write(JSONUtil.Myformat(result));
    }

    public abstract Object process(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
