/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import models.UserModel;

/**
 *
 * @author hendr
 */
public class ControllerUser {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public int saveUser(UserModel user) {
     int hasil = 0;
     
    String selectQuery = "SELECT * FROM register WHERE nama_user = '" + user.getNama_user() + "'";
    String insertQuery = "INSERT INTO register(name, email, phone, address, nama_user, pass_user) "
        + "VALUES ('" + user.getName() + "','" + user.getEmail() + "','" + user.getPhone() + "','"
        + user.getAddress() + "','" + user.getNama_user() + "','" + user.getPass_user() + "')";


        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(selectQuery);

            if (rs.next() == true) {
                hasil = -1;
            } else {
                hasil = st.executeUpdate(insertQuery);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
 }

    
    public int Login(UserModel user) throws SQLException{ // nama_mhs dan nim_mhs merepresentasikan data mahasiswa yang akan disimpan.
        int hasil = 0;
        String sql = "SELECT * FROM register WHERE nama_user ='" + user.getNama_user()+ "'AND pass_user ='" + user.getPass_user() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (!rs.getString("pass_user").equals(user.getPass_user())) {
                    hasil = -1;
                } else if (rs.getString("pass_user").equals(user.getPass_user())) {
                    user.setId_user(rs.getInt("id_user"));
                    user.setNama_user(rs.getString("nama_user"));
                    user.setPass_user(rs.getString("pass_user"));

                    hasil = 1;
                } else {
                    hasil = 0;
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
    
    public List<UserModel> getUser() {
        List<UserModel> lsUser = new ArrayList<UserModel>();
        String sql;

        sql = "SELECT * FROM register";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                UserModel um = new UserModel();
                um.setName(rs.getString("name"));
                um.setEmail(rs.getString("email"));
                um.setPhone(rs.getString("phone"));
                um.setAddress(rs.getString("address"));
                um.setNama_user(rs.getString("nama_user"));
                um.setPass_user(rs.getString("pass_user"));
                um.setId_user(rs.getInt("id_user"));
                lsUser.add(um);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsUser;
    }
}
