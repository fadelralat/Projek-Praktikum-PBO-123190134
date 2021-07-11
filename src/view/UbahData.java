package view;

import Peta_Covid19.Peta_Covid19;
import controller.ControlData;
import database.DBConnection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class UbahData {
  DBConnection dbconnection = new DBConnection();
  Peta_Covid19 peta = new Peta_Covid19();
  ControlData control = new ControlData();
  
  JLabel lNama = new JLabel("Nama Daerah");
  JLabel lSembuh = new JLabel("Sembuh");
  JLabel lIsolasi = new JLabel("Isolasi");
  JLabel lMeninggal = new JLabel("Meninggal");

  JTextField tfNama = new JTextField(200);
  JTextField tfSembuh = new JTextField();
  JTextField tfIsolasi = new JTextField();
  JTextField tfMeninggal = new JTextField();

  JButton btnEdit = new JButton("Ubah");
  JButton btnReset = new JButton("Reset");
  JButton btnBack = new JButton("Kembali");
  
  private void clearFields(){
      tfNama.setText(null);
      tfSembuh.setText(null);
      tfIsolasi.setText(null);
      tfMeninggal.setText(null);
  }
  
  public UbahData(Peta_Covid19 peta) {
    JFrame frame = new JFrame("Ubah Data " + peta.getNamadaerah());
    frame.setLayout(null);
    frame.setSize(380, 250);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    frame.add(lNama);
    frame.add(lSembuh);
    frame.add(lIsolasi);
    frame.add(lMeninggal);
    frame.add(tfSembuh);
    frame.add(tfNama);
    frame.add(tfIsolasi);
    frame.add(tfMeninggal);
    frame.add(btnEdit);
    frame.add(btnReset);
    frame.add(btnBack);

    lNama.setBounds(80, 20, 80, 25);
    lSembuh.setBounds(80, 50, 80, 25);
    lIsolasi.setBounds(80, 80, 80, 25);
    lMeninggal.setBounds(80, 110, 80, 25);

    tfNama.setBounds(170, 20, 120, 25);
    tfSembuh.setBounds(170, 50, 120, 25);
    tfIsolasi.setBounds(170, 80, 120, 25);
    tfMeninggal.setBounds(170, 110, 120, 25);

    btnEdit.setBounds(240, 150, 80, 40);
    btnReset.setBounds(150, 150, 80, 40);
    btnBack.setBounds(60, 150, 80, 40);
    btnEdit.setBackground(new Color(0,255,255));
    btnReset.setBackground(new Color(255,200,0));
    btnBack.setBackground(new Color(64, 64, 64));
    btnBack.setForeground(Color.WHITE);    
    
    tfNama.setText(peta.getNamadaerah());
    tfSembuh.setText(String.valueOf(peta.getSembuh()));
    tfIsolasi.setText(String.valueOf(peta.getIsolasi()));
    tfMeninggal.setText(String.valueOf(peta.getMeninggal()));
    
    btnEdit.addActionListener((var arg0) -> {
      String namadaerah = tfNama.getText();
      String status = null;
      int sembuh = 0, isolasi = 0, meninggal = 0, jumlahkasus = 0;
      try {
        sembuh = Integer.valueOf(tfSembuh.getText());
        isolasi = Integer.valueOf(tfIsolasi.getText());
        meninggal = Integer.valueOf(tfMeninggal.getText());
        jumlahkasus = sembuh + isolasi + meninggal;

            if(jumlahkasus < 1000){
              status = "Hijau";
            }else if (jumlahkasus < 10000){
              status = "Kuning";              
            }else if (jumlahkasus < 100000){
              status = "Oranye";
            }else if (jumlahkasus > 100001) {
              status = "Merah";
            }
        if (namadaerah.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Kolom Nama Harap Di isi");
          tfNama.requestFocusInWindow();
        }else if(sembuh < 0 || isolasi < 0 || meninggal < 0){
           JOptionPane.showMessageDialog(null,"Masukkan jumlah sembuh, isolasi dan meninggal harus bilangan positif");
           tfSembuh.requestFocus();
        }else{
          peta.setPeta_Covid19(namadaerah, sembuh, isolasi, meninggal, jumlahkasus, status);
          if (control.ubah(peta)) {
            frame.dispose();
            new LihatData();
            JOptionPane.showMessageDialog(null, "Ubah Data Daerah Berhasil");
          }
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Pastikan Semua Kolom Sudah Di isi");
      }
    });

    btnReset.addActionListener((ActionEvent arg0) -> {
        clearFields();
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new LihatData();
    });
  }
    
}
