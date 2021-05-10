package DoiTuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class TheThanhVien {
    private int maThe = 0;
    private int maKH = 0;
    private LocalDate ngayLap = LocalDate.now();
    private LocalDate ngayHetHan = LocalDate.of(ngayLap.getYear() + 3, ngayLap.getMonth(), ngayLap.getDayOfMonth());

    public TheThanhVien(int maThe, int maKH, LocalDate ngayLap, LocalDate ngayHetHan) {
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

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

//    Equals and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TheThanhVien)) return false;
        TheThanhVien that = (TheThanhVien) o;
        return Objects.equals(getMaThe(), that.getMaThe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaThe());
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return maThe + ";" + dtf.format(ngayLap) + ";" + dtf.format(ngayHetHan);
    }
}
