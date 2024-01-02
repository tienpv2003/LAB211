/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PhạmVinhTiến
 */
public class LoginServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("user_name");
        String pass = request.getParameter("password");
        String name_init = getServletContext().getInitParameter("user_name");
        String pass_init = getServletContext().getInitParameter("password");
        if (name.equals(name_init) && pass.equals(pass_init)) {
            response.sendRedirect("welcome");
        } else {
            response.sendRedirect("login.html");
        }
    } 

}
