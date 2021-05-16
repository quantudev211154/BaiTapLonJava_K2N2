package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.DoanhThu;
import GiaoDien.GiaoDienChinh.GiaoDienLon;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import QuanLyDoiTuong.QuanLyDoanhThu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class CSXemDoanhThuTheoThang extends JFrame implements ActionListener {
    public JLabel lbYeuCau, lbThang, lbNam;
    public JComboBox<Integer> cbThang, cbNam;
    public JButton btnXemDoanhThu;

    public CSXemDoanhThuTheoThang(){
        setTitle("Xem doanh thu theo tháng");
        setSize(400, 360);
        dungGiaoDien();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void dungGiaoDien() {
        JPanel khungChua = new JPanel();
        JPanel khungNho = new JPanel();
        khungNho.setLayout(new BoxLayout(khungNho, BoxLayout.Y_AXIS));
        khungNho.add(Box.createVerticalStrut(15));
        khungNho.add(lbYeuCau = new JLabel("Hãy nhập thời gian cần xem doanh thu"));
        lbYeuCau.setPreferredSize(new Dimension(350, 30));
        lbYeuCau.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 17));
        khungNho.add(Box.createVerticalStrut(15));
        khungNho.add(lbThang = new JLabel("Tháng:     "));
        lbThang.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        khungNho.add(Box.createVerticalStrut(10));
        khungNho.add(cbThang = new JComboBox<>());
        cbThang.setPreferredSize(new Dimension(10, 40));
        for (int i = 0; i < 12; i++)
            cbThang.addItem(i+1);
        khungNho.add(Box.createVerticalStrut(15));
        khungNho.add(lbNam = new JLabel("Năm:    "));
        lbNam.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        khungNho.add(Box.createVerticalStrut(10));
        khungNho.add(cbNam = new JComboBox<>());
        cbNam.setPreferredSize(new Dimension(10, 40));
        docDanhSachNam(cbNam);
        khungNho.add(Box.createVerticalStrut(20));
        khungChua.add(khungNho);
        khungChua.add(btnXemDoanhThu = new JButton("Xem doanh thu"));
        btnXemDoanhThu.setPreferredSize(new Dimension(300, 45));
        btnXemDoanhThu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        btnXemDoanhThu.addActionListener(this);
        add(khungChua);
    }

    public void docDanhSachNam(JComboBox<Integer> cbNam) {
        KetNoiToiCoSoDuLieu kn = null;
        try{
            kn = new KetNoiToiCoSoDuLieu();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        ArrayList<DoanhThu> dsDoanhThu = new QuanLyDoanhThu(kn).getDsDoanhThu();
        ArrayList<Integer> dsNam = new ArrayList<>();
        for (DoanhThu d : dsDoanhThu){
            cal.setTime(d.getThoiGian());
            if (!dsNam.contains(cal.get(Calendar.YEAR))){
                dsNam.add(cal.get(Calendar.YEAR));
                cbNam.addItem(cal.get(Calendar.YEAR));
            }
        }
        kn.ngatKetNoiToiCSDL();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXemDoanhThu)){
            int thang = (Integer) cbThang.getSelectedItem();
            int nam = (Integer) cbNam.getSelectedItem();
            GiaoDienLon.xemDoanhThuTheoThang(thang, nam);
        }
    }
}
