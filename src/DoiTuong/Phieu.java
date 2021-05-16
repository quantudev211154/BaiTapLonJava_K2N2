package DoiTuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public abstract class Phieu {
    private int maPhieu = 0;
    private int maThe = 0;
    private int maNV = 0;
    private int maBD = 0;
    private int soLuong = 0;
    private Date ngayLap = new Date();

    public Phieu(int maPhieu, int maThe, int maNV, int maBD, int soLuong, Date ngayLap) {
        this.maPhieu = maPhieu;
        this.maThe = maThe;
        this.maNV = maNV;
        this.maBD = maBD;
        this.soLuong = soLuong;
        this.ngayLap = ngayLap;
    }

    public Phieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaBD() {
        return maBD;
    }

    public void setMaBD(int maBD) {
        this.maBD = maBD;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Phieu{" +
                "maPhieu=" + maPhieu +
                ", maThe=" + maThe +
                ", maNV=" + maNV +
                ", maBD=" + maBD +
                ", soLuong=" + soLuong +
                ", ngayLap=" + ngayLap +
                '}';
    }
}
