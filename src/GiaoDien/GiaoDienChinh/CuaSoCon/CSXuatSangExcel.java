package GiaoDien.GiaoDienChinh.CuaSoCon;

import GiaoDien.GiaoDienChinh.GiaoDienLon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CSXuatSangExcel extends JFrame implements ActionListener {
    public JLabel lbTieuDe;
    public JComboBox<String> cbLuaChonXuatDL;
    public JButton btnXacNhanXuat;
    public Color tieuDeColor = new Color(22, 135, 219);
    public Dimension cbSize = new Dimension(400, 40);
    String[] duLieuCB = {"Xuất tất cả dữ liệu hiện có","Xuất dữ liệu băng đĩa",
                        "Xuất dữ liệu phiếu thuê", "Xuất dữ liệu phiếu trả",
                        "Xuất dữ liệu phiếu chưa trả", "Xuất dữ liệu khách hàng",
                        "Xuất dữ liệu thẻ thành viên", "Xuất dữ liệu nhân viên",
                        "Xuất dữ liệu doanh thu"};

    public CSXuatSangExcel(){
        setTitle("Xuất dữ liệu ra File Excel");
        setSize(500, 400);
        dungGiaoDien();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void dungGiaoDien(){
        JPanel khung = new JPanel(new FlowLayout(1, 20, 50));
        JPanel tieuDe = new JPanel();
        tieuDe.add(lbTieuDe = new JLabel("Xuất dữ liệu sang File  Excel"));
        lbTieuDe.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        lbTieuDe.setForeground(tieuDeColor);
        JPanel p2 = new JPanel();
        p2.add(cbLuaChonXuatDL = new JComboBox<>(duLieuCB));
        cbLuaChonXuatDL.setPreferredSize(cbSize);
        JPanel p3 = new JPanel();
        p3.add(btnXacNhanXuat = new JButton("Xác Nhận"));
        btnXacNhanXuat.setPreferredSize(new Dimension(150, 50));
        btnXacNhanXuat.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        btnXacNhanXuat.setFocusable(false);
        btnXacNhanXuat.addActionListener(this);
        khung.add(tieuDe);
        khung.add(p2);
        khung.add(p3);
        add(khung);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXacNhanXuat)){
            int luaChon = cbLuaChonXuatDL.getSelectedIndex();
            GiaoDienLon.xacNhanInDuLieu(luaChon);
            JOptionPane.showMessageDialog(this, "Đã xuất xong. Thư mục chứa dữ liệu" +
                    "có tên Data ở màn hình Desktop của bạn");
            if (luaChon == 0)
                dispose();
        }
    }
}
