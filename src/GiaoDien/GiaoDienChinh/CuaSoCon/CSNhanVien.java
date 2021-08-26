package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.NhanVien;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;

public class CSNhanVien extends JFrame implements ActionListener, danhSachRegex {
    public JLabel lblten,lblgioitinh,lblsdt,lblmota;
    public static JTextField txtten,txtsdt;
    public static JComboBox combobox;
    public static JTextArea txtmota;
    public JButton btnthem,btncapnhat;
    private int chieuRong = 300;

    public CSNhanVien() {
        setTitle("Nhân viên");
        setSize(335,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        Font ft= new Font("Times New Roman",Font.PLAIN,16);
        lblten = new JLabel("Tên nhân viên: ");
        lblten.setFont(ft);
        lblten.setBounds(10,10,chieuRong,20);
        txtten = new JTextField();
        txtten.setBounds(10,35,chieuRong,30);
        txtten.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblgioitinh = new JLabel("Giới tính:");
        lblgioitinh.setBounds(10,70,chieuRong,30);
        lblgioitinh.setFont(ft);
        String [] gioitinh = {"Nam","Nữ"};
        combobox = new JComboBox(gioitinh);
        combobox.setBounds(10, 95, chieuRong, 40);
        lblsdt = new JLabel("Số điện thoại:");
        lblsdt.setBounds(10,140,150,30);
        lblsdt.setFont(ft);
        txtsdt = new JTextField();
        txtsdt.setBounds(10,165,chieuRong,30);
        txtsdt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtsdt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    NhanVien nv = layDuLieuTuTXT();
                    if (nv != null){
                        GiaoDienLon.themNhanVien(nv);
                        dispose();
                    }
                }
            }
        });
        lblmota = new JLabel("Mô tả:");
        lblmota.setBounds(10,200,chieuRong,30);
        lblmota.setFont(ft);
        txtmota = new JTextArea();
        txtmota.setBounds(10,230,chieuRong,150);
        txtmota.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnthem = new JButton("Thêm");
        btnthem.setBounds(10, 400, 145, 45);
        btncapnhat = new JButton("Cập nhật");
        btncapnhat.setBounds(165, 400, 145, 45);
        add(lblten);
        add(txtten);
        add(lblgioitinh);
        add(combobox);
        add(lblsdt);
        add(txtsdt);
        add(lblmota);
        add(txtmota);
        add(btnthem);
        add(btncapnhat);
        btnthem.addActionListener(this);
        btncapnhat.addActionListener(this);
        btncapnhat.setBackground(new Color(10, 246, 170));
        setVisible(true);
    }

    public void datTinhTrangCacNut(int tinhTrang){
        if (tinhTrang == 1){
            setTitle("Thêm nhân viên");
            btncapnhat.setEnabled(false);
        }
        if (tinhTrang == 2) {
            setTitle("Cập nhật thông tin nhân viên");
            btncapnhat.setEnabled(false);
            btnthem.setEnabled(false);
            txtten.setEditable(false);
            combobox.setEnabled(false);
        }
        if (tinhTrang == 3){
            setTitle("Xem thông tin nhân viên");
            btncapnhat.setEnabled(false);
            btnthem.setEnabled(false);
            txtsdt.setEditable(false);
            txtten.setEditable(false);
            txtmota.setEditable(false);
            combobox.setEditable(false);
        }
    }

    public static void hienThiDuLieuLenTXT(NhanVien nv){
        txtten.setText(nv.getTen());
        txtmota.setText(nv.getMoTa());
        txtsdt.setText(nv.getSoDT());
        combobox.setSelectedIndex((nv.getGioiTinh()) == 1 ? 0 : 1);
    }

    public NhanVien layDuLieuTuTXT(){
        if (!txtten.getText().trim().equals("")
            && !txtsdt.getText().trim().equals("")){
            String tenNV = txtten.getText().trim();
            int gioiTinh = (combobox.getSelectedIndex() == 0) ? 1 : 2;
            String moTa = txtmota.getText().trim();
            String soDT = txtsdt.getText().trim();
//            Matcher
            Matcher mSoDT = pSoDT.matcher(soDT);
            if (!mSoDT.matches()){
                JOptionPane.showMessageDialog(this, "Định dạng số điện thoại không hợp lệ");
                txtsdt.selectAll();
                txtsdt.requestFocus();
                return null;
            }
            NhanVien nv = new NhanVien(1, tenNV, gioiTinh, soDT, moTa);
            return nv;
        }
        else
            JOptionPane.showMessageDialog(this, "Các thông tin chưa được nhập đủ");
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnthem)){
            NhanVien nv = layDuLieuTuTXT();
            if (nv != null){
                GiaoDienLon.themNhanVien(nv);
                dispose();
            }
        }
        if (o.equals(btncapnhat)){
            NhanVien nv = layDuLieuTuTXT();
            if (nv != null){
                GiaoDienLon.capNhatNhanVien(nv);
            }
        }
    }
}
