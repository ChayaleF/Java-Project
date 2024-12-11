/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 
 * @author huser
 */
@Entity
@DiscriminatorValue("Magazine")
public class Magazine extends Item{
    int year_;
    int shit_number;

    public int getYear_() {
        return year_;
    }

    @Override
    public String toString() {
        return "Magazine{" + "year_=" + year_ + ", shit_number=" + shit_number + '}';
    }

    public void setYear_(int year_) {
        this.year_ = year_;
    }

    public int getShit_number() {
        return shit_number;
    }

    public void setShit_number(int shit_number) {
        this.shit_number = shit_number;
    }
    
    
}
