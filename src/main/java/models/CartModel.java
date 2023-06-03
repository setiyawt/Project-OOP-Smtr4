/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author hendr
 */
public class CartModel {
    private int id_user;
    private int id_barang;
    private String nama_kategori;
    private String nama_barang;
    private int harga_barang;
    private int jumlah_barang;
    private int total;


    public CartModel(int id_user, int id_barang, String nama_kategori, String nama_barang, int harga_barang, int jumlah_barang, int total) {
        this.id_user = id_user;
        this.id_barang = id_barang;
        this.nama_kategori = nama_kategori;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.jumlah_barang = jumlah_barang;
        this.total = total;
    }

    

    public CartModel() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
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

    
    

    

    @Override
    public String toString() {
        return "{" +
                " id_user='" + getId_user() + "'" + 
                ", id_barang'" + getId_barang() + "'" +
                ", nama_kategori" + getNama_kategori() + "'" +
                ", nama_barang='" + getNama_barang() + "'" +
                ", harga_barang='" + getHarga_barang() + "'" +
                ", jumlah_barang='" + getJumlah_barang() + "'" +
                ", total='" + getTotal() + "'" +
                "}";
    }
    
    
    
    
    
}
