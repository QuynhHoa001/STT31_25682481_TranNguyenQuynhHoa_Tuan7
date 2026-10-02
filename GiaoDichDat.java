package GiaoDichNhaDat;

import java.time.LocalDate;

// ======================= GIAO DỊCH ĐẤT =======================
class GiaoDichDat extends GiaoDich {
    private char loaiDat; // A, B, C

    public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich,
                       double donGia, double dienTich, char loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }

    public char getLoaiDat() {
        return loaiDat;
    }

    @Override
    public double tinhThanhTien() {
        if (loaiDat == 'A' || loaiDat == 'a') {
            return dienTich * donGia * 1.5;
        }

        // Loại B, C
        return dienTich * donGia;
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(
            " | Loai dat: %c | Thanh tien: %.2f%n",
            loaiDat, tinhThanhTien()
        );
    }
}
