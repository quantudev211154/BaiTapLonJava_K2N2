package QuanLyDoiTuong;

import DoiTuong.NhanVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyNhanVien {
    private ArrayList<NhanVien> dsNhanVien;

    public QuanLyNhanVien(KetNoiToiCoSoDuLieu kn){
        this.dsNhanVien = new ArrayList<>(kn.docDuLieuNhanVien());
    }

    public ArrayList<NhanVien> getDsNhanVien() {
        return dsNhanVien;
    }

    public boolean themNhanVien(KetNoiToiCoSoDuLieu kn, NhanVien nv){
        return kn.themNhanVien(nv);
    }

    public boolean xoaNhanVien(KetNoiToiCoSoDuLieu kn, int maNV){
        return kn.xoaNhanVien(maNV);
    }

}
