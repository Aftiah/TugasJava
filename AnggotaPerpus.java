package model;

import database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnggotaPerpus {
    private String id;
    private String nama;
    private String alamat;
    private int telp; 
    
    public AnggotaPerpus(){
        
    }

    public AnggotaPerpus(String id, String nama, String alamat, int telp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
       
    }
    
        public void create(){
        String insertQuery = "INSERT INTO anggota (id,nama,alamat,telp) VALUES (?,?,?,?)";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,this.id);
            ps.setString(2,this.nama);
            ps.setString(3,this.alamat);
            ps.setInt(4,this.telp);
            ps.execute();
            System.out.println("Tambah Data Berhasil");
        } catch (SQLException throwables){
            System.out.println("Tambah Data Gagal");
            throwables.printStackTrace();
        }
        }
             public void read(){
        String selectQuery = "SELECT * FROM anggota";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            Statement statement=con.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            
            while(resultSet.next()){
                System.out.println(resultSet.getString("id"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    public void update(){
      String insertQuery = "UPDATE anggota SET nama= ? ,alamat= ? ,telp= ? WHERE id= ?";
        Database database = new Database();
        Connection con = database.getConnection();
        
        try {
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(4,this.id);
            ps.setString(1,this.nama);
            ps.setString(2,this.alamat);
            ps.setInt(3,this.telp);
            ps.execute();
            System.out.println("Update Data Berhasil");
        } catch (SQLException throwables){
            System.out.println("Update Data Gagal");
            throwables.printStackTrace();
        }  
    }
    
    public void delete(){
        Database database = new Database();
        Connection con = database.getConnection();
        
        String deleteQuery= "DELETE FROM anggota WHERE id=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setString(1,this.id);
            ps.execute();
//            Statement statement = con.createStatement();
//            statement.execute(deleteQuery);
            System.out.println("Hapus Data Berhasil");
        } catch (SQLException throwables){
            System.out.println("Hapus Data Gagal");
            throwables.printStackTrace();
        }
    }
    
    public void delete(String id){
        Database database = new Database();
        Connection con = database.getConnection();
        
        String deleteQuery= "DELETE FROM anggota WHERE id=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setString(1,this.id);
            ps.execute();
            System.out.println("Hapus Data Berhasil");
        } catch (SQLException throwables){
            System.out.println("Hapus Data Gagal");
            throwables.printStackTrace();
        }
    }
       
    
    public void pinjamBuku(){
        
    }
    
    public void kembaliBuku(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getTelp() {
        return telp;
    }

    public void setTelp(int telp) {
        this.telp = telp;
    }
    

}
