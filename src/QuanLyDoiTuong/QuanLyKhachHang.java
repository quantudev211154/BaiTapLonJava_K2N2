package QuanLyDoiTuong;

import DoiTuong.KhachHang;
import DoiTuong.PhieuThue;
import DoiTuong.TheThanhVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.sql.SQLException;
import java.util.*;

public class QuanLyKhachHang {
    private ArrayList<KhachHang> dsKhachHang;

    public QuanLyKhachHang(KetNoiToiCoSoDuLieu kn){
        this.dsKhachHang = kn.docDuLieuKhachHang();
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public boolean themKhachHang(KetNoiToiCoSoDuLieu kn, KhachHang kh){
        return kn.themKhachHang(kh);
    }

    public boolean xoaKhachHang(KetNoiToiCoSoDuLieu kn, int maKH){
        return kn.xoaKhachHang(maKH);
    }

    public boolean capNhatKhachHang(KetNoiToiCoSoDuLieu kn, int maKH, String soDT_M, String diaChi_M){
        return kn.capNhatKhachHang(maKH, soDT_M, diaChi_M);
    }

    public KhachHang timKhachHang(String soCMND){
        for (KhachHang kh : dsKhachHang){
            if (kh.getSoCMND().equals(soCMND))
                return kh;
        }
        return null;
    }

    public int doLonDuLieu(){
        return dsKhachHang.size();
    }

    public int[] tinhSoKhachTheoGioiTinh(){
        int soNam = 0, soNu = 0;
        for (KhachHang kh : dsKhachHang)
            if (kh.getGioiTinh() == 1)
                soNam++;
            else
                soNu++;
        int[] giaTriTraVe = {soNam, soNu};
        return giaTriTraVe;
    }

    public String[] timKhachSop(KetNoiToiCoSoDuLieu kn){
        Set<Integer> dsMaThe = new HashSet<>();
        ArrayList<Integer> dsSoDia = new ArrayList<>();
        ArrayList<PhieuThue> dsPT = new QuanLyPhieuThue(kn).getDsPhieuThue();
        for (PhieuThue p : dsPT)
            dsMaThe.add(p.getMaThe());
        for (Integer i : dsMaThe){
            int soDia = 0;
            for (PhieuThue p : dsPT)
                if (p.getMaThe() == i)
                    soDia += p.getSoLuong();
            dsSoDia.add(soDia);
        }
        int soDiaLonNhat = 0;
        int vt = 0;
        for (Integer i : dsSoDia){
            if (i >= soDiaLonNhat){
                soDiaLonNhat = i;
                vt = dsSoDia.indexOf(i);
            }
        }
        ArrayList<Integer> dsMaTheEpKieu = new ArrayList<>(dsMaThe);
        int maTheThueNhieuDiaNhat = dsMaTheEpKieu.get(vt);
        int maKHThueNhieuNhat = 0;
        ArrayList<TheThanhVien> t = new QuanLyThe(kn).getDsTheThanhVien();
        for (TheThanhVien tv : t){
            if (tv.getMaThe() == maTheThueNhieuDiaNhat)
                maKHThueNhieuNhat = tv.getMaKH();
        }
        String tenKHThueNhieuNhat = "";
        for (KhachHang k : dsKhachHang){
            if (k.getID() == maKHThueNhieuNhat)
                tenKHThueNhieuNhat = k.getTen();
        }
        String[] giaTriTraVe = {tenKHThueNhieuNhat, soDiaLonNhat+""};
        return giaTriTraVe;
    }

    public void sapXepTangDanTheoTen(){
        Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if (o1.getTen().compareTo(o2.getTen()) > 0)
                    return 1;
                if (o1.getTen().compareTo(o2.getTen()) == 0)
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoTen(){
        Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if (o1.getTen().compareTo(o2.getTen()) < 0)
                    return 1;
                if (o1.getTen().compareTo(o2.getTen()) == 0)
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMa(){
        Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang o1, KhachHang o2) {
                if (o1.getID() < o2.getID())
                    return 1;
                if (o1.getID() == o2.getID())
                    return 0;
                return -1;
            }
        });
    }

}
