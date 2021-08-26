package GiaoDien.GiaoDienChinh;

import DoiTuong.*;
import GiaoDien.GiaoDienChinh.CuaSoCon.*;
import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import MoHinhDoiTuong.*;
import QuanLyDoiTuong.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class GiaoDienLon extends JFrame implements danhSachBien, ActionListener {
    public static int maNhanVienDangDung = 1;
    public JPanel pnKhungChua, pnHopCongCu, pnHopDuLieu;
    public static KetNoiToiCoSoDuLieu kn;
    public static MoHinhBangDia mhBangDia;
    public static TableRowSorter tableFilter;
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
            maNhanVienDangDung = GiaoDienDangNhap.layMaNV();
            System.out.println("Ma nhan vien dang dung: " + maNhanVienDangDung);
            phanQuyenNguoiDung(maNhanVienDangDung);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
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
        themHanhDongChoCacNut();
        themHanhDongDoubleClickChoCacJTable();
        themSuKienEnterChotxtTimKiem();
        add(pnKhungChua);
    }

    public JMenuBar thanhMenu() {
        thanhMenu.add(miBangDia);
        thanhMenu.add(miPhieuThue);
        thanhMenu.add(miPhieuTra);
        thanhMenu.add(miPhieuChuaTra);
        thanhMenu.add(miKhachHang);
        thanhMenu.add(miTheThanhVien);
        thanhMenu.add(miNhanVien);
        thanhMenu.add(miTaiKhoan);
        thanhMenu.add(miThongKe);
//        JMenu Doanh Thu
        thanhMenu.add(mnDoanhThu);
        mnDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu - 13, chieuCaoMenuBar));
        mnDoanhThu.add(miDoanhThuTrongNgay);
        miDoanhThuTrongNgay.setPreferredSize(new Dimension(chieuRongJMenu - 15, chieuCaoMenuBar));
        mnDoanhThu.add(miChiTietDoanhThu);
        miChiTietDoanhThu.setPreferredSize(new Dimension(chieuRongJMenu - 15, chieuCaoMenuBar));
//        JMenu Nang Cao
        thanhMenu.add(mnNangCao);
        mnNangCao.setPreferredSize(new Dimension(chieuRongJMenu - 13, chieuCaoMenuBar));
        mnNangCao.add(miNguoiDung);
        miNguoiDung.setPreferredSize(new Dimension(chieuRongJMenu - 15, chieuCaoMenuBar));
        mnNangCao.add(miDangXuat);
        miDangXuat.setPreferredSize(new Dimension(chieuRongJMenu - 15, chieuCaoMenuBar));
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
        miThongKe.addActionListener(this);
        miPhieuChuaTra.addActionListener(this);
        return thanhMenu;
    }

    public void phanQuyenNguoiDung(int maNV){
        if (maNV != 1 && maNV != 2){
            miTaiKhoan.setEnabled(false);
            btnXoaNhanVien.setEnabled(false);
            btnCapNhatNhanVien.setEnabled(false);
            btnCapNhatTaiKhoan.setEnabled(false);
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
        hopCCBangDia.setLayout(new FlowLayout(1, 40, 10));
        hopCCBangDia.add(btnThemDia);
        btnThemDia.setFocusable(false);
        hopCCBangDia.add(btnXoaDia);
        btnXoaDia.setFocusable(false);
        hopCCBangDia.add(btnCapNhatDia);
        btnCapNhatDia.setFocusable(false);
        hopCCBangDia.add(btnXemDuLieuDia);
        btnXemDuLieuDia.setFocusable(false);
        hopCCBangDia.add(cbSapXepDia);
        cbSapXepDia.setPreferredSize(new Dimension(200, 50));
        hopCCBangDia.add(txtTimBangDia);
        tuyChinhJTextField(txtTimBangDia, 300, 50, "Nhập mã băng đĩa cần tìm", Color.black);
        hopCCBangDia.setBackground(toolBarBgr);
        tuyChinhJPanel(hopCCBangDia, chieuRongGiaoDien, chieuCaoHopCongCu, toolBarBgr);
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
        tuyChinhJPanel(hopDuLieuDia, chieuRongBangDuLieu, chieuCaoHopDuLieu, Color.WHITE);
    }

    public void themHanhDongChoCacNut(){
        btnThemDia.addActionListener(this);
        btnXoaDia.addActionListener(this);
        btnCapNhatDia.addActionListener(this);
        btnXemDuLieuDia.addActionListener(this);
        btnTaoPhieuThue.addActionListener(this);
        btnTimPhieuThue.addActionListener(this);
        btnXemPhieuChuaTra.addActionListener(this);
        btnTaoPhieuTra.addActionListener(this);
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
        btnThongKeDuLieu.addActionListener(this);
        btnXemDiaBanChay.addActionListener(this);
        btnXemDiaBanE.addActionListener(this);
        btnXemKhachTreDia.addActionListener(this);
        btnXemNhanVienGioi.addActionListener(this);
        btnXemDiaRe.addActionListener(this);
        cbSapXepDia.addActionListener(this);
        btnThongKeKH.addActionListener(this);
        cbSapXepPThue.addActionListener(this);
        btnThongKeDoanhThu.addActionListener(this);
        btnThongKeNV.addActionListener(this);
        btnThongKeTaiKhoan.addActionListener(this);
        btnThongKePCT.addActionListener(this);
        btnThongKePTra.addActionListener(this);
        btnThongKePT.addActionListener(this);
        cbSapXepGiaoDich.addActionListener(this);
        cbSapXepTaiKhoan.addActionListener(this);
        cbSapXepNV.addActionListener(this);
        cbSapXepKhachHang.addActionListener(this);
        cbSapXepThe.addActionListener(this);
        cbSapXepPhieuTra.addActionListener(this);
        cbSapXepPCT.addActionListener(this);
        btnDSPhieuTre.addActionListener(this);
        btnThongKeThe.addActionListener(this);
        btnInDuLieuTbSangExcel.addActionListener(this);
    }

    public void themSuKienEnterChotxtTimKiem(){
        tbBangDia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbBangDia.getSelectedRow();
                if (e.getButton() == MouseEvent.BUTTON3 && row != -1){
                    int maDia = (Integer) tbBangDia.getValueAt(row, 0);
                    CSPhieuThue cs = new CSPhieuThue();
                    cs.datTinhTrangChoNut(true);
                    cs.ganGiaTriChoTxtMaDia(maDia);
                }
            }
        });
        txtTimBangDia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tableFilter = new TableRowSorter(mhBangDia);
                tbBangDia.setRowSorter(tableFilter);
                tableFilter.setRowFilter(RowFilter.regexFilter(txtTimBangDia.getText().trim()));
            }

        });
        txtTimPhieuTra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuPhieuTra();
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timPhieuTra();
            }
        });
        txtTimPhieuChuaTra.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuPhieuChuaTra();
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timPhieuChuaTra();
            }
        });
        txtTimPhieuThue.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timPhieuThue();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuPhieuThue();
            }
        });
        txtTimKhachHang.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuKhachHang();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                tableFilter = new TableRowSorter(mhKhachHang);
                tbKhachHang.setRowSorter(tableFilter);
                tableFilter.setRowFilter(RowFilter.regexFilter(txtTimKhachHang.getText().trim()));
            }
        });
        txtTimTheTV.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuTheTV();
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timTheThanhVien();
            }
        });
        txtTimTaiKhoan.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timTaiKhoan();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuTaiKhoan();
            }
        });
        txtTimNhanVien.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timNhanVien();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuNhanVien();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                tableFilter = new TableRowSorter(mhNhanVien);
                tableFilter.setRowFilter(RowFilter.regexFilter(txtTimNhanVien.getText().trim()));
                tbNhanVien.setRowSorter(tableFilter);
            }
        });
        txtTimGiaoDich.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    timDoanhThu();
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    capNhatDuLieuDoanhThu();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                tableFilter = new TableRowSorter(mhDoanhThu);
                tbDoanhThu.setRowSorter(tableFilter);
                tableFilter.setRowFilter(RowFilter.regexFilter(txtTimGiaoDich.getText().trim()));
            }
        });
        txtTimGiaoDich.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1){
                    txtTimGiaoDich.setText("");
                }
            }
        });
    }

    public void themHanhDongDoubleClickChoCacJTable(){
        themSuKienDoubleClickChoTBPhieuTra();
        themSuKienDoubleClickChoTBPhieuChuaTra();
        themSuKienDoubleClickChoTBNhanVien();
        themSuKienDoubleClickChoTBKhachHang();
        themSuKienDoubleClickChoTBBangDia();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(miBangDia)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnThemDia);
            btnThemDia.setFocusable(false);
            pnHopCongCu.add(btnXoaDia);
            btnXoaDia.setFocusable(false);
            pnHopCongCu.add(btnCapNhatDia);
            btnCapNhatDia.setFocusable(false);
            pnHopCongCu.add(cbSapXepDia);
            cbSapXepDia.setPreferredSize(new Dimension(200, 50));
            pnHopCongCu.add(btnXemDuLieuDia);
            btnXemDuLieuDia.setFocusable(false);
            pnHopCongCu.add(txtTimBangDia);
            tuyChinhJTextField(txtTimBangDia, 200, 50, "Nhập mã hoặc tên băng đĩa cần tìm", Color.black);
            btnTimDia.setFocusable(false);
            pnHopCongCu.revalidate();
