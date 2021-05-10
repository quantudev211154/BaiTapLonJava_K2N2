package GiaoDien.GiaoDienChinh;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDienLon extends JFrame implements danhSachBien, cacThanhPhanGiaoDien, ActionListener {
    public JPanel pnKhungChua, pnHopCongCu, pnHopDuLieu, pnHopThongTinDuLieu;

    public GiaoDienLon(){
        setTitle("Quản lý băng đĩa");
        setSize(chieuRongGiaoDien, chieuCaoGiaoDien);
        dungGiaoDien();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void dungGiaoDien(){
        pnKhungChua = new JPanel();
        pnKhungChua.setLayout(new BoxLayout(pnKhungChua, BoxLayout.Y_AXIS));
        setJMenuBar(thanhMenu());
        pnKhungChua.add(pnHopCongCu = hopCongCuBangDia());
        pnHopCongCu.setLayout(new BoxLayout(pnHopCongCu, BoxLayout.X_AXIS));
        pnKhungChua.add(pnHopDuLieu = hopDuLieuBangDia());
        pnKhungChua.add(pnHopThongTinDuLieu = hopTTDuLieuBangDia());
        add(pnKhungChua);
    }

    public static void main(String[] args) {
        new GiaoDienLon().setVisible(true);
    }

    @Override
    public JMenuBar thanhMenu() {
        thanhMenu.add(miBangDia);
        thanhMenu.add(miPhieuThue);
        thanhMenu.add(miPhieuTra);
        thanhMenu.add(miKhachHang);
        thanhMenu.add(miTheThanhVien);
        thanhMenu.add(miNhanVien);
        thanhMenu.add(miTaiKhoan);
//        JMenu Doanh Thu
        thanhMenu.add(mnDoanhThu);
        mnDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar));
        mnDoanhThu.add(miTongDoanhThu);
        miTongDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar - 13));
        mnDoanhThu.add(miChiTietDoanhThu);
        miChiTietDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar - 13));
//        JMenu Nang Cao
        thanhMenu.add(mnNangCao);
        mnNangCao.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar));
        mnNangCao.add(miNguoiDung);
        miNguoiDung.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar));
        mnNangCao.add(miDangXuat);
        miDangXuat.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar));
        thanhMenu.setPreferredSize(new Dimension( chieuRongGiaoDien,chieuCaoMenuBar));
