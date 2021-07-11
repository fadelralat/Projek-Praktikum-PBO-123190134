package view;
import database.DBConnection;
import Peta_Covid19.Peta_Covid19;
import controller.ControlData;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TambahData extends ControlData {
  DBConnection dbconnection = new DBConnection();
  ControlData control = new ControlData();
  Peta_Covid19 data = new Peta_Covid19();
  
  JFrame frame = new JFrame("Masukan Data");
  JLabel LInput = new JLabel("Masukan Data Daerah Terdampak");
  JLabel LNama = new JLabel("Nama Daerah");
  JLabel LSembuh = new JLabel("Sembuh");
  JLabel LIsolasi = new JLabel("Isolasi");
  JLabel LMeninggal = new JLabel("Meninggal");
  JTextField tfNama = new JTextField(35);
  JTextField tfSembuh = new JTextField(35);
  JTextField tfIsolasi = new JTextField(35);
  JTextField tfMeninggal = new JTextField(35);
  
  JButton btnSubmit = new JButton("Submit");
  JButton btnReset = new JButton("Reset");
  JButton btnBack = new JButton("Kembali");
  
  Container container = new Container();

  public void clearFields(){
      tfNama.setText(null);
      tfSembuh.setText(null);
      tfIsolasi.setText(null);
      tfMeninggal.setText(null);
  }
  
  public TambahData(){
    frame.setLayout(null);
    frame.setSize(380, 300);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(LInput);
    frame.add(LNama);
    frame.add(LSembuh);
    frame.add(LIsolasi);
    frame.add(LMeninggal);
    
    frame.add(tfNama);
    frame.add(tfSembuh);
    frame.add(tfIsolasi);
    frame.add(tfMeninggal);
    
    frame.add(btnSubmit);
    frame.add(btnReset);
    frame.add(btnBack);
       
    LInput.setBounds(80, 10, 220, 30);
    LNama.setBounds(80, 40, 80, 25);
    tfNama.setBounds(160, 40, 130, 25);
    LSembuh.setBounds(80, 70, 80, 25);
    tfSembuh.setBounds(160, 70, 130, 25);
    LIsolasi.setBounds(80, 100, 80, 25);
    tfIsolasi.setBounds(160, 100, 130, 25);
    LMeninggal.setBounds(80, 130, 80, 25);
    tfMeninggal.setBounds(160, 130, 130, 25);
    
    btnSubmit.setBounds(80, 165, 100, 30);
    btnReset.setBounds(190, 165, 100, 30);
    btnBack.setBounds(20, 210, 330, 30);
    btnSubmit.setBackground(new Color(0, 255, 0));
    btnReset.setBackground(new Color(255,200,0));
    btnBack.setBackground(new Color(64, 64, 64));
    btnBack.setForeground(Color.WHITE);
    
    btnSubmit.addActionListener((ActionEvent arg0) -> {
      int sembuh,isolasi, meninggal, jumlahkasus;
      String status = null;
      String nama = tfNama.getText();

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
            if (nama.isEmpty()) {
              JOptionPane.showMessageDialog(null, "Kolom Nama Harap Di isi");
              tfNama.requestFocusInWindow();
            }else if(sembuh < 0 || isolasi < 0 || meninggal < 0){
               JOptionPane.showMessageDialog(null,"Input jumlah sembuh, isolasi dan meninggal harus bilangan positif");
            }else{
                data.setPeta_Covid19(nama, sembuh, isolasi, meninggal, jumlahkasus, status);
                if (control.masukan(data)) {
                    frame.dispose();
                    new MenuUtama();
                    JOptionPane.showMessageDialog(null, "Tambah Data Daerah Berhasil");
              } else {
                    JOptionPane.showMessageDialog(null, "Tambah Data Daerah Gagal");
              }
            }
      } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null,"Pastikan Semua Kolom Sudah Di isi");
      }
    });
    btnReset.addActionListener((ActionEvent arg0) -> {
      clearFields();
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new MenuUtama();
    });
   }
}
