package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.BangDia;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import MoHinhDoiTuong.MoHinhBangDia;
import QuanLyDoiTuong.QuanLyBangDia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CSDiaDeThue extends JFrame {
    public JLabel lbTitle = new JLabel("Top 10 đĩa có giá thuê dễ chịu");
    public JTable table;
    public MoHinhBangDia mhBangDia;
    public KetNoiToiCoSoDuLieu kn;

    public CSDiaDeThue() {
        setTitle("Top 10 đĩa có giá dễ thuê chịu");
        setSize(1200, 500);
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
        try{
            kn = new KetNoiToiCoSoDuLieu();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        ArrayList<String> dsTenDia = kn.xemTop10DiaCoGiaThueRe();
        ArrayList<BangDia> dsBangDia = new ArrayList<>();
        ArrayList<BangDia> dsAllBD = new QuanLyBangDia(kn).getDsBangDia();
        for (String i : dsTenDia)
            for (BangDia bd : dsAllBD)
                if (bd.getTenBD().equals(i)){
                    dsBangDia.add(bd);
                    break;
                }
        mhBangDia = new MoHinhBangDia(dsBangDia);
        table = new JTable();
        table.setModel(mhBangDia);
        table.setRowHeight(30);
        JScrollPane scrPane = new JScrollPane(table);
        scrPane.setPreferredSize(new Dimension(1170, 480));
        p.add(scrPane);
        add(p);
        kn.ngatKetNoiToiCSDL();
    }

}

