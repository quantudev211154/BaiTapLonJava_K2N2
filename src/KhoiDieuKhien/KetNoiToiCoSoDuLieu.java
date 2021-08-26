package KhoiDieuKhien;

import DoiTuong.*;

import java.sql.*;
import java.util.ArrayList;

public class KetNoiToiCoSoDuLieu {
    private Connection conn;

    public KetNoiToiCoSoDuLieu() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=DuLieu;username=sa;password=197521");
            System.out.println(" Kết nối tới CSDL thành công");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ngatKetNoiToiCSDL(){
        try{
            System.out.println("Đã ngắt kết nối tới CSDL");
            conn.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    Thao tác liên quan đến BangDia
    public boolean themBangDia(BangDia bd){
        System.out.println("Tiến hành thêm băng đĩa");
        String cauLenhThem =
                "EXEC THEMBANGDIA ?, ?, ?, ?, ?, ?, ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setString(1, bd.getTenBD());
            ps.setString(2, bd.getTheLoai());
            ps.setInt(3, 1);
            ps.setString(4, bd.getHangSX());
            ps.setString(5, bd.getGhiChu());
            ps.setInt(6, bd.getSoLuongGoc());
            ps.setDouble(7, bd.getDonGia());
            ps.setDouble(8, bd.getGiaThue());
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<BangDia> docDuLieuBangDia(){
        System.out.println("Tiến hành đọc dữ liệu băng đĩa");
        ArrayList<BangDia> dsBangDia = new ArrayList<BangDia>();
        String cauLenhDoc = "SELECT * FROM BangDia";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BangDia bd = new BangDia(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        true,
                                        rs.getString(5),
                                        rs.getString(6),
                                        rs.getInt(7),
                                        rs.getInt(8),
                                        rs.getDouble(9),
                                        rs.getDouble(10));
                dsBangDia.add(bd);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsBangDia;
    }

    public boolean xoaBangDia(int maBD){
        System.out.println("Tiến hành xóa băng đĩa");
        String cauLenhXoa = "EXEC XOABANGDIA ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maBD);
            return ps.executeUpdate() > 0;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean capNhatDia(int maBD, String tenBD_M, String theLoai_M, String hangSX_M,
                              String ghiChu_M, int slGoc_M, double donGia_M, double giaThue_M){
        System.out.println("Tiến hành cập nhật băng đĩa");
        String cauLenhCapNhat = "EXEC CAPNHATDIA ?,?,?,?,?,?,?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhCapNhat);
            ps.setInt(1, maBD);
            ps.setString(2, tenBD_M);
            ps.setString(3, theLoai_M);
            ps.setString(4, hangSX_M);
            ps.setString(5, ghiChu_M);
            ps.setInt(6, slGoc_M);
            ps.setDouble(7, donGia_M);
            ps.setDouble(8, giaThue_M);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến NhanVien
    public ArrayList<NhanVien> docDuLieuNhanVien(){
        System.out.println("Tiến hành đọc dữ liệu nhân viên");
        ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
        String cauLenhDoc = "SELECT * FROM NhanVien";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getInt(3),
                                            rs.getString(4),
                                            rs.getString(5)
                        );
                dsNhanVien.add(nv);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsNhanVien;
    }

    public boolean themNhanVien(NhanVien nv){
        System.out.println("Tiến hành thêm nhân viên");
        String cauLenhThem = "EXEC THEMNHANVIEN ?, ?, ?, ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setString(1, nv.getTen());
            ps.setInt(2, nv.getGioiTinh());
            ps.setString(3, nv.getSoDT());
            ps.setString(4, nv.getMoTa());
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaNhanVien(int maNV){
        System.out.println("Tiến hành xóa nhân viên");
        String cauLenhXoa = "EXEC XOANHANVIEN ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean capNhatNhanVien(int maNV, String soDT_M, String moTa_M){
        System.out.println("Tiến hành cập nhật nhân viên");
        String cauLenhCapNhat = "EXEC CAPNHATNHANVIEN ?, ?, ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhCapNhat);
            ps.setInt(1, maNV);
            ps.setString(2, soDT_M);
            ps.setString(3, moTa_M);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public NhanVien xacDinhNhanVienDangDung(int maNV){
        System.out.println("Tiến hành xác định nhân viên đang sử dụng hệ thống");
        String cauLenhTim = "SELECT * FROM NhanVien WHERE MaNV = ?";
        NhanVien nv = new NhanVien(maNV);
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhTim);
            ps.setInt(1, maNV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                nv.setTen(rs.getString(2));
                nv.setGioiTinh(rs.getInt(3));
                nv.setSoDT(rs.getString(4));
                nv.setMoTa(rs.getString(5));
                return nv;
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

//    Thao tác liên quan đến TaiKhoan
    public ArrayList<TaiKhoan> docDuLieuTaiKhoan(){
        System.out.println("Tiến hành đọc dữ liệu tài khoản");
        ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
        String cauLenhDoc = "SELECT * FROM TaiKhoan";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TaiKhoan tk = new TaiKhoan(rs.getInt(1),
                                            rs.getString(2),
                                            rs.getInt(3));
                dsTaiKhoan.add(tk);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsTaiKhoan;
    }

    public boolean themTaiKhoan(String matKhau){
        System.out.println("Tiến hành thêm tài khoản");
        String cauLenhThem = "EXEC THEMTAIKHOAN ?, ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setString(1, matKhau);
            ps.setInt(2, 2);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean capNhatTaiKhoan(int maTK, String matKhau_M){
        System.out.println("Tiến hành cập nhật tài khoản");
        String cauLenhCapNhat = "EXEC CAPNHATTAIKHOAN ?, ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhCapNhat);
            ps.setInt(1, maTK);
            ps.setString(2, matKhau_M);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến KhachHang
    public ArrayList<KhachHang> docDuLieuKhachHang(){
        System.out.println("Tiến hành đọc dữ liệu khách hàng");
        ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
        String cauLenhDoc = "SELECT * FROM KhachHang";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                KhachHang kh = new KhachHang(rs.getInt(1),
                                                rs.getString(3),
                                                rs.getInt(4),
                                                rs.getString(5),
                                                rs.getInt(2),
                                                rs.getString(6),
                                                rs.getString(7));
                dsKhachHang.add(kh);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsKhachHang;
    }

    public boolean themKhachHang(KhachHang kh){
        System.out.println("Tiến hành thêm khách hàng");
        String cauLenhThem = "EXEC THEMKHACHHANG ?, ?, ?, ?, ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setInt(1, kh.getMaNV());
            ps.setString(2, kh.getTen());
            ps.setInt(3, kh.getGioiTinh());
            ps.setString(4, kh.getSoDT());
            ps.setString(5, kh.getDiaChi());
            ps.setString(6, kh.getSoCMND());
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaKhachHang(int maKH){
        System.out.println("Tiến hành xóa khách hàng");
        String cauLenhXoa = "EXEC XOAKHACHHANG ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maKH);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean capNhatKhachHang(int maKH, String soDT_M, String diaChi_M){
        System.out.println("Tiến hành cập nhật khách hàng");
        String cauLenhCapNhat = "EXEC CAPNHATKHACHHANG ?, ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhCapNhat);
            ps.setInt(1, maKH);
            ps.setString(2, soDT_M);
            ps.setString(3, diaChi_M);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến thẻ thành viên

    public ArrayList<TheThanhVien> docDuLieuTheThanhVien(){
        System.out.println("Tiến hành đọc dữ liệu thẻ thành viên của khách hàng");
        ArrayList<TheThanhVien> dsThe = new ArrayList<TheThanhVien>();
        String cauLenhDoc = "SELECT * FROM TheThanhVien";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                TheThanhVien ttv = new TheThanhVien(rs.getInt(1),
                        rs.getInt(2), rs.getDate(3), rs.getDate(4));
                dsThe.add(ttv);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsThe;
    }

    public boolean themTheThanhVien(){
        System.out.println("Tiến hành thêm thẻ thành viên");
        TheThanhVien ttv = new TheThanhVien(1);
        String cauLenhThem = "EXEC THEMTHETHANHVIEN ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setDate(1, new Date(ttv.getNgayLap().getTime()));
            ps.setDate(2, new Date(ttv.getNgayHetHan().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaTheThanhVien(int maKH){
        System.out.println("Tiến hành xóa thẻ thành viên");
        String cauLenhXoa = "EXEC XOATHETHANHVIEN ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maKH);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean taiTaoThe(int maKH){
        System.out.println("Tiến hành tái tạo thẻ thành viên");
        String cauLenhTaiTao = "EXEC TAITAOTHE ?, ?, ?";
        TheThanhVien ttv = new TheThanhVien(2);
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhTaiTao);
            ps.setInt(1, maKH);
            ps.setDate(2, new Date(ttv.getNgayLap().getTime()));
            ps.setDate(3, new Date(ttv.getNgayHetHan().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến phiếu thuê
    public ArrayList<PhieuThue> docDuLieuPhieuThue(){
        System.out.println("Tiến hành đọc dữ liệu phiếu thuê");
        ArrayList<PhieuThue> dsPhieuThue = new ArrayList<PhieuThue>();
        String cauLenhDoc = "SELECT * FROM ThongTinPhieuThue";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PhieuThue p = new PhieuThue(rs.getInt(1),
                        rs.getInt(2), rs.getInt(3),
                        rs.getInt(5), rs.getInt(6),
                        rs.getDate(4), rs.getDate(7),
                        rs.getDouble(8));
                dsPhieuThue.add(p);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsPhieuThue;
    }

    public ArrayList<PhieuThue> docDuLieuPhieuChuaTra(){
        System.out.println("Tiến hành đọc dữ liệu phiếu thuê chưa trả");
        ArrayList<PhieuThue> dsPhieuChuaTra = new ArrayList<PhieuThue>();
        String cauLenhDoc = "SELECT * FROM PhieuChuaTra";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PhieuThue p = new PhieuThue(rs.getInt(1),
                        rs.getInt(2), rs.getInt(3),
                        rs.getInt(5), rs.getInt(6),
                        rs.getDate(4), rs.getDate(7),
                        rs.getDouble(8));
                dsPhieuChuaTra.add(p);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsPhieuChuaTra;
    }

    public boolean themPhieuThue(PhieuThue p){
        System.out.println("Tiến hành thêm phiếu thuê");
        String cauLenhThem = "EXEC THEMPHIEUTHUE ?, ?, ?, ?, ?, ?";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setInt(1, p.getMaThe());
            ps.setInt(2, p.getMaNV());
            ps.setDate(3, new Date(p.getNgayLap().getTime()));
            ps.setInt(4, p.getMaBD());
            ps.setInt(5, p.getSoLuong());
            ps.setDate(6, new Date(p.getNgayHetHan().getTime()));
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaPhieuThue(int maPhieuThue){
        System.out.println("Tiến hành xóa phiếu thuê");
        String cauLenhXoa = "EXEC XOAPHIEUTHUE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maPhieuThue);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến phiếu trả
    public ArrayList<PhieuTra> docDuLieuPhieuTra(){
        System.out.println("Tiến hành đọc dữ liệu phiếu trả");
        ArrayList<PhieuTra> dsPhieuTra = new ArrayList<>();
        String cauLenhDoc = "SELECT * FROM ThongTinPhieuTra";
        try{
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PhieuTra p = new PhieuTra(rs.getInt(1), rs.getInt(3),
                        rs.getInt(4), rs.getInt(6), rs.getInt(7),
                        rs.getDate(5), rs.getInt(2), rs.getInt(8),
                        rs.getDouble(9));
                dsPhieuTra.add(p);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsPhieuTra;
    }

    public boolean themPhieuTra(PhieuTra p){
        System.out.println("Tiến hành thêm phiếu trả");
        String cauLenhThem = "EXEC THEMPHIEUTRA ?, ?, ?, ?, ?, ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhThem);
            ps.setInt(1, p.getMaPhieuThue());
            ps.setInt(2, p.getMaThe());
            ps.setInt(3, p.getMaNV());
            ps.setDate(4, new Date(p.getNgayLap().getTime()));
            ps.setInt(5, p.getMaBD());
            ps.setInt(6, p.getSoLuong());
            ps.setInt(7, p.getTinhTrangDia());
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public boolean xoaPhieuTra(int maPhieuTra){
        System.out.println("Tiến hành xóa phiếu trả");
        String cauLenhXoa = "EXEC XOAPHIEUTRA ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhXoa);
            ps.setInt(1, maPhieuTra);
            return ps.executeUpdate() > 0;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

//    Thao tác liên quan đến doanh thu
    public ArrayList<DoanhThu> docDuLieuDoanhThu(){
        System.out.println("Tiến hành đọc dữ liệu doanh thu");
        String cauLenhDoc = "SELECT * FROM DoanhThu";
        ArrayList<DoanhThu> dsDoanhThu = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DoanhThu d = new DoanhThu(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getDouble(4), rs.getDate(5));
                dsDoanhThu.add(d);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsDoanhThu;
    }

    public double xemDoanhThuTrongNgay(){
        System.out.println("Tiến hành xem doanh thu trong ngày");
        double doanhThuNgay = 0;
        String cauLenh = "SELECT dbo.XemDoanhThuTrongNgay()";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                doanhThuNgay = rs.getDouble(1);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return doanhThuNgay;
    }

    public double xemDoanhThuThangHienTai(){
        System.out.println("Tiến hành xem doanh thu tháng hiện tại");
        double doanhThuThang = 0;
        String cauLenh = "SELECT dbo.XEMDOANHTHUTHANGHIENTAI()";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                doanhThuThang = rs.getDouble(1);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return doanhThuThang;
    }

    public double xemDoanhThuTheoThang(int thang, int nam){
        System.out.println("Tiến hành xem doanh thu theo tháng và năm được nhập từ bàn phím");
        double doanhThu = 0;
        String cauLenhDoc = "SELECT DBO.XEMDOANHTHUTHANG(?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                doanhThu = rs.getDouble(1);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return doanhThu;
    }

//    Thao tac lien quan den cac thong ke
    public ArrayList<Integer> xemTop10DiaDangBanChay(){
        ArrayList<Integer> dsMaDiaChay = new ArrayList<>();
        System.out.println("Tiến hành xem top 10 đĩa đang bán chạy");
        int maDia = 0;
        String cauLenhDoc = "SELECT * FROM XEMDIABANCHAY";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                maDia = rs.getInt(1);
                dsMaDiaChay.add(maDia);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsMaDiaChay;
    }

    public ArrayList<Integer> xemTop10DiaBanE(){
        ArrayList<Integer> dsDiaE = new ArrayList<>();
        System.out.println("Tiến hành xem top 10 đĩa đang ế");
        int maDia = 0;
        String cauLenhDoc = "SELECT * FROM XEMDIAEAM";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                maDia = rs.getInt(1);
                dsDiaE.add(maDia);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsDiaE;
    }

    public ArrayList<Integer> xemTop10KhachTreTraDia(){
        ArrayList<Integer> dsMaKhach = new ArrayList<>();
        System.out.println("Tiến hành xem top 10 khách trả đĩa chậm");
        int maKhach = 0;
        String cauLenhDoc = "SELECT * FROM XEMDANHSACHKHACHTRADIATRE";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                maKhach = rs.getInt(1);
                dsMaKhach.add(maKhach);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsMaKhach;
    }

    public ArrayList<String> xemTop2NhanVienNangSuat(){
        ArrayList<String> dsNV = new ArrayList<>();
        System.out.println("Tiến hành xem top 2 nhân viên năng suất");
        String tenKhach = "";
        String cauLenhDoc = "SELECT * FROM XEMNHANVIENBANNHIEUNHAT";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tenKhach = rs.getString(1);
                dsNV.add(tenKhach);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsNV;
    }

    public ArrayList<String> xemTop10DiaCoGiaThueRe(){
        ArrayList<String> dsMaDia = new ArrayList<>();
        System.out.println("Tiến hành xem top 10 đĩa có giá thuê rẻ");
        String tenDia = "";
        String cauLenhDoc = "SELECT * FROM TOP10DIADETIEPCAN";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhDoc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                tenDia = rs.getString(1);
                dsMaDia.add(tenDia);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dsMaDia;
    }

//    public static void main(String[] args) throws SQLException {
//        KetNoiToiCoSoDuLieu kn = new KetNoiToiCoSoDuLieu();
//        ArrayList<TaiKhoan> tk = kn.docDuLieuTaiKhoan();
//        System.out.println(tk);
//        ArrayList<NhanVien> dsNV = kn.docDuLieuNhanVien();
//        System.out.println(dsNV);
//       kn.themKhachHang(new KhachHang(1, "Thanh Hà", 1, "03311", 1, "haNoi", "2155444"));
//        kn.themTheThanhVien();
//        kn.themBangDia(new BangDia(0, "Anh yeu em", "Tình cảm", true, "Sếp's", "Không GC", 10, 10, 100000, 15000));
//
//        if (kn.themPhieuThue(new PhieuThue(1, 1, 1, 1, 5, new java.util.Date(), new java.util.Date(), 0)))
//            System.out.println("Them thanh cong");
//        else
//            System.out.println("Them thất bại");
//         kn.themPhieuTra(new PhieuTra(1, 1, 1, 1, 2, new java.util.Date(), 1, 1, 0));
//        ArrayList<PhieuThue> ps = kn.docDuLieuPhieuThue();
//        System.out.println(ps);
//        kn.xoaPhieuThue(1);
//        ArrayList<BangDia> bd = kn.docDuLieuBangDia();
//        System.out.println(bd);
//        ArrayList<DoanhThu> d = kn.docDuLieuDoanhThu();
//        System.out.println(d);
//
//        System.out.println(kn.xemDoanhThuTrongNgay());
//        System.out.println(new PhieuTra(1, 1, 1, 1, 1, new java.util.Date(), 1, 1, 0));
//        kn.ngatKetNoiToiCSDL();
//    }

}
