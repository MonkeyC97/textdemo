package com.monkeyc.blog.Servlet;

import com.monkeyc.blog.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = UEditorServlet.class.getClassLoader().getResource("config.json").getPath();
        MyActionEnter actionEnter = new MyActionEnter(request,path);
        String exec = actionEnter.exec();
        response.getWriter().write(exec);
    }
}
