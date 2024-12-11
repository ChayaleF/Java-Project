/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import classes.Borrows;
import classes.Customer;
import controller.borrows;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author huser
 */
@WebServlet(name = "BorrowSer", urlPatterns = {"/BorrowSer"})
public class BorrowSer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        PrintWriter out = resp.getWriter();
        Customer cus = (Customer) getServletContext().getAttribute("customer");
        borrows borrowController = new borrows();
        Borrows b = new Borrows();
        String s = borrowController.addItem(itemId, cus.getId());
        out.append(s);
    }

}
