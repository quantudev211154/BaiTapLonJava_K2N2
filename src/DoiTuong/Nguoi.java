package DoiTuong;

import java.util.Objects;

public abstract class Nguoi {
    private int ID = 0;
    private String Ten = "";
    /**
     * GioiTinh = True => Nam (Male)
     * GioiTinh = False => Nu (Female)
     */
    private boolean gioiTinh = true;
    private String soDT = "";

    public Nguoi(int ID) {
        this.ID = ID;
    }

    public Nguoi(int ID, String ten, boolean gioiTinh, String soDT) {
        this.ID = ID;
        Ten = ten;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
    }

//    Getter and Setter
    public int getID() {
        return ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    //

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nguoi)) return false;
        Nguoi nguoi = (Nguoi) o;
        return getID() == nguoi.getID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }

    /**
     * - gioiTinh = true => return "Nam"
     * - gioiTinh = false => return "Nữ"
     * @return
     */
    @Override
    public String toString() {
        if (gioiTinh == true)
            return ID + ";" + Ten + ";" + "Nam" + ";" + soDT;
        return ID + ";" + Ten + ";" + "Nữ" + ";" + soDT;
    }
}
