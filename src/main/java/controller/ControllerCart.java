/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import models.CartModel;
import models.UserModel;

/**
 *
 * @author hendr
 */
public class ControllerCart {

    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<CartModel> getCart(UserModel usr) {
        List<CartModel> lsCart = new ArrayList<CartModel>();
        String sql;

        sql = "SELECT * FROM cart WHERE id_user = '" + usr.getId_user() + "'";


        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CartModel Carta = new CartModel();
                Carta.setId_user(rs.getInt("id_user"));
                Carta.setId_barang(rs.getInt("id_barang"));
                Carta.setNama_kategori(rs.getString("nama_kategori"));
                Carta.setNama_barang(rs.getString("nama_barang"));
                Carta.setHarga_barang(rs.getInt("harga_barang"));
                Carta.setJumlah_barang(rs.getInt("jumlah_barang"));
                Carta.setTotal(rs.getInt("total"));

                lsCart.add(Carta);
            }

        } catch (java.sql.SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsCart;
    }
    
    
    public int saveCart(CartModel Cart) {
        int hasil = 0;
        String sql = null;
        
        sql = "INSERT INTO cart (id_user, id_barang, nama_kategori, nama_barang, harga_barang, jumlah_barang, total) VALUES ('" + Cart.getId_user()
         + "','" + Cart.getId_barang() + "','" + Cart.getNama_kategori() + "','" + Cart.getNama_barang() + "','" + Cart.getHarga_barang() + "','" + Cart.getJumlah_barang() + "','"
        + Cart.getTotal() + "')";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return hasil;
    }

    public int deleteCart(UserModel usr) {
        int hasil = 0;
        String sql = null;
        sql = "DELETE FROM cart WHERE id_user = '" + usr.getId_user() + "'";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerCart.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return hasil;
    }
}
