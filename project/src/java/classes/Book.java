/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 *
 * @author huser
 */
@Entity
@DiscriminatorValue( "Book")
public class Book extends Item {
   Category category;
   String author;

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Book{" + "category=" + category + ", author=" + author + '}';
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
