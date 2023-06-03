/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hendr
 */
public class UserModel {
    
    
    private String name;
    private String email;
    private String phone;
    private String address;
    private String nama_user;
    private String pass_user;
    private int id_user;
    
    public UserModel(){
        
    }

    public UserModel(String name, String email, String phone, String address, String nama_user, String pass_user, int id_user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.nama_user = nama_user;
        this.pass_user = pass_user;
        this.id_user = id_user;
    }

    

    public UserModel(String name, String email, String phone, String address, String nama_user, String pass_user) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.nama_user = nama_user;
    this.pass_user = pass_user;
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getPass_user() {
        return pass_user;
    }

    public void setPass_user(String pass_user) {
        this.pass_user = pass_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    
    
    @Override
    public String toString() {
        return "{" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", phone='" + getPhone() + "'" +
                ", address='" + getAddress() + "'" +
                ", nama_user='" + getNama_user() + "'" +
                ", pass_user='" + getPass_user() + "'" +
                " id_user='" + getId_user() + "'" +
                "}";
    }
    
    
}