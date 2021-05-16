package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.PhieuThue;
import DoiTuong.PhieuTra;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CSPhieuTra extends JFrame implements ActionListener {
    public JLabel lblMaPhieuThue,lblTheKH,lblMaDiaTra,lblSlTra,lblTinhTrangDia;
    public JTextField txtMaPhieuThue,txtTheKH,txtMaDiaTra,txtSlTra;
    public JButton btnTaoPhieuTra;
    public JComboBox combobox;

    public CSPhieuTra() {
        setSize(390,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        Font ft = new Font("Arial",Font.PLAIN,16);
        lblMaPhieuThue = new JLabel("Mã phiếu thuê");
        lblMaPhieuThue.setFont(ft);
        lblMaPhieuThue.setBounds(10, 10, 150, 30);
        txtMaPhieuThue = new JTextField();
        txtMaPhieuThue.setBounds(10, 40, 350, 30);
        txtMaPhieuThue.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblTheKH = new JLabel("Mã Thẻ khách hàng ");
        lblTheKH.setFont(ft);
        lblTheKH.setBounds(10, 75, 150, 30);
        txtTheKH = new JTextField();
        txtTheKH.setBounds(10, 105, 350, 30);
        txtTheKH.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblMaDiaTra = new JLabel("Mã đĩa trả");
        lblMaDiaTra.setFont(ft);
        lblMaDiaTra.setBounds(10, 140, 150, 30);
        txtMaDiaTra = new JTextField();
        txtMaDiaTra.setBounds(10, 170, 350, 30);
        txtMaDiaTra.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblSlTra = new JLabel("Số lượng trả");
        lblSlTra.setFont(ft);
        lblSlTra.setBounds(10, 206, 150, 30);
        txtSlTra = new JTextField();
        txtSlTra.setBounds(10, 240, 350, 30);
        txtSlTra.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblTinhTrangDia = new JLabel("Tình trạng đĩa");
        lblTinhTrangDia.setFont(ft);
        lblTinhTrangDia.setBounds(10, 275, 150, 30);

        String[ ] Tinhtrang = {"Hoàn hảo","Đã hỏng"};
        combobox = new JComboBox(Tinhtrang);
        combobox.setBounds(10, 310, 350, 40);

        btnTaoPhieuTra = new JButton("Tạo phiếu trả");
        btnTaoPhieuTra.setBounds(100, 380, 150, 50);
        add(lblMaPhieuThue);
        add(txtMaPhieuThue);
        add(lblTheKH);
        add(txtTheKH);
        add(lblMaDiaTra);
        add(txtMaDiaTra);
        add(lblSlTra);
        add(txtSlTra);
        add(btnTaoPhieuTra);
        add(lblTinhTrangDia);
        add(combobox);
        btnTaoPhieuTra.addActionListener(this);
        setVisible(true);
    }

    public PhieuTra layDuLieuTuTXT(){
        if (!txtTheKH.getText().trim().equals("")
            && !txtMaDiaTra.getText().trim().equals("")
            && !txtMaPhieuThue.getText().trim().equals("")
            && !txtSlTra.getText().trim().equals("")){
            int maThe = 0, maPhieu = 0, maDia = 0, soLuong = 0;
            try {
                maPhieu = Integer.parseInt(txtMaPhieuThue.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng mã phiếu không hợp lệ");
                return null;
            }
            try {
                maThe = Integer.parseInt(txtTheKH.getText().trim());
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng mã thẻ khách hàng không hợp lệ");
                return null;
            }
            try {
                maDia = Integer.parseInt(txtMaDiaTra.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng mã đĩa không hợp lệ");
                return null;
            }
            try {
                soLuong = Integer.parseInt(txtSlTra.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng số lượng trả không hợp lệ");
                return null;
            }
            int tinhTrangDia = (combobox.getSelectedIndex() == 0) ? 1 : 2;
            PhieuTra p = new PhieuTra(1, maThe, 1, maDia, soLuong, new Date(), maPhieu, tinhTrangDia, 10);
            return p;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnTaoPhieuTra)){
            PhieuTra p = layDuLieuTuTXT();
            if (p != null){
                GiaoDienLon.themPhieuTra(p);
                txtMaPhieuThue.setText("");
                txtMaDiaTra.setText("");
                txtSlTra.setText("");
                txtMaPhieuThue.requestFocus();
            }
        }
    }
}


