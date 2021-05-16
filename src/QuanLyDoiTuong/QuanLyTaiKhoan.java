package QuanLyDoiTuong;

import DoiTuong.TaiKhoan;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyTaiKhoan {
    private ArrayList<TaiKhoan> dsTaiKhoan;

    public QuanLyTaiKhoan(KetNoiToiCoSoDuLieu kn){
        this.dsTaiKhoan = new ArrayList<>(kn.docDuLieuTaiKhoan());
    }

    public ArrayList<TaiKhoan> getDsTaiKhoan() {
        return dsTaiKhoan;
    }

    public boolean themTaiKhoan(KetNoiToiCoSoDuLieu kn, String matKhau) {
        return kn.themTaiKhoan(matKhau);
    }

    public boolean capNhatTaiKhoan(KetNoiToiCoSoDuLieu kn, int maTK, String matKhauMoi){
        return kn.capNhatTaiKhoan(maTK, matKhauMoi);
    }

    public int timTaiKhoan(int maTK){
        for (TaiKhoan tk : dsTaiKhoan)
            if (tk.getMaNV() == maTK)
                return dsTaiKhoan.indexOf(tk);
        return -1;
    }
}
