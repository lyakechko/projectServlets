package com.example.demo.Servlets;

import com.example.demo.DAO.CreateObjects;
import com.example.demo.DBO.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "authorizedZoneServlet", value = "/authorizedZone-servlet")
public class AuthorizedZoneServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("444444444");
        int page = 1;
        int recordsPerPage = 3;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        List<UserInfo> list = CreateObjects.userInfoList(page,  recordsPerPage);
        System.out.println("-----------");
        System.out.println(list);
        System.out.println("-----------");
        int noOfRecords = 2;
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("userInfoList", list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/authorizationPage.jsp");
        view.forward(request, response);
    }




}
