/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author huser
 */
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Borrows")

public class Borrows {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="custId",referencedColumnName="id")
    private Customer cust;
    
    private boolean Borrow;

    public boolean isBorrow() {
        return Borrow;
    }

    public void setBorrow(boolean Borrow) {
        this.Borrow = Borrow;
    }

    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Borrows{" + "id=" + id + ", item=" + item + ", cust=" + cust + '}';
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

  

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
