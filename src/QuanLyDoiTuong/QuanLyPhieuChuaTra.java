package QuanLyDoiTuong;

import DoiTuong.PhieuThue;
import DoiTuong.TheThanhVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.*;

public class QuanLyPhieuChuaTra {
    private ArrayList<PhieuThue> dsPhieuChuaTra;

    public QuanLyPhieuChuaTra(KetNoiToiCoSoDuLieu kn) {
        try{
            this.dsPhieuChuaTra = kn.docDuLieuPhieuChuaTra();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<PhieuThue> getDsPhieuChuaTra() {
        return dsPhieuChuaTra;
    }

    public ArrayList<PhieuThue> timPhieuChuaTra(int maThe){
        ArrayList<PhieuThue> dsPCT = new ArrayList<>();
        for (PhieuThue p : dsPhieuChuaTra)
            if (p.getMaThe() == maThe)
                dsPCT.add(p);
        return dsPCT;
    }

    public int doLonDuLieu(){return dsPhieuChuaTra.size();}

    public void sapXepTangDanNgayThue(){
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
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

    public void sapXepGiamDanNgayThue(){
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
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
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getTongTienThue() > (o2.getTongTienThue()))
                    return 1;
                if (o1.getTongTienThue() == o2.getTongTienThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanThanhTien(){
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getTongTienThue() < (o2.getTongTienThue()))
                    return 1;
                if (o1.getTongTienThue() == o2.getTongTienThue())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXemTangDanNgayHetHan(){
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getNgayHetHan().after(o2.getNgayHetHan()))
                    return 1;
                if (o1.getNgayHetHan().equals(o2.getNgayHetHan()))
                    return 0;
                return -1;
            }
        });
    }

    public void sapXemGiamDanNgayHetHan(){
        Collections.sort(dsPhieuChuaTra, new Comparator<PhieuThue>() {
            @Override
            public int compare(PhieuThue o1, PhieuThue o2) {
                if (o1.getNgayHetHan().before(o2.getNgayHetHan()))
                    return 1;
                if (o1.getNgayHetHan().equals(o2.getNgayHetHan()))
                    return 0;
                return -1;
            }
        });
    }

    public int soDiaTreHan(){
        int soDiaTre = 0;
        for (PhieuThue p : dsPhieuChuaTra)
            if (p.getNgayHetHan().before(new Date()))
                soDiaTre += p.getSoLuong();
        return soDiaTre;
    }

    public int soPhieuTreHan(){
        int sl = 0;
        for (PhieuThue p : dsPhieuChuaTra)
            if (p.getNgayHetHan().before(new Date()))
                sl++;
        return sl;
    }

    public String diaTreHanNhat(){
        Date tgTreNhat = new Date();
        for (PhieuThue p : dsPhieuChuaTra)
            if (p.getNgayHetHan().before(tgTreNhat))
                tgTreNhat = p.getNgayHetHan();
        if (tgTreNhat.equals(new Date()))
            return "Không đĩa trễ hạn";
        DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
        return df.format(tgTreNhat);
    }

    public ArrayList<PhieuThue> dsPhieuQuaHan(){
        ArrayList<PhieuThue> dsPTQuaHan = new ArrayList<>();
        for (PhieuThue p : dsPhieuChuaTra)
            if (p.getNgayHetHan().before(new Date()))
                dsPTQuaHan.add(p);
        return dsPTQuaHan;
    }

    public int soMaDiaTreHan(ArrayList<PhieuThue> dsTreHan){
        Set<Integer> dsMaDiaTre = new HashSet<>();
        for (PhieuThue p : dsTreHan)
            dsMaDiaTre.add(p.getMaBD());
        return dsMaDiaTre.size();
    }

    public static void main(String[] args) throws SQLException {
        QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(new KetNoiToiCoSoDuLieu());
        System.out.println(ql.dsPhieuQuaHan().size());
    }
}
