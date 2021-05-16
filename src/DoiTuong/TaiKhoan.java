package DoiTuong;

import java.util.Objects;

public class TaiKhoan {
    private int maNV = 0;
    private String matKhau = "";
    /**
     * loaiTK = True => Quan tri vien (Administrator)
     * loaiTK = False => NV binh thuong (Staff)
     */
    private int loaiTK = 2;

    public TaiKhoan(int maNV, String matKhau, int loaiTK) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
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

    public int getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(int loaiTK) {
        this.loaiTK = loaiTK;
    }

    @Override
    public String toString() {
        if (loaiTK == 1)
            return maNV + ";" + matKhau + ";" + "QTV";
        return maNV + ";" + matKhau + ";" + "Nhan Vien";
    }
}
