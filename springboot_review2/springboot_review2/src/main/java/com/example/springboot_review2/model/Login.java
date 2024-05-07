package com.example.springboot_review2.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
    
    private String email;
    private String contact;
    private String carNumber;
    private String carModel;
    
    @OneToMany(mappedBy = "ivtmg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Service> products = new HashSet<>();

    
    public Login(String email, String contact, String carNumber, String carModel) {
        this.email = email;
        this.contact = contact;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getContact() {
        return contact;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }


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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


   
    public Set<Service> getProducts() {
        return products;
    }


    public void setProducts(Set<Service> products) {
        this.products = products;
    }


    public Login(String username, String password) {
        this.username = username;
        this.password = password;

    }


    public Login() {
    }
    
    
}