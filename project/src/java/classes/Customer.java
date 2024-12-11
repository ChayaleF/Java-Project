/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.*;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author huser
 */
@Entity
@Table(name = "TBL_CUSTOMER")
@NamedQueries({
    @NamedQuery(name = "customer.findById", query = "from Customer c where c.id=:id"),})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", fName=" + fName + ", lName=" + lName + ", customerDeatails=" + customerDeatails + '}';
    }
    @Column(name = "f_NAME")
    private String fName;
    private String lName;
    @Embedded
    private CustomerDetails customerDeatails;

    public CustomerDetails getCustomerDeatails() {
        return customerDeatails;
    }

    public void setCustomerDeatails(CustomerDetails customerDeatails) {
        this.customerDeatails = customerDeatails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

}
