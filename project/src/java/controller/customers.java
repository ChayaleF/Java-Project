/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Book;
import classes.Customer;
import classes.Item;
import classes.Magazine;
import classes.NewHibernateUtil;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author huser
 */
public class customers {

    Session session = NewHibernateUtil.getSessionFactory().openSession();

    public Customer getCustomer(int custId) {
        return (Customer) session.get(Customer.class, custId);

    }

    public String addCust(Customer c) {
        try {
            Query q = session.createQuery(" from Customer z where z.fName=:custName and z.email=:custEmail");
            q.setString("custName", c.getfName());
            q.setString("custEmail", c.getCustomerDeatails().getEmail());
            List<Customer> custs = q.list();
            if (!custs.isEmpty()) {
                return "error userName or password are incorrect";
            }
            session.save(c);
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        return "add " + c;
    }

    public int isValid(String name, String email) {
        Query q = session.createQuery(" from Customer z where z.fName=:name");
        q.setString("name", name);
        List<Customer> cu=q.list();
        for(Customer c :cu)
        {
            if(c.getCustomerDeatails().getEmail().equals(email))
                return c.getId();
        }
        return -1;
    }
}
