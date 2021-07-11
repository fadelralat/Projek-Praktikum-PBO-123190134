package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {
  private String url = "jdbc:mysql://localhost/petacovid19";
  private String user = "root";
  private String pass = "";
  private Connection con = null;

  public DBConnection(){
    try {
      con = DriverManager.getConnection(url, user, pass);
      System.out.println("Koneksi Berhasil");
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Tidak dapat terhubung ke database. Pastikan Xampp sudah aktif!");
      Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
      con = null;
    }
  }
 
  public Connection getConnection(){
    return con;
  }
}


