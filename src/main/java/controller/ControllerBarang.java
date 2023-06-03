/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.ConnectionManager;
import models.BarangModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author hendr
 */
public class ControllerBarang {

    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Statement stm;
    

    public int saveBrg(BarangModel brg) {
        int hasil = 0;
        String checkdata, sql;

        checkdata = "SELECT * FROM barang WHERE nama_barang = '" + brg.getNama_barang() + "%'";
        sql = "INSERT INTO barang(nama_kategori, nama_barang, harga_barang, stok_barang) VALUES ('"
                + brg.getNama_kategori() + "','" + brg.getNama_barang() + "','"
                + brg.getHarga_barang() + "','" + brg.getStok_barang()
                + "')";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(checkdata);

            if (rs.next() == true) {
                hasil = -1;
            } else {
                hasil = st.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public List<BarangModel> getBrg() {
        List<BarangModel> lsBrg = new ArrayList<BarangModel>();
        String sql;

        sql = "SELECT * FROM barang ORDER BY id_barang";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                BarangModel bm = new BarangModel();
                bm.setId_barang(rs.getInt("id_barang"));
                bm.setNama_kategori(rs.getString("nama_kategori"));
                bm.setNama_barang(rs.getString("nama_barang"));
                bm.setHarga_barang(rs.getInt("harga_barang"));
                bm.setStok_barang(rs.getInt("stok_barang"));

                lsBrg.add(bm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBrg;
    }

    public int updateBrg(BarangModel brg) {
        int hasil = 0;
        String sql = "UPDATE barang SET nama_kategori='" + brg.getNama_kategori() + "',nama_barang='" + brg.getNama_barang()
                + "',harga_barang='" + brg.getHarga_barang() + "',stok_barang='" + brg.getStok_barang()
                + "' WHERE id_barang='" + brg.getId_barang() + "'";
        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public int deleteBrg(BarangModel brg) {
        int hasil = 0;
        String sql = "DELETE FROM barang WHERE id_barang = '" + brg.getId_barang() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    

}
