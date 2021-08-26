package QuanLyDoiTuong;

import DoiTuong.PhieuTra;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public ArrayList<PhieuTra> timPhieuTra(int maThe){
        ArrayList<PhieuTra> dsPT = new ArrayList<>();
        for (PhieuTra p : dsPhieuTra)
            if (p.getMaThe() == maThe)
                dsPT.add(p);
        return dsPT;
    }

    public void sapXepTangDanTheoMaPhieuThue(){
        Collections.sort(dsPhieuTra, new Comparator<PhieuTra>() {
            @Override
            public int compare(PhieuTra o1, PhieuTra o2) {
                if (o1.getMaPhieuThue() > o2.getMaPhieuThue())
                    return 1;
                if (o1.getMaPhieuThue() == o2.getMaPhieuThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMaPhieuThue(){
        Collections.sort(dsPhieuTra, new Comparator<PhieuTra>() {
            @Override
            public int compare(PhieuTra o1, PhieuTra o2) {
                if (o1.getMaPhieuThue() < o2.getMaPhieuThue())
                    return 1;
                if (o1.getMaPhieuThue() == o2.getMaPhieuThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepTangDanTheoMaDiaThue(){
        Collections.sort(dsPhieuTra, new Comparator<PhieuTra>() {
            @Override
            public int compare(PhieuTra o1, PhieuTra o2) {
                if (o1.getMaBD() > o2.getMaBD())
                    return 1;
                if (o1.getMaPhieuThue() == o2.getMaPhieuThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMaDiaThue(){
        Collections.sort(dsPhieuTra, new Comparator<PhieuTra>() {
            @Override
            public int compare(PhieuTra o1, PhieuTra o2) {
                if (o1.getMaBD() < o2.getMaBD())
                    return 1;
                if (o1.getMaPhieuThue() == o2.getMaPhieuThue())
                    return 0;
                return -1;
            }
        });
    }

    public int doLonDuLieu(){
        return dsPhieuTra.size();
    }

    public double soTienPhat(){
        double soTienPhat = 0;
        for (PhieuTra p : dsPhieuTra)
            soTienPhat += p.getSoTienPhat();
        return soTienPhat;
    }

    public int soPhieuTraDiaHong(){
        int soPhieuTraHong = 0;
        for (PhieuTra p : dsPhieuTra)
            if (p.getTinhTrangDia() == 2)
                soPhieuTraHong++;
        return soPhieuTraHong;
    }
}
