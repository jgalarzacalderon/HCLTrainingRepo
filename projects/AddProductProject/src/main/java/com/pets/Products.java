package com.pets;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity  
@Table(name= "products")   

public class Products {
	

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    @NotEmpty(message = "must not be left blank.")
    @Size(min = 1, max = 50)
    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;
    
    @NotEmpty(message = "must not be left blank.")
    @Size(min = 1, max = 50000)
    @Column(name = "price", unique = false, nullable = false)
    private BigDecimal price;
    
    @NotEmpty(message = "must not be left blank.")
    @Size(min = 1, max = 30)
    @Column(name = "color", unique = false, nullable = false)
    private String color;

    
    public Products() {
        
    }
    
    public Products(long id, String name, String color, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.color = color;
    }
    

    public long getID() {return this.id; }
    public String getName() { return this.name;}
    public BigDecimal getPrice() { return this.price;}
    public String getColor() { return this.color;}
    
    public void setID(long id) { this.id = id;}
    public void setName(String name) { this.name = name;}
    public void setPrice(BigDecimal price) { this.price = price;}
    public void setColor(String color) { this.color = color;}
}
