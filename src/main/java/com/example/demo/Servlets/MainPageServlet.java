package com.example.demo.Servlets;

import com.example.demo.DAO.CreateObjects;
import com.example.demo.DBO.UserInfo;
import com.example.demo.Validation.Validator;

import java.io.*;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainPageServlet", value = "/mainPage-servlet")
public class MainPageServlet extends HttpServlet {
    private Set<UserInfo> userInfoSet;


    public void init() {
        userInfoSet = CreateObjects.getUserInfoList();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        response.sendRedirect(contextPath + "/registration.jsp");
    }

    public void destroy() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = getServletContext();
        Validator.generalMethodHandlingRequests(request, response);
    }

}