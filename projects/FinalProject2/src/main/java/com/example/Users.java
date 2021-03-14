package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name= "users")   

public class Users {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id")
    private long id;
    
    @Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
    
    @NotEmpty(message = "must not be left blank")
    @Size(min = 1, max = 32)
	@Column(name = "name")
    private String name;
    
    @NotEmpty(message = "must not be left blank")
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    
    @NotEmpty(message = "must not be left blank")
    @Size(min = 8, max = 32)
    @Column(name = "password")
    private String password;


    public Users() {
        
    }
    
    public Users(long id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
    }
    

    public long getID() {return this.id; }
    public String getName() { return this.name;}
    public String getEmail() { return this.email;}
    public String getPassword() { return this.password;}
    
    public void setID(long id) { this.id = id;}
    public void setName(String name) { this.name = name;}
    public void setEmail(String email) { this.email = email;}
    public void setPassword(String password) { this.password = password;}
}