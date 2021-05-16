package GiaoDien.GiaoDienChinh;

import DoiTuong.*;
import GiaoDien.GiaoDienChinh.CuaSoCon.*;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import MoHinhDoiTuong.*;
import QuanLyDoiTuong.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class GiaoDienLon extends JFrame implements danhSachBien, ActionListener {
    public static int maNhanVienDangDung = 1;
    public JPanel pnKhungChua, pnHopCongCu, pnHopDuLieu, pnHopThongTinDuLieu;
    public static KetNoiToiCoSoDuLieu kn;
    public static MoHinhBangDia mhBangDia;
    public static MoHinhNhanVien mhNhanVien;
    public static MoHinhTaiKhoan mhTaiKhoan;
    public static MoHinhKhachHang mhKhachHang;
    public static MoHinhDoanhThu mhDoanhThu;
    public static MoHinhTheThanhVien mhThe;
    public static MoHinhPhieuThue mhPhieuThue;
    public static MoHinhPhieuTra mhPhieuTra;

    public GiaoDienLon(){
        try{
            setTitle("Quản lý băng đĩa");
            setSize(chieuRongGiaoDien, chieuCaoGiaoDien);
            dungGiaoDien();
            kn = new KetNoiToiCoSoDuLieu();
            phanQuyenNguoiDung(maNhanVienDangDung);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void dungGiaoDien() throws SQLException {
        pnKhungChua = new JPanel();
        pnKhungChua.setLayout(new BoxLayout(pnKhungChua, BoxLayout.Y_AXIS));
        setJMenuBar(thanhMenu());
        pnKhungChua.add(pnHopCongCu = new JPanel());
        hopCongCuBangDia(pnHopCongCu);
        pnKhungChua.add(pnHopDuLieu = new JPanel());
        hopDuLieuBangDia(pnHopDuLieu);
        pnKhungChua.add(pnHopThongTinDuLieu = new JPanel());
        hopTTDuLieuBangDia(pnHopThongTinDuLieu);
        themHanhDongChoCacNut();
        add(pnKhungChua);
    }

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
        mnDoanhThu.add(miDoanhThuTrongNgay);
        miDoanhThuTrongNgay.setPreferredSize(new Dimension(chieuRongJMenu - 2, chieuCaoMenuBar));
        mnDoanhThu.add(miChiTietDoanhThu);
        miChiTietDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu - 2, chieuCaoMenuBar));
//        JMenu Nang Cao
        thanhMenu.add(mnNangCao);
        mnNangCao.setPreferredSize(new Dimension(chieuRongJMenu, chieuCaoMenuBar));
        mnNangCao.add(miNguoiDung);
        miNguoiDung.setPreferredSize(new Dimension(chieuRongJMenu - 9, chieuCaoMenuBar));
        mnNangCao.add(miDangXuat);
        miDangXuat.setPreferredSize(new Dimension(chieuRongJMenu - 9, chieuCaoMenuBar));
        thanhMenu.setPreferredSize(new Dimension( chieuRongGiaoDien,chieuCaoMenuBar));
//        Them hanh dong cho cac MenuItems
        miBangDia.addActionListener(this);
        miPhieuThue.addActionListener(this);
        miPhieuTra.addActionListener(this);
        miKhachHang.addActionListener(this);
        miTheThanhVien.addActionListener(this);
        miNhanVien.addActionListener(this);
        miTaiKhoan.addActionListener(this);
        miDoanhThuTrongNgay.addActionListener(this);
        miChiTietDoanhThu.addActionListener(this);
        miNguoiDung.addActionListener(this);
        miDangXuat.addActionListener(this);
        return thanhMenu;
    }

    public void layMaNguoiDung(int maNguoiDung){
        maNhanVienDangDung = maNguoiDung;
    }

    public void phanQuyenNguoiDung(int maNV){
        if (maNV != 1 && maNV != 2){
            miTaiKhoan.setEnabled(false);
            btnXoaNhanVien.setEnabled(false);
            btnCapNhatNhanVien.setEnabled(false);
            btnCapNhatTaiKhoan.setEnabled(false);
            btnXoaPhieuThue.setEnabled(false);
            btnXoaPhieuTra.setEnabled(false);
        }
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
    public void hopCongCuBangDia(JPanel hopCCBangDia) {
        hopCCBangDia.setLayout(new BoxLayout(hopCCBangDia, BoxLayout.X_AXIS));
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnThemDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnXoaDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnCapNhatDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(txtTimBangDia);
        tuyChinhJTextField(txtTimBangDia, 300, 50, "Nhập mã băng đĩa cần tìm", Color.black);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        hopCCBangDia.add(btnTimDia);
        hopCCBangDia.add(Box.createHorizontalStrut(20));
        tuyChinhJPanel(hopCCBangDia, chieuRongGiaoDien, chieuCaoHopCongCu, Color.red);
        btnThemDia.addActionListener(this);
        btnXoaDia.addActionListener(this);
        btnCapNhatDia.addActionListener(this);
        btnTimDia.addActionListener(this);
    }

    /**
     * - Dùng để load lên khi chạy giao diện
     * @return: Hộp dữ liệu về băng đĩa
     */
    public void hopDuLieuBangDia(JPanel hopDuLieuDia) throws SQLException {
        KetNoiToiCoSoDuLieu ketNoi = new KetNoiToiCoSoDuLieu();
        mhBangDia = new MoHinhBangDia(new QuanLyBangDia(ketNoi).getDsBangDia());
        tbBangDia.setModel(mhBangDia);
        tbBangDia.setRowHeight(chieuCaoHangTrongBang);
        scrPaneBangDia.setPreferredSize(new Dimension(chieuRongGiaoDien - 20, chieuCaoHopDuLieu));
        hopDuLieuDia.add(scrPaneBangDia);
        tuyChinhJPanel(hopDuLieuDia, chieuRongBangDuLieu, chieuCaoHopDuLieu, Color.blue);
    }

    /**
     * - Dùng để load lên khi chạy giao diện
     * @return: Hộp thông tin dữ liệu băng đĩa
     */
    public void hopTTDuLieuBangDia(JPanel hopTTDL) throws SQLException {
        hopTTDL.add(lbThongTinDuLieu);
        KetNoiToiCoSoDuLieu ketNoi = new KetNoiToiCoSoDuLieu();
        lbThongTinDuLieu.setText("Hệ thống hiện đang lưu trữ: " + new QuanLyBangDia(ketNoi).getDsBangDia().size() + " băng đĩa");
        lbThongTinDuLieu.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lbThongTinDuLieu.setForeground(Color.blue);
        tuyChinhJPanel(hopTTDL, chieuRongGiaoDien, chieuCaoHopTTDuLieu, Color.cyan);
    }

    public void themHanhDongChoCacNut(){
        btnTimDia.addActionListener(this);
        btnTaoPhieuThue.addActionListener(this);
        btnXoaPhieuThue.addActionListener(this);
        btnCapNhatPhieuThue.addActionListener(this);
        btnTimPhieuThue.addActionListener(this);
        btnXemPhieuChuaTra.addActionListener(this);
        btnTaoPhieuTra.addActionListener(this);
        btnXoaPhieuTra.addActionListener(this);
        btnCapNhatPhieuTra.addActionListener(this);
        btnTimPhieuTra.addActionListener(this);
        btnThemKhachHang.addActionListener(this);
        btnXoaKhachHang.addActionListener(this);
        btnCapNhatTTKhachHang.addActionListener(this);
        btnTimKhachHang.addActionListener(this);
        btnThemNhanVien.addActionListener(this);
        btnXoaNhanVien.addActionListener(this);
        btnCapNhatNhanVien.addActionListener(this);
        btnTimNhanVien.addActionListener(this);
        btnXemDoanhThuTheoThang.addActionListener(this);
        btnXemDoanhThuThangHienTai.addActionListener(this);
        btnThemTheTV.addActionListener(this);
        btnXoaTheTV.addActionListener(this);
        btnCapNhatTheTV.addActionListener(this);
        btnTimTheTV.addActionListener(this);
        btnThemTaiKhoan.addActionListener(this);
        btnCapNhatTaiKhoan.addActionListener(this);
        btnTimTaiKhoan.addActionListener(this);
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
            tuyChinhJTextField(txtTimBangDia, 200, 50, "Nhập mã băng đĩa cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimDia);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.revalidate();
//            Hop thong tin du lieu
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuBangDia();
            scrPaneBangDia.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneBangDia);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miPhieuThue)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTaoPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXemPhieuChuaTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimPhieuThue);
            tuyChinhJTextField(txtTimPhieuThue, 300, 20, "Nhập mã phiếu thuê cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimPhieuThue);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuPhieuThue();
            scrPanePhieuThue.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuThue);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(btnXemPhieuChuaTra)){
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            mhPhieuThue = new MoHinhPhieuThue(kn.docDuLieuPhieuChuaTra());
            tbPhieuThue.setModel(mhPhieuThue);
            tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
            scrPanePhieuThue.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuThue);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miPhieuTra)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTaoPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXoaPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimPhieuTra);
            tuyChinhJTextField(txtTimPhieuTra, 300, 20, "Nhập mã phiếu trả cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimPhieuTra);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuPhieuTra();
            scrPanePhieuTra.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuTra);
            pnHopDuLieu.revalidate();
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
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuKhachHang();
            scrPaneKhachHang.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneKhachHang);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miTheThanhVien)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
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
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuTheTV();
            scrPaneTheTV.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneTheTV);
            pnHopDuLieu.revalidate();
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
            pnHopCongCu.revalidate();
