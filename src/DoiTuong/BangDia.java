package DoiTuong;

import java.util.Objects;

public class BangDia {
    private int maBD = 0;
    private String tenBD = "";
    private String theLoai = "";
    /**
     * tinhTrang = True => Con dung duoc
     * tinhTrang = False => Coi nhu hong -> Xoa luon
     */
    private boolean tinhTrang = true;
    private String hangSX = "";
    private String ghiChu = "";
    private int soLuongGoc = 0;
    private int soLuongTon = 0;
    private double donGia = 0;
    private double giaThue = 0;

    public BangDia(int maBD) {
        this.maBD = maBD;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public BangDia(int maBD, String tenBD, String theLoai, boolean tinhTrang, String hangSX, String ghiChu, int soLuongGoc, int soLuongTon, double donGia, double giaThue) {
        this.maBD = maBD;
        this.tenBD = tenBD;
        this.theLoai = theLoai;
        this.tinhTrang = tinhTrang;
        this.hangSX = hangSX;
        this.ghiChu = ghiChu;
        this.soLuongGoc = soLuongGoc;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.giaThue = giaThue;
    }

    public int getMaBD() {
        return maBD;
    }

    public String getTenBD() {
        return tenBD;
    }

    public void setTenBD(String tenBD) {
        this.tenBD = tenBD;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLuongGoc() {
        return soLuongGoc;
    }

    public void setSoLuongGoc(int soLuongGoc) {
        this.soLuongGoc = soLuongGoc;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BangDia)) return false;
        BangDia bangDia = (BangDia) o;
        return getMaBD() == bangDia.getMaBD();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaBD());
    }

    @Override
    public String toString() {
        if (tinhTrang == true)
            return maBD + ";" + tenBD + ";" + theLoai + ";" + "OK" + ";"
                + hangSX + ";" + ghiChu + ";" + soLuongGoc + ";" + soLuongTon
                + ";" + donGia + ";" + giaThue;
        return maBD + ";" + tenBD + ";" + theLoai + ";" + "Da hong" + ";"
                + hangSX + ";" + ghiChu + ";" + soLuongGoc + ";" + soLuongTon
                + ";" + donGia + ";" + giaThue;
    }
}
