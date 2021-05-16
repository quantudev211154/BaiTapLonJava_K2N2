package QuanLyDoiTuong;

import DoiTuong.DoanhThu;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.util.ArrayList;

public class QuanLyDoanhThu {
    private ArrayList<DoanhThu> dsDoanhThu;

    public QuanLyDoanhThu(KetNoiToiCoSoDuLieu kn){
        this.dsDoanhThu = new ArrayList<>(kn.docDuLieuDoanhThu());
    }

    public ArrayList<DoanhThu> getDsDoanhThu() {
        return dsDoanhThu;
    }

    public int timDoanhThu(int maTK){
        for (DoanhThu d : dsDoanhThu)
            if (d.getMaTK() == maTK)
                return dsDoanhThu.indexOf(d);
        return -1;
    }
}
