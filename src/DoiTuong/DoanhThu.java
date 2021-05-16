package DoiTuong;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class DoanhThu {
    private int maTK = 0;
    private int maPhieu = 1;
    /**
     * loaiPhieu = true => PhieuThue
     * loaiPhieu = false => PhieuTra
     */
    private int loaiPhieu = 1;
    private double soTien = 0;
    private Date thoiGian = new Date();

    public DoanhThu(int maTK, int maPhieu, int loaiPhieu, double soTien, Date thoiGian) {
        this.maTK = maTK;
        this.maPhieu = maPhieu;
        this.loaiPhieu = loaiPhieu;
        this.soTien = soTien;
        this.thoiGian = thoiGian;
    }

    public DoanhThu(int maTK) {
        this.maTK = maTK;
    }

    public int getMaTK() {
        return maTK;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(int loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }


    @Override
    public String toString() {
        return "DoanhThu{" +
                "maTK=" + maTK +
                ", maPhieu=" + maPhieu +
                ", loaiPhieu=" + loaiPhieu +
                ", soTien=" + soTien +
                ", thoiGian=" + thoiGian +
                '}';
    }
}
