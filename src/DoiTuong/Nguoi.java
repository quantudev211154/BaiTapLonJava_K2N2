package DoiTuong;

import java.util.Objects;

public abstract class Nguoi {
    private int ID = 0;
    private String Ten = "";
    /**
     * GioiTinh = True => Nam (Male)
     * GioiTinh = False => Nu (Female)
     */
    private int gioiTinh = 1;
    private String soDT = "";

    public Nguoi(int ID) {
        this.ID = ID;
    }

    public Nguoi(int ID, String ten, int gioiTinh, String soDT) {
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

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    //

    /**
     * - gioiTinh = true => return "Nam"
     * - gioiTinh = false => return "Nữ"
     * @return
     */
    @Override
    public String toString() {
        if (gioiTinh == 1)
            return ID + ";" + Ten + ";" + "Nam" + ";" + soDT;
        return ID + ";" + Ten + ";" + "Nữ" + ";" + soDT;
    }
}
