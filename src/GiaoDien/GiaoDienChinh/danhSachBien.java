package GiaoDien.GiaoDienChinh;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public interface danhSachBien {
    /**
     * Các biến tính được sử dụng để căn kích thước JPanel
     */
    public final int chieuCaoGiaoDien = 745,
                     chieuCaoMenuBar = 35,
                     chieuCaoHopCongCu = 80,
                     chieuCaoHopDuLieu = 585;
    public final int chieuRongGiaoDien = 1370, chieuRongJMenu = 150,
                    chieuRongBangDuLieu = chieuRongGiaoDien - 20;
    public final int chieuCaoHangTrongBang = 30;
    public final Dimension kichThuocBTNThongKe = new Dimension(280, 110);
    public final Font fontBtnThongKe = new Font("Times New Roman", Font.PLAIN, 20);
    public final Color toolBarBgr = new Color(8, 163, 156);
    /**
     * JMenuBar
     */
    public JMenuBar thanhMenu = new JMenuBar();

    /**
     * - Các JMenu
     */
    public JMenu mnDoanhThu = new JMenu("            Doanh thu"),
                 mnNangCao = new JMenu("             Nâng cao");

    /**
     * - Các JMenuItems
     */
    public JMenuItem miBangDia = new JMenuItem("      Băng đĩa"),
                    miPhieuThue = new JMenuItem("      Phiếu thuê"),
                    miPhieuTra = new JMenuItem("       Phiếu trả"),
                    miPhieuChuaTra = new JMenuItem("    Phiếu chưa trả"),
                    miKhachHang = new JMenuItem("       Khách hàng"),
                    miTheThanhVien = new JMenuItem("       Thẻ thành viên"),
                    miNhanVien = new JMenuItem("          Nhân viên"),
                    miTaiKhoan = new JMenuItem("        DS Tài khoản"),
                    miDoanhThuTrongNgay = new JMenuItem("Doanh thu trong ngày"),
                    miChiTietDoanhThu = new JMenuItem("Chi tiết doanh thu"),
                    miNguoiDung = new JMenuItem("NV đang hoạt động"),
                    miDangXuat = new JMenuItem("Đăng xuất"),
                    miThongKe = new JMenuItem("            Thống kê");

    /**
     * - Danh sách các biểu tượng Thêm, Sửa, Xóa, Tìm kiếm
     */
    public ImageIcon bieuTuongThem = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThem.png");
    public ImageIcon bieuTuongXoa = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoa.png");
    public ImageIcon bieuTuongCapNhat = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongCapNhat.png");
    public ImageIcon bieuTuongTim = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongTim_24px.png");
    public ImageIcon bieuTuongCaiVi = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongVi.png");
    public ImageIcon bieuTuongViThang = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongViThang.png");
    public ImageIcon btThemPhieu = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThemPhieu.png");
    public ImageIcon btXoaPhieu = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoaPhieu.png");
    public ImageIcon btThemThe = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThemThe.png");
    public ImageIcon btXoaThe = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoaTheThanhVien.png");
    public ImageIcon btCapNhatThe = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btCapNhatTheThanhVien.png");
    public ImageIcon btThemTaiKhoan = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThemTaiKhoan.png");
    public ImageIcon btThemNhanVien = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieutuongThemNhanVien.png");
    public ImageIcon btXemPhieuChuaTra = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btXemPhieuChuaTra.png");
    public ImageIcon btThongKeDuLieu = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKeSL.png");
    public ImageIcon btBangDia = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btBangDia.png");
    public ImageIcon btBangDiaE = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btDiaE.png");
    public ImageIcon btKhachTreDia = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btKhachTreDia.png");
    public ImageIcon btNVNangSuat = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btNVNangSuat.png");
    public ImageIcon btDiaRe = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btDiaRe.png");
    public ImageIcon btThongKeKhachHang = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKeKH.png");
    public ImageIcon btThongKePThue = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKePhieuThue.png");
    public ImageIcon btThongKePTra = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKePTra.png");
    public ImageIcon btThongKePChuaTra = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKePCT.png");
    public ImageIcon btThongKeNhanVien = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKeNhanVien.png");
    public ImageIcon btThongKeTaiKhoan = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKeTaiKhoan.png");
    public ImageIcon btThongKeDoanhThu = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThongKeDoanhThu.png");
    public ImageIcon btDSDiaTre = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btPhieuTre.png");
    public ImageIcon btThongKeThe = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bThongKePT.png");
    public ImageIcon btInRaExcel = new ImageIcon("D:\\IUH - Uni\\Yeah_2\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btExcel.png");


    /**
     * - Các JButton ở hộp Công cụ của đối tượng BangDia
     */
    public JButton btnThemDia = new JButton("Thêm đĩa", bieuTuongThem),
                    btnXoaDia = new JButton("Xóa đĩa", bieuTuongXoa),
                    btnCapNhatDia = new JButton("Cập nhật đĩa", bieuTuongCapNhat),
                    btnTimDia = new JButton("Tìm đĩa", bieuTuongTim),
                    btnXemDuLieuDia = new JButton("Thống kê", btBangDia);
    String[] sapXepDia = {"Không sắp xếp",
            "Sắp xếp tăng dần theo đơn giá", "Sắp xếp giảm dần theo đơn giá",
            "Sắp xếp tăng dần theo giá thuê", "Sắp xếp giảm dần theo giá thuê"};
    public JComboBox<String> cbSapXepDia = new JComboBox<>(sapXepDia);
    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuThue
     */
    public JButton btnTaoPhieuThue = new JButton("Tạo phiếu thuê", btThemPhieu),
                    btnThongKePT = new JButton("Thống kê", btThongKePThue),
                    btnTimPhieuThue = new JButton("Tìm phiếu thuê", bieuTuongTim);
    String[] sapXepPhieuThue = {"Không sắp xếp",
            "Sắp xếp tăng dần theo ngày thuê", "Sắp xếp giảm dần theo ngày thuê",
            "Sắp xếp tăng dần theo thành tiền", "Sắp sếp giảm dần theo thành tiền"};
    public JComboBox<String> cbSapXepPThue = new JComboBox<>(sapXepPhieuThue);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuTra
     */
    public JButton btnTaoPhieuTra = new JButton("Tạo phiếu trả", btThemPhieu),
                    btnThongKePTra = new JButton("Thống kê", btThongKePTra),
                    btnTimPhieuTra = new JButton("Tìm phiếu trả", bieuTuongTim);
    String[] sapXepPhieuTra = {"Không sắp xếp",
                "Sắp xếp tăng dần theo mã phiếu thuê", "Sắp xếp  giảm dần theo mã phiếu thuê",
                "Sắp xếp tăng dần theo mã đĩa", "Sắp xếp giảm dần theo mã đĩa"};
    public JComboBox<String> cbSapXepPhieuTra = new JComboBox<>(sapXepPhieuTra);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuChuaTra
     */
    public JButton btnXemPhieuChuaTra = new JButton("Xem phiếu chưa trả", btXemPhieuChuaTra),
            btnThongKePCT = new JButton("Thống kê", btThongKePChuaTra),
            btnTimPhieuChuaTra = new JButton("Tìm phiếu chưa trả", bieuTuongTim),
            btnDSPhieuTre = new JButton("Danh sách phiếu thuê trễ hạn", btDSDiaTre);
    String[] sapXepPhieuChuaTra = {"Không sắp xếp",
            "Sắp xếp tăng dần theo ngày thuê", "Sắp xếp giảm dần theo ngày thuê",
            "Sắp xếp tăng dần theo thành tiền", "Sắp sếp giảm dần theo thành tiền",
            "Sắp xếp tăng dần theo ngày hết hạn", "Sắp xếp giảm dần theo ngày hết hạn"};
    public JComboBox<String> cbSapXepPCT = new JComboBox<>(sapXepPhieuChuaTra);
    /**

    /**
     * - Các JButton ở hộp Công cụ của đối tượng KhachHang
     */
    public JButton btnThemKhachHang = new JButton("Thêm khách", btThemNhanVien),
                    btnXoaKhachHang = new JButton("Xóa khách", bieuTuongXoa),
                    btnCapNhatTTKhachHang = new JButton("Cập nhật TT khách hàng", bieuTuongCapNhat),
                    btnTimKhachHang = new JButton("Tìm khách hàng", bieuTuongTim),
                    btnThongKeKH = new JButton("Thống kê", btThongKeKhachHang);
    String[] sapXepKhachHang = {"Không sắp xếp",
                    "Sắp xếp tăng dần theo tên", "Sắp xếp giảm dần theo tên",
                    "Sắp xếp giảm dần theo mã khách hàng"};
    public JComboBox<String> cbSapXepKhachHang = new JComboBox<>(sapXepKhachHang);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TheThanhVien
     */
    public JButton btnThemTheTV = new JButton("Thêm Thẻ TV", btThemThe),
                    btnXoaTheTV = new JButton("Xóa Thẻ TV", btXoaThe),
                    btnCapNhatTheTV = new JButton("Tái cấp thẻ TV", btCapNhatThe),
                    btnTimTheTV = new JButton("Tìm Thẻ TV", bieuTuongTim),
                    btnThongKeThe = new JButton("Thống kê", btThongKeThe);
    String[] sapXepThe = {"Không sắp xếp",
            "Sắp xếp tăng dần theo mã khách hàng", "Sắp xếp giảm dần theo mã khách hàng",
            "Sắp xếp tăng dần theo ngày lập thẻ", "Sắp xếp giảm dần theo ngày lập thẻ",
            "Sắp xếp tăng dần theo ngày hết hạn thẻ", "Sắp xếp giảm dần theo ngày hết hạn thẻ"};
    JComboBox<String> cbSapXepThe = new JComboBox<>(sapXepThe);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng NhanVien
     */
    public JButton btnThemNhanVien = new JButton("Thêm nhân viên", btThemNhanVien),
                    btnXoaNhanVien = new JButton("Xóa nhân viên", bieuTuongXoa),
                    btnCapNhatNhanVien = new JButton("Cập nhật nhân viên", bieuTuongCapNhat),
                    btnTimNhanVien = new JButton("Tìm nhân viên", bieuTuongTim),
                    btnThongKeNV = new JButton("Thống kê", btThongKeNhanVien);
    String[] sapXepNhanVien = {"Không sắp xếp",
            "Sắp xếp tăng dần theo tên NV", "Sắp xếp giảm dần theo tên NV",
            "Sắp xếp giảm dần theo mã NV"};
    JComboBox<String> cbSapXepNV = new JComboBox<>(sapXepNhanVien);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TaiKhoan
     */
    public JButton btnThemTaiKhoan = new JButton("Tạo tài khoản NV", btThemTaiKhoan),
            btnCapNhatTaiKhoan = new JButton("Đổi mật khẩu", bieuTuongCapNhat),
            btnTimTaiKhoan = new JButton("Tìm tài khoản", bieuTuongTim),
            btnThongKeTaiKhoan = new JButton("Thống kê", btThongKeTaiKhoan);
    String[] sapXepTaiKhoan = {"Không sắp xếp",
                "Sắp xếp tăng dần theo tên đăng nhập", "Sắp xếp giảm dần theo tên đăng nhập"};
    public JComboBox<String> cbSapXepTaiKhoan = new JComboBox<>(sapXepTaiKhoan);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng DoanhThu
     */
    public JButton btnXemDoanhThuThangHienTai = new JButton("Doanh thu tháng hiện tại", bieuTuongCaiVi);
    public JButton btnXemDoanhThuTheoThang = new JButton("Xem doanh thu theo tháng", bieuTuongViThang);
    public JButton btnTimGiaoDich = new JButton("Tìm giao dịch", bieuTuongTim);
    public JButton btnThongKeDoanhThu = new JButton("Thống kê", btThongKeDoanhThu);
    String[] sapXepDoanhThu = {"Không sắp xếp",
                "Sắp xếp tăng dần theo mã phiếu", "Sắp xếp giảm dần theo mã phiếu",
                "Sắp xếp tăng dần theo số tiền", "Sắp xếp giảm dần theo số tiền"};
    public JComboBox<String> cbSapXepGiaoDich = new JComboBox<>(sapXepDoanhThu);

    /**
     * - Các JButton ở hộp Thống kê
     */
    public JButton btnThongKeDuLieu = new JButton("Thống kê dữ liệu", btThongKeDuLieu);
    public JButton btnXemDiaBanChay = new JButton("Top 10 đĩa bán chạy", btBangDia);
    public JButton btnXemDiaBanE = new JButton("Top 10 đĩa ế", btBangDiaE);
    public JButton btnXemKhachTreDia = new JButton("Top 10 khách xù đĩa", btKhachTreDia);
    public JButton btnXemNhanVienGioi = new JButton("Top 2 nhân viên giỏi", btNVNangSuat);
    public JButton btnXemDiaRe = new JButton("Top 10 đĩa dễ thuê", btDiaRe);
    public JButton btnInDuLieuTbSangExcel = new JButton("Xuất dữ liệu sang file Excel", btInRaExcel);
    /**
     * - Các JTextFiedld
     */
    public JTextField txtTimBangDia = new JTextField(30),
                        txtTimPhieuThue = new JTextField(30),
                        txtTimPhieuTra = new JTextField(30),
                        txtTimKhachHang = new JTextField(18),
                        txtTimTheTV = new JTextField(30),
                        txtTimNhanVien = new JTextField(20),
                        txtTimTaiKhoan = new JTextField(30),
                        txtTimGiaoDich = new JTextField(30),
                        txtTimPhieuChuaTra = new JTextField(30);

    /**
     * - Các JTable
     */
    public JTable tbBangDia = new JTable();
    public JTable tbNhanVien = new JTable();
    public JTable tbTaiKhoan = new JTable();
    public JTable tbKhachHang = new JTable();
    public JTable tbDoanhThu = new JTable();
    public JTable tbTheTV = new JTable();
    public JTable tbPhieuThue = new JTable();
    public JTable tbPhieuTra = new JTable();
    public JTable tbPhieuChuaTra = new JTable();

    /**
     * - Các JScrollPane
     */
    public JScrollPane scrPaneBangDia = new JScrollPane(tbBangDia);
    public JScrollPane scrPaneNhanVien = new JScrollPane(tbNhanVien);
    public JScrollPane scrPaneTaiKhoan = new JScrollPane(tbTaiKhoan);
    public JScrollPane scrPaneKhachHang = new JScrollPane(tbKhachHang);
    public JScrollPane scrPaneDoanhThu = new JScrollPane(tbDoanhThu);
    public JScrollPane scrPaneTheTV = new JScrollPane(tbTheTV);
    public JScrollPane scrPanePhieuThue = new JScrollPane(tbPhieuThue);
    public JScrollPane scrPanePhieuTra = new JScrollPane(tbPhieuTra);
    public JScrollPane scrPanePhieuChuaTra = new JScrollPane(tbPhieuChuaTra);

    /**
     * File URL
     */
    public String FILE_URL = "C:\\Users\\Quan Tu\\OneDrive\\Desktop\\Data";
}

