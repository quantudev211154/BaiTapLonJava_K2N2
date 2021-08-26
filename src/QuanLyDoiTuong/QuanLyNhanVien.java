package QuanLyDoiTuong;

import DoiTuong.NhanVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public NhanVien timNhanVien(String soDT){
        for (NhanVien nv : dsNhanVien)
            if (nv.getSoDT().equals(soDT))
                return nv;
        return null;
    }

    public void sapXepTangDanTheoTenNV(){
        Collections.sort(dsNhanVien, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.getTen().compareTo(o2.getTen()) > 1)
                    return 1;
                if (o1.getID() == o2.getID())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoTenNV(){
        Collections.sort(dsNhanVien, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.getTen().compareTo(o2.getTen()) < 1)
                    return 1;
                if (o1.getID() == o2.getID())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMaNV(){
        Collections.sort(dsNhanVien, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if (o1.getID() < o2.getID())
                    return 1;
                if (o1.getID() == o2.getID())
                    return 0;
                return -1;
            }
        });
    }

    public int doLonDuLieu(){
        return dsNhanVien.size();
    }

    public int[] phanLoaiNhanVienTheoGT(){
        int soNVNam = 0, soNVNu = 0;
        for (NhanVien nv : dsNhanVien)
            if (nv.getGioiTinh() == 1)
                soNVNam++;
            else
                soNVNu++;
        int[] gtriTraVe = {soNVNam, soNVNu};
        return gtriTraVe;
    }
}
