/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.Customer;
import controller.customers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huser
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        String name = req.getParameter("userName");
        String email = req.getParameter("email");
        customers controllerCus = new customers();
        PrintWriter out = resp.getWriter();
        int id = controllerCus.isValid(name, email);
        if (id == -1) {
            req.getRequestDispatcher("/index.html").include(req, resp);
            out.append("<h1>error!!!!!</h1>");
        } else {
            Customer cus = controllerCus.getCustomer(id);
            Cookie coo = new Cookie("userName", cus.getfName());
            coo.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(coo);
            getServletContext().setAttribute("customer", cus);
            out.append("<h1>welcome " + name
                    + "<div>\n"
                    + "                <input type=\"number\" name=\"itemId\">\n"
                    + "            <form action=\"/webProject/BorrowSer\" method=\"post\">\n"
                    + "                <button type=\"submit\" value=\"borrow\" >\n"
                    + "            </form>\n"
                    + "        </div>\n"
                    + "        <div>\n"
                    + "            <form action=\"/webProject/ReturnSer\" method=\"post\">\n"
                    + "                <button type=\"submit\" value=\"return\" >\n"
                    + "            </form>\n"
                    + "        </div>"
                    + "</h1>");

        }

    }

}
