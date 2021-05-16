package DoiTuong;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PhieuTra extends Phieu {
    public int maPhieuThue = 0;
    public int tinhTrangDia = 1;
    public double soTienPhat = 0;

    public PhieuTra(int maPhieu, int maThe, int maNV, int maBD, int soLuong, Date ngayLap, int maPhieuThue, int tinhTrangDia, double soTienPhat) {
        super(maPhieu, maThe, maNV, maBD, soLuong, ngayLap);
        this.maPhieuThue = maPhieuThue;
        this.tinhTrangDia = tinhTrangDia;
        this.soTienPhat = soTienPhat;
    }

    public PhieuTra(int maPhieu) {
        super(maPhieu);
    }

    public int getMaPhieuThue() {
        return maPhieuThue;
    }

    public int getTinhTrangDia() {
        return tinhTrangDia;
    }

    public void setTinhTrangDia(int tinhTrangDia) {
        this.tinhTrangDia = tinhTrangDia;
    }

    public double getSoTienPhat() {
        return soTienPhat;
    }

    public void setSoTienPhat(double soTienPhat) {
        this.soTienPhat = soTienPhat;
    }

    @Override
    public String toString() {
       return super.toString() + ";" + maPhieuThue + ";" + tinhTrangDia + ";" + soTienPhat;
    }

}
