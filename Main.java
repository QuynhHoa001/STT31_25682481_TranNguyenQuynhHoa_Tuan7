package GiaoDichNhaDat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// ======================= CLASS MAIN =======================
public class Main {

    public static void main(String[] args) {

        List<GiaoDich> danhSach = new ArrayList<>();

        // ==================================================
        // TẠO 3 GIAO DỊCH ĐẤT MỖI LOẠI A, B, C
        // ==================================================

        // Đất loại A
        danhSach.add(new GiaoDichDat(
                "D001",
                LocalDate.of(2013, 9, 5),
                100,
                50,
                'A'
        ));

        danhSach.add(new GiaoDichDat(
                "D002",
                LocalDate.of(2013, 8, 10),
                120,
                60,
                'A'
        ));

        danhSach.add(new GiaoDichDat(
                "D003",
                LocalDate.of(2013, 10, 15),
                150,
                70,
                'A'
        ));

        // Đất loại B
        danhSach.add(new GiaoDichDat(
                "D004",
                LocalDate.of(2013, 9, 12),
                200,
                80,
                'B'
        ));

        danhSach.add(new GiaoDichDat(
                "D005",
                LocalDate.of(2013, 7, 20),
                180,
                90,
                'B'
        ));

        danhSach.add(new GiaoDichDat(
                "D006",
                LocalDate.of(2013, 11, 1),
                220,
                100,
                'B'
        ));

        // Đất loại C
        danhSach.add(new GiaoDichDat(
                "D007",
                LocalDate.of(2013, 9, 20),
                250,
                100,
                'C'
        ));

        danhSach.add(new GiaoDichDat(
                "D008",
                LocalDate.of(2013, 6, 15),
                300,
                120,
                'C'
        ));

        danhSach.add(new GiaoDichDat(
                "D009",
                LocalDate.of(2013, 12, 5),
                280,
                110,
                'C'
        ));


        // ==================================================
        // TẠO 3 GIAO DỊCH NHÀ CAO CẤP
        // ==================================================

        danhSach.add(new GiaoDichNha(
                "N001",
                LocalDate.of(2013, 9, 3),
                500,
                100,
                "cao cap",
                "Quan 1"
        ));

        danhSach.add(new GiaoDichNha(
                "N002",
                LocalDate.of(2013, 8, 18),
                600,
                120,
                "cao cap",
                "Quan 3"
        ));

        danhSach.add(new GiaoDichNha(
                "N003",
                LocalDate.of(2013, 10, 25),
                550,
                110,
                "cao cap",
                "Quan 5"
        ));


        // ==================================================
        // TẠO 3 GIAO DỊCH NHÀ THƯỜNG
        // ==================================================

        danhSach.add(new GiaoDichNha(
                "N004",
                LocalDate.of(2013, 9, 8),
                400,
                80,
                "thuong",
                "Quan 10"
        ));

        danhSach.add(new GiaoDichNha(
                "N005",
                LocalDate.of(2013, 7, 12),
                450,
                90,
                "thuong",
                "Quan 11"
        ));

        danhSach.add(new GiaoDichNha(
                "N006",
                LocalDate.of(2013, 11, 20),
                420,
                85,
                "thuong",
                "Quan 12"
        ));


        // ==================================================
        // XUẤT DANH SÁCH
        // ==================================================

        System.out.println("========== DANH SACH GIAO DICH ==========");

        for (GiaoDich gd : danhSach) {
            gd.xuat();
        }


        // ==================================================
        // TÍNH TỔNG SỐ LƯỢNG TỪNG LOẠI
        // ==================================================

        int datA = 0;
        int datB = 0;
        int datC = 0;

        int nhaCaoCap = 0;
        int nhaThuong = 0;

        for (GiaoDich gd : danhSach) {

            if (gd instanceof GiaoDichDat) {

                GiaoDichDat dat = (GiaoDichDat) gd;

                switch (Character.toUpperCase(dat.getLoaiDat())) {
                    case 'A':
                        datA++;
                        break;

                    case 'B':
                        datB++;
                        break;

                    case 'C':
                        datC++;
                        break;
                }

            } else if (gd instanceof GiaoDichNha) {

                GiaoDichNha nha = (GiaoDichNha) gd;

                if (nha.getLoaiNha().equalsIgnoreCase("cao cap")) {
                    nhaCaoCap++;
                } else {
                    nhaThuong++;
                }
            }
        }

        System.out.println("\n========== SO LUONG TUNG LOAI ==========");
        System.out.println("Dat loai A: " + datA);
        System.out.println("Dat loai B: " + datB);
        System.out.println("Dat loai C: " + datC);
        System.out.println("Nha cao cap: " + nhaCaoCap);
        System.out.println("Nha thuong: " + nhaThuong);


        // ==================================================
        // TÍNH TRUNG BÌNH THÀNH TIỀN GIAO DỊCH ĐẤT
        // ==================================================

        double tongTienDat = 0;
        int soLuongDat = 0;

        for (GiaoDich gd : danhSach) {

            if (gd instanceof GiaoDichDat) {
                tongTienDat += gd.tinhThanhTien();
                soLuongDat++;
            }
        }

        double trungBinhDat = 0;

        if (soLuongDat > 0) {
            trungBinhDat = tongTienDat / soLuongDat;
        }

        System.out.printf(
            "%nTrung binh thanh tien giao dich dat: %.2f%n",
            trungBinhDat
        );


        // ==================================================
        // XUẤT CÁC GIAO DỊCH TRONG THÁNG 9 NĂM 2013
        // ==================================================

        System.out.println(
            "\n========== GIAO DICH THANG 9/2013 =========="
        );

        for (GiaoDich gd : danhSach) {

            LocalDate ngay = gd.getNgayGiaoDich();

            if (ngay.getMonthValue() == 9 &&
                ngay.getYear() == 2013) {

                gd.xuat();
            }
        }
    }
}
