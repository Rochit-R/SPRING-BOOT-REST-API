package com.example.day4post.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Login")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String userpassword;
    private String contact;
    private String carNumber;
    private String carModel;
    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserpassword() {
        return userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public User(int id, String username, String email, String userpassword, String contact,String carNumber,String carModel) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userpassword = userpassword;
        this.contact = contact;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }
    public User() {
    }
    
}
