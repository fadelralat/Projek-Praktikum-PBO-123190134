package Peta_Covid19;

public class Peta_Covid19 {
  private int id;  
  private String namadaerah;
  private int sembuh;
  private int isolasi;
  private int meninggal;
  private int jumlahkasus;
  private String status;
  
  public void setPeta_Covid19(String namadaerah, int sembuh, int isolasi, int meninggal, int jumlahkasus, String status){
    this.namadaerah = namadaerah;
    this.sembuh = sembuh;
    this.isolasi = isolasi;
    this.meninggal = meninggal;
    this.jumlahkasus = jumlahkasus;
    this.status = status;
  }
  public void setId(int id){
   this.id = id;
  }
  public void setStatus(String status){
   this.status = status;
  }
  public String getNamadaerah(){
    return namadaerah;
  }
  public int getSembuh(){
    return sembuh;
  }
  public int getIsolasi(){
    return isolasi;
  }
  public int getMeninggal(){
    return meninggal;
  }
  public int getJumlahkasus(){
    return jumlahkasus;
  }
  public String getStatus(){
    return status;
  }
  public int getId(){
    return id;
  }
}
