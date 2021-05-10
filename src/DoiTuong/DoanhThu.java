package DoiTuong;

import java.time.LocalDate;
import java.util.Objects;

public class DoanhThu {
    private int maTK = 0;
    private String maPhieu = "";
    /**
     * loaiPhieu = true => PhieuThue
     * loaiPhieu = false => PhieuTra
     */
    private boolean loaiPhieu = true;
    private double soTien = 0;
    private LocalDate thoiGian = LocalDate.now();

    public DoanhThu(int maTK, String maPhieu, boolean loaiPhieu, double soTien, LocalDate thoiGian) {
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

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public boolean isLoaiPhieu() {
        return loaiPhieu;
    }

    public void setLoaiPhieu(boolean loaiPhieu) {
        this.loaiPhieu = loaiPhieu;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public LocalDate getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(LocalDate thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoanhThu)) return false;
        DoanhThu doanhThu = (DoanhThu) o;
        return Objects.equals(getMaTK(), doanhThu.getMaTK());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaTK());
    }

}
