/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author huser
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Customer getCust(int id) {
        Session session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction trc = session.beginTransaction();
        Customer cus = (Customer) session.get(Customer.class, 1);
        trc.commit();
        return cus;
    }

    public static void main(String[] args) {

        Customer c = new Customer();
        c.setId(120);
        c.setfName("moshe");
        c.setlName("levi");
        CustomerDetails custd = new CustomerDetails();
        custd.setEmail("qwt@k.hj");
        custd.setPhone("098765");
        c.setCustomerDeatails(custd);
        System.out.println("main");

        Book b = new Book();
        b.setName("abc");
        b.setAuthor("sara");
        b.setCategory(Category.HISTORY);

        Magazine m = new Magazine();
        m.setName("bbb");
        m.setShit_number(23);
        m.setYear_(2023);
        Borrows bor = new Borrows();
        bor.setItem(m);
        bor.setCust(c);
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction trc = session.beginTransaction();
        session.save(c);
        session.save(b);
        session.save(m);
        session.save(bor);
        System.out.println(bor.getItem());
        System.out.println(getCust(1));
        trc.commit();
        Query q = session.createQuery(" from Customer z where z.fName=:fname and z.id>:id");

        q.setParameter("fname", "moshe");
        q.setInteger("id", 7);
        q.list().stream().map(x -> ((Customer) x).getfName()).forEach(System.out::println);
        session.getNamedQuery("customer.findById").setParameter("id", 2).list().stream().forEach(System.out::println);

    }

}