//            Hop du lieu
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuBangDia();
            scrPaneBangDia.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneBangDia);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miPhieuThue)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnTaoPhieuThue);
            btnTaoPhieuThue.setFocusable(false);
            pnHopCongCu.add(cbSapXepPThue);
            cbSapXepPThue.setPreferredSize(new Dimension(220, 50));
            pnHopCongCu.add(btnThongKePT);
            btnThongKePT.setFocusable(false);
            pnHopCongCu.add(txtTimPhieuThue);
            tuyChinhJTextField(txtTimPhieuThue, 300, 50, "Nhập số CMDN khách hàng cần tìm", Color.black);
            pnHopCongCu.add(btnTimPhieuThue);
            btnTimPhieuThue.setFocusable(false);
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuPhieuThue();
            scrPanePhieuThue.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuThue);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miPhieuTra)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnTaoPhieuTra);
            btnTaoPhieuTra.setFocusable(false);
            pnHopCongCu.add(cbSapXepPhieuTra);
            cbSapXepPhieuTra.setPreferredSize(new Dimension(220, 50));
            pnHopCongCu.add(btnThongKePTra);
            btnThongKePTra.setFocusable(false);
            pnHopCongCu.add(txtTimPhieuTra);
            tuyChinhJTextField(txtTimPhieuTra, 300, 50, "Nhập số CMDN của khách hàng cần tìm", Color.black);
            pnHopCongCu.add(btnTimPhieuTra);
            btnTimPhieuTra.setFocusable(false);
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuPhieuTra();
            scrPanePhieuTra.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuTra);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miPhieuChuaTra)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnDSPhieuTre);
            btnDSPhieuTre.setFocusable(false);
            pnHopCongCu.add(cbSapXepPCT);
            cbSapXepPCT.setPreferredSize(new Dimension(220, 50));
            pnHopCongCu.add(btnThongKePCT);
            btnThongKePCT.setFocusable(false);
            pnHopCongCu.add(txtTimPhieuChuaTra);
            tuyChinhJTextField(txtTimPhieuChuaTra, 300, 50, "Nhập số CMND của khách hàng cần tìm", Color.black);
            pnHopCongCu.add(btnTimPhieuChuaTra);
            btnTimPhieuChuaTra.setFocusable(false);
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuPhieuChuaTra();
            scrPanePhieuChuaTra.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPanePhieuChuaTra);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miKhachHang)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnThemKhachHang);
            btnThemKhachHang.setFocusable(false);
            pnHopCongCu.add(btnXoaKhachHang);
            btnXoaKhachHang.setFocusable(false);
            pnHopCongCu.add(btnCapNhatTTKhachHang);
            btnCapNhatTTKhachHang.setFocusable(false);
            pnHopCongCu.add(cbSapXepKhachHang);
            cbSapXepKhachHang.setPreferredSize(new Dimension(225, 50));
            pnHopCongCu.add(btnThongKeKH);
            btnThongKeKH.setFocusable(false);
            pnHopCongCu.add(txtTimKhachHang);
            tuyChinhJTextField(txtTimKhachHang, 200, 50, "Nhập số CMND của khách hàng cần tìm", Color.black);
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuKhachHang();
            scrPaneKhachHang.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneKhachHang);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miTheThanhVien)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnCapNhatTheTV);
            btnCapNhatTheTV.setFocusable(false);
            pnHopCongCu.add(cbSapXepThe);
            cbSapXepThe.setPreferredSize(new Dimension(240, 50));
            pnHopCongCu.add(btnThongKeThe);
            btnThongKeThe.setFocusable(false);
            pnHopCongCu.add(txtTimTheTV);
            tuyChinhJTextField(txtTimTheTV, 300, 50, "Nhập số CMND khách hàng cần tìm thẻ", Color.black);
            pnHopCongCu.revalidate();
//
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuTheTV();
            scrPaneTheTV.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneTheTV);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miNhanVien)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnThemNhanVien);
            btnThemNhanVien.setFocusable(false);
            pnHopCongCu.add(btnXoaNhanVien);
            btnXoaNhanVien.setFocusable(false);
            pnHopCongCu.add(btnCapNhatNhanVien);
            btnCapNhatNhanVien.setFocusable(false);
            pnHopCongCu.add(cbSapXepNV);
            cbSapXepNV.setPreferredSize(new Dimension(190, 50));
            pnHopCongCu.add(btnThongKeNV);
            btnThongKeNV.setFocusable(false);
            pnHopCongCu.add(txtTimNhanVien);
            tuyChinhJTextField(txtTimNhanVien, 300, 50, "Nhập số điện thoại của nhân viên cần tìm", Color.black);
            pnHopCongCu.revalidate();
//            Hop Du Lieu Nhan Vien
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuNhanVien();
            scrPaneNhanVien.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneNhanVien);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miTaiKhoan)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnCapNhatTaiKhoan);
            btnCapNhatTaiKhoan.setFocusable(false);
            pnHopCongCu.add(cbSapXepTaiKhoan);
            cbSapXepTaiKhoan.setPreferredSize(new Dimension(230, 50));
            pnHopCongCu.add(btnThongKeTaiKhoan);
            btnThongKeTaiKhoan.setFocusable(false);
            pnHopCongCu.add(txtTimTaiKhoan);
            tuyChinhJTextField(txtTimTaiKhoan, 300, 50, "Nhập số điện thoại của cần tìm", Color.black);
            pnHopCongCu.add(btnTimTaiKhoan);
            btnTimTaiKhoan.setFocusable(false);
            pnHopCongCu.revalidate();
