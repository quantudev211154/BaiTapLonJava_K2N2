package DoiTuong;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class PhieuThue extends Phieu {
    private Date ngayHetHan = new Date();
    private double tongTienThue = 0;

    public PhieuThue(int maPhieu, int maThe, int maNV, int maBD, int soLuong, Date ngayLap, Date ngayHetHan, double tongTienThue) {
        super(maPhieu, maThe, maNV, maBD, soLuong, ngayLap);
        this.ngayHetHan = ngayHetHan;
        this.tongTienThue = tongTienThue;
    }

    public PhieuThue(int maPhieu) {
        super(maPhieu);
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public double getTongTienThue() {
        return tongTienThue;
    }

    public void setTongTienThue(double tongTienThue) {
        this.tongTienThue = tongTienThue;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ngayHetHan + ";" + tongTienThue;
    }
}
