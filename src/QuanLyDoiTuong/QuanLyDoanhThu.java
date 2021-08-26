package QuanLyDoiTuong;

import DoiTuong.DoanhThu;
import DoiTuong.Phieu;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class QuanLyDoanhThu {
    private ArrayList<DoanhThu> dsDoanhThu;

    public QuanLyDoanhThu(KetNoiToiCoSoDuLieu kn){
        this.dsDoanhThu = new ArrayList<>(kn.docDuLieuDoanhThu());
    }

    public ArrayList<DoanhThu> getDsDoanhThu() {
        return dsDoanhThu;
    }

    public ArrayList<DoanhThu> timDoanhThu(Date ngayLap){
        ArrayList<DoanhThu> ds = new ArrayList<>();
        for (DoanhThu d : dsDoanhThu)
            if (d.getThoiGian().equals(ngayLap))
                ds.add(d);
        return ds;
    }

    public int doLonDuLieu(){
        return dsDoanhThu.size();
    }

    public void sapXepTangDanTheoMaPhieu(){
        Collections.sort(dsDoanhThu, new Comparator<DoanhThu>() {
            @Override
            public int compare(DoanhThu o1, DoanhThu o2) {
                if (o1.getMaPhieu() > o2.getMaPhieu())
                    return 1;
                if (o1.getMaPhieu() == o2.getMaPhieu())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoMaPhieu(){
        Collections.sort(dsDoanhThu, new Comparator<DoanhThu>() {
            @Override
            public int compare(DoanhThu o1, DoanhThu o2) {
                if (o1.getMaPhieu() < o2.getMaPhieu())
                    return 1;
                if (o1.getMaPhieu() == o2.getMaPhieu())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepTangDanTheoSoTien(){
        Collections.sort(dsDoanhThu, new Comparator<DoanhThu>() {
            @Override
            public int compare(DoanhThu o1, DoanhThu o2) {
                if (o1.getSoTien() > o2.getSoTien())
                    return 1;
                if (o1.getSoTien() == o2.getSoTien())
                    return 0;
                return -1;
            }
        });
    }

    public void sapXepGiamDanTheoSoTien(){
        Collections.sort(dsDoanhThu, new Comparator<DoanhThu>() {
            @Override
            public int compare(DoanhThu o1, DoanhThu o2) {
                if (o1.getSoTien() < o2.getSoTien())
                    return 1;
                if (o1.getSoTien() == o2.getSoTien())
                    return 0;
                return -1;
            }
        });
    }

    public int[] soPhieuThueHoacTra(){
        int soPThue = 0, soPTra = 0;
        for (DoanhThu d : dsDoanhThu)
            if (d.getLoaiPhieu() == 1)
                soPThue++;
            else
                soPTra++;
        int[] gtriTraVe = {soPThue, soPTra};
        return gtriTraVe;
    }

    public double[] coCauDoanhThu(){
        double dtTuPThue = 0, dtTuPTra = 0;
        for (DoanhThu d : dsDoanhThu)
            if (d.getLoaiPhieu() == 1)
                dtTuPThue += d.getSoTien();
            else
                dtTuPTra += d.getSoTien();
        double[] gtriTraVe = {dtTuPThue, dtTuPTra};
        return gtriTraVe;
    }
}
