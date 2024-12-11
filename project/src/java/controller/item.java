/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Book;
import classes.Item;
import classes.Magazine;
import classes.NewHibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author huser
 */
public class item {

    Session session = NewHibernateUtil.getSessionFactory().openSession();

    public Item getItem(int itemId) {
        return (Item) session.get(Item.class, itemId);

    }

    public String addItem(Item i) {
        try {
            if (i instanceof Book) {
                session.save((Book) i);
            } else {
                if (i instanceof Magazine) {
                    session.save((Magazine) i);
                } else {
                    session.save(i);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        return "add " + i + " succesfully";
    }
}
