package QuanLyDoiTuong;

import DoiTuong.PhieuThue;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyPhieuThue {
    private ArrayList<PhieuThue> dsPhieuThue;

    public QuanLyPhieuThue(KetNoiToiCoSoDuLieu kn){
        this.dsPhieuThue = new ArrayList<>(kn.docDuLieuPhieuThue());
    }

    public ArrayList<PhieuThue> getDsPhieuThue() {
        return dsPhieuThue;
    }

    public ArrayList<PhieuThue> docDuLieuPhieuChuaTra(KetNoiToiCoSoDuLieu kn){
        return kn.docDuLieuPhieuChuaTra();
    }

    public boolean themPhieuThue(KetNoiToiCoSoDuLieu kn, PhieuThue p){
        return kn.themPhieuThue(p);
    }

    public boolean xoaPhieuThue(KetNoiToiCoSoDuLieu kn, int maPhieuThue){
        return kn.xoaPhieuThue(maPhieuThue);
    }

    public int timPhieuThue(int maPhieuThue){
        for (PhieuThue p : dsPhieuThue)
            if (p.getMaPhieu() == maPhieuThue)
                return dsPhieuThue.indexOf(p);
        return -1;
    }
}
