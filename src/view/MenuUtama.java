package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuUtama {
 
  JFrame frame = new JFrame("Menu Utama");
  JLabel LProjek = new JLabel("Program Peta Sebaran Covid19");
  JButton btnMasukan = new JButton("Tambah Daftar Daerah");
  JButton btnLihat = new JButton("Lihat dan Perbarui Data Sebaran Covid-19");
  
  public MenuUtama(){
    frame.setLayout(null);
    frame.setSize(400, 200);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    
    frame.add(LProjek);
    frame.add(btnMasukan);
    frame.add(btnLihat);
    
    LProjek.setBounds(110, 10, 275, 50);
    btnMasukan.setBounds(60, 65, 275, 30);
    btnLihat.setBounds(60, 100, 275, 30);
    btnMasukan.setBackground(new Color(153,153,255));
    btnLihat.setBackground(new Color(102,153,255));
    
    btnMasukan.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new TambahData();
    });
    btnLihat.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new LihatData();
    });
  }
}
