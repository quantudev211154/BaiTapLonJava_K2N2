package QuanLyDoiTuong;

import DoiTuong.PhieuThue;
import DoiTuong.TheThanhVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.sql.SQLException;
import java.util.*;

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

    public int doLonDuLieu(){
        return dsPhieuThue.size();
    }

    public ArrayList<PhieuThue> timPhieuThue(int maThe){
        ArrayList<PhieuThue> dsPT = new ArrayList<>();
        for (PhieuThue p : dsPhieuThue)
            if (p.getMaThe() == maThe)
                dsPT.add(p);
        return dsPT;
    }

    public void sapXepTangDanNgayLap(){
        Collections.sort(dsPhieuThue, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getNgayLap().after(o2.getNgayLap()))
                    return 1;
                if (o1.getNgayLap().equals(o2.getNgayLap()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanNgayLap(){
        Collections.sort(dsPhieuThue, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getNgayLap().before(o2.getNgayLap()))
                    return 1;
                if (o1.getNgayLap().equals(o2.getNgayLap()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepTangDanThanhTien(){
        Collections.sort(dsPhieuThue, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getTongTienThue() > o2.getTongTienThue())
                    return 1;
                if (o1.getTongTienThue() == o2.getTongTienThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanThanhTien(){
        Collections.sort(dsPhieuThue, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getTongTienThue() < o2.getTongTienThue())
                    return 1;
                if (o1.getTongTienThue() == o2.getTongTienThue())
                    return 0;
                return -1;
            }
        });
    }

    public int timSoLuongDiaDuocThue(){
        int sl = 0;
        for (PhieuThue p : dsPhieuThue)
            sl += p.getSoLuong();
        return sl;
    }

    public double tinhDoanhThuTongCong(){
        double doanhThuLon = 0;
        for (PhieuThue p : dsPhieuThue)
            doanhThuLon += p.getTongTienThue();
        return doanhThuLon;
    }

    public int tinhSoLuongKhachDaThueDia(){
        Set<Integer> dsThe = new HashSet<>();
        for (PhieuThue p : dsPhieuThue)
            dsThe.add(p.getMaThe());
        return dsThe.size();
    }

    public int tinhSoMaDiaDuocThue(){
        Set<Integer> dsMaDia = new HashSet<>();
        for (PhieuThue p : dsPhieuThue)
            dsMaDia.add(p.getMaBD());
        return dsMaDia.size();
    }

    public Date layNgayLapPTSomNhat(){
        return dsPhieuThue.get(0).getNgayLap();
    }

}
