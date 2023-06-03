/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *p
 * @author hendr
 */
public class BarangModel {
    private int id_barang;
    private String nama_kategori;
    private String nama_barang;
    private int harga_barang;
    private int stok_barang;

    public BarangModel(String nama_kategori, String nama_barang, int harga_barang, int stok_barang) {
        
        this.nama_kategori = nama_kategori;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.stok_barang = stok_barang;
    }

    public BarangModel(int id_barang, String nama_kategori, String nama_barang, int harga_barang, int stok_barang) {
        this.id_barang = id_barang;
        this.nama_kategori = nama_kategori;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.stok_barang = stok_barang;
    }

    
    
    public BarangModel(){
        
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

    public int getStok_barang() {
        return stok_barang;
    }

    public void setStok_barang(int stok_barang) {
        this.stok_barang = stok_barang;
    }

    
}
