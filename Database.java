package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Database {
 private final String URL= "jdbc:mysql://localhost:3306/perpustakaan?"+"serverTimezone=Asia/Makassar";
 private final String USER="root";
 private final String PASS="";
 
 public Connection getConnection(){
     
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con;
         con = DriverManager.getConnection(URL, USER, PASS);
         System.out.println("koneksi berhasil");
         return con;
     } catch (ClassNotFoundException | SQLException ex) {
         System.err.println("ERROR"+ex.toString());
         System.out.println("koneksi gagal");
         return null;
     }
 }
 public static void main(String[] args){
     Database database = new Database();
     Connection con= database.getConnection();
 }
}
