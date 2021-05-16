package QuanLyDoiTuong;

import DoiTuong.PhieuTra;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyPhieuTra {
    private ArrayList<PhieuTra> dsPhieuTra;

    public QuanLyPhieuTra(KetNoiToiCoSoDuLieu kn){
        this.dsPhieuTra = new ArrayList<>(kn.docDuLieuPhieuTra());
    }

    public ArrayList<PhieuTra> getDsPhieuTra() {
        return dsPhieuTra;
    }

    public boolean themPhieuTra(KetNoiToiCoSoDuLieu kn, PhieuTra p){
        return kn.themPhieuTra(p);
    }

    public boolean xoaPhieuTra(KetNoiToiCoSoDuLieu kn, int maPhieuTra){
        return kn.xoaPhieuTra(maPhieuTra);
    }

    public int timPhieuTra(int maPhieu){
        for (PhieuTra p : dsPhieuTra)
            if (p.getMaPhieu() == maPhieu)
                return dsPhieuTra.indexOf(p);
        return -1;
    }
}
