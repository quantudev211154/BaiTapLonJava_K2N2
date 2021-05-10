package DoiTuong;

import java.time.LocalDate;
import java.util.ArrayList;

public class PhieuTra extends Phieu {
    private ArrayList<Boolean> dsTinhTrangDia = new ArrayList<Boolean>();
    private ArrayList<Double> dsTienPhat = new ArrayList<Double>();
    private double tongTienPhat = 0;

    public PhieuTra(int maPhieu) {
        super(maPhieu);
    }

    public PhieuTra(int maPhieu, int maThe, int maNV, ArrayList<BangDia> dsBangDia, LocalDate ngayLap, ArrayList<Boolean> dsTinhTrangDia) {
        super(maPhieu, maThe, maNV, dsBangDia, ngayLap);
        this.dsTinhTrangDia = dsTinhTrangDia;
        setDsTienPhat();
        setTongTienPhat();
    }

    public ArrayList<Boolean> getDsTinhTrangDia() {
        return dsTinhTrangDia;
    }

    public void setDsTinhTrangDia(ArrayList<Boolean> dsTinhTrangDia) {
        this.dsTinhTrangDia = dsTinhTrangDia;
    }

    public ArrayList<Double> getDsTienPhat() {
        return dsTienPhat;
    }

    public void setDsTienPhat() {
        for (Boolean sta : dsTinhTrangDia){
            if (sta == false)
                this.dsTienPhat.add(0.0);
            else{
                int loc = dsTienPhat.indexOf(sta);
                double tienPhat = getDsBangDia().get(loc).getDonGia();
                this.dsTienPhat.add(tienPhat);
            }
        }
    }

    public double getTongTienPhat() {
        return tongTienPhat;
    }

    public void setTongTienPhat() {
        for (Double d : dsTienPhat)
            this.tongTienPhat += d;
    }

}
