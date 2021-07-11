package controller;

import Peta_Covid19.Peta_Covid19;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlData {
    public boolean masukan(Peta_Covid19 b) {
    String query = "INSERT INTO `petacovid19`(`namadaerah`, `sembuh`, `isolasi`, `meninggal`, `jumlahkasus`, `status`) VALUES (?,?,?,?,?,?)";
     PreparedStatement ps;  
    
     try {
      DBConnection dbconnection = new DBConnection();
      ps = dbconnection.getConnection().prepareStatement(query);
      ps.setString(1, b.getNamadaerah());
      ps.setInt(2, b.getSembuh());
      ps.setInt(3, b.getIsolasi());
      ps.setInt(4, b.getMeninggal());
      ps.setInt(5, b.getJumlahkasus());
      ps.setString(6, b.getStatus());

      if (ps.executeUpdate() > 0) {
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
      return false;
    }
    return false;
   }
  
    private int hitungbaris() {
        String query = "SELECT * FROM `petacovid19`";
        PreparedStatement ps;
        ResultSet rs;

        int a = 0;
        try {
          DBConnection dbconnection = new DBConnection();
          ps = dbconnection.getConnection().prepareStatement(query);
          rs = ps.executeQuery();

          while (rs.next()) {
            a++;
          }
          return a ;

        } catch (SQLException ex) {
          Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -4;
    }
    
    public String[][] bacadata() {
        String query = "SELECT * FROM `petacovid19`";
        PreparedStatement ps;
        ResultSet rs;

        int cr = hitungbaris();

        String data[][] = new String[cr][7];

        try {
          DBConnection dbconnection = new DBConnection();
          ps = dbconnection.getConnection().prepareStatement(query);
          rs = ps.executeQuery();

          int n = 0; 
          while (rs.next()) { 
            data[n][0] = rs.getString(1);
            data[n][1] = rs.getString(2);
            data[n][2] = rs.getString(3);
            data[n][3] = rs.getString(4);
            data[n][4] = rs.getString(5);
            data[n][5] = rs.getString(6);
            data[n][6] = rs.getString(7);
            n++;
          }
          return data;
        } catch (SQLException ex) {
          Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        } 
    }
  
    public boolean ambilData(Peta_Covid19 peta, int n){
        String query = "Select * from `petacovid19` WHERE id=?";
        PreparedStatement ps;
        ResultSet rs;

        try {
          DBConnection dbconnection = new DBConnection();
          ps = dbconnection.getConnection().prepareStatement(query);
          ps.setInt(1, n);
          rs = ps.executeQuery();
          if (rs.next()) {
            int id = rs.getInt(1);
            String namadaerah = rs.getString(2);
            int sembuh = rs.getInt(3);
            int isolasi = rs.getInt(4);
            int meninggal = rs.getInt(5);
            int jumlahkasus = rs.getInt(6);
            String status = rs.getString(7);

            peta.setPeta_Covid19(namadaerah, sembuh, isolasi, meninggal, jumlahkasus, status);
            peta.setId(id);
            return true;
          }
        } catch (SQLException ex) {
          Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }
        return false;
    }
  
    public boolean ubah(Peta_Covid19 peta){
        String query = "UPDATE `petacovid19` SET `namadaerah`=?,`sembuh`=?,`isolasi`=?,`meninggal`=?,`jumlahkasus`=?,`status`=? WHERE `id`=?";
        PreparedStatement ps;
         try {
          DBConnection dbconnection = new DBConnection();
          ps = dbconnection.getConnection().prepareStatement(query);
          ps.setString(1, peta.getNamadaerah());
          ps.setInt(2, peta.getSembuh());
          ps.setInt(3, peta.getIsolasi());
          ps.setInt(4, peta.getMeninggal());
          ps.setInt(5, peta.getJumlahkasus());
          ps.setString(6, peta.getStatus());
          ps.setInt(7, peta.getId());
          int i = ps.executeUpdate();

          return i == 1; 

        } catch (SQLException ex) {
          Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }
    }
    
    public boolean hapus(Peta_Covid19 peta){
        String query = "DELETE FROM `petacovid19` WHERE `id`=?";
        PreparedStatement ps;

         try {
          DBConnection dbconnection = new DBConnection();
          ps = dbconnection.getConnection().prepareStatement(query);
          ps.setInt(1, peta.getId());

          int i = ps.executeUpdate();

          return i == 1;
          
        } catch (SQLException ex) {
          Logger.getLogger(ControlData.class.getName()).log(Level.SEVERE, null, ex);
          return false;
        }
    }
}
