package MoHinhDoiTuong;


import DoiTuong.BangDia;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MoHinhBangDia extends AbstractTableModel {
    private final int maBD = 0;
    private final int tenBD = 1;
    private final int theLoai = 2;
    private final int tinhTrang = 3;
    private final int hangSX = 4;
    private final int ghiChu = 5;
    private final int soLuongGoc = 6;
    private final int soLuongTon = 7;
    private final int donGia = 8;
    private final int giaThue = 9;
    private final ArrayList<BangDia> dsBangDia;
    private String[] header = "Mã đĩa;Tên đĩa;Thể loại;Tình trạng;Hãng sản xuất;Ghi chú;Số lượng gốc;Số lượng tồn;Đơn giá;Giá cho thuê".split(";");

    public MoHinhBangDia(ArrayList<BangDia> dsBangDia){
        this.dsBangDia = dsBangDia;
    }


    @Override
    public int getRowCount() {
        return dsBangDia.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BangDia b = dsBangDia.get(rowIndex);
        switch (columnIndex){
            case maBD:
                return b.getMaBD();
            case tenBD:
                return b.getTenBD();
            case theLoai:
                return b.getTheLoai();
            case tinhTrang:
                return b.isTinhTrang();
            case hangSX:
                return b.getHangSX();
            case ghiChu:
                return b.getGhiChu();
            case soLuongGoc:
                return b.getSoLuongGoc();
            case soLuongTon:
                return b.getSoLuongTon();
            case donGia:
                return b.getDonGia();
            case giaThue:
                return b.getGiaThue();
            default:
                return b;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
