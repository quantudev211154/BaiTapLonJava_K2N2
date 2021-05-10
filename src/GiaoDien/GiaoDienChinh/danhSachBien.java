package GiaoDien.GiaoDienChinh;

import MoHinhDoiTuong.MoHinhBangDia;

import javax.swing.*;

public interface danhSachBien {
    /**
     * Các biến tính được sử dụng để căn kích thước JPanel
     */
    public final int chieuCaoGiaoDien = 700,
                     chieuCaoMenuBar = 35,
                     chieuCaoHopCongCu = 70,
                     chieuCaoHopDuLieu = 545,
                     chieuCaoHopTTDuLieu = 50;
    public final int chieuRongGiaoDien = 1400, chieuRongJMenu = 150;

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
    public JMenuItem miBangDia = new JMenuItem("       Băng đĩa"),
                    miPhieuThue = new JMenuItem("       Phiếu thuê"),
                    miPhieuTra = new JMenuItem("        Phiếu trả"),
                    miKhachHang = new JMenuItem("       Khách hàng"),
                    miTheThanhVien = new JMenuItem("       Thẻ thành viên"),
                    miNhanVien = new JMenuItem("           Nhân viên"),
                    miTaiKhoan = new JMenuItem("         DS Tài khoản"),
                    miTongDoanhThu = new JMenuItem("Tổng doanh thu"),
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
    public JButton btnTaoPhieuThue = new JButton("Tạo phiếu thuê", bieuTuongThem),
                    btnXoaPhieuThue = new JButton("Xóa phiếu thuê", bieuTuongXoa),
                    btnCapNhatPhieuThue = new JButton("Cập nhật phiếu thuê", bieuTuongCapNhat),
                    btnTimPhieuThue = new JButton("Tìm phiếu thuê", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng PhieuTra
     */
    public JButton btnTaoPhieuTra = new JButton("Tạo phiếu trả", bieuTuongThem),
                    btnXoaPhieuTra = new JButton("Xóa phiếu trả", bieuTuongXoa),
                    btnCapNhatPhieuTra = new JButton("Cập nhật phiếu trả", bieuTuongCapNhat),
                    btnTimPhieuTra = new JButton("Tìm phiếu trả", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng KhachHang
     */
    public JButton btnThemKhachHang = new JButton("Thêm khách hàng", bieuTuongThem),
                    btnXoaKhachHang = new JButton("Xóa khách hàng", bieuTuongXoa),
                    btnCapNhatTTKhachHang = new JButton("Cập nhật TT khách hàng", bieuTuongCapNhat),
                    btnTimKhachHang = new JButton("Tìm khách hàng", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TheThanhVien
     */
    public JButton btnThemTheTV = new JButton("Thêm Thẻ TV", bieuTuongThem),
                    btnXoaTheTV = new JButton("Xóa Thẻ TV", bieuTuongXoa),
                    btnCapNhatTheTV = new JButton("Cập nhật Thẻ TV", bieuTuongCapNhat),
                    btnTimTheTV = new JButton("Tìm Thẻ TV", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng NhanVien
     */
    public JButton btnThemNhanVien = new JButton("Thêm nhân viên", bieuTuongThem),
                    btnXoaNhanVien = new JButton("Xóa nhân viên", bieuTuongXoa),
                    btnCapNhatNhanVien = new JButton("Cập nhật nhân viên", bieuTuongCapNhat),
                    btnTimNhanVien = new JButton("Tìm nhân viên", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng TaiKhoan
     */
    public JButton btnThemTaiKhoan = new JButton("Tạo tài khoản NV", bieuTuongThem),
            btnXoaTaiKhoan = new JButton("Xóa tài khoản", bieuTuongXoa),
            btnCapNhatTaiKhoan = new JButton("Cập nhật tài khoản", bieuTuongCapNhat),
            btnTimTaiKhoan = new JButton("Tìm tài khoản", bieuTuongTim);

    /**
     * - Các JButton ở hộp Công cụ của đối tượng DoanhThu
     */
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

//    /**
//     * - Các TableModel
//     */
//    public MoHinhBangDia moHinhBangDia = new MoHinhBangDia();
//
//    /**
//     * - Các JTable
//     */
//    public JTable tbBangDia, tbPhieuThue,

}
