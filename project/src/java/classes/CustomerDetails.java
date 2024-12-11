/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.Embeddable;

/**
 *
 * @author huser
 */
@Embeddable
public class CustomerDetails {
    private String phone;
    private String email;

    @Override
    public String toString() {
        return "CustomerDetails{" + "phone=" + phone + ", email=" + email + '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
