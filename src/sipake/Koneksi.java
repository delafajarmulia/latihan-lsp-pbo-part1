/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sipake;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Siswa
 */
public class Koneksi {
    private static Connection con;
    
//    public static void main(String [] args){
//    }
     
    public static Connection getKoneksiDB() throws ClassNotFoundException, SQLException{
        if(con == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/sekolah_db";
                String user = "root";
                String pw = "";

                con = DriverManager.getConnection(url, user, pw);
                System.out.println("koneksi berhasil");
            }catch(SQLException e){
                System.out.println("koneksi gagal");
            }
        }
        
        return con;
    }
}
