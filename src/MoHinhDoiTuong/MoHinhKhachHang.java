package MoHinhDoiTuong;


import DoiTuong.KhachHang;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhKhachHang extends AbstractTableModel {
    private final int ID = 0;
    private final int tenNV = 1;
    private final int gioiTinh = 2;
    private final int soDT = 3;
    private final int maNV = 4;
    private final int diaChi = 5;
    private final int soCMND = 6;
    private final ArrayList<KhachHang> dsKhachHang;
    private String[] header = "Mã khách hàng;Tên khách hàng;Giới tính;Số điện thoại;Mã NV đã thêm;Địa chỉ;Số CMND".split(";");

    public MoHinhKhachHang(ArrayList<KhachHang> dsKhachHang){
        this.dsKhachHang = dsKhachHang;
    }

    @Override
    public int getRowCount() {
        return dsKhachHang.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KhachHang k = dsKhachHang.get(rowIndex);
        switch (columnIndex){
            case ID:
                return k.getID();
            case tenNV:
                return k.getTen();
            case gioiTinh:
                return (k.getGioiTinh() == 1) ? "Nam" : "Nữ";
            case soDT:
                return k.getSoDT();
            case maNV:
                return k.getMaNV();
            case diaChi:
                return k.getDiaChi();
            case soCMND:
                return k.getSoCMND();
            default:
                return k;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
