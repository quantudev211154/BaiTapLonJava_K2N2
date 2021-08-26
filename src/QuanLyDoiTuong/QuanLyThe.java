package QuanLyDoiTuong;

import DoiTuong.PhieuThue;
import DoiTuong.TheThanhVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.text.DateFormat;
import java.util.*;

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

    public TheThanhVien timTheThanhVien(int maKH){
        for (TheThanhVien t : dsTheThanhVien)
            if (t.getMaKH() == maKH)
                return t;
        return null;
    }

    public int tinhSoKhachKhongThueDia(KetNoiToiCoSoDuLieu kn){
        int dem = 0;
        ArrayList<PhieuThue> dsPT = new QuanLyPhieuThue(kn).getDsPhieuThue();
        for (TheThanhVien tv : dsTheThanhVien){
            int tmp = 0;
            for (PhieuThue p : dsPT)
                if (tv.getMaThe() == p.getMaThe())
                    tmp++;
            if (tmp == 0)
                dem++;
        }
        return dem;
    }

    public void sapXepTangDanTheoMaKH(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getMaKH() > o2.getMaKH())
                    return 1;
                if (o1.getMaKH() == o2.getMaKH())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMaKH(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getMaKH() < o2.getMaKH())
                    return 1;
                if (o1.getMaKH() == o2.getMaKH())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepTangDanTheoNgayLapThe(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getNgayLap().after(o2.getNgayLap()))
                    return 1;
                if (o1.getNgayLap().equals(o2.getNgayLap()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoNgayLapThe(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getNgayLap().before(o2.getNgayLap()))
                    return 1;
                if (o1.getNgayLap().equals(o2.getNgayLap()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepTangDanTheoNgayHetHan(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getNgayHetHan().after(o2.getNgayHetHan()))
                    return 1;
                if (o1.getNgayHetHan().equals(o2.getNgayHetHan()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoNgayHetHan(){
        Collections.sort(dsTheThanhVien, new Comparator<TheThanhVien>() {
            @Override
            public int compare(TheThanhVien o1, TheThanhVien o2) {
                if (o1.getNgayHetHan().before(o2.getNgayHetHan()))
                    return 1;
                if (o1.getNgayHetHan().equals(o2.getNgayHetHan()))
                    return 0;
                return -1;
            }
        });
    }

    public int tinhDoLonDuLieu(){
        return dsTheThanhVien.size();
    }

    public int soTheHetHan(){
        int soTheQuaHan = 0;
        for (TheThanhVien t : dsTheThanhVien)
            if (t.getNgayHetHan().before(new Date()))
                soTheQuaHan++;
        return soTheQuaHan;
    }

    public String ngayQuanHanLauNhat(){
        Date moc = new Date();
        for (TheThanhVien t : dsTheThanhVien)
            if (t.getNgayHetHan().before(moc))
                moc = t.getNgayHetHan();
        if (moc.equals(new Date()))
            return "không thẻ nào hết hạn";
        DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
        return df.format(moc);
    }

}
