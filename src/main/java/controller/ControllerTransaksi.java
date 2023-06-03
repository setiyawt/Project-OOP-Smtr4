/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import connection.ConnectionManager;
import models.TransaksiModel;
import java.sql.Connection;
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
public class ControllerTransaksi {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<TransaksiModel> getTrx() {
        List<TransaksiModel> lsTrx = new ArrayList<TransaksiModel>();
        String sql;

        sql = "SELECT * FROM transaksi ORDER BY id_transaksi";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                TransaksiModel trxa = new TransaksiModel();
                trxa.setId_transaksi(rs.getInt("id_transaksi"));
                trxa.setId_barang(rs.getInt("id_barang"));
                trxa.setId_user(rs.getInt("id_user"));
                trxa.setJumlah_barang(rs.getInt("jumlah_barang"));
                trxa.setTotal(rs.getInt("total"));

                lsTrx.add(trxa);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsTrx;
    }

    public int saveTrx(TransaksiModel trx) {
        int hasil = 0;
        String sql = null;

        sql = "INSERT INTO transaksi(id_barang, id_user, jumlah_barang, total) VALUES('" + trx.getId_barang()
                + "','" + trx.getId_user() + "','" + trx.getJumlah_barang() + "','"
                + trx.getTotal() + "')";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}
