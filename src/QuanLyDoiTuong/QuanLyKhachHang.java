package QuanLyDoiTuong;

import DoiTuong.KhachHang;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

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

    public int timKhachHang(int maKH){
        for (KhachHang kh : dsKhachHang){
            if (kh.getID() == maKH)
                return dsKhachHang.indexOf(kh);
        }
        return -1;
    }
}