//            Hop du lieu tai khoan
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuTaiKhoan();
            scrPaneTaiKhoan.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneTaiKhoan);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(miThongKe)){
            pnHopCongCu.removeAll();
            pnHopCongCu.repaint();
            pnHopCongCu.revalidate();
            pnHopCongCu.setPreferredSize(new Dimension(0, 0));
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout(1, 150, 80));
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, (chieuCaoHopDuLieu + chieuCaoHopCongCu)));
            pnHopDuLieu.add(btnThongKeDuLieu);
            btnThongKeDuLieu.setFocusable(false);
            btnThongKeDuLieu.setFont(fontBtnThongKe);
            btnThongKeDuLieu.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnInDuLieuTbSangExcel);
            btnInDuLieuTbSangExcel.setFocusable(false);
            btnInDuLieuTbSangExcel.setFont(fontBtnThongKe);
            btnInDuLieuTbSangExcel.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnXemDiaBanChay);
            btnXemDiaBanChay.setFocusable(false);
            btnXemDiaBanChay.setFont(fontBtnThongKe);
            btnXemDiaBanChay.setPreferredSize(kichThuocBTNThongKe);
            btnXemDiaBanE.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnXemKhachTreDia);
            btnXemKhachTreDia.setFocusable(false);
            btnXemKhachTreDia.setFont(fontBtnThongKe);
            btnXemKhachTreDia.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnXemNhanVienGioi);
            btnXemNhanVienGioi.setFocusable(false);
            btnXemNhanVienGioi.setFont(fontBtnThongKe);
            btnXemNhanVienGioi.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnXemDiaRe);
            btnXemDiaRe.setFocusable(false);
            btnXemDiaRe.setFont(fontBtnThongKe);
            btnXemDiaRe.setPreferredSize(kichThuocBTNThongKe);
            pnHopDuLieu.add(btnXemDiaBanE);
            btnXemDiaBanE.setFocusable(false);
            btnXemDiaBanE.setFont(fontBtnThongKe);
            btnXemDiaBanE.setPreferredSize(kichThuocBTNThongKe);
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
            pnHopCongCu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopCongCu));
            pnHopCongCu.add(btnXemDoanhThuThangHienTai);
            btnXemDoanhThuThangHienTai.setFocusable(false);
            pnHopCongCu.add(btnXemDoanhThuTheoThang);
            btnXemDoanhThuTheoThang.setFocusable(false);
            pnHopCongCu.add(cbSapXepGiaoDich);
            cbSapXepGiaoDich.setPreferredSize(new Dimension(200, 50));
            pnHopCongCu.add(btnThongKeDoanhThu);
            btnThongKeDoanhThu.setFocusable(false);
            pnHopCongCu.add(txtTimGiaoDich);
            txtTimGiaoDich.setText("dd/MM/YYYY");
            txtTimGiaoDich.selectAll();
            tuyChinhJTextField(txtTimGiaoDich, 300, 50, "Nhập thông tin bạn có về giao dịch", Color.black);
            pnHopCongCu.revalidate();
