/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.DonHang;
import java.security.interfaces.RSAKey;
import java.util.ArrayList;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ulits.DBConnect;
import Interface.IDonHang;

/**
 *
 * @author Admin
 */
public class HoaDonRepository implements IDonHang {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DonHang> getListHoaDon() {
        try {
            ArrayList<DonHang> list = new ArrayList();
            String query = "select * from hoadon";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idKH = rs.getString("IdKH");
                String idNV = rs.getString("IdNV");
                String ma = rs.getString("Ma");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                Date ngayShip = rs.getDate("NgayShip");
                Date ngayNhan = rs.getDate("NgayNhan");
                int tinhTrang = rs.getInt("TinhTrang");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                DonHang hoaDon = new DonHang(id, idKH, idNV, ma, ngayTao, ngayThanhToan, ngayShip, ngayNhan, tinhTrang, tenNguoiNhan, diaChi, sdt);
                list.add(hoaDon);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean insert(DonHang hoaDon) {
        try {
            String query = "insert into HoaDon (IdKH,IdNV,Ma,NgayTao,NgayThanhToan,NgayShip,NgayNhan,TinhTrang,TenNguoiNhan,DiaChi,Sdt) values(?,?,?,?,?,?,?,?,?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hoaDon.getIdKH());
            ps.setString(2, hoaDon.getIdNV());
            ps.setString(3, hoaDon.getMa());
            ps.setDate(4, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            ps.setDate(6, new java.sql.Date(hoaDon.getNgayShip().getTime()));
            ps.setDate(7, new java.sql.Date(hoaDon.getNgayNhan().getTime()));
            ps.setInt(8, hoaDon.getTinhTrang());
            ps.setString(9, hoaDon.getTenNguoiNhan());
            ps.setString(10, hoaDon.getDiaChi());
            ps.setString(11, hoaDon.getSoDienThoai());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            String query = "delete from HoaDon where id  = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

//    @Override
//    public ArrayList<ViewModelHoaDon> getTimKiemByTen(int tenTinhTrang) {
//        try {
//            ArrayList<ViewModelHoaDon> list = new ArrayList();
//            String query = "SELECT HoaDon.Ma AS 'maHoaDon', HoaDon.NgayTao AS 'ngayTaoHoaDon', "
//                    + "NhanVien.Ten AS 'tenNhanVien', HoaDon.TinhTrang AS 'tinhTrangHoaDon' "
//                    + "FROM HoaDon "
//                    + "INNER JOIN NhanVien ON HoaDon.IdNV = NhanVien.Id "
//                    + "WHERE HoaDon.TinhTrang = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, tenTinhTrang);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String maHoaDon = rs.getString("maHoaDon");
//                Date ngayTaoHoaDon = rs.getDate("ngayTaoHoaDon");
//                String tenNhanVien = rs.getString("tenNhanVien");
//                int tinhTrangHoaDon = rs.getInt("tinhTrangHoaDon");
//                ViewModelHoaDon viewModelHoaDon = new ViewModelHoaDon();
//                viewModelHoaDon.setMa(maHoaDon);
//                viewModelHoaDon.setNgayTao(ngayTaoHoaDon);
//                viewModelHoaDon.setTenNV(tenNhanVien);
//                viewModelHoaDon.setTinhTrang(tinhTrangHoaDon);
//                list.add(viewModelHoaDon);
//            }
//            return list;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//    @Override
//    public void updateHoaDon(int so, String maHoaDon) {
//        try {
//            String query = "update HoaDon set tinhTrang = ?  where ma = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, so);
//            ps.setString(2, maHoaDon);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
    @Override
    public boolean update(String id, DonHang hoaDon) {
        try {
            String query = "update  HoaDon set IdKH = ?,IdNV = ?,Ma = ?,NgayTao = ?,NgayThanhToan = ?,NgayShip = ?,NgayNhan = ?,TinhTrang = ?,TenNguoiNhan = ?,DiaChi = ?,Sdt = ? where id =? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hoaDon.getIdKH());
            ps.setString(2, hoaDon.getIdNV());
            ps.setString(3, hoaDon.getMa());
            ps.setDate(4, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            ps.setDate(6, new java.sql.Date(hoaDon.getNgayShip().getTime()));
            ps.setDate(7, new java.sql.Date(hoaDon.getNgayNhan().getTime()));
            ps.setInt(8, hoaDon.getTinhTrang());
            ps.setString(9, hoaDon.getTenNguoiNhan());
            ps.setString(10, hoaDon.getDiaChi());
            ps.setString(11, hoaDon.getSoDienThoai());
            ps.setString(12, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean kiemTraMaTrung(String ma) {

        try {
            String query = "select ma  from HoaDon where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getMaHoaDonByIdHoaDon(String id) {
        String ma = null;
        try {
            String query = " select ma from HoaDon where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = rs.getString("Ma");
            }
            return ma;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getIdHDCTByMaHDCT(String ma) {
        String id = null;
        try {
            String query = "select id from HoaDon where ma = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

//@Override
//public int checkTinhTrang(String maHD) {
//        Integer tinhTrang = -1;
//        try {
//            String query = "select tinhTrang from HoaDon where ma = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, maHD);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                 tinhTrang = rs.getInt("TinhTrang");
//            }
//            return tinhTrang; 
//           
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return -1;
//        }
//    }

//}
