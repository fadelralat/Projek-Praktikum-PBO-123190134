package view;

import Peta_Covid19.Peta_Covid19;
import controller.ControlData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class LihatData extends ControlData {
  Peta_Covid19 peta = new Peta_Covid19();
  ControlData baca = new ControlData();
 
  JFrame frame = new JFrame("Lihat Data");
  JTable tabel;
  DefaultTableModel tableModel;
  JScrollPane scrollPane;
  Object namaKolom[] = {"Id", "Nama Daerah", "Sembuh", "Isolasi", "Meninggal", "Jumlah Kasus", "Status"};
  JButton btnBack = new JButton("Kembali");
  JButton btnPilih = new JButton("Pilih");
  
  JLabel Llabel1 = new JLabel("Pilih ID Daerah Covid19 : ");
  JLabel Llabel2 = new JLabel("(Untuk diubah atau dihapus)");
  JTextField tfId = new JTextField(35);
  public LihatData() {
    frame.setLayout(null);
    frame.setSize(550, 460);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(btnBack);
    frame.add(btnPilih);
    frame.add(tfId);
    frame.add(Llabel1);
    frame.add(Llabel2);
 
    btnBack.setBounds(0, 390, 535, 30);
    btnPilih.setBounds(190, 350, 70, 30);
    btnPilih.setBackground(new Color(0, 255, 0));
    btnBack.setBackground(new Color(64, 64, 64));
    btnBack.setForeground(Color.WHITE);
    
    Llabel1.setBounds(20, 300, 150, 30);
    Llabel2.setBounds(20, 320, 180, 30);
    tfId.setBounds(190, 310, 70, 30);
    
    if(baca.bacadata() == null){
      JOptionPane.showMessageDialog(null, "Tidak Ada Data");
      tabel = new JTable(null, namaKolom);
    }else{
      tabel = new JTable(baca.bacadata(), namaKolom);
    }
    
    scrollPane = new JScrollPane(tabel);
    frame.add(scrollPane);

    scrollPane.setBounds(20, 0, 500, 300);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new MenuUtama();
    });
    
    btnPilih.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      
      int Id = Integer.valueOf(tfId.getText());
      baca.ambilData(peta,Id);
      new RincianData(peta);
    });
  }
}
