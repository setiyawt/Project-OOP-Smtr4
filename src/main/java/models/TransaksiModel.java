/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;


/**
 *
 * @author hendr
 */
public class TransaksiModel {
    private int id_transaksi;
    private int id_barang;
    private int id_user;
    private int jumlah_barang;
    private int total;

    
    
    public TransaksiModel(int id_barang, int id_user, int jumlah_barang, int total) {

        this.id_barang = id_barang;
        this.id_user = id_user;
        this.jumlah_barang = jumlah_barang;
        this.total = total;
    }
    
   
    
    public TransaksiModel(){
        
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }


    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

   
    
}