//        Them hanh dong cho cac MenuItems
        miBangDia.addActionListener(this);
        miPhieuThue.addActionListener(this);
        miPhieuTra.addActionListener(this);
        miKhachHang.addActionListener(this);
        miTheThanhVien.addActionListener(this);
        miNhanVien.addActionListener(this);
        miTaiKhoan.addActionListener(this);
        miTongDoanhThu.addActionListener(this);
        miChiTietDoanhThu.addActionListener(this);
        miNguoiDung.addActionListener(this);
        miDangXuat.addActionListener(this);
        return thanhMenu;
    }

    /**
     * - Dùng để tùy chỉnh thông số các JPanel
     * @param thanhPhan: JPanel cần căn kích thước
     * @param chieuRong: Chiều rộng cần căn
     * @param chieuCao: Chiều cao cần căn
     * @param mauVien: Màu Viền cần đặt
     */
    public void tuyChinhJPanel(JPanel thanhPhan, int chieuRong, int chieuCao, Color mauVien){
        thanhPhan.setPreferredSize(new Dimension(chieuRong, chieuCao));
        thanhPhan.setBorder(BorderFactory.createLineBorder(mauVien));
    }

    /**
     * - Dùng để tùy chỉnh thông số các JTextField
     * @param txt: JTextField cần tùy chỉnh
     * @param chieuRongTxt: Chiều rộng của JTextField
     * @param chieuCaoTxt: Chiều cao của JTextField
     * @param moTaTxt: Mục đích của JTextField
     * @param mauVien: Màu viền cần đặt
     */
    public void tuyChinhJTextField(JTextField txt, int chieuRongTxt, int chieuCaoTxt, String moTaTxt, Color mauVien){
        txt.setPreferredSize(new Dimension(chieuRongTxt, chieuCaoTxt));
        txt.setBorder(new TitledBorder(BorderFactory.createLineBorder(mauVien), moTaTxt));
    }

    /**
     * - Dùng để load lên khi chạy giao diện
     * @return: Hộp công cụ băng đĩa
     */
    @Override
    public JPanel hopCongCuBangDia() {
        JPanel hopCCBangDia = new JPanel();
        hopCCBangDia.setLayout(new BoxLayout(hopCCBangDia, BoxLayout.X_AXIS));
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnThemDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnXoaDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnCapNhatDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(txtTimBangDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        tuyChinhJTextField(txtTimBangDia, 300, 50, "Nhập mã băng đĩa cần tìm", Color.black);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnTimDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        tuyChinhJPanel(hopCCBangDia, chieuRongGiaoDien, chieuCaoHopCongCu, Color.red);
        btnThemDia.addActionListener(this);
        btnXoaDia.addActionListener(this);
        btnCapNhatDia.addActionListener(this);
        btnTimDia.addActionListener(this);
        return hopCCBangDia;
    }

    /**
     * - Dùng để load lên khi chạy giao diện
     * @return: Hộp dữ liệu về băng đĩa
     */
    @Override
    public JPanel hopDuLieuBangDia() {
        JPanel hopDLBangDia = new JPanel();

        tuyChinhJPanel(hopDLBangDia, chieuRongGiaoDien, chieuCaoHopDuLieu, Color.blue);
        return hopDLBangDia;
    }

    /**
     * - Dùng để load lên khi chạy giao diện
     * @return: Hộp thông tin dữ liệu băng đĩa
     */
    @Override
    public JPanel hopTTDuLieuBangDia() {
        JPanel hopTTDLBangDia = new JPanel();

        tuyChinhJPanel(hopTTDLBangDia, chieuRongGiaoDien, chieuCaoHopTTDuLieu, Color.cyan);
        return hopTTDLBangDia;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(miBangDia)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnThemDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimBangDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            tuyChinhJTextField(txtTimBangDia, 200, 50, "Nhập mã băng đĩa cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnThemDia.addActionListener(this);
            btnXoaDia.addActionListener(this);
            btnCapNhatDia.addActionListener(this);
            btnTimDia.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miPhieuThue)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTaoPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimPhieuThue);
            tuyChinhJTextField(txtTimPhieuThue, 300, 20, "Nhập mã phiếu thuê cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnTaoPhieuThue.addActionListener(this);
            btnXoaPhieuThue.addActionListener(this);
            btnCapNhatPhieuThue.addActionListener(this);
            btnTimPhieuThue.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miPhieuTra)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTaoPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimPhieuTra);
            tuyChinhJTextField(txtTimPhieuTra, 300, 20, "Nhập mã phiếu trả cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnTaoPhieuTra.addActionListener(this);
            btnXoaPhieuTra.addActionListener(this);
            btnCapNhatPhieuTra.addActionListener(this);
            btnTimPhieuTra.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miKhachHang)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnThemKhachHang);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaKhachHang);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatTTKhachHang);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimKhachHang);
            tuyChinhJTextField(txtTimKhachHang, 300, 20, "Nhập mã khách hàng cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimKhachHang);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnThemKhachHang.addActionListener(this);
            btnXoaKhachHang.addActionListener(this);
            btnCapNhatTTKhachHang.addActionListener(this);
            btnTimKhachHang.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miTheThanhVien)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnThemTheTV);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaTheTV);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatTheTV);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimTheTV);
            tuyChinhJTextField(txtTimTheTV, 300, 20, "Nhập mã thẻ thành viên cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimTheTV);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnThemTheTV.addActionListener(this);
            btnXoaTheTV.addActionListener(this);
            btnCapNhatTheTV.addActionListener(this);
            btnTimTheTV.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miNhanVien)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnThemNhanVien);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaNhanVien);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatNhanVien);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimNhanVien);
            tuyChinhJTextField(txtTimNhanVien, 300, 20, "Nhập mã nhân viên cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimNhanVien);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnThemNhanVien.addActionListener(this);
            btnXoaNhanVien.addActionListener(this);
            btnCapNhatNhanVien.addActionListener(this);
            btnTimNhanVien.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        if (o.equals(miTaiKhoan)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnThemTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimTaiKhoan);
            tuyChinhJTextField(txtTimTaiKhoan, 300, 20, "Nhập mã tài khoản cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnThemTaiKhoan.addActionListener(this);
            btnXoaTaiKhoan.addActionListener(this);
            btnCapNhatTaiKhoan.addActionListener(this);
            btnTimTaiKhoan.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        /**
         * Chua viet gi
         */
        if (o.equals(miTongDoanhThu)){

        }
        if (o.equals(miChiTietDoanhThu)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimGiaoDich);
            tuyChinhJTextField(txtTimGiaoDich, 300, 20, "Nhập mã giao dịch cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimGiaoDich);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnTimGiaoDich.addActionListener(this);
            pnHopCongCu.revalidate();
        }
        /**
         * Chua viet gi
         */
        if (o.equals(miNguoiDung)){

        }
        if (o.equals(miDangXuat)){
            System.exit(0);
        }
    }
}
