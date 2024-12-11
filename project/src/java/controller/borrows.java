/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import classes.Borrows;
import classes.Customer;
import classes.Item;
import classes.NewHibernateUtil;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author huser
 */
public class borrows {

    Session session = NewHibernateUtil.getSessionFactory().openSession();

    public String addItem(int itemId, int customerId) {
        List<Borrows> borrows;
        List<Item> items;
        try {
            Query q = session.createQuery(" from Borrows z where z.Item.id=:itemId");
            q.setInteger("itemId", itemId);
            borrows = q.list();
            for(Borrows bb:borrows){
            if (bb.isBorrow()) {
                return "the book is borrowing";
            }}
            Query q2 = session.createQuery(" from Item z where z.id=:itemId");
            q.setInteger("itemId", itemId);
            items = q2.list();
            if (items.isEmpty()) {
                return "this book not exist";
            }
            Borrows b = new Borrows();
            customers cusController = new customers();
            item itemController = new item();
            if (!borrows.isEmpty() && borrows.get(0).isBorrow() == false) {
                borrows.get(0).setCust(cusController.getCustomer(customerId));
                borrows.get(0).setBorrow(true);
                session.save(borrows.get(0));
            }
            b.setCust(cusController.getCustomer(customerId));
            b.setItem(itemController.getItem(itemId));
            b.setBorrow(true);
            session.save(b);

        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        return "the book borrowed successfuly";
    }

    public String updateItem(int itemId, int custId) {
        List<Item> itemList;
        List<Borrows> borrowsList;
        try {
            Query q = session.createQuery(" from Item z where z.id=:itemId");
            q.setInteger("itemId", itemId);
            itemList = q.list();
            if (itemList.isEmpty()) {
                return "the book isnt exist in the library";
            }
            Query q2 = session.createQuery(" from Borrows z where z.Item.id=:itemId");
            q2.setInteger("itemId", itemId);
            borrowsList = q2.list();
            Borrows b=new Borrows();
            for(Borrows bb:borrowsList){
                b=bb;
                 if (bb.isBorrow()) {
                return "error returnedbook this book is returned";
            } 
            }
          
            if (b.getCust().getId()!=custId) {
                return "error returned item";
            }
           b.setBorrow(false);
            session.save(b);

        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        return "Succeeded erturning item:" + borrowsList.get(0).toString();
    }
}
//

