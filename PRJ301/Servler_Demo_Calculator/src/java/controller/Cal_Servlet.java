/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author PhạmVinhTiến
 */
@WebServlet(name = "Cal_Servlet", urlPatterns = {"/calc"})
public class Cal_Servlet extends HttpServlet {

    private String cal(double n1, double n2, String op) {
        String rs = "";;
        switch (op) {
            case "+":
                rs = n1 + "+" + n2 + "=" + (n1 + n2);
                break;
            case "-":
                rs = n1 + "-" + n2 + "=" + (n1 - n2);
                break;
            case "x":
                rs = n1 + "x" + n2 + "=" + (n1 * n2);
                break;
            case ":":
                if (n2 != 0) {
                    rs = n1 + ":" + n2 + "=" + (n1 / n2);
                } else {
                    rs = "divide by zero";
                }
                break;
        }
        return rs;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Result</title>");
            out.println("</head>");
            out.println("<body>");
            String n1 = request.getParameter("num1");
            String n2 = request.getParameter("num2");
            String op = request.getParameter("operator");
            double num1, num2;
            String rs = "";
            try {
                num1 = Double.parseDouble(n1);
                num2 = Double.parseDouble(n2);
                rs = cal(num1, num2, op);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            out.println("<h1 style='color: blue'> " + rs + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
