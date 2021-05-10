package KhoiDieuKhien;

import DoiTuong.BangDia;

import java.sql.*;
import java.util.ArrayList;

public class KetNoiToiCoSoDuLieu {
    private Connection conn;

    public KetNoiToiCoSoDuLieu() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=DuLieu;username=sa;password=197521");
            System.out.println("Success");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean themBangDia(BangDia bd){
        String cauLenhGhi =
                "EXEC THEMBANGDIA ?, ?, ?, ?, ?, ?, ?, ?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhGhi);
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
        String cauLenhCapNhat = "EXEC CAPNHATDIA ?,?,?,?,?,?,?,?";
        try {
            PreparedStatement ps = conn.prepareStatement(cauLenhCapNhat);
            ps.setInt(1, maBD);
            ps.setString(2, tenBD_M);
            ps.setString(3, tenBD_M);
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

//    public static void main(String[] args) throws SQLException {
//        KetNoiToiCoSoDuLieu kn = new KetNoiToiCoSoDuLieu();
//        BangDia b = new BangDia(5, "Tam", "HanhDong", true, "Russ", "", 10, 8, 100000, 12000);
////        if (kn.themBangDia(b))
////            System.out.println("Success");
////        kn.capNhatDia(3, "yeu", "yeu", "yeu", "", 12, 1521, 1200);
////        ArrayList<BangDia> tmp = kn.docDuLieuBangDia();
// //       kn.xoaBangDia(3);
//        //System.out.println(tmp.toString());
//    }

}
