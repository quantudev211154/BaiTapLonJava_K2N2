package GiaoDien.GiaoDienChinh.CuaSoCon;

import DoiTuong.BangDia;
import GiaoDien.GiaoDienChinh.GiaoDienLon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

public class CSBangDia extends JFrame implements ActionListener {
    public JLabel lbTenBD, lbTheLoai, lbHangSX, lbGhiChu, lbSoLuong, lbDonGia, lbGiaThue;
    public JButton btnThemDia, btnCapNhatDia;
    public static JTextField txtTenBD, txtTheLoai, txtHangSX;
    public static JTextField txtGhiChu, txtSoLuong, txtDonGia, txtGiaThue;
    private Dimension kichThuocTextField = new Dimension(350, 40);
    private Dimension kichThuocLabel = new Dimension(100, 20);

    public CSBangDia(){
        setTitle("Thêm băng đĩa");
        setSize(380, 550);
        dungGiaoDienThem();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void dungGiaoDienThem(){
        JPanel hopChua = new JPanel();
//        TenBD
        JPanel pTenBD = new JPanel();
        pTenBD.setLayout(new BoxLayout(pTenBD, BoxLayout.Y_AXIS));
        pTenBD.add(lbTenBD = new JLabel("Tên đĩa" + "                                                       "));
        lbTenBD.setPreferredSize(kichThuocLabel);
        pTenBD.add(txtTenBD = new JTextField());
        txtTenBD.setPreferredSize(kichThuocTextField);
        hopChua.add(pTenBD);
//        TheLoai
        JPanel pTheLoai = new JPanel();
        pTheLoai.setLayout(new BoxLayout(pTheLoai, BoxLayout.Y_AXIS));
        pTheLoai.add(lbTheLoai = new JLabel("Thể loại" + "                                                       "));
        lbTheLoai.setPreferredSize(kichThuocLabel);
        pTheLoai.add(txtTheLoai = new JTextField());
        txtTheLoai.setPreferredSize(kichThuocTextField);
        hopChua.add(pTheLoai);
//        HangSX
        JPanel pHangSX = new JPanel();
        pHangSX.setLayout(new BoxLayout(pHangSX, BoxLayout.Y_AXIS));
        pHangSX.add(lbHangSX = new JLabel("Hãng sản xuất" + "                                                       "));
        lbHangSX.setPreferredSize(kichThuocLabel);
        pHangSX.add(txtHangSX = new JTextField());
        txtHangSX.setPreferredSize(kichThuocTextField);
        hopChua.add(pHangSX);
//        GhiChu
        JPanel pGhiChu = new JPanel();
        pGhiChu.setLayout(new BoxLayout(pGhiChu, BoxLayout.Y_AXIS));
        pGhiChu.add(lbGhiChu = new JLabel("Ghi chú" + "                                                       "));
        lbGhiChu.setPreferredSize(kichThuocLabel);
        pGhiChu.add(txtGhiChu = new JTextField());
        txtGhiChu.setPreferredSize(kichThuocTextField);
        hopChua.add(pGhiChu);
//        SoLuong
        JPanel pSoLuong = new JPanel();
        pSoLuong.setLayout(new BoxLayout(pSoLuong, BoxLayout.Y_AXIS));
        pSoLuong.add(lbSoLuong = new JLabel("Số lượng" + "                                                       "));
        lbSoLuong.setPreferredSize(kichThuocLabel);
        pSoLuong.add(txtSoLuong = new JTextField());
        txtSoLuong.setPreferredSize(kichThuocTextField);
        hopChua.add(pSoLuong);
//        DonGia
        JPanel pDonGia = new JPanel();
        pDonGia.setLayout(new BoxLayout(pDonGia, BoxLayout.Y_AXIS));
        pDonGia.add(lbDonGia = new JLabel("Đơn giá" + "                                                       "));
        lbDonGia.setPreferredSize(kichThuocLabel);
        pDonGia.add(txtDonGia = new JTextField());
        txtDonGia.setPreferredSize(kichThuocTextField);
        hopChua.add(pDonGia);
//        GiaThue
        JPanel pGiaThue = new JPanel();
        pGiaThue.setLayout(new BoxLayout(pGiaThue, BoxLayout.Y_AXIS));
        pGiaThue.add(lbGiaThue = new JLabel("Giá thuê" + "                                                       "));
        lbGiaThue.setPreferredSize(kichThuocLabel);
        pGiaThue.add(txtGiaThue = new JTextField());
        txtGiaThue.setPreferredSize(kichThuocTextField);
        txtGiaThue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    BangDia bd = taoDoiTuongTuTXT();
                    if (bd != null){
                        GiaoDienLon.themBangDia(bd);
                        txtTenBD.setText("");
                        txtTheLoai.setText("");
                        txtHangSX.setText("");
                        txtGhiChu.setText("");
                        txtSoLuong.setText("");
                        txtDonGia.setText("");
                        txtGiaThue.setText("");
                        txtTenBD.requestFocus();
                    }
                }
            }
        });
        hopChua.add(pGiaThue);
