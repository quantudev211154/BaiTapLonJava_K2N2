package MoHinhDoiTuong;

import DoiTuong.PhieuTra;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhPhieuTra extends AbstractTableModel {
    private final int maPhieu = 0;
    private final int maThe = 1;
    private final int dsBangDia = 2;
    private final int ngayLap = 3;
    private final int dsTinhTrangDia = 4;
    private final int tongTienPhat = 5;
    private final ArrayList<PhieuTra> dsPhieuTra;
    private String[] header = "Mã phiếu trả;Mã thẻ KH Trả;DS Đĩa trả;Ngày Trả;DS Tình trạng đĩa trả;Tổng tiền phạt".split(";");

    public MoHinhPhieuTra(ArrayList<PhieuTra> dsPhieuTra){
        this.dsPhieuTra = dsPhieuTra;
    }

    @Override
    public int getRowCount() {
        return dsPhieuTra.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PhieuTra p = dsPhieuTra.get(rowIndex);
        switch (columnIndex){
            case maPhieu:
                return p.getMaPhieu();
            case maThe:
                return p.getMaThe();
            case dsBangDia:
                return p.getDsBangDia();
            case ngayLap:
                return p.getNgayLap();
            case dsTinhTrangDia:
                return p.getDsTinhTrangDia();
            case tongTienPhat:
                return p.getTongTienPhat();
            default:
                return p;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
