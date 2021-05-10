package MoHinhDoiTuong;


import DoiTuong.NhanVien;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhNhanVien extends AbstractTableModel {
    private final int ID = 0;
    private final int tenNV = 1;
    private final int gioiTinh = 2;
    private final int soDT = 3;
    private final int moTa = 4;
    private final ArrayList<NhanVien> dsNV;
    private String[] header = "Mã Nhân Viên;Tên Nhân Viên;Giới tính;Số điện thoại;Mô tả".split(";");

    public MoHinhNhanVien(ArrayList<NhanVien> dsNV){
        this.dsNV = dsNV;
    }

    @Override
    public int getRowCount() {
        return dsNV.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NhanVien n = dsNV.get(rowIndex);
        switch (columnIndex){
            case ID:
                return n.getID();
            case tenNV:
                return n.getTen();
            case gioiTinh:
                return n.isGioiTinh();
            case moTa:
                return n.getMoTa();
            default:
                return n;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
