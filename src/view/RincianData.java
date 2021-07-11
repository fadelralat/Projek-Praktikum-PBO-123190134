package view;

import Peta_Covid19.Peta_Covid19;
import controller.ControlData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RincianData {
  Peta_Covid19 peta = new Peta_Covid19();
  ControlData control = new ControlData();
  
  JLabel LNama = new JLabel("Nama Daerah : ");
  JLabel LSembuh = new JLabel("Sembuh : ");
  JLabel LIsolasi = new JLabel("Isolasi : ");
  JLabel LMeninggal = new JLabel("Meninggal : ");
  JLabel LJumlahkasus = new JLabel("Jumlah Kasus : ");
  JLabel LStatus = new JLabel("Status : ");

  JLabel LDataNama = new JLabel();
  JLabel LDataSembuh = new JLabel();
  JLabel LDataIsolasi = new JLabel();
  JLabel LDataMeninggal = new JLabel();
  JLabel LDataJumlahkasus = new JLabel();
  JLabel LDataStatus = new JLabel();

  JButton btnHapus = new JButton("Hapus");
  JButton btnEdit = new JButton("Ubah");
  JButton btnBack = new JButton("Kembali");
  
   public RincianData(Peta_Covid19 peta) {
    JLabel Llabel = new JLabel("Rincian Data "+ peta.getNamadaerah());
    JFrame frame = new JFrame(peta.getNamadaerah());
    frame.setLayout(null);
    frame.setSize(380, 300);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    frame.add(Llabel);
    frame.add(LNama);
    frame.add(LSembuh);
    frame.add(LIsolasi);
    frame.add(LMeninggal);
    frame.add(LJumlahkasus);
    frame.add(LStatus);
    frame.add(LDataSembuh);
    frame.add(LDataNama);
    frame.add(LDataIsolasi);
    frame.add(LDataMeninggal);
    frame.add(LDataJumlahkasus);
    frame.add(LDataStatus);;
    frame.add(btnHapus);
    frame.add(btnEdit);
    frame.add(btnBack);

    Llabel.setBounds(80, 0, 200, 35);
    LNama.setBounds(80, 30, 200, 35);
    LSembuh.setBounds(80, 55, 100, 35);
    LIsolasi.setBounds(80, 80, 200, 35);
    LMeninggal.setBounds(80, 105, 200, 35);
    LJumlahkasus.setBounds(80, 130, 200, 35);
    LStatus.setBounds(80, 155, 200, 35);

    LDataNama.setBounds(170, 30, 120, 35);
    LDataSembuh.setBounds(170, 55, 120, 35);
    LDataIsolasi.setBounds(170, 80, 120, 35);
    LDataMeninggal.setBounds(170, 105, 120, 35);
    LDataJumlahkasus.setBounds(170, 130, 120, 35);
    LDataStatus.setBounds(170, 155, 120, 35);

    btnHapus.setBounds(235, 200, 80, 40);
    btnEdit.setBounds(145, 200, 80, 40);
    btnBack.setBounds(55, 200, 80, 40);
    btnHapus.setBackground(new Color(255,0,0));
    btnEdit.setBackground(new Color(0,255,255));
    btnBack.setBackground(new Color(64, 64, 64));
    btnBack.setForeground(Color.WHITE);
    
    LDataNama.setText(peta.getNamadaerah());
    LDataSembuh.setText(String.valueOf(peta.getSembuh()));
    LDataIsolasi.setText(String.valueOf(peta.getIsolasi()));
    LDataMeninggal.setText(String.valueOf(peta.getMeninggal()));
    LDataJumlahkasus.setText(String.valueOf(peta.getJumlahkasus()));
    LDataStatus.setText(String.valueOf(peta.getStatus()));

        
    btnHapus.addActionListener((ActionEvent arg0) -> {
      if(control.hapus(peta)){
        JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
      }else{
        JOptionPane.showMessageDialog(null, "Hapus Data Gagal");
      }
      frame.dispose();
      new LihatData();
    });

    btnEdit.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new UbahData(peta);
    });
    btnBack.addActionListener((ActionEvent arg0) -> {
      frame.dispose();
      new LihatData();
    });
   }

}
