package DoiTuong;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PhieuThue extends Phieu {
    private LocalDate ngayHetHan = LocalDate.now();
    private ArrayList<Double> dsGiaThue = new ArrayList<Double>();
    private double tongTienThue = 0;

    public PhieuThue(int maPhieu, int maThe, int maNV, ArrayList<BangDia> dsBangDia, LocalDate ngayLap, LocalDate ngayHetHan) {
        super(maPhieu, maThe, maNV, dsBangDia, ngayLap);
        this.ngayHetHan = ngayHetHan;
        setGiaThue();
        setTongTienThue();
    }

    public PhieuThue(int maPhieu) {
        super(maPhieu);
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public ArrayList<Double> getGiaThue() {
        return dsGiaThue;
    }

    public void setGiaThue() {
        long soNgayThue = ChronoUnit.DAYS.between(ngayHetHan, getNgayLap());
        for (BangDia b : getDsBangDia()){
            this.dsGiaThue.add(b.getGiaThue() * soNgayThue);
        }
    }

    public double getTongTienThue() {
        return tongTienThue;
    }

    public void setTongTienThue() {
        for (Double d : dsGiaThue){
            tongTienThue += d;
        }
    }
}
