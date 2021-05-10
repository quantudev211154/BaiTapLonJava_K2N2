package MoHinhDoiTuong;


import DoiTuong.PhieuThue;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhPhieuThue extends AbstractTableModel {
    private final int maPhieu = 0;
    private final int maThe = 1;
    private final int dsBangDia = 2;
    private final int ngayLap = 3;
    private final int ngayHetHan = 4;
    private final int tongTienThue = 5;
    private final ArrayList<PhieuThue> dsPhieuThue;
    private String[] header = "Mã phiếu thuê;Mã thẻ khách thuê;DS Đĩa mượn;Ngày Thuê;Ngày Trả;Tổng tiền thuê".split(";");

    public MoHinhPhieuThue(ArrayList<PhieuThue> dsPhieuThue){
        this.dsPhieuThue = dsPhieuThue;
    }

    @Override
    public int getRowCount() {
        return dsPhieuThue.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PhieuThue p = dsPhieuThue.get(rowIndex);
        switch (columnIndex){
            case maPhieu:
                return p.getMaPhieu();
            case maThe:
                return p.getMaThe();
            case dsBangDia:
                return p.getDsBangDia();
            case ngayLap:
                return p.getNgayLap();
            case ngayHetHan:
                return p.getNgayHetHan();
            case tongTienThue:
                return p.getTongTienThue();
            default:
                return p;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
