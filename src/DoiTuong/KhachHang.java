package DoiTuong;

import java.util.Objects;

public class KhachHang extends Nguoi{
    private int maNV = 0;
    private String diaChi = "";
    private String soCMND = "";

    public KhachHang(int ID) {
        super(ID);
    }

    public KhachHang(int ID, String ten, int gioiTinh, String soDT, int maNV, String diaChi, String soCMND) {
        super(ID, ten, gioiTinh, soDT);
        this.maNV = maNV;
        this.diaChi = diaChi;
        this.soCMND = soCMND;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + maNV + ";" + diaChi + ";" + soCMND;
    }
}