//            Hop du lieu doanh thu
            pnHopDuLieu.removeAll();
            pnHopDuLieu.repaint();
            pnHopDuLieu.setLayout(new FlowLayout());
            pnHopDuLieu.setPreferredSize(new Dimension(chieuRongGiaoDien, chieuCaoHopDuLieu));
            capNhatDuLieuDoanhThu();
            scrPaneDoanhThu.setPreferredSize(new Dimension(chieuRongBangDuLieu, chieuCaoHopDuLieu));
            pnHopDuLieu.add(scrPaneDoanhThu);
            pnHopDuLieu.revalidate();
        }
        if (o.equals(btnXemDoanhThuThangHienTai)){
            double doanhThuThangNay = kn.xemDoanhThuThangHienTai();
            Locale vn = new Locale("vi", "vn");
            NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance(new Locale("vi", "vn"));
            cal.setTime(currentDate);
            int month = cal.get(cal.MONTH) + 1;
            int year = cal.get(cal.YEAR);
            JOptionPane.showMessageDialog(this, "Doanh thu tháng " + month +"/" + year + " cho đến giờ là " + nf.format(doanhThuThangNay));
        }
        if (o.equals(btnXemDoanhThuTheoThang)){
            new CSXemDoanhThuTheoThang();
        }
        if (o.equals(miNguoiDung)){
            try {
                NhanVien nv = kn.xacDinhNhanVienDangDung(maNhanVienDangDung);
                String chucVu = (nv.getID() == 1 || nv.getID() == 2) ? "Quản trị viên" : "Nhân viên";
                JOptionPane.showMessageDialog(this,"Hệ thống đang được dùng bởi: \n\n- " + chucVu + ": " + nv.getTen() + "\n\n- Có mã nhân viên là: " + nv.getID() + "\n\n");
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        if (o.equals(miDangXuat)){
            kn.ngatKetNoiToiCSDL();
            System.exit(0);
        }
        if (o.equals(btnThemDia)){
            new CSBangDia().datTinhTrangCacNut(1);
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
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn đĩa cần xóa");
        }
        if (o.equals(btnCapNhatDia)){
            int hangChon = tbBangDia.getSelectedRow();
            if (hangChon != -1){
                new CSBangDia().datTinhTrangCacNut(2);
                int hangDuocChon = tbBangDia.getSelectedRow();
                BangDia tmp = new QuanLyBangDia(kn).getDsBangDia().get(hangDuocChon);
                CSBangDia.hienThiDuLieuDiaLenTXT(tmp);
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn đĩa cần cập nhật thông tin");
        }
        if (o.equals(btnXemDuLieuDia)){
            QuanLyBangDia ql = new QuanLyBangDia(kn);
            if (ql.doLonDuLieu() == 0)
                JOptionPane.showMessageDialog(this, "Chưa có băng đĩa nào được lưu trong hệ thống");
            else {
                double[] giaThue = ql.xemHaiCucGiaThue();
                double[] donGia = ql.xemHaiCucDonGia();
                int soHangSX = ql.tinhSoHangSX();
                int soTheLoai = ql.tinhSoTheLoai();
                int soDia = ql.doLonDuLieu();
                Locale vn = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
                String s1 = "\n- Hệ thống đang lưu trữ tổng cộng:    " + soDia + " băng đĩa\n\n";
                String s2 = "- Đơn giá đĩa cao nhất là:                       " + nf.format(donGia[0]) + "\n\n";
                String s3 = "- Đơn giá đĩa thấp nhất là:                      " + nf.format(donGia[1]) + "\n\n";
                String s4 = "- Giá thuê đĩa cao nhất là:                      " + nf.format(giaThue[0]) + "\n\n";
                String s5 = "- Giá thuê đĩa thấp nhất là:                     " + nf.format(giaThue[1]) + "\n\n";
                String s6 = "- Các băng đĩa thuộc:                             " + soTheLoai + " thể loại\n\n";
                String s7 = "- Các băng đĩa đến từ:                            " + soHangSX + " hãng sản xuất\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5+s6+s7);
            }
        }
        if (o.equals(btnThemNhanVien)){
            new CSNhanVien().datTinhTrangCacNut(1);
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
                    new CSNhanVien().datTinhTrangCacNut(2);
                    NhanVien nv = new QuanLyNhanVien(kn).getDsNhanVien().get(hangDuocChon);
                    CSNhanVien.hienThiDuLieuLenTXT(nv);
                }
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn nhân viên cần cập nhật thông tin");
        }
        if (o.equals(btnThemKhachHang)){
            new CSKhachHang().datTinhTrangCacNut(1);
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
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần xóa");
        }
        if (o.equals(btnCapNhatTTKhachHang)){
            int hangDuocChon = tbKhachHang.getSelectedRow();
            if (hangDuocChon != -1){
                new CSKhachHang().datTinhTrangCacNut(2);
                KhachHang kh = new QuanLyKhachHang(kn).getDsKhachHang().get(hangDuocChon);
                CSKhachHang.hienThiThongTinKhachHang(kh);
            }
            else
                JOptionPane.showMessageDialog(this, "Hãy chọn khách hàng cần cập nhật thông tin");
        }
        if (o.equals(btnThongKeKH)){
            QuanLyKhachHang ql = new QuanLyKhachHang(kn);
            if (ql.doLonDuLieu() == 0)
                JOptionPane.showMessageDialog(this, "Chưa có khách hàng nào để thống kê");
            else{
                int[] phanLoaiKH = ql.tinhSoKhachTheoGioiTinh();
                String[] khThueNhieuNhat = ql.timKhachSop(kn);
                int soKhachKhongThue = new QuanLyThe(kn).tinhSoKhachKhongThueDia(kn);
                String s1 = "\n- Hệ thống đang lưu trữ:                                            " + ql.doLonDuLieu() + " khách hàng\n\n";
                String s2 = "- Số lượng khách hàng Nam là :                              " + phanLoaiKH[0]  + " khách hàng\n\n";
                String s3 = "- Số lượng khách hàng nữ là:                                  " + phanLoaiKH[1] + " khách hàng\n\n";
                String s4 = "- Khách hàng thuê nhiều nhất tên là:                      " + khThueNhieuNhat[0] + " với " + khThueNhieuNhat[1] + " đĩa\n\n";
                String s5 = "- Số khách hàng chưa từng thuê đĩa là:                  " + soKhachKhongThue + " khách hàng\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5);
            }
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
        if (o.equals(btnTaoPhieuTra)){
            new CSPhieuTra();
        }
        if (o.equals(btnTimPhieuThue)){
            timPhieuThue();
        }
        if (o.equals(btnTimPhieuTra)){
            timPhieuTra();
        }
        if (o.equals(btnTimKhachHang)){
            timKhachHang();
        }
        if (o.equals(btnTimNhanVien)){
            timNhanVien();
        }
        if (o.equals(btnTimTheTV)){
            timTheThanhVien();
        }
        if (o.equals(btnTimTaiKhoan)){
            timTaiKhoan();
        }
        if (o.equals(btnTimGiaoDich)){
            timDoanhThu();
        }
        if (o.equals(btnThongKeDuLieu)){
            int soDia = new QuanLyBangDia(kn).getDsBangDia().size();
            int soPhieuThue = new QuanLyPhieuThue(kn).getDsPhieuThue().size();
            int soPhieuTra = new QuanLyPhieuTra(kn).getDsPhieuTra().size();
            int soKhachHang = new QuanLyKhachHang(kn).getDsKhachHang().size();
            int soGiaoDich = new QuanLyDoanhThu(kn).getDsDoanhThu().size();
            int soNhanVien = new QuanLyNhanVien(kn).getDsNhanVien().size();
            int soTK = new QuanLyTaiKhoan(kn).getDsTaiKhoan().size();
            String thongBao = "\n\nHệ thống đang lưu trữ:\n\n" +
                    "- " + soDia + " băng đĩa\n\n" +
                    "- " + soPhieuThue + " phiếu thuê\n\n" +
                    "- " + soPhieuTra + " phiếu trả\n\n" +
                    "- " + soKhachHang + " khách hàng\n\n" +
                    "- " + soNhanVien + " nhân viên\n\n" +
                    "- " + soTK + " tài khoản nhân viên\n\n" +
                    "- " + soGiaoDich + " giao dịch tạo ra doanh thu\n\n";
            JOptionPane.showMessageDialog(this, thongBao);
        }
        if (o.equals(btnInDuLieuTbSangExcel)){
            new CSXuatSangExcel();
        }
        if (o.equals(btnXemDiaBanChay)){
            new CSDiaBanChay();
        }
        if (o.equals(btnXemKhachTreDia)){
            if (new QuanLyPhieuThue(kn).getDsPhieuThue().size() != 0){
                ArrayList<Integer> dsMaKhach = kn.xemTop10KhachTreTraDia();
                if (dsMaKhach.size() == 0){
                    JOptionPane.showMessageDialog(this, "Không khách hàng nào trả đĩa trễ");
                }
                else {
                    String dsMaKH = "";
                    for (Integer i : dsMaKhach)
                        if (i != null)
                            dsMaKH += i + "\n";
                    JOptionPane.showMessageDialog(this, "Top 10 khách xù đĩa lâu nhất (theo thứ tự giảm dần số ngày xù) có mã là: \n" + dsMaKH);
                }
            }
             else
                 JOptionPane.showMessageDialog(this, "Chưa có khách nào thuê đĩa trong tháng này");
        }
        if (o.equals(btnXemNhanVienGioi)){
            new CSNhanVienGioi();
        }
        if (o.equals(btnXemDiaRe)){
            new CSDiaDeThue();
        }
        if (o.equals(btnXemDiaBanE)){
            new CSDiaE();
        }
        if (o.equals(cbSapXepDia)){
            int luaChon = cbSapXepDia.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyBangDia ql = new QuanLyBangDia(kn);
                    mhBangDia = new MoHinhBangDia(ql.getDsBangDia());
                    tbBangDia.setModel(mhBangDia);
                    tbBangDia.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyBangDia ql = new QuanLyBangDia(kn);
                    ql.sapXepDonGiaTangDan();
                    mhBangDia = new MoHinhBangDia(ql.getDsBangDia());
                    tbBangDia.setModel(mhBangDia);
                    tbBangDia.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyBangDia ql = new QuanLyBangDia(kn);
                    ql.sapXepDonGiaGiamDan();
                    mhBangDia = new MoHinhBangDia(ql.getDsBangDia());
                    tbBangDia.setModel(mhBangDia);
                    tbBangDia.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyBangDia ql = new QuanLyBangDia(kn);
                    ql.sapXepGiaThueTangDan();
                    mhBangDia = new MoHinhBangDia(ql.getDsBangDia());
                    tbBangDia.setModel(mhBangDia);
                    tbBangDia.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyBangDia ql = new QuanLyBangDia(kn);
                    ql.sapXepGiaThueGiamDan();
                    mhBangDia = new MoHinhBangDia(ql.getDsBangDia());
                    tbBangDia.setModel(mhBangDia);
                    tbBangDia.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepPThue)){
            int luaChon = cbSapXepPThue.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuThue());
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
                    ql.sapXepTangDanNgayLap();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuThue());
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
                    ql.sapXepGiamDanNgayLap();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuThue());
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
                    ql.sapXepTangDanThanhTien();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuThue());
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
                    ql.sapXepGiamDanThanhTien();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuThue());
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepPhieuTra)){
            int luaChon = cbSapXepPhieuTra.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
                    mhPhieuTra = new MoHinhPhieuTra(ql.getDsPhieuTra());
                    tbPhieuTra.setModel(mhPhieuTra);
                    tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
                    ql.sapXepTangDanTheoMaPhieuThue();
                    mhPhieuTra = new MoHinhPhieuTra(ql.getDsPhieuTra());
                    tbPhieuTra.setModel(mhPhieuTra);
                    tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
                    ql.sapXepGiamDanTheoMaPhieuThue();
                    mhPhieuTra = new MoHinhPhieuTra(ql.getDsPhieuTra());
                    tbPhieuTra.setModel(mhPhieuTra);
                    tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
                    ql.sapXepTangDanTheoMaDiaThue();
                    mhPhieuTra = new MoHinhPhieuTra(ql.getDsPhieuTra());
                    tbPhieuTra.setModel(mhPhieuTra);
                    tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
                    ql.sapXepGiamDanTheoMaDiaThue();
                    mhPhieuTra = new MoHinhPhieuTra(ql.getDsPhieuTra());
                    tbPhieuTra.setModel(mhPhieuTra);
                    tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepPCT)){
            int luaChon = cbSapXepPCT.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXepTangDanNgayThue();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXepGiamDanNgayThue();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXepTangDanThanhTien();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXepGiamDanThanhTien();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 5:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXemTangDanNgayHetHan();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 6:{
                    QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
                    ql.sapXemGiamDanNgayHetHan();
                    mhPhieuThue = new MoHinhPhieuThue(ql.getDsPhieuChuaTra());
                    tbPhieuChuaTra.setModel(mhPhieuThue);
                    tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepKhachHang)){
            int luaChon = cbSapXepKhachHang.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyKhachHang ql = new QuanLyKhachHang(kn);
                    mhKhachHang = new MoHinhKhachHang(ql.getDsKhachHang());
                    tbKhachHang.setModel(mhKhachHang);
                    tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyKhachHang ql = new QuanLyKhachHang(kn);
                    ql.sapXepTangDanTheoTen();
                    mhKhachHang = new MoHinhKhachHang(ql.getDsKhachHang());
                    tbKhachHang.setModel(mhKhachHang);
                    tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyKhachHang ql = new QuanLyKhachHang(kn);
                    ql.sapXepGiamDanTheoTen();
                    mhKhachHang = new MoHinhKhachHang(ql.getDsKhachHang());
                    tbKhachHang.setModel(mhKhachHang);
                    tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyKhachHang ql = new QuanLyKhachHang(kn);
                    ql.sapXepGiamDanTheoMa();
                    mhKhachHang = new MoHinhKhachHang(ql.getDsKhachHang());
                    tbKhachHang.setModel(mhKhachHang);
                    tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepThe)){
            int luaChon = cbSapXepThe.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepTangDanTheoMaKH();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepGiamDanTheoMaKH();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepTangDanTheoNgayLapThe();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepGiamDanTheoNgayLapThe();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 5:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepTangDanTheoNgayHetHan();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 6:{
                    QuanLyThe ql = new QuanLyThe(kn);
                    ql.sapXepGiamDanTheoNgayHetHan();
                    mhThe = new MoHinhTheThanhVien(ql.getDsTheThanhVien());
                    tbTheTV.setModel(mhThe);
                    tbTheTV.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepNV)){
            int luaChon = cbSapXepNV.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyNhanVien ql = new QuanLyNhanVien(kn);
                    mhNhanVien = new MoHinhNhanVien(ql.getDsNhanVien());
                    tbNhanVien.setModel(mhNhanVien);
                    tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyNhanVien ql = new QuanLyNhanVien(kn);
                    ql.sapXepTangDanTheoTenNV();
                    mhNhanVien = new MoHinhNhanVien(ql.getDsNhanVien());
                    tbNhanVien.setModel(mhNhanVien);
                    tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyNhanVien ql = new QuanLyNhanVien(kn);
                    ql.sapXepGiamDanTheoTenNV();
                    mhNhanVien = new MoHinhNhanVien(ql.getDsNhanVien());
                    tbNhanVien.setModel(mhNhanVien);
                    tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyNhanVien ql = new QuanLyNhanVien(kn);
                    ql.sapXepGiamDanTheoMaNV();
                    mhNhanVien = new MoHinhNhanVien(ql.getDsNhanVien());
                    tbNhanVien.setModel(mhNhanVien);
                    tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepTaiKhoan)){
            int luaChon = cbSapXepTaiKhoan.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyTaiKhoan ql = new QuanLyTaiKhoan(kn);
                    mhTaiKhoan = new MoHinhTaiKhoan(ql.getDsTaiKhoan());
                    tbTaiKhoan.setModel(mhTaiKhoan);
                    tbTaiKhoan.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyTaiKhoan ql = new QuanLyTaiKhoan(kn);
                    ql.sapXepTangDanTheoTenDN();
                    mhTaiKhoan = new MoHinhTaiKhoan(ql.getDsTaiKhoan());
                    tbTaiKhoan.setModel(mhTaiKhoan);
                    tbTaiKhoan.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyTaiKhoan ql = new QuanLyTaiKhoan(kn);
                    ql.sapXepGiamDanTheoTenDN();
                    mhTaiKhoan = new MoHinhTaiKhoan(ql.getDsTaiKhoan());
                    tbTaiKhoan.setModel(mhTaiKhoan);
                    tbTaiKhoan.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(cbSapXepGiaoDich)){
            int luaChon = cbSapXepGiaoDich.getSelectedIndex();
            switch (luaChon){
                case 0:{
                    QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
                    mhDoanhThu = new MoHinhDoanhThu(ql.getDsDoanhThu());
                    tbDoanhThu.setModel(mhDoanhThu);
                    tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 1:{
                    QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
                    ql.sapXepTangDanTheoMaPhieu();
                    mhDoanhThu = new MoHinhDoanhThu(ql.getDsDoanhThu());
                    tbDoanhThu.setModel(mhDoanhThu);
                    tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 2:{
                    QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
                    ql.sapXepGiamDanTheoMaPhieu();
                    mhDoanhThu = new MoHinhDoanhThu(ql.getDsDoanhThu());
                    tbDoanhThu.setModel(mhDoanhThu);
                    tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 3:{
                    QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
                    ql.sapXepTangDanTheoSoTien();
                    mhDoanhThu = new MoHinhDoanhThu(ql.getDsDoanhThu());
                    tbDoanhThu.setModel(mhDoanhThu);
                    tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
                case 4:{
                    QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
                    ql.sapXepGiamDanTheoSoTien();
                    mhDoanhThu = new MoHinhDoanhThu(ql.getDsDoanhThu());
                    tbDoanhThu.setModel(mhDoanhThu);
                    tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
                    break;
                }
            }
        }
        if (o.equals(btnThongKePT)){
            QuanLyPhieuThue ql = new QuanLyPhieuThue(kn);
            if (ql.getDsPhieuThue().size() == 0)
                JOptionPane.showMessageDialog(this, "Không tồn tại phiếu thuê nào trong hệ thống");
            else {
                int doLonDuLieu = ql.doLonDuLieu();
                DateFormat df = DateFormat.getDateInstance(1, new Locale("vi", "vn"));
                Locale vn = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
                int slDiaDuocThue = ql.timSoLuongDiaDuocThue();
                Date ngayLapSomNhat = ql.layNgayLapPTSomNhat();
                double tongDoanhThu = ql.tinhDoanhThuTongCong();
                int slKhachThue = ql.tinhSoLuongKhachDaThueDia();
                int soMaDiaDuocThue = ql.tinhSoMaDiaDuocThue();
                String s1 = "\n\n- Hệ thống hiện đang lưu trữ:                                " + doLonDuLieu + " phiếu thuê";
                String s2 = "\n\n- Phiếu thuê đầu tiên được lập vào ngày:          " + df.format(ngayLapSomNhat);
                String s3 = "\n\n- Số lượng đĩa đã được thuê:                                 " + slDiaDuocThue;
                String s4 = "\n\n- Tổng doanh thu từ hoạt động cho thuê là:        " + nf.format(tongDoanhThu);
                String s5 = "\n\n- Số mã đĩa đã được cho thuê:                                " + soMaDiaDuocThue + "\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5);
            }
        }
        if (o.equals(btnThongKePTra)){
            QuanLyPhieuTra ql = new QuanLyPhieuTra(kn);
            if (ql.getDsPhieuTra().size() == 0){
                JOptionPane.showMessageDialog(this, "Chưa có đĩa nào được trả");
            }
            else {
                Locale vn = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
                int doLonDuLieu = ql.doLonDuLieu();
                double soTienPhat = ql.soTienPhat();
                int soPhieuTraHong = ql.soPhieuTraDiaHong();
                String s1 = "\n\n- Hệ thống đang lưu trữ:        " + doLonDuLieu + " phiếu trả";
                String s2 = "\n\n- Số tiền phạt tổng cộng:        " + nf.format(soTienPhat);
                String s3 = "\n\n- Số phiếu trả đĩa hỏng là:         " + soPhieuTraHong + "\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3);
            }
        }
        if (o.equals(btnDSPhieuTre)){
            QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
            if (ql.dsPhieuQuaHan().size() == 0)
                JOptionPane.showMessageDialog(this, "Không phiếu nào bị trễ hạn");
            else{
                mhPhieuThue = new MoHinhPhieuThue(new QuanLyPhieuChuaTra(kn).dsPhieuQuaHan());
                tbPhieuChuaTra.setModel(mhPhieuThue);
                tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
            }
        }
        if (o.equals(btnThongKePCT)){
            QuanLyPhieuChuaTra ql = new QuanLyPhieuChuaTra(kn);
            if (ql.getDsPhieuChuaTra().size() == 0){
                JOptionPane.showMessageDialog(this, "Các đĩa đều đã được trả");
            }
            else{
                int doLonDuLieu = ql.doLonDuLieu();
                int soPhieuTreHan = ql.soPhieuTreHan();
                int soDiaTreHan = ql.soDiaTreHan();
                int soMaDiaTre = ql.soMaDiaTreHan(ql.dsPhieuQuaHan());
                String ngayTreHanNhat = ql.diaTreHanNhat();
                String s1 = "\n\n- Hệ thống đang ghi nhận:                             " + doLonDuLieu + " phiếu chưa trả";
                String s2 = "\n\n- Số phiếu đang trễ hạn là:                           " + soPhieuTreHan + " phiếu";
                String s3 = "\n\n- Số lượng đĩa đang trễ hạn là:                    " + soDiaTreHan + " đĩa";
                String s4 = "\n\n- Số mã đĩa đang trễ hạn là:                         " + soMaDiaTre + "\n\n";
                String s5 = "- Phiếu thuê trễ nhất hết hạn từ ngày:      " + ngayTreHanNhat + "\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5);
            }
        }
        if (o.equals(btnCapNhatTheTV)){
            String tmp = JOptionPane.showInputDialog(this, "Nhập số CMND của khách hàng cần cấp lại thẻ: ");
            String soCMND = tmp.trim();
            KhachHang kh = new QuanLyKhachHang(kn).timKhachHang(soCMND);
            if (kh == null)
                JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng nào có số CMND này trong hệ thống");
            else {
                QuanLyThe qlThe = new QuanLyThe(kn);
                TheThanhVien the = qlThe.timTheThanhVien(kh.getID());
                if (the != null){
                    int luaChon = JOptionPane.showConfirmDialog(this, "Khách hàng này đã có thẻ rồi. Bạn chắc chắn muốn cấp lại thẻ cho họ chứ?",
                            "Xác nhận cấp lại thẻ", JOptionPane.YES_NO_OPTION);
                    if (luaChon == 0){
                        kn.taiTaoThe(kh.getID());
                        JOptionPane.showMessageDialog(this, "Đã cấp lại thẻ mới cho khách hàng này.");
                        capNhatDuLieuTheTV();
                    }
                }
                else {
                    int luaChon = JOptionPane.showConfirmDialog(this, "Khách hàng này chưa có thẻ thành viên. Bạn sẽ cấp thẻ cho khách hàng này đúng chứ?",
                            "Xác nhận cấp thẻ", JOptionPane.YES_NO_OPTION);
                    if (luaChon == 0){
                        kn.taiTaoThe(kh.getID());
                        JOptionPane.showMessageDialog(this, "Đã cấp thẻ thành viên cho khách hàng này. Hãy chờ máy in trong giây lát");
                        capNhatDuLieuTheTV();
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Cảnh báo. Khách hàng này sẽ không thể thuê đĩa nếu bạn không cấp thẻ thành viên cho họ.");
                    }
                }
            }
        }
        if (o.equals(btnThongKeThe)){
            QuanLyThe ql = new QuanLyThe(kn);
            if (ql.getDsTheThanhVien().size() == 0)
                JOptionPane.showMessageDialog(this, "Hệ thống đang không lưu hành thẻ thành viên nào");
            else{
                int soThe = ql.tinhDoLonDuLieu();
                int soTheHetHan = ql.soTheHetHan();
                String ngayQuaHanLauNhat = ql.ngayQuanHanLauNhat();
                String s1 = "\n\n- Hệ thống đang lưu trữ:                                           " + soThe + " thẻ thành viên";
                String s2 = "\n\n- Số thẻ hết niên hạn là:                                           " + soTheHetHan + " thẻ";
                String s3 = "\n\n- Thẻ hết hạn lâu nhất có ngày hết hạn vào:        " + ngayQuaHanLauNhat + "\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3);
            }
        }
        if (o.equals(btnThongKeNV)){
            QuanLyNhanVien ql = new QuanLyNhanVien(kn);
            int doLonDuLieu = ql.doLonDuLieu();
            int[] ploaiTheoGT = ql.phanLoaiNhanVienTheoGT();
            String s1 = "\n\n- Hệ thống đang lưu trữ:                    " + doLonDuLieu + " nhân viên";
            String s2 = "\n\n- Số nhân viên nam là:                        " + ploaiTheoGT[0] + " nhân viên";
            String s3 = "\n\n- Số nhân viên nữ là:                           " + ploaiTheoGT[1] + " nhân viên";
            String s4 = "\n\n- Số nhân viên cấp cao là:                  " + "2 nhân viên";
            String s5 = "\n\n- Số nhân viên bình thường là:          " + (ql.doLonDuLieu() - 2) + " nhân viên\n\n";
            JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5);
        }
        if (o.equals(btnThongKeTaiKhoan)){
            QuanLyTaiKhoan ql = new QuanLyTaiKhoan(kn);
            if (ql.getDsTaiKhoan().size() == 0)
                JOptionPane.showMessageDialog(this, "Hệ thống chưa ghi nhận tài khoản nào");
            else {
                int doLonDuLieu = ql.doLonDuLieu();
                int soMKYeu = ql.plMatKhauManh();
                String s1 = "\n\n- Hệ thống đang lưu trữ:                                           " + doLonDuLieu + " tài khoản nội bộ";
                String s2 = "\n\n- Số tài khoản cấp cao là:                                         2 tài khoản";
                String s3 = "\n\n- Số tài khoản bình thường là:                                 " + (doLonDuLieu - 2) + " tài khoản";
                String s4 = "\n\n- Số tài khoản có mật khẩu chưa mạnh là:          " + soMKYeu + " tài khoản\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4);
            }
        }
        if (o.equals(btnThongKeDoanhThu)){
            QuanLyDoanhThu ql = new QuanLyDoanhThu(kn);
            if (ql.getDsDoanhThu().size() == 0)
                JOptionPane.showMessageDialog(this, "Hệ thống chưa ghi nhận giao dịch tạo ra doanh thu nào");
            else{
                Locale vn = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getCurrencyInstance(vn);
                int slGD = ql.doLonDuLieu();
                int[] soPhieu = ql.soPhieuThueHoacTra();
                double[] coCauDT = ql.coCauDoanhThu();
                String s1 = "\n\n- Hệ thống đang lưu trữ:                                      " + slGD + " giao dịch";
                String s2 = "\n\n- Số phiếu thuê được ghi nhận là:                     " + soPhieu[0] + " phiếu";
                String s3 = "\n\n- Số phiếu trả được ghi nhận là:                        " + soPhieu[1] + " phiếu";
                String s4 = "\n\n- Doanh thu thu được từ phiếu thuê:                " + nf.format(coCauDT[0]);
                String s5 = "\n\n- Doanh thu thu được từ phiếu trả:                    " + nf.format(coCauDT[1]) + "\n\n";
                JOptionPane.showMessageDialog(this, s1+s2+s3+s4+s5);
            }
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

    public static void capNhatDuLieuPhieuChuaTra(){
        mhPhieuThue = new MoHinhPhieuThue(new QuanLyPhieuChuaTra(kn).getDsPhieuChuaTra());
        tbPhieuChuaTra.setModel(mhPhieuThue);
        tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
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
        System.out.println(kh);
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
                    capNhatDuLieuBangDia();
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
                    capNhatDuLieuPhieuChuaTra();
                }
                else
                    JOptionPane.showMessageDialog(null, "Phiếu thuê này đã được trả hết. Trả nữa làm gì");
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

    public void timPhieuThue(){
        String soCMND = txtTimPhieuThue.getText().trim();
        KhachHang kh = new QuanLyKhachHang(kn).timKhachHang(soCMND);
        if (kh == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng này trong hệ thống");
        else{
            TheThanhVien t = new QuanLyThe(kn).timTheThanhVien(kh.getID());
            if (t == null)
                JOptionPane.showMessageDialog(this, "Khách hàng này chưa được cấp thẻ thành viên");
            else {
                ArrayList<PhieuThue> dsPT = new QuanLyPhieuThue(kn).timPhieuThue(t.getMaThe());
                if (dsPT.size() == 0)
                    JOptionPane.showMessageDialog(this, "Khách hàng này chưa từng thuê đĩa");
                else{
                    mhPhieuThue = new MoHinhPhieuThue(dsPT);
                    tbPhieuThue.setModel(mhPhieuThue);
                    tbPhieuThue.setRowHeight(chieuCaoHangTrongBang);
                    JOptionPane.showMessageDialog(this, "\n\nTìm được " + dsPT.size() + " phiếu thuê của khách hàng này\n\n");
                }
            }
        }
    }

    public void timPhieuTra(){
        String soCMND = txtTimPhieuTra.getText().trim();
        KhachHang kh = new QuanLyKhachHang(kn).timKhachHang(soCMND);
        if (kh == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng này trong hệ thống");
        else{
            TheThanhVien t = new QuanLyThe(kn).timTheThanhVien(kh.getID());
            if (t == null)
                JOptionPane.showMessageDialog(this, "Khách hàng này chưa được cấp thẻ thành viên");
            else {
                ArrayList<PhieuThue> dsPhieuThue = new QuanLyPhieuThue(kn).timPhieuThue(t.getMaThe());
                if (dsPhieuThue.size() == 0)
                    JOptionPane.showMessageDialog(this, "Khách hàng này chưa từng thuê đĩa nào");
                else {
                    ArrayList<PhieuTra> dsPT = new QuanLyPhieuTra(kn).timPhieuTra(t.getMaThe());
                    if (dsPT.size() == 0)
                        JOptionPane.showMessageDialog(this, "Khách hàng này chưa từng trả đĩa");
                    else{
                        mhPhieuTra = new MoHinhPhieuTra(dsPT);
                        tbPhieuTra.setModel(mhPhieuTra);
                        tbPhieuTra.setRowHeight(chieuCaoHangTrongBang);
                        JOptionPane.showMessageDialog(this, "\n\nTìm được " + dsPT.size() + " phiếu trả của khách hàng này\n\n");
                    }
                }
            }
        }
    }

    public void timPhieuChuaTra(){
        String soCMND = txtTimPhieuChuaTra.getText().trim();
        KhachHang kh = new QuanLyKhachHang(kn).timKhachHang(soCMND);
        if (kh == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng này trong hệ thống");
        else{
            TheThanhVien t = new QuanLyThe(kn).timTheThanhVien(kh.getID());
            if (t == null)
                JOptionPane.showMessageDialog(this, "Khách hàng này chưa được cấp thẻ thành viên");
            else {
                ArrayList<PhieuThue> dsPhieuThue = new QuanLyPhieuThue(kn).timPhieuThue(t.getMaThe());
                if (dsPhieuThue.size() == 0)
                    JOptionPane.showMessageDialog(this, "Khách hàng này chưa từng thuê đĩa");
                else {
                    ArrayList<PhieuThue> dsPT = new QuanLyPhieuChuaTra(kn).timPhieuChuaTra(t.getMaThe());
                    if (dsPT.size() == 0)
                        JOptionPane.showMessageDialog(this, "Khách hàng này đã trả hết đĩa thuê");
                    else{
                        mhPhieuThue = new MoHinhPhieuThue(dsPT);
                        tbPhieuChuaTra.setModel(mhPhieuThue);
                        tbPhieuChuaTra.setRowHeight(chieuCaoHangTrongBang);
                        JOptionPane.showMessageDialog(this, "\n\nTìm được " + dsPT.size() + " phiếu chưa trả của khách hàng này\n\n");
                    }
                }
            }
        }
    }

    public void timKhachHang(){
        String soCMND = txtTimKhachHang.getText().trim();
        QuanLyKhachHang ql = new QuanLyKhachHang(kn);
        KhachHang kh = ql.timKhachHang(soCMND);
        if (kh == null){
            JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng nào có số CMND này");
        }
        else {
            ArrayList<KhachHang> dsKH = new ArrayList<>();
            dsKH.add(kh);
            MoHinhKhachHang mh = new MoHinhKhachHang(dsKH);
            tbKhachHang.setModel(mh);
            tbKhachHang.setRowHeight(chieuCaoHangTrongBang);
        }
    }

    public void timNhanVien(){
        String soDT = txtTimNhanVien.getText().trim();
        NhanVien nv = new QuanLyNhanVien(kn).timNhanVien(soDT);
        if (nv == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên nào có số điện thoại này");
        else {
            ArrayList<NhanVien> dsNV = new ArrayList<>();
            dsNV.add(nv);
            MoHinhNhanVien mh = new MoHinhNhanVien(dsNV);
            tbNhanVien.setModel(mh);
            tbNhanVien.setRowHeight(chieuCaoHangTrongBang);
        }
    }

    public void timTheThanhVien(){
        String soCMND = txtTimTheTV.getText().trim();
        KhachHang kh = new QuanLyKhachHang(kn).timKhachHang(soCMND);
        if (kh == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại khách hàng nào có số CMND này");
        else{
            int maKH = kh.getID();
            TheThanhVien t = new QuanLyThe(kn).timTheThanhVien(maKH);
            ArrayList<TheThanhVien> ds = new ArrayList<>();
            ds.add(t);
            mhThe = new MoHinhTheThanhVien(ds);
            tbTheTV.setModel(mhThe);
            tbTheTV.setRowHeight(chieuCaoHangTrongBang);
            JOptionPane.showMessageDialog(this, "Đây là thông tin thẻ thành viên của khách hàng này");
        }
    }

    public void timTaiKhoan(){
        String sdt = txtTimTaiKhoan.getText().trim();
        NhanVien nv = new QuanLyNhanVien(kn).timNhanVien(sdt);
        if (nv == null)
            JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên nào có số điện thoại này");
        else{
            TaiKhoan tk = new QuanLyTaiKhoan(kn).timTaiKhoan(nv.getID());
            if (tk == null)
                JOptionPane.showMessageDialog(this, "Nhân viên này chưa được lập tài khoản");
            else {
                ArrayList<TaiKhoan> dsTK = new ArrayList<>();
                dsTK.add(tk);
                mhTaiKhoan = new MoHinhTaiKhoan(dsTK);
                tbTaiKhoan.setModel(mhTaiKhoan);
                tbTaiKhoan.setRowHeight(chieuCaoHangTrongBang);
                JOptionPane.showMessageDialog(this, "Đây là dữ liệu tài khoản đăng nhập của nhân viên này");
            }
        }
    }

    public void timDoanhThu(){
        Date ngayLap = new Date();
        try {
            ngayLap = new SimpleDateFormat("dd/MM/yyyy").parse(txtTimGiaoDich.getText().trim());
            ArrayList<DoanhThu> ds = new QuanLyDoanhThu(kn).timDoanhThu(ngayLap);
            if (ds.size() == 0)
                JOptionPane.showMessageDialog(this, "Không tìm thấy Giao dịch nào trong ngày đó");
            else{
                JOptionPane.showMessageDialog(this, "Tìm thấy " + ds.size() + " giao dịch");
                MoHinhDoanhThu mh = new MoHinhDoanhThu(ds);
                tbDoanhThu.setModel(mh);
                tbDoanhThu.setRowHeight(chieuCaoHangTrongBang);
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Ngày lập phải có dạng dd/MM/yyyy");
        }
    }

    public void themSuKienDoubleClickChoTBBangDia(){
        tbBangDia.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbBangDia.getSelectedRow();
                if (e.getClickCount() == 2 && row != -1){
                    int maDia = (Integer) tbBangDia.getValueAt(row, 0);
                    BangDia bd = new QuanLyBangDia(kn).timBangDia(maDia);
                    CSBangDia cs = new CSBangDia();
                    cs.datTinhTrangCacNut(3);
                    cs.hienThiDuLieuDiaLenTXT(bd);
                }
            }
        });
    }

    public void themSuKienDoubleClickChoTBKhachHang(){
        tbKhachHang.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbKhachHang.getSelectedRow();
                if (row != -1 && e.getClickCount() == 2){
                    KhachHang kh = new QuanLyKhachHang(kn).getDsKhachHang().get(row);
                    CSKhachHang cs = new CSKhachHang();
                    cs.datTinhTrangCacNut(3);
                    cs.hienThiThongTinKhachHang(kh);
                }
            }
        });
    }

    public void themSuKienDoubleClickChoTBNhanVien(){
        tbNhanVien.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbNhanVien.getSelectedRow();
                if (row != -1 && e.getClickCount() == 2){
                    NhanVien nv = new QuanLyNhanVien(kn).getDsNhanVien().get(row);
                    CSNhanVien cs = new CSNhanVien();
                    cs.datTinhTrangCacNut(3);
                    cs.hienThiDuLieuLenTXT(nv);
                }
            }
        });
    }

    public void themSuKienDoubleClickChoTBPhieuChuaTra(){
        tbPhieuChuaTra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbPhieuChuaTra.getSelectedRow();
                if (row != -1 && e.getClickCount() == 2){
                    int maPhieu = (Integer) tbPhieuChuaTra.getValueAt(row, 0);
                    int maThe = (Integer) tbPhieuChuaTra.getValueAt(row, 1);
                    int maBD = (Integer) tbPhieuChuaTra.getValueAt(row, 4);
                    PhieuThue p = new PhieuThue(maPhieu);
                    p.setMaBD(maBD);
                    p.setMaThe(maThe);
                    CSPhieuTra cs = new CSPhieuTra();
                    cs.datTinhTrangCacNut(true);
                    cs.taoPhieuTraTuCSPhieuThue(p);
                }
            }
        });
    }

    public void themSuKienDoubleClickChoTBPhieuTra(){
        tbPhieuTra.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = tbPhieuTra.getSelectedRow();
                if (row != -1 && e.getClickCount() == 2){
                    PhieuTra p = new QuanLyPhieuTra(kn).getDsPhieuTra().get(row);
                    CSPhieuTra cs = new CSPhieuTra();
                    cs.datTinhTrangCacNut(false);
                    cs.hienThiDuLieuLenTXT(p);
                }
            }
        });
    }

    public static void inDuLieuRaExcel(JTable table, String fileName){
            try {
                TableModel model = table.getModel();
                XSSFWorkbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet();
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < model.getColumnCount();i++){
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(model.getColumnName(i));
                }
                for (int i = 0; i < model.getRowCount(); i++){
                    Row row = sheet.createRow(i+1); //Tranh ghi de
                    for (int j = 0; j < model.getColumnCount(); j++){
                        Cell cell = row.createCell(j);
                        if (model.getValueAt(i, j) != null)
                            cell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(FILE_URL+"\\"+fileName+".xlsx"));
                wb.write(out);
                wb.close();
                out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void xacNhanInDuLieu(int luaChon){
        String[] tieuDe = {"DuLieuBangDia","DuLieuPhieuThue","DuLieuPhieuTra","DuLieuPhieuChuaTra",
                        "DuLieuKhachHang","DuLieuTheThanhVien","DuLieuNhanVien","DuLieuDoanhThu"};
        JTable[] table = {tbBangDia, tbPhieuThue, tbPhieuTra, tbPhieuChuaTra, tbKhachHang, tbTheTV,
                            tbNhanVien, tbDoanhThu};
        capNhatDuLieuPhieuThue();
        capNhatDuLieuPhieuTra();
        capNhatDuLieuPhieuChuaTra();
        capNhatDuLieuKhachHang();
        capNhatDuLieuTheTV();
        capNhatDuLieuNhanVien();
        capNhatDuLieuDoanhThu();
        switch (luaChon){
            case 0:{
                for (int i = 0; i < tieuDe.length; i++)
                    inDuLieuRaExcel(table[i], tieuDe[i]);
                break;
            }
            case 1:{
                inDuLieuRaExcel(table[0], tieuDe[0]);
                break;
            }
            case 2:{
                inDuLieuRaExcel(table[1], tieuDe[1]);
                break;
            }
            case 3:{
                inDuLieuRaExcel(table[2], tieuDe[2]);
                break;
            }
            case 4:{
                inDuLieuRaExcel(table[3], tieuDe[3]);
                break;
            }
            case 5:{
                inDuLieuRaExcel(table[4], tieuDe[4]);
                break;
            }
            case 6:{
                inDuLieuRaExcel(table[5], tieuDe[5]);
                break;
            }
            case 7:{
                inDuLieuRaExcel(table[6], tieuDe[6]);
                break;
            }
            case 8:{
                inDuLieuRaExcel(table[7], tieuDe[7]);
                break;
            }
        }
    }

}
