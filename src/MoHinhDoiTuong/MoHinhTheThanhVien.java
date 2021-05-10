package MoHinhDoiTuong;


import DoiTuong.TheThanhVien;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhTheThanhVien extends AbstractTableModel {
    private final int maThe = 0;
    private final int maKH = 1;
    private final int ngayLap = 2;
    private final int ngayHetHan = 3;
    private final ArrayList<TheThanhVien> dsThe;
    private String[] header = "Mã thẻ;Mã KH sỡ hữu;Ngày Lập;Ngày hết hạn".split(";");

    public MoHinhTheThanhVien(ArrayList<TheThanhVien> dsThe){
        this.dsThe = dsThe;
    }

    @Override
    public int getRowCount() {
        return dsThe.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TheThanhVien t = dsThe.get(rowIndex);
        switch (columnIndex){
            case maThe:
                return t.getMaThe();
            case maKH:
                return t.getMaKH();
            case ngayLap:
                return t.getNgayLap();
            case ngayHetHan:
                return t.getNgayHetHan();
            default:
                return t;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
