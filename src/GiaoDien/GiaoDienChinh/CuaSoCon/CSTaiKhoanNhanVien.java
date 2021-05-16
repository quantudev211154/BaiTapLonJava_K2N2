package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.TaiKhoan;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CSTaiKhoanNhanVien extends JFrame implements ActionListener {
    public JLabel lbMatKhau, lbNhapLaiMK;
    public static JPasswordField pfMatKhau, pfNhapLaiMatKhau;
    public static JButton btnThemTaiKhoan, btnCapNhatTK;
    private Dimension kichThuocLabel = new Dimension(400, 35);
    private Dimension kichThuocPassField = new Dimension(400, 45);
    private Dimension kichThuocButton = new Dimension(200, 50);
    private Font labelFont = new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 18);
    private Color mauNenButton = new Color(10, 246, 134);

    public CSTaiKhoanNhanVien(){
        setTitle("Thiết lập tài khoản");
        setSize(500, 400);
        dungGiaoDien();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void dungGiaoDien(){
        JPanel khungChua = new JPanel();
        khungChua.setLayout(new BoxLayout(khungChua, BoxLayout.Y_AXIS));
//        Panel Mat Khau
        JPanel pMatKhau = new JPanel();
        pMatKhau.add(lbMatKhau = new JLabel("Tạo mật khẩu"));
        lbMatKhau.setPreferredSize(kichThuocLabel);
        lbMatKhau.setFont(labelFont);
        pMatKhau.add(pfMatKhau = new JPasswordField());
        pfMatKhau.setPreferredSize(kichThuocPassField);

//        Panel Nhap Lai Mat Khau
        JPanel pNhapLai = new JPanel();
        pNhapLai.add(lbNhapLaiMK = new JLabel("Nhập lại mật khẩu"));
        lbNhapLaiMK.setPreferredSize(kichThuocLabel);
        lbNhapLaiMK.setFont(labelFont);
        pNhapLai.add(pfNhapLaiMatKhau = new JPasswordField());
        pfNhapLaiMatKhau.setPreferredSize(kichThuocPassField);

//        Panel chua Button
        JPanel pCacNut = new JPanel();
        pCacNut.add(btnThemTaiKhoan = new JButton("Tạo tài khoản"));
        btnThemTaiKhoan.setPreferredSize(kichThuocButton);
        btnThemTaiKhoan.setFont(labelFont);
        pCacNut.add(btnCapNhatTK = new JButton("Cập nhật tài khoản"));
        btnCapNhatTK.setPreferredSize(kichThuocButton);
        btnCapNhatTK.setFont(labelFont);
        btnCapNhatTK.setBackground(mauNenButton);
        btnCapNhatTK.addActionListener(this);
        btnThemTaiKhoan.addActionListener(this);
//
        khungChua.add(Box.createVerticalStrut(20));
        khungChua.add(pMatKhau);
        khungChua.add(pNhapLai);
        khungChua.add(Box.createVerticalStrut(20));
        khungChua.add(pCacNut);
        add(khungChua);
    }

    public static void main(String[] args) {
        new CSTaiKhoanNhanVien();
    }

    public static void datTinhTrangCacNut(boolean tinhTrang){
        if (tinhTrang){
            btnCapNhatTK.setEnabled(false);
        }
        else {
            btnThemTaiKhoan.setEnabled(false);
            btnCapNhatTK.setEnabled(true);
        }
    }

    public static void hienThiDuLieuLenPF(TaiKhoan tk){
        pfMatKhau.setText(tk.getMatKhau());
        pfNhapLaiMatKhau.setText(tk.getMatKhau());
    }

    public TaiKhoan layDuLieuTuPF(){
        if (!pfMatKhau.getText().trim().equals("")
            && !pfNhapLaiMatKhau.getText().trim().equals("")){
            String matKhau = pfMatKhau.getText().trim();
            String matKhauNL = pfNhapLaiMatKhau.getText().trim();
            if (matKhau.equals(matKhauNL)){
                TaiKhoan tk = new TaiKhoan(1, matKhau, 2);
                return tk;
            }
            else{
                JOptionPane.showMessageDialog(this, "Hai mật khẩu không khớp nhau");
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Chưa nhập đầy đủ thông tin cần thiết");
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThemTaiKhoan)){
            TaiKhoan tk = layDuLieuTuPF();
            if (tk != null){
                GiaoDienLon.themTaiKhoan(tk);
                dispose();
            }
        }
        if (o.equals(btnCapNhatTK)){
            TaiKhoan tk = layDuLieuTuPF();
            if (tk != null){
                GiaoDienLon.capNhatMatKhau(tk);
                dispose();
            }
        }
    }
}