//        Cac JButton
        hopChua.add(btnThemDia = new JButton("Thêm đĩa"));
        btnThemDia.setPreferredSize(new Dimension(172, 40));
        hopChua.add(btnCapNhatDia = new JButton("Cập nhật đĩa"));
        btnCapNhatDia.setPreferredSize(new Dimension(172, 40));
        btnThemDia.addActionListener(this);
        btnCapNhatDia.addActionListener(this);
        btnCapNhatDia.setBackground(new Color(10, 246, 234));
        add(hopChua);
    }

    public void datTinhTrangCacNut(boolean tinhHuong){
        if (tinhHuong == true){
            btnThemDia.setEnabled(true);
            btnCapNhatDia.setEnabled(false);
        }
        else {
            btnThemDia.setEnabled(false);
            btnCapNhatDia.setEnabled(true);
        }
    }

    public BangDia taoDoiTuongTuTXT(){
        if (!txtTenBD.getText().trim().equals("")
            && !txtHangSX.getText().trim().equals("")
            && !txtTheLoai.getText().trim().equals("")
            && !txtDonGia.getText().trim().equals("")
            && !txtGiaThue.getText().trim().equals("")
            && !txtSoLuong.getText().trim().equals("")){
            String tenDia = txtTenBD.getText().trim();
            String theLoai = txtTheLoai.getText().trim();
            String hangSX = txtHangSX.getText().trim();
            String ghiChu = txtGhiChu.getText().trim();
            int soLuong = 0;
            double donGia = 0, giaThue = 0;
            try {
                soLuong = Integer.parseInt(txtSoLuong.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng số lượng không hợp lệ");
                return null;
            }
            try{
                donGia = Double.parseDouble(txtDonGia.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng đơn giá không hợp lệ");
                return null;
            }
            try {
                giaThue = Double.parseDouble(txtGiaThue.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Định dạng giá thuê không hợp lệ");
                return null;
            }
            BangDia bd = new BangDia(1, tenDia, theLoai, true, hangSX, ghiChu, soLuong, soLuong, donGia, giaThue);
            return bd;
        }
        else
            JOptionPane.showMessageDialog(this, "Các thông tin chưa được điền đủ");
        return null;
    }

    public static void hienThiDuLieuDiaLenTXT(BangDia bd){
        txtTenBD.setText(bd.getTenBD());
        txtTheLoai.setText(bd.getTheLoai());
        txtHangSX.setText(bd.getHangSX());
        txtSoLuong.setText(bd.getSoLuongGoc()+"");
        txtDonGia.setText(bd.getDonGia()+"");
        txtGiaThue.setText(bd.getGiaThue()+"");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnThemDia)){
            BangDia bd = taoDoiTuongTuTXT();
            if (bd != null){
                GiaoDienLon.themBangDia(bd);
                txtTenBD.setText("");
                txtTheLoai.setText("");
                txtHangSX.setText("");
                txtGhiChu.setText("");
                txtSoLuong.setText("");
                txtDonGia.setText("");
                txtGiaThue.setText("");
                txtTenBD.requestFocus();
            }
        }
        if (o.equals(btnCapNhatDia)){
            BangDia bd = taoDoiTuongTuTXT();
            if (bd != null)
                GiaoDienLon.capNhatDia(bd);
        }
    }
}
