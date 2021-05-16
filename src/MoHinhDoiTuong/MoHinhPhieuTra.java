package MoHinhDoiTuong;

import DoiTuong.Phieu;
import DoiTuong.PhieuTra;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MoHinhPhieuTra extends AbstractTableModel {
    private static final int maPhieu = 0;
    private static final int maThe = 1;
    private static final int maNV = 2;
    private static final int ngayLap = 3;
    private static final int maBD = 4;
    private static final int soLuong = 5;
    private static final int maPhieuThue = 6;
    private static final int tinhTrangDia = 7;
    private static final int soTienPhat = 8;
    private ArrayList<PhieuTra> dsPhieuTra;
    private String[] tieuDe = "Mã phiếu trả;Mã thẻ;Mã NV Lập;Ngày lập;Mã đĩa thuê;Số lượng;Mã phiếu thuê;Tình Trạng đĩa;Số tiền phạt".split(";");

    public MoHinhPhieuTra(ArrayList<PhieuTra> dsPhieuTra){
        this.dsPhieuTra = dsPhieuTra;
    }

    @Override
    public int getRowCount() {
        return dsPhieuTra.size();
    }

    @Override
    public int getColumnCount() {
        return tieuDe.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PhieuTra p = dsPhieuTra.get(rowIndex);
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
            case maPhieuThue:
                return p.getMaPhieuThue();
            case tinhTrangDia:
                return (p.getTinhTrangDia() == 1) ? "Hoàn hảo" : "Đã hỏng";
            case soTienPhat:
                return nf.format(p.getSoTienPhat());
            default:
                return p;
        }
    }

    @Override
    public String getColumnName(int column) {
        return tieuDe[column];
    }
}
