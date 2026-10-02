package GiaoDichNhaDat;
import java.time.LocalDate;

// ======================= LỚP CHA =======================
abstract class GiaoDich {
    protected String maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected double dienTich;

    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich,
                    double donGia, double dienTich) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }

    // Phương thức trừu tượng
    public abstract double tinhThanhTien();

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void xuat() {
        System.out.printf(
            "Ma: %s | Ngay: %s | Don gia: %.2f | Dien tich: %.2f",
            maGiaoDich, ngayGiaoDich, donGia, dienTich
        );
    }
}



