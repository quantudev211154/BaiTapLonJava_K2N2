package MoHinhDoiTuong;


import DoiTuong.DoanhThu;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MoHinhDoanhThu extends AbstractTableModel {
    private final int maTK = 0;
    private final int maPhieu = 1;
    private final int loaiPhieu = 2;
    private final int soTien = 3;
    private final int thoiGian = 4;
    private final ArrayList<DoanhThu> dsDoanhThu;
    private String[] header = "Mã thống kê;Mã phiếu;Loại phiếu;Số tiền;Thời gian lập".split(";");

    public MoHinhDoanhThu(ArrayList<DoanhThu> dsDoanhThu){
        this.dsDoanhThu = dsDoanhThu;
    }

    @Override
    public int getRowCount() {
        return dsDoanhThu.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DoanhThu d = dsDoanhThu.get(rowIndex);
        Locale vn = new Locale("vi", "vn");
        NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
        DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
        switch (columnIndex){
            case maTK:
                return d.getMaTK();
            case maPhieu:
                return d.getMaPhieu();
            case loaiPhieu:
                return (d.getLoaiPhieu() == 1) ? "Phiếu thuê" : "Phiếu trả";
            case soTien:
                return nf.format(d.getSoTien());
            case thoiGian:
                return df.format(d.getThoiGian());
            default:
                return d;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
