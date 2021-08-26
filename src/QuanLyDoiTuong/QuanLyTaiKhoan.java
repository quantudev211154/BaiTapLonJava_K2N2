package QuanLyDoiTuong;

import DoiTuong.TaiKhoan;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public TaiKhoan timTaiKhoan(int maNV){
        for (TaiKhoan tk : dsTaiKhoan)
            if (tk.getMaNV() == maNV)
                return tk;
        return null;
    }

    public void sapXepTangDanTheoTenDN(){
        Collections.sort(dsTaiKhoan, new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan o1, TaiKhoan o2) {
                if (o1.getMaNV() > o2.getMaNV())
                    return 1;
                if (o1.getMaNV() == o2.getMaNV())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoTenDN(){
        Collections.sort(dsTaiKhoan, new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan o1, TaiKhoan o2) {
                if (o1.getMaNV() < o2.getMaNV())
                    return 1;
                if (o1.getMaNV() == o2.getMaNV())
                    return 0;
                return -1;
            }
        });
    }

    public int doLonDuLieu(){
        return dsTaiKhoan.size();
    }

    public int plMatKhauManh(){
        int sl = 0;
        for (TaiKhoan tk : dsTaiKhoan){
            if (tk.getMatKhau().length() <= 6)
                sl++;
        }
        return sl;
    }
}
