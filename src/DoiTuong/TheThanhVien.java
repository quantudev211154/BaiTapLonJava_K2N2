package DoiTuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class TheThanhVien {
    private int maThe = 0;
    private int maKH = 0;
    private Date ngayLap = new Date();
    private Date ngayHetHan = new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000 * 1096L));

    public TheThanhVien(int maThe, int maKH, Date ngayLap, Date ngayHetHan) {
        this.maThe = maThe;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        this.ngayHetHan = ngayHetHan;
    }

    public TheThanhVien(int maThe) {
        this.maThe = maThe;
    }

//    Getter and Setter

    public int getMaThe() {
        return maThe;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

//    Equals and Hashcode


    @Override
    public String toString() {
        return "TheThanhVien{" +
                "maThe=" + maThe +
                ", maKH=" + maKH +
                ", ngayLap=" + ngayLap +
                ", ngayHetHan=" + ngayHetHan +
                '}';
    }
}
