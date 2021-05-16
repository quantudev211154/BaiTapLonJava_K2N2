package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.PhieuThue;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class CSPhieuThue extends JFrame implements ActionListener {
    public JLabel lblMathe,lblMadiamuon,lblSlDia,lblSongaymuon;
    public static JTextField txtMathe,txtMadiamuon,txtSlDia,txtSongaymuon;
    public JButton btnTaoPhieu;

    public CSPhieuThue() {
        setSize(380,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        Font ft = new Font("Arial",Font.PLAIN,16);
        lblMathe = new JLabel("Mã thẻ khách hàng");
        lblMathe.setFont(ft);
        lblMathe.setBounds(10, 20, 150, 30);
        txtMathe = new JTextField();
        txtMathe.setBounds(10, 50, 350, 40);
        txtMathe.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblMadiamuon = new JLabel("Mã đĩa mượn");
        lblMadiamuon.setFont(ft);
        lblMadiamuon.setBounds(10, 100, 150, 30);
        txtMadiamuon = new JTextField();
        txtMadiamuon.setBounds(10, 125, 350, 40);
        txtMadiamuon.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblSlDia = new JLabel("Số lượng đĩa");
        lblSlDia.setFont(ft);
        lblSlDia.setBounds(10, 175, 150, 30);
        txtSlDia = new JTextField();
        txtSlDia.setBounds(10, 200, 350, 40);
        txtSlDia.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        lblSongaymuon = new JLabel("Số ngày mượn");
        lblSongaymuon.setFont(ft);
        lblSongaymuon.setBounds(10, 250, 150, 30);
        txtSongaymuon = new JTextField();
        txtSongaymuon.setBounds(10, 280, 350, 40);
        txtSongaymuon.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnTaoPhieu = new JButton("Tạo phiếu thuê");
        btnTaoPhieu.setBounds(100, 350, 150, 50);
        btnTaoPhieu.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblMathe);
        add(txtMathe);
        add(lblMadiamuon);
        add(txtMadiamuon);
        add(lblSlDia);
        add(txtSlDia);
        add(lblSongaymuon);
        add(txtSongaymuon);
        add(btnTaoPhieu);
        btnTaoPhieu.addActionListener(this);
        setVisible(true);
    }

    public static PhieuThue layDuLieuTuTXT(){
        if (!txtMathe.getText().trim().equals("")
            && !txtMadiamuon.getText().trim().equals("")
            && !txtSlDia.getText().trim().equals("")
            && !txtSongaymuon.getText().trim().equals("")){
            int maThe = 0, maDia = 0, soLuong = 0, soNgayMuon = 0;
            try {
                maThe = Integer.parseInt(txtMathe.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Định dạng mã thẻ không hợp lệ");
                return null;
            }
            try {
                maDia = Integer.parseInt(txtMadiamuon.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Định dạng Mã đĩa mượn không hợp lệ");
                return null;
            }
            try{
                soLuong = Integer.parseInt(txtSlDia.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Định dạng Số lượng đĩa không hợp lệ");
                return null;
            }
            try {
                soNgayMuon = Integer.parseInt(txtSongaymuon.getText().trim());
                if (soNgayMuon > 5){
                    JOptionPane.showMessageDialog(null, "Không được mượn quá đĩa quá 5 ngày đâu");
                    return null;
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Định dạng số ngày mượn không hợp lệ");
                return null;
            }
            PhieuThue p = new PhieuThue(1, maThe, 1, maDia, soLuong, new Date(), new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000 * soNgayMuon)), 10);
            return p;
        }
        else
            JOptionPane.showMessageDialog(null, "Các thông tin chưa được điền đủ");
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnTaoPhieu)){
            PhieuThue p = layDuLieuTuTXT();
            if (p != null){
                GiaoDienLon.themPhieuThue(p);
                txtMadiamuon.setText("");
                txtSongaymuon.setText("");
                txtMadiamuon.requestFocus();
            }
        }
    }
}
