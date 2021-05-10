package DoiTuong;

import java.util.Objects;

public class TaiKhoan {
    private int maNV = 0;
    private String matKhau = "";
    /**
     * loaiTK = True => Quan tri vien (Administrator)
     * loaiTK = False => NV binh thuong (Staff)
     */
    private boolean loaiTK = false;

    public TaiKhoan(int maNV, String matKhau) {
        this.maNV = maNV;
        this.matKhau = matKhau;
    }

    public TaiKhoan(int maNV) {
        this.maNV = maNV;
    }

    public int getMaNV() {
        return maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isLoaiTK() {
        return loaiTK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaiKhoan)) return false;
        TaiKhoan taiKhoan = (TaiKhoan) o;
        return getMaNV() == taiKhoan.getMaNV();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaNV());
    }

    @Override
    public String toString() {
        if (loaiTK == true)
            return maNV + ";" + matKhau + ";" + "QTV";
        return maNV + ";" + matKhau + ";" + "Nhan Vien";
    }
}