//            Hop Du Lieu Nhan Vien
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuNhanVien();
            scrPaneNhanVien.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneNhanVien);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miTaiKhoan)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnCapNhatTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimTaiKhoan);
            tuyChinhJTextField(txtTimTaiKhoan, 300, 20, "Nhập mã tài khoản cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimTaiKhoan);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.revalidate();
//            Hop du lieu tai khoan
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuTaiKhoan();
            scrPaneTaiKhoan.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneTaiKhoan);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miDoanhThuTrongNgay)){
            try {
                double doanhThuNgay = kn.xemDoanhThuTrongNgay();
                Locale vn = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
                JOptionPane.showMessageDialog(this, "Doanh thu hôm nay cho đến giờ là: " + nf.format(doanhThuNgay));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (o.equals(miChiTietDoanhThu)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXemDoanhThuThangHienTai);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnXemDoanhThuTheoThang);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(txtTimGiaoDich);
            tuyChinhJTextField(txtTimGiaoDich, 300, 20, "Nhập mã giao dịch cần tìm", Color.black);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            pnHopCongCu.add(btnTimGiaoDich);
            pnHopCongCu.add(Box.createHorizontalStrut(20));
            btnTimGiaoDich.addActionListener(this);
            pnHopCongCu.revalidate();
//            Hop du lieu doanh thu
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            capNhatDuLieuDoanhThu();
            scrPaneDoanhThu.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneDoanhThu);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(btnXemDoanhThuThangHienTai)){
            double doanhThuThangNay = kn.xemDoanhThuThangHienTai();
            Locale vn = new Locale("vi", "vn");
            NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
            JOptionPane.showMessageDialog(this, "Doanh thu tháng này cho đến giờ là " + nf.format(doanhThuThangNay));
        }
        if (o.equals(btnXemDoanhThuTheoThang)){
            new CSXemDoanhThuTheoThang();
        }
        if (o.equals(miNguoiDung)){
            try {
                NhanVien nv = kn.xacDinhNhanVienDangDung(maNhanVienDangDung);
                String chucVu = (nv.getID() == 1 || nv.getID() == 2) ? "Quản trị viên" : "Nhân viên";
                JOptionPane.showMessageDialog(this,"Hệ thống đang được dùng bởi " + chucVu + " " + nv.getTen() + ", có mã NV là " + nv.getID());
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (o.equals(miDangXuat)){
            kn.ngatKetNoiToiCSDL();
            System.exit(0);
        }
        if (o.equals(btnThemDia)){
            new CSBangDia().datTinhTrangCacNut(true);
        }
        if (o.equals(btnXoaDia)){
            int hangChon = tbBangDia.getSelectedRow();
            if (hangChon != -1){
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa đĩa này?",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (luaChon == 0){
                    int maBD = (Integer) tbBangDia.getValueAt(tbBangDia.getSelectedRow(), 0);
                    if (kn.xoaBangDia(maBD)){
                        JOptionPane.showMessageDialog(this, "Đã xóa đĩa có mã " + maBD);
                        capNhatDuLieuBangDia();
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Không xóa thì thôi vậy. Hú hồn");
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn đĩa cần xóa");
        }
        if (o.equals(btnCapNhatDia)){
            int hangChon = tbBangDia.getSelectedRow();
            if (hangChon != -1){
                new CSBangDia().datTinhTrangCacNut(false);
                int hangDuocChon = tbBangDia.getSelectedRow();
                BangDia tmp = new QuanLyBangDia(kn).getDsBangDia().get(hangDuocChon);
                CSBangDia.hienThiDuLieuDiaLenTXT(tmp);
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn đĩa cần cập nhật thông tin");
        }
        if (o.equals(btnThemNhanVien)){
            new CSNhanVien().datTinhTrangCacNut(true);
        }
        if (o.equals(btnXoaNhanVien)){
            int hangChon = tbNhanVien.getSelectedRow();
            if (hangChon != -1){
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (luaChon == 0){
                    int maNV = (Integer) tbNhanVien.getValueAt(tbNhanVien.getSelectedRow(), 0);
                    if (maNV == 1 || maNV == 2){
                        JOptionPane.showMessageDialog(this, "Bạn không đủ quyền xóa nhân viên này");
                    }
                    else {
                        kn.xoaNhanVien(maNV);
                        JOptionPane.showMessageDialog(this, "Đã xóa nhân viên có mã " + maNV);
                        capNhatDuLieuNhanVien();
                        capNhatDuLieuTaiKhoan();
                    }
                }
                else
                    JOptionPane.showMessageDialog(this, "Không xóa thì thôi vậy. Hú hồn");
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần xóa");
        }
        if (o.equals(btnCapNhatNhanVien)){
            int hangDuocChon = tbNhanVien.getSelectedRow();
            if (hangDuocChon != -1){
                if ((Integer) tbNhanVien.getValueAt(hangDuocChon, 0) == 1 || (Integer) tbNhanVien.getValueAt(hangDuocChon, 0) == 2){
                    JOptionPane.showMessageDialog(this, "Bạn không đủ quyền để thao tác với nhân viên này");
                }
                else {
                    new CSNhanVien().datTinhTrangCacNut(false);
                    NhanVien nv = new QuanLyNhanVien(kn).getDsNhanVien().get(hangDuocChon);
                    CSNhanVien.hienThiDuLieuLenTXT(nv);
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần cập nhật thông tin");
        }
        if (o.equals(btnThemKhachHang)){
            new CSKhachHang().datTinhTrangCacNut(true);
        }
        if (o.equals(btnXoaKhachHang)){
            int hangChon = tbKhachHang.getSelectedRow();
            if (hangChon != -1){
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa khách hàng này?",
                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (luaChon == 0){
                    int maKH = (Integer) tbKhachHang.getValueAt(hangChon, 0);
                    kn.xoaKhachHang(maKH);
                    JOptionPane.showMessageDialog(this, "Đã xóa nhân viên có mã " + maKH);
                    capNhatDuLieuKhachHang();
                }
                else
                    JOptionPane.showMessageDialog(this, "Không xóa thì thôi vậy. Hú hồn");
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần xóa");
        }
        if (o.equals(btnCapNhatTTKhachHang)){
            int hangDuocChon = tbKhachHang.getSelectedRow();
            if (hangDuocChon != -1){
                new CSKhachHang().datTinhTrangCacNut(false);
                KhachHang kh = new QuanLyKhachHang(kn).getDsKhachHang().get(hangDuocChon);
                CSKhachHang.hienThiThongTinKhachHang(kh);
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần cập nhật thông tin");
        }
        if (o.equals(btnCapNhatTaiKhoan)){
            int hangChon = tbTaiKhoan.getSelectedRow();
            if (hangChon != -1){
                new CSTaiKhoanNhanVien().datTinhTrangCacNut(false);
                TaiKhoan tk = new QuanLyTaiKhoan(kn).getDsTaiKhoan().get(hangChon);
                CSTaiKhoanNhanVien.hienThiDuLieuLenPF(tk);
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn tài khoản cần cập nhật");
        }
        if (o.equals(btnTaoPhieuThue)){
            new CSPhieuThue();
        }
        if (o.equals(btnXoaPhieuThue)){
            int hangChon = tbPhieuThue.getSelectedRow();
            if (hangChon != -1){
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa phiếu thuê này?",
                        "Xác nhận xóa phiếu thuê", JOptionPane.YES_NO_OPTION);
                if (luaChon == JOptionPane.YES_OPTION){
                    int maPhieu = (Integer) tbPhieuThue.getValueAt(hangChon, 0);
                    if (kn.xoaPhieuThue(maPhieu)){
                        JOptionPane.showMessageDialog(this, "Đã xóa phiếu thuê có mã " + maPhieu);
                        capNhatDuLieuPhieuThue();
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
        }
        if (o.equals(btnTaoPhieuTra)){
            new CSPhieuTra();
        }
        if (o.equals(btnXoaPhieuTra)){
            int hangChon = tbPhieuTra.getSelectedRow();
            if (hangChon != -1){
                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa phiếu trả này?",
                        "Xác nhận xóa phiếu trả", JOptionPane.YES_NO_OPTION);
                if (luaChon == JOptionPane.YES_OPTION){
                    int maPhieu = (Integer) tbPhieuTra.getValueAt(hangChon, 0);
                    if (kn.xoaPhieuTra(maPhieu)){
                        JOptionPane.showMessageDialog(this, "Đã xóa phiếu trả có mã " + maPhieu);
                        capNhatDuLieuPhieuTra();
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn phiếu cần xóa");
        }
    }

    public static void capNhatDuLieuBangDia(){
        mhBangDia = new MoHinhBangDia(new QuanLyBangDia(kn).getDsBangDia());
        tbBangDia.setModel(mhBangDia);
        tbBangDia.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuNhanVien(){
        mhNhanVien = new MoHinhNhanVien(new QuanLyNhanVien(kn).getDsNhanVien());
        tbNhanVien.setModel(mhNhanVien);
        tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuTaiKhoan(){
        mhTaiKhoan = new MoHinhTaiKhoan(new QuanLyTaiKhoan(kn).getDsTaiKhoan());
        tbTaiKhoan.setModel(mhTaiKhoan);
        tbTaiKhoan.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuKhachHang(){
        mhKhachHang = new MoHinhKhachHang(new QuanLyKhachHang(kn).getDsKhachHang());
        tbKhachHang.setModel(mhKhachHang);
        tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuDoanhThu(){
        mhDoanhThu = new MoHinhDoanhThu(new QuanLyDoanhThu(kn).getDsDoanhThu());
        tbDoanhThu.setModel(mhDoanhThu);
        tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuTheTV(){
        mhThe = new MoHinhTheThanhVien(new QuanLyThe(kn).getDsTheThanhVien());
        tbTheTV.setModel(mhThe);
        tbTheTV.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuPhieuThue(){
        mhPhieuThue = new MoHinhPhieuThue(new QuanLyPhieuThue(kn).getDsPhieuThue());
        tbPhieuThue.setModel(mhPhieuThue);
        tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void capNhatDuLieuPhieuTra(){
        mhPhieuTra = new MoHinhPhieuTra(new QuanLyPhieuTra(kn).getDsPhieuTra());
        tbPhieuTra.setModel(mhPhieuTra);
        tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
    }

    public static void themBangDia(BangDia bd){
        if (kn.themBangDia(bd)){
            JOptionPane.showMessageDialog(null, "Thêm đĩa mới thành công");
            capNhatDuLieuBangDia();
        }
        else {
            JOptionPane.showMessageDialog(null, "Đã tồn tại đĩa này trong hệ thống. Thêm đĩa thất bại");
        }
    }

    public static void capNhatDia(BangDia bd){
        int maDia = (Integer) tbBangDia.getValueAt(tbBangDia.getSelectedRow(), 0);
        if (kn.capNhatDia(maDia, bd.getTenBD(), bd.getTheLoai(), bd.getHangSX(), bd.getGhiChu(), bd.getSoLuongGoc(), bd.getDonGia(), bd.getGiaThue())){
            capNhatDuLieuBangDia();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công cho băng đĩa có mã " + maDia);
        }
    }

    public static void themNhanVien(NhanVien nv){
        if (kn.themNhanVien(nv)){
            JOptionPane.showMessageDialog(null, "Thêm nhân viên mới thành công");
            capNhatDuLieuNhanVien();
            new CSTaiKhoanNhanVien().datTinhTrangCacNut(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Nhân viên này đã tồn tại trong hệ thống");
        }
    }

    public static void capNhatNhanVien(NhanVien nv){
        int maNV = (Integer) tbNhanVien.getValueAt(tbNhanVien.getSelectedRow(), 0);
        if (kn.capNhatNhanVien(maNV, nv.getSoDT(), nv.getMoTa())){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công cho nhân viên có mà " + maNV);
            capNhatDuLieuNhanVien();
        }
    }

    public static void themKhachHang(KhachHang kh){
        kh.setMaNV(maNhanVienDangDung);
        if (kn.themKhachHang(kh)){
            JOptionPane.showMessageDialog(null, "Thêm khách hàng mới thành công");
            capNhatDuLieuKhachHang();
            kn.themTheThanhVien();
            JOptionPane.showMessageDialog(null, "Thẻ thành viên cho khách hàng đã được tạo. Hãy đợi máy in thẻ trong giây lát.");
        }
        else {
            JOptionPane.showMessageDialog(null, "Khách hàng này đã tồn tại trong hệ thống");
        }
    }

    public static void capNhatKhachHang(KhachHang kh){
        int maKH = (Integer) tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 0);
        if (kn.capNhatKhachHang(maKH, kh.getSoDT(), kh.getDiaChi())){
            JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin cho khách hàng có mã là " + maKH);
            capNhatDuLieuKhachHang();
        }
    }

    public static void themTaiKhoan(TaiKhoan tk){
        if (kn.themTaiKhoan(tk.getMatKhau())){
            JOptionPane.showMessageDialog(null, "Thêm tài khoản đăng nhập thành công");
        }
    }

    public static void capNhatMatKhau(TaiKhoan tk){
        int maTK = (Integer) tbTaiKhoan.getValueAt(tbTaiKhoan.getSelectedRow(), 0);
        if (kn.capNhatTaiKhoan(maTK, tk.getMatKhau())){
            JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu thành công");
            capNhatDuLieuTaiKhoan();
        }
    }

    public static void themPhieuThue(PhieuThue p){
        p.setMaNV(maNhanVienDangDung);
        QuanLyThe dsThe = new QuanLyThe(kn);
        if (dsThe.kiemTraThe(p.getMaThe()) == false){
            JOptionPane.showMessageDialog(null, "Không tồn tai khách hàng có mã này trong hệ thống");
        }
        else{
            QuanLyBangDia dsDia = new QuanLyBangDia(kn);
            if (dsDia.kiemTraDia(p.getMaBD())){
                if (kn.themPhieuThue(p)){
                    JOptionPane.showMessageDialog(null, "Thêm phiếu thuê thành công");
                    capNhatDuLieuPhieuThue();
                }
                else
                    JOptionPane.showMessageDialog(null, "Số lượng đĩa còn lại không đủ để đáp ứng");
            }
            else
                JOptionPane.showMessageDialog(null, "Không tồn tại đĩa nào có mã này hết trơn");
        }
    }

    public static void themPhieuTra(PhieuTra p){
        p.setMaNV(maNhanVienDangDung);
        QuanLyThe dsThe = new QuanLyThe(kn);
        if (dsThe.kiemTraThe(p.getMaThe()) == false){
            JOptionPane.showMessageDialog(null, "Không tồn tai khách hàng có mã này trong hệ thống");
        }
        else {
            QuanLyBangDia dsDia = new QuanLyBangDia(kn);
            if (dsDia.kiemTraDia(p.getMaBD())){
                if (kn.themPhieuTra(p)){
                    JOptionPane.showMessageDialog(null, "Thêm phiếu trả thành công");
                    capNhatDuLieuPhieuTra();
                }
                else
                    JOptionPane.showMessageDialog(null, "Không tồn tại phiếu thuê này trong hệ thống");
            }
            else
                JOptionPane.showMessageDialog(null, "Không tồn tại đĩa nào có mã này hết trơn");
        }
    }

    public static void xemDoanhThuTheoThang(int thang, int nam){
        double doanhThu = kn.xemDoanhThuTheoThang(thang, nam);
        Locale vn = new Locale("vi", "vn");
        NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
        JOptionPane.showMessageDialog(null, "Doanh thu của tháng " + thang + "/" + nam + " là: " + nf.format(doanhThu));
    }
}
