package Peta_Covid19;

import database.DBConnection;
import view.MenuUtama;

public class Main {

  public static void main(String[] args) {
    DBConnection dbconnection = new DBConnection();
    if (dbconnection.getConnection() == null);
    else new MenuUtama();
  }
}
