package QuanLyDoiTuong;

import DoiTuong.BangDia;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyBangDia {
    public ArrayList<BangDia> dsBangDia;
    public KetNoiToiCoSoDuLieu kn;

    public QuanLyBangDia() {
        try{
            this.dsBangDia = new ArrayList<BangDia>();
            this.kn = new KetNoiToiCoSoDuLieu();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<BangDia> getDsBangDia() {
        return dsBangDia;
    }

    public void napDuLieu(){
        try{
            this.dsBangDia = kn.docDuLieuBangDia();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public boolean themBangDia(BangDia bd){
        return kn.themBangDia(bd);
    }

    public boolean xoaBangDia(int maBD){
        return kn.xoaBangDia(maBD);
    }

    public boolean capNhatDia(int maBD, String tenBD_M, String theLoai_M, String hangSX_M,
                              String ghiChu_M, int slGoc_M, double donGia_M, double giaThue_M){
        return kn.capNhatDia(maBD, tenBD_M, theLoai_M, hangSX_M, ghiChu_M, slGoc_M, donGia_M, giaThue_M);
    }

    public int timDia(int maBD){
        for (BangDia bd : dsBangDia){
            if (bd.getMaBD() == maBD){
                return dsBangDia.indexOf(bd);
            }
        }
        return -1;
    }

}
