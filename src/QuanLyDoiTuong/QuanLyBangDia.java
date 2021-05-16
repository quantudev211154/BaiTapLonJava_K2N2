package QuanLyDoiTuong;

import DoiTuong.BangDia;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public int timBangDia(int maBD){
        for (BangDia bd : dsBangDia){
            if (bd.getMaBD() == maBD)
                return dsBangDia.indexOf(bd);
        }
        return -1;
    }

    public boolean kiemTraDia(int maDia){
        for (BangDia bd : dsBangDia)
            if (bd.getMaBD() == maDia)
                return true;
        return false;
    }

}
