package DoiTuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Phieu {
    private int maPhieu = 0;
    private int maThe = 0;
    private int maNV = 0;
    private ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
    private LocalDate ngayLap = LocalDate.now();

    public Phieu(int maPhieu, int maThe, int maNV, ArrayList<BangDia> dsBangDia, LocalDate ngayLap) {
        this.maPhieu = maPhieu;
        this.maThe = maThe;
        this.maNV = maNV;
        this.dsBangDia = dsBangDia;
        this.ngayLap = ngayLap;
    }

    public Phieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public int getMaPhieu() {
        return maPhieu;
    }

    public int getMaThe() {
        return maThe;
    }

    public void setMaThe(int maThe) {
        this.maThe = maThe;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public ArrayList<BangDia> getDsBangDia() {
        return dsBangDia;
    }

    public void setDsBangDia(ArrayList<BangDia> dsBangDia) {
        this.dsBangDia = dsBangDia;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phieu)) return false;
        Phieu phieu = (Phieu) o;
        return Objects.equals(getMaPhieu(), phieu.getMaPhieu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaPhieu());
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return maPhieu + ";" + maThe + ";" + maNV + ";" + dsBangDia + ";" + dtf.format(ngayLap);
    }
}
