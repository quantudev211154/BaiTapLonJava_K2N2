package GiaoDien.GiaoDienChinh;

import KhoiDieuKhien.KetNoiToiCoSoDuLieu;
import MoHinhDoiTuong.MoHinhBangDia;
import QuanLyDoiTuong.QuanLyBangDia;

import javax.swing.*;

public interface danhSachBien {
    /**
     * Các biến tính được sử dụng để căn kích thước JPanel
     */
    public final int chieuCaoGiaoDien = 745,
                     chieuCaoMenuBar = 35,
                     chieuCaoHopCongCu = 70,
                     chieuCaoHopDuLieu = 545,
                     chieuCaoHopTTDuLieu = 50;
    public final int chieuRongGiaoDien = 1370, chieuRongJMenu = 150,
                    chieuRongBangDuLieu = chieuRongGiaoDien - 20;
    public final int chieuCaoHangTrongBang = 30;


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
    public JMenuItem miBangDia = new JMenuItem("           Băng đĩa"),
                    miPhieuThue = new JMenuItem("           Phiếu thuê"),
                    miPhieuTra = new JMenuItem("            Phiếu trả"),
                    miKhachHang = new JMenuItem("           Khách hàng"),
                    miTheThanhVien = new JMenuItem("          Thẻ thành viên"),
                    miNhanVien = new JMenuItem("               Nhân viên"),
                    miTaiKhoan = new JMenuItem("              DS Tài khoản"),
                    miDoanhThuTrongNgay = new JMenuItem("Doanh thu trong ngày"),
                    miChiTietDoanhThu = new JMenuItem("Chi tiết doanh thu"),
                    miNguoiDung = new JMenuItem("NV đang hoạt động"),
                    miDangXuat = new JMenuItem("Đăng xuất");

    /**
     * - Danh sách các biểu tượng Thêm, Sửa, Xóa, Tìm kiếm
     */
    public ImageIcon bieuTuongThem = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThem.png");
    public ImageIcon bieuTuongXoa = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoa.png");
    public ImageIcon bieuTuongCapNhat = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongCapNhat.png");
    public ImageIcon bieuTuongTim = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongTim_24px.png");
    public ImageIcon bieuTuongCaiVi = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongVi.png");
    public ImageIcon bieuTuongViThang = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongViThang.png");
    public ImageIcon btThemPhieu = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThemPhieu.png");
    public ImageIcon btXoaPhieu = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoaPhieu.png");
    public ImageIcon btThemThe = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btThemThe.png");
    public ImageIcon btXoaThe = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongXoaTheThanhVien.png");
    public ImageIcon btCapNhatThe = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btCapNhatTheThanhVien.png");
    public ImageIcon btThemTaiKhoan = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieuTuongThemTaiKhoan.png");
    public ImageIcon btThemNhanVien = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\bieutuongThemNhanVien.png");
    public ImageIcon btXemPhieuChuaTra = new ImageIcon("D:\\IUH - Uni\\IUH - Details\\Tearm II\\Java - EOP\\JavaProject\\src\\GiaoDien\\GiaoDienChinh\\BieuTuong\\btXemPhieuChuaTra.png");


    /**
     * - Các JButton ở hộp Công cụ của đối tượng BangDia
     */
    public JButton btnThemDia = new JButton("Thêm đĩa", bieuTuongThem),
                    btnXoaDia = new JButton("Xóa đĩa", bieuTuongXoa),
                    btnCapNhatDia = new JButton("Cập nhật đĩa", bieuTuongCapNhat),
                    btnTimDia = new JButton("Tìm đĩa", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuThue
     */
    public JButton btnTaoPhieuThue = new JButton("Tạo phiếu thuê", btThemPhieu),
                    btnXoaPhieuThue = new JButton("Xóa phiếu thuê", btXoaPhieu),
                    btnCapNhatPhieuThue = new JButton("Cập nhật phiếu thuê", bieuTuongCapNhat),
                    btnTimPhieuThue = new JButton("Tìm phiếu thuê", bieuTuongTim),
                    btnXemPhieuChuaTra = new JButton("Xem phiếu chưa trả", btXemPhieuChuaTra);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuTra
     */
    public JButton btnTaoPhieuTra = new JButton("Tạo phiếu trả", btThemPhieu),
                    btnXoaPhieuTra = new JButton("Xóa phiếu trả", btXoaPhieu),
                    btnCapNhatPhieuTra = new JButton("Cập nhật phiếu trả", bieuTuongCapNhat),
                    btnTimPhieuTra = new JButton("Tìm phiếu trả", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng KhachHang
     */
    public JButton btnThemKhachHang = new JButton("Thêm khách hàng", btThemNhanVien),
                    btnXoaKhachHang = new JButton("Xóa khách hàng", bieuTuongXoa),
                    btnCapNhatTTKhachHang = new JButton("Cập nhật TT khách hàng", bieuTuongCapNhat),
                    btnTimKhachHang = new JButton("Tìm khách hàng", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TheThanhVien
     */
    public JButton btnThemTheTV = new JButton("Thêm Thẻ TV", btThemThe),
                    btnXoaTheTV = new JButton("Xóa Thẻ TV", btXoaThe),
                    btnCapNhatTheTV = new JButton("Tái cấp thẻ TV", btCapNhatThe),
                    btnTimTheTV = new JButton("Tìm Thẻ TV", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng NhanVien
     */
    public JButton btnThemNhanVien = new JButton("Thêm nhân viên", btThemNhanVien),
                    btnXoaNhanVien = new JButton("Xóa nhân viên", bieuTuongXoa),
                    btnCapNhatNhanVien = new JButton("Cập nhật nhân viên", bieuTuongCapNhat),
                    btnTimNhanVien = new JButton("Tìm nhân viên", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TaiKhoan
     */
    public JButton btnThemTaiKhoan = new JButton("Tạo tài khoản NV", btThemTaiKhoan),
            btnXoaTaiKhoan = new JButton("Xóa tài khoản", bieuTuongXoa),
            btnCapNhatTaiKhoan = new JButton("Đổi mật khẩu", bieuTuongCapNhat),
            btnTimTaiKhoan = new JButton("Tìm tài khoản", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng DoanhThu
     */
    public JButton btnXemDoanhThuThangHienTai = new JButton("Doanh thu tháng hiện tại", bieuTuongCaiVi);
    public JButton btnXemDoanhThuTheoThang = new JButton("Xem doanh thu theo tháng", bieuTuongViThang);
    public JButton btnTimGiaoDich = new JButton("Tìm giao dịch", bieuTuongTim);

    /**
     * - Các JTextFiedld
     */
    public JTextField txtTimBangDia = new JTextField(30),
                        txtTimPhieuThue = new JTextField(30),
                        txtTimPhieuTra = new JTextField(30),
                        txtTimKhachHang = new JTextField(30),
                        txtTimTheTV = new JTextField(30),
                        txtTimNhanVien = new JTextField(30),
                        txtTimTaiKhoan = new JTextField(30),
                        txtTimGiaoDich = new JTextField(30);

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

    /**
     * JLabel dùng để hiển thị thông tin dữ liệu
     */
    public JLabel lbThongTinDuLieu = new JLabel(" ");

}

