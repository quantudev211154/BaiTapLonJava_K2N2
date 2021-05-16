package MoHinhDoiTuong;


import DoiTuong.TheThanhVien;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MoHinhTheThanhVien extends AbstractTableModel {
    private final int maThe = 0;
    private final int maKH = 1;
    private final int ngayLap = 2;
    private final int ngayHetHan = 3;
    private final ArrayList<TheThanhVien> dsThe;
    private String[] header = "Mã thẻ;Mã KH sở hữu;Ngày Lập;Ngày hết hạn".split(";");

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
        DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
        switch (columnIndex){
            case maThe:
                return t.getMaThe();
            case maKH:
                return t.getMaKH();
            case ngayLap:
                return df.format(t.getNgayLap());
            case ngayHetHan:
                return df.format(t.getNgayHetHan());
            default:
                return t;
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
}
