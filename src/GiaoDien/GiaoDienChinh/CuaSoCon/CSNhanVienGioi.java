package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.BangDia;
import DoiTuong.NhanVien;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import MoHinhDoiTuong.MoHinhBangDia;
import MoHinhDoiTuong.MoHinhNhanVien;
import QuanLyDoiTuong.QuanLyBangDia;
import QuanLyDoiTuong.QuanLyNhanVien;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CSNhanVienGioi extends JFrame {
    public JLabel lbTitle = new JLabel("Top 2 nhân viên đạt doanh số cao");
    public JTable table;
    public MoHinhNhanVien mhNhanVien;
    public KetNoiToiCoSoDuLieu kn;

    public CSNhanVienGioi() {
        setTitle("Top 2 nhân viên có doanh số cao");
        setSize(600, 300);
        dungGiaoDien();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void dungGiaoDien() {
        JPanel p = new JPanel(new FlowLayout(1, 20, 20));
        p.add(lbTitle);
        lbTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        try {
            kn = new KetNoiToiCoSoDuLieu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ArrayList<String> dsTenNV = kn.xemTop2NhanVienNangSuat();
        ArrayList<NhanVien> dsNhanVien = new ArrayList<>();
        ArrayList<NhanVien> dsAllNV = new QuanLyNhanVien(kn).getDsNhanVien();
        for (String i : dsTenNV)
            for (NhanVien nv : dsAllNV)
                if (nv.getTen().equals(i)) {
                    dsNhanVien.add(nv);
                    break;
                }
        mhNhanVien = new MoHinhNhanVien(dsNhanVien);
        table = new JTable();
        table.setModel(mhNhanVien);
        table.setRowHeight(30);
        JScrollPane scrPane = new JScrollPane(table);
        scrPane.setPreferredSize(new Dimension(580, 280));
        p.add(scrPane);
        add(p);
        kn.ngatKetNoiToiCSDL();
    }
}