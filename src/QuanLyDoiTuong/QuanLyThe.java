package QuanLyDoiTuong;

import DoiTuong.TheThanhVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyThe {
    private ArrayList<TheThanhVien> dsTheThanhVien;

    public QuanLyThe(KetNoiToiCoSoDuLieu kn){
        this.dsTheThanhVien = new ArrayList<>(kn.docDuLieuTheThanhVien());
    }

    public ArrayList<TheThanhVien> getDsTheThanhVien() {
        return dsTheThanhVien;
    }

    public boolean themTheThanhVien(KetNoiToiCoSoDuLieu kn, TheThanhVien ttv){
        return kn.themTheThanhVien();
    }

    public boolean taiCapThe(KetNoiToiCoSoDuLieu kn, int maKH){
        return kn.taiTaoThe(maKH);
    }

    public boolean kiemTraThe(int maThe){
        for (TheThanhVien the : dsTheThanhVien){
            if (the.getMaThe() == maThe)
                return true;
        }
        return false;
    }

    public int timTheThanhVien(int maKH){
        for (TheThanhVien t : dsTheThanhVien)
            if (t.getMaKH() == maKH)
                return dsTheThanhVien.indexOf(t);
        return -1;
    }

}
