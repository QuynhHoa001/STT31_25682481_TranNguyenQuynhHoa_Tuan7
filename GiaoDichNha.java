package GiaoDichNhaDat;

import java.time.LocalDate;
//======================= GIAO DỊCH NHÀ =======================
class GiaoDichNha extends GiaoDich {
 private String loaiNha; // cao cap, thuong
 private String diaChi;

 public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich,
                    double donGia, double dienTich,
                    String loaiNha, String diaChi) {
     super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
     this.loaiNha = loaiNha;
     this.diaChi = diaChi;
 }

 public String getLoaiNha() {
     return loaiNha;
 }

 @Override
 public double tinhThanhTien() {
     if (loaiNha.equalsIgnoreCase("cao cap")) {
         return dienTich * donGia;
     }

     // Nhà thường giảm 10%
     return dienTich * donGia * 0.9;
 }

 @Override
 public void xuat() {
     super.xuat();
     System.out.printf(
         " | Loai nha: %s | Dia chi: %s | Thanh tien: %.2f%n",
         loaiNha, diaChi, tinhThanhTien()
     );
 }
}

