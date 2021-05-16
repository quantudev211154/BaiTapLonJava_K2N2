package MoHinhDoiTuong;

import DoiTuong.PhieuThue;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MoHinhPhieuThue extends AbstractTableModel {
    private static final int maPhieu = 0;
    private static final int maThe = 1;
    private static final int maNV = 2;
    private static final int ngayLap = 3;
    private static final int maBD = 4;
    private static final int soLuong = 5;
    private static final int ngayHetHan = 6;
    private static final int thanhTien = 7;
    private ArrayList<PhieuThue> dsPhieuThue;
    private String[] tieuDe = "Mã phiếu thuê;Mã thẻ;Mã NV Lập;Ngày lập;Mã đĩa thuê;Số lượng;Ngày hết hạn thuê; Thành tiền".split(";");

    public MoHinhPhieuThue(ArrayList<PhieuThue> dsPhieuThue){
        this.dsPhieuThue = dsPhieuThue;
    }

    @Override
    public int getRowCount() {
        return dsPhieuThue.size();
    }

    @Override
    public int getColumnCount() {
        return tieuDe.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PhieuThue p = dsPhieuThue.get(rowIndex);
        Locale vn = new Locale("vi", "vn");
        NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
        DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
        switch (columnIndex){
            case maPhieu:
                return p.getMaPhieu();
            case maThe:
                return p.getMaThe();
            case maNV:
                return p.getMaNV();
            case ngayLap:
                return df.format(p.getNgayLap());
            case maBD:
                return p.getMaBD();
            case soLuong:
                return p.getSoLuong();
            case ngayHetHan:
                return df.format(p.getNgayHetHan());
            case thanhTien:
                return nf.format(p.getTongTienThue());
            default:
                return p;
        }
    }

    @Override
    public String getColumnName(int column) {
        return tieuDe[column];
    }
}
