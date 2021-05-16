package DoiTuong;

public class NhanVien extends Nguoi {
    private String moTa = "";

    public NhanVien(int ID) {
        super(ID);
    }

    public NhanVien(int ID, String ten, int gioiTinh, String soDT, String moTa) {
        super(ID, ten, gioiTinh, soDT);
        this.moTa = moTa;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + moTa;
    }
}
