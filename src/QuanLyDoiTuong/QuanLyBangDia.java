package QuanLyDoiTuong;

import DoiTuong.BangDia;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.sql.SQLException;
import java.util.*;

public class QuanLyBangDia {
    private ArrayList<BangDia> dsBangDia;

    public QuanLyBangDia(KetNoiToiCoSoDuLieu kn){
        this.dsBangDia = new ArrayList<>(kn.docDuLieuBangDia());
    }

    public ArrayList<BangDia> getDsBangDia() {
        return dsBangDia;
    }

    public boolean themBangDia(KetNoiToiCoSoDuLieu kn, BangDia bd){
        return kn.themBangDia(bd);
    }

    public boolean xoaBangDia(KetNoiToiCoSoDuLieu kn, int maBD){
        return kn.xoaBangDia(maBD);
    }

    public boolean capNhatDia(KetNoiToiCoSoDuLieu kn, int maBD, String tenBD_M, String theLoai_M, String hangSX_M,
                              String ghiChu_M, int slGoc_M, double donGia_M, double giaThue_M){
        return kn.capNhatDia(maBD, tenBD_M, theLoai_M, hangSX_M, ghiChu_M, slGoc_M, donGia_M, giaThue_M);
    }

    public BangDia timBangDia(int maBD){
        for (BangDia bd : dsBangDia){
            if (bd.getMaBD() == maBD)
                return bd;
        }
        return null;
    }

    public boolean kiemTraDia(int maDia){
        for (BangDia bd : dsBangDia)
            if (bd.getMaBD() == maDia)
                return true;
        return false;
    }

    public int doLonDuLieu(){
        return dsBangDia.size();
    }

    public int tinhSoTheLoai(){
        Set<String> dsTheLoai = new HashSet<>();
        for (BangDia bd : dsBangDia){
            dsTheLoai.add(bd.getTheLoai());
        }
        return dsTheLoai.size();
    }

    public int tinhSoHangSX(){
        Set<String> dsHangSX = new HashSet<>();
        for (BangDia bd : dsBangDia)
            dsHangSX.add(bd.getHangSX());
        return dsHangSX.size();
    }

    public double[] xemHaiCucGiaThue(){
        double giaThueCaoNhat = 0, giaThueThapNhat = dsBangDia.get(0).getGiaThue();
        for (BangDia bd : dsBangDia){
            if (bd.getGiaThue() >= giaThueCaoNhat)
                giaThueCaoNhat = bd.getGiaThue();
            if (bd.getGiaThue() <= giaThueThapNhat)
                giaThueThapNhat = bd.getGiaThue();
        }
        double[] duLieuTraVe = {giaThueCaoNhat, giaThueThapNhat};
        return duLieuTraVe;
    }

    public double[] xemHaiCucDonGia(){
        double donGiaCaoNhat = 0, donGiaThapNhat = dsBangDia.get(0).getDonGia();
        for (BangDia bd : dsBangDia){
            if (bd.getDonGia() >= donGiaCaoNhat)
                donGiaCaoNhat = bd.getDonGia();
            if (bd.getDonGia() < donGiaThapNhat)
                donGiaThapNhat = bd.getDonGia();
        }
        double[] duLieuTraVe = {donGiaCaoNhat, donGiaThapNhat};
        return duLieuTraVe;
    }

    public void sapXepDonGiaTangDan(){
        Collections.sort(dsBangDia, new Comparator<BangDia>() {
            @Override
            public int compare(BangDia o1, BangDia o2) {
                if (o1.getDonGia() > o2.getDonGia())
                    return 1;
                if (o1.getDonGia() == o2.getDonGia())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepDonGiaGiamDan(){
        Collections.sort(dsBangDia, new Comparator<BangDia>() {
            @Override
            public int compare(BangDia o1, BangDia o2) {
                if (o1.getDonGia() < o2.getDonGia())
                    return 1;
                if (o1.getDonGia() == o2.getDonGia())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiaThueTangDan(){
        Collections.sort(dsBangDia, new Comparator<BangDia>() {
            @Override
            public int compare(BangDia o1, BangDia o2) {
                if (o1.getGiaThue() > o2.getGiaThue())
                    return 1;
                if (o1.getDonGia() == o2.getDonGia())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiaThueGiamDan(){
        Collections.sort(dsBangDia, new Comparator<BangDia>() {
            @Override
            public int compare(BangDia o1, BangDia o2) {
                if (o1.getGiaThue() < o2.getGiaThue())
                    return 1;
                if (o1.getDonGia() == o2.getDonGia())
                    return 0;
                return -1;
            }
        });
    }
}
