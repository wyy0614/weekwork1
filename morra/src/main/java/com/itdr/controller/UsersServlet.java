package com.itdr.controller;


import com.itdr.dao.UsersDao;
import com.itdr.pojo.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UsersServlet extends HttpServlet {

    UsersDao ud = new UsersDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        switch (split[split.length - 1]){
            case "register":
                register(request,response);
                break;
            case "login":
                login(request,response);
                break;
        }


        }

        private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            String uname = request.getParameter("uname");
            String password = request.getParameter("password");

            Users users = ud.selectByUname(uname);
            if(users != null){

            }else {
                int i = ud.insertByUnameAndPassword(uname, password);
                request.getSession().setAttribute("uname",uname);
            }
            request.getRequestDispatcher("index.jsp").forward(request,response);
//            response.sendRedirect("index.jsp");
    }

        private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            System.out.println(uname);
            System.out.println(password);

            Users users = ud.selectByUnameAndPassword(uname, password);
            request.getSession().setAttribute("uname",users.getUname());
            request.getRequestDispatcher("game.jsp").forward(request,response);
        }



}
