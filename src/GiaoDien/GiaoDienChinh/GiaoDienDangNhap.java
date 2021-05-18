package GiaoDien.GiaoDienChinh;

import DoiTuong.TaiKhoan;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GiaoDienDangNhap extends JFrame implements ActionListener {
    private JPanel khungChua;
    private JLabel lbTieuDe, lbTenDangNhap, lbMatKhau;
    private static JTextField txtTenDangNhap;
    private JPasswordField txtMatKhau;
    private JButton btnDangNhap;
    private Dimension kichThuocLabel = new Dimension(200, 35);
    private Dimension kichThuocTextField = new Dimension(400, 45);
    private Font labelFont = new Font(Font.SANS_SERIF, Font.TYPE1_FONT, 18);
    private KetNoiToiCoSoDuLieu kn;
    private ArrayList<TaiKhoan> dsTaiKhoan;
    private int soLanDangNhapHut = 0;
    private final Color mauBTN = new Color(46, 82, 102);

    public GiaoDienDangNhap(){
        setTitle("Đăng nhập");
        setSize(550, 450);
        dungGiaoDien();
        try{
            kn = new KetNoiToiCoSoDuLieu();
            dsTaiKhoan = kn.docDuLieuTaiKhoan();
            kn.ngatKetNoiToiCSDL();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void dungGiaoDien(){
        khungChua = new JPanel();
        khungChua.setLayout(new BoxLayout(khungChua, BoxLayout.Y_AXIS));
        khungChua.add(pTieuDe());
        khungChua.add(thongTinDangNhap());
        khungChua.add(Box.createVerticalStrut(40));
        khungChua.add(xacNhanDangNhap());
        add(khungChua);
    }

    public JPanel pTieuDe(){
        JPanel pTieuDe = new JPanel(new FlowLayout(1, 50, 20));
        pTieuDe.add(lbTieuDe = new JLabel("Đăng nhập vào hệ thống"));
        lbTieuDe.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 33));
        lbTieuDe.setForeground(new Color(30, 129, 176));
        pTieuDe.setPreferredSize(new Dimension(550, 8));
        return pTieuDe;
    }

    public JPanel thongTinDangNhap(){
        JPanel pTTDangNhap = new JPanel();
//        Panel Ten Dang Nhap
        JPanel pTenDangNhap = new JPanel();
        pTenDangNhap.setLayout(new BoxLayout(pTenDangNhap, BoxLayout.Y_AXIS));
        pTenDangNhap.add(lbTenDangNhap = new JLabel("Mã nhân viên:"));
        lbTenDangNhap.setPreferredSize(kichThuocLabel);
        lbTenDangNhap.setFont(labelFont);
        pTenDangNhap.add(txtTenDangNhap = new JTextField());
        txtTenDangNhap.setPreferredSize(kichThuocTextField);
        txtTenDangNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    kiemTraDangNhap();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });
//        Panel Mat Khau
        JPanel pMatKhau = new JPanel();
        pMatKhau.setLayout(new BoxLayout(pMatKhau, BoxLayout.Y_AXIS));
        pMatKhau.add(lbMatKhau = new JLabel("Mật khẩu:"));
        lbMatKhau.setPreferredSize(kichThuocLabel);
        lbMatKhau.setFont(labelFont);
        pMatKhau.add(txtMatKhau = new JPasswordField());
        txtMatKhau.setPreferredSize(kichThuocTextField);
        txtMatKhau.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    kiemTraDangNhap();
                }
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }
        });
//        Them cac thanh phan con
        pTTDangNhap.add(pTenDangNhap);
        pTTDangNhap.add(pMatKhau);
        return pTTDangNhap;
    }

    public JPanel xacNhanDangNhap(){
        JPanel pXacNhan = new JPanel();
        pXacNhan.add(btnDangNhap = new JButton("Đăng nhập"));
        btnDangNhap.setPreferredSize(new Dimension(200, 50));
        btnDangNhap.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        btnDangNhap.addActionListener(this);
        btnDangNhap.setBackground(mauBTN);
        btnDangNhap.setForeground(Color.WHITE);
        pXacNhan.setPreferredSize(new Dimension(550, 10));
        return pXacNhan;
    }

    public void huyYeuCauDangNhap(int soLanHut){
        if (soLanHut == 3){
            JOptionPane.showMessageDialog(this, "Đã quá số lần đăng nhập được phép");
            System.exit(1);
        }
    }

    public boolean kiemTraTTDangNhap(int maNV, String matKhau){
        for (TaiKhoan tk : dsTaiKhoan){
            if (tk.getMaNV() == maNV && tk.getMatKhau().equals(matKhau))
                return true;
        }
        return false;
    }

    public static int layMaNV(){
        return Integer.parseInt(txtTenDangNhap.getText().trim());
    }

    public void kiemTraDangNhap(){
        if (!txtTenDangNhap.getText().trim().equals("")
                && !txtMatKhau.getText().trim().equals("")){
            int maNV = 0;
            try{
                maNV = Integer.parseInt(txtTenDangNhap.getText().trim());
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Mã nhân viên không đúng định dạng");
            }
            String passThat = "";
            char[] mkTam = txtMatKhau.getPassword();
            for (int i = 0; i < mkTam.length; ++i)
                passThat += mkTam[i];
            if (kiemTraTTDangNhap(maNV, passThat) == true){
                GiaoDienLon gd = new GiaoDienLon();
                gd.setVisible(true);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản này. Hãy thử lại");
                soLanDangNhapHut++;
                txtMatKhau.requestFocus();
                huyYeuCauDangNhap(soLanDangNhapHut);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Bạn chưa cung cấp đủ thông tin đăng nhập");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnDangNhap)){
            kiemTraDangNhap();
        }
    }
}
