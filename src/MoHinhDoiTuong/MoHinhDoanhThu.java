package MoHinhDoiTuong;


import DoiTuong.DoanhThu;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

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
        switch (columnIndex){
            case maTK:
                return d.getMaTK();
            case maPhieu:
                return d.getMaPhieu();
            case loaiPhieu:
                return d.isLoaiPhieu();
            case soTien:
                return d.getSoTien();
            case thoiGian:
                return d.getThoiGian();
            default:
                return d;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
