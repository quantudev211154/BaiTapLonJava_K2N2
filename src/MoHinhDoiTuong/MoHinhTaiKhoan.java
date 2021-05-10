package MoHinhDoiTuong;

import DoiTuong.TaiKhoan;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhTaiKhoan extends AbstractTableModel {
    private final int tenDN = 0;
    private final int matKhau = 1;
    private final int loaiTK = 2;
    private final ArrayList<TaiKhoan> dsTaiKhoan;
    private String[] header = "Tên đăng nhập;Mật khẩu;Loại tài khoản".split(";");

    public MoHinhTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan){
        this.dsTaiKhoan = dsTaiKhoan;
    }

    @Override
    public int getRowCount() {
        return dsTaiKhoan.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TaiKhoan t = dsTaiKhoan.get(rowIndex);
        switch (columnIndex){
            case tenDN:
                return t.getMaNV();
            case matKhau:
                return t.getMatKhau();
            case loaiTK:
                return t.isLoaiTK();
            default:
                return t;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
