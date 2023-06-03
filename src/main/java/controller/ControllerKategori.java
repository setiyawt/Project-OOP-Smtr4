/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import connection.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import models.KategoriModel;

/**
 *
 * @author hendr
 */
public class ControllerKategori {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<KategoriModel> getJenisBrg() {
        List<KategoriModel> lsJBrg = new ArrayList<KategoriModel>();
        String sql;

        sql = "SELECT * FROM kategori ORDER BY id_kategori";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                KategoriModel jbm = new KategoriModel();
                jbm.setId_kategori(rs.getInt("id_kategori"));
                jbm.setNama_kategori(rs.getString("nama_kategori"));

                lsJBrg.add(jbm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerKategori.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lsJBrg;
    }
}
