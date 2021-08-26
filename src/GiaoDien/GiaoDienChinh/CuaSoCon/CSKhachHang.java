package GiaoDien.GiaoDienChinh.CuaSoCon;
import DoiTuong.KhachHang;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;

import javax.swing.*;

public class CSKhachHang extends JFrame implements ActionListener, danhSachRegex{
    public JLabel lbltenkh,lblgioitinh,lblsdtkh,lbldiachi,lblcmnd;
    public static JTextField txttenkh,txtsdtkh,txtdiachi,txtcmnd;
    public static JComboBox combobox;
    public JButton btnthemkh,btncapnhatkh;
    public int chieuRong = 300;

    public CSKhachHang() {
        setSize(335,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        Font ft= new Font("Times New Roman",Font.PLAIN,16);
        lbltenkh = new JLabel("Tên khách hàng: ");
        lbltenkh.setFont(ft);
        lbltenkh.setBounds(10,10,chieuRong,20);
        txttenkh = new JTextField();
        txttenkh.setBounds(10,35,chieuRong,30);
        txttenkh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblgioitinh = new JLabel("Giới tính:");
        lblgioitinh.setBounds(10,70,chieuRong,30);
        lblgioitinh.setFont(ft);
        String [] gioitinh = {"Nam","Nữ"};
        combobox = new JComboBox(gioitinh);
        combobox.setBounds(10, 95, chieuRong, 40);
        lblsdtkh = new JLabel("Số điện thoại:");
        lblsdtkh.setBounds(10,140,chieuRong,30);
        lblsdtkh.setFont(ft);
        txtsdtkh = new JTextField();
        txtsdtkh.setBounds(10,165,chieuRong,30);
        txtsdtkh.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lbldiachi = new JLabel("Địa chỉ:");
        lbldiachi.setBounds(10,200,chieuRong,30);
        lbldiachi.setFont(ft);
        txtdiachi = new JTextField();
        txtdiachi.setBounds(10,230,chieuRong,30);
        txtdiachi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblcmnd = new JLabel("Số CMND:");
        lblcmnd.setBounds(10,270,chieuRong,30);
        lblcmnd.setFont(ft);
        txtcmnd = new JTextField();
        txtcmnd.setBounds(10, 300, chieuRong, 30);
        txtcmnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtcmnd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KhachHang kh = layDuLieuTuTXT();
                    if (kh != null){
                        GiaoDienLon.themKhachHang(kh);
                        dispose();
                    }
                }
            }
        });
        btnthemkh = new JButton("Thêm KH");
        btnthemkh.setBounds(10, 350, 145, 45);
        btncapnhatkh = new JButton("Cập nhật KH");
        btncapnhatkh.setBounds(165, 350, 145, 45);
        add(lbltenkh);
        add(txttenkh);
        add(lblgioitinh);
        add(combobox);
        add(lblsdtkh);
        add(txtsdtkh);
        add(lbldiachi);
        add(txtdiachi);
        add(lblcmnd);
        add(txtcmnd);
        add(btnthemkh);
        add(btncapnhatkh);
        btnthemkh.addActionListener(this);
        btncapnhatkh.addActionListener(this);
        btncapnhatkh.setBackground(new Color(10, 231, 246));
        setVisible(true);

    }

    public void datTinhTrangCacNut(int tinhTrang){
        if (tinhTrang == 1){
            btncapnhatkh.setEnabled(false);
            setTitle("Thêm khách hàng");
        }
        if (tinhTrang == 2) {
            setTitle("Cập nhật khách hàng");
            btnthemkh.setEnabled(false);
            btncapnhatkh.setEnabled(true);
            txtcmnd.setEditable(false);
            txttenkh.setEditable(false);
            combobox.setEditable(false);
        }
        if (tinhTrang == 3){
            setTitle("Xem thông tin khách hàng");
            btnthemkh.setEnabled(false);
            btncapnhatkh.setEnabled(false);
            txtcmnd.setEditable(false);
            txttenkh.setEditable(false);
            txtsdtkh.setEditable(false);
            txtdiachi.setEditable(false);
            combobox.setEditable(false);
        }
    }

    public KhachHang layDuLieuTuTXT(){
        if (!txtcmnd.getText().trim().equals("")
            && !txttenkh.getText().trim().equals("")
            && !txtdiachi.getText().trim().equals("")
            && !txtsdtkh.getText().trim().equals("")){
            String soCMND = txtcmnd.getText().trim();
            String diaChi = txtdiachi.getText().trim();
            String soDT = txtsdtkh.getText().trim();
            String tenKH = txttenkh.getText().trim();
            int gioiTinh = (combobox.getSelectedIndex() == 0) ? 1 : 0;
//          Matcher
            Matcher mSoDT = pSoDT.matcher(soDT);
            Matcher mSoCMND = pSoCMDN.matcher(soCMND);
            if (!mSoCMND.matches()){
                JOptionPane.showMessageDialog(this, "Định dạng số CMND không hợp lệ");
                txtcmnd.selectAll();
                txtcmnd.requestFocus();
                return null;
            }
            if (!mSoDT.matches()){
                JOptionPane.showMessageDialog(this, "Định dạng số điện thoại không hợp lệ");
                txtsdtkh.selectAll();
                txtsdtkh.requestFocus();
                return null;
            }
            KhachHang kh = new KhachHang(1, tenKH, gioiTinh, soDT, 1, diaChi, soCMND);
            return kh;
        }
        else
            JOptionPane.showMessageDialog(this, "Các thông tin chưa được nhập đủ");
        return null;
    }

    public static void hienThiThongTinKhachHang(KhachHang kh){
        txtcmnd.setText(kh.getSoCMND());
        txtsdtkh.setText(kh.getSoDT());
        txtdiachi.setText(kh.getDiaChi());
        txttenkh.setText(kh.getTen());
        combobox.setSelectedIndex((kh.getGioiTinh() == 1) ? 0 : 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnthemkh)){
            KhachHang kh = layDuLieuTuTXT();
            if (kh != null){
                GiaoDienLon.themKhachHang(kh);
                dispose();
            }
        }
        if (o.equals(btncapnhatkh)){
            KhachHang kh = layDuLieuTuTXT();
            if (kh != null){
                GiaoDienLon.capNhatKhachHang(kh);
            }
        }
    }
}
