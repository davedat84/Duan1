/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChucVu;
import Model.CuaHang;
import Model.NhanVien;
import Interface.INhanVienRepository;
import java.sql.Connection;
import java.util.ArrayList;
import Ulits.DBConnect;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
public class NhanVienRepository implements INhanVienRepository {

    private static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<NhanVien> listGetNhanVien() {
        try {
            ArrayList<NhanVien> list = new ArrayList();
            String query = "select * from NhanVien ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                String gioiTinh = rs.getString("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                String matKhau = rs.getString("MatKhau");
                String idCH = rs.getString("IdCH");
                String idCV = rs.getString("IdCV");
                String idGuiBC = rs.getString("IdGuiBC");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nhanVien = new NhanVien(id, ma, ten, tenDem, ho, gioiTinh, ngaySinh, diaChi, sdt, matKhau, idCH, idCV, idGuiBC, trangThai);
                list.add(nhanVien);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getIdNhanVienByTen(String tenNhanVien) {
        try {
            String id = "";
            String query = "select id from NhanVien where ten = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenNhanVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(NhanVien nhanVien) {
        try {
            String query = "insert into NhanVien(Ma,Ten,TenDem,Ho,GioiTinh,NgaySinh,DiaChi,Sdt,MatKhau,IdCH,IdCV,IdGuiBC,TrangThai) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nhanVien.getMa());
            ps.setString(2, nhanVien.getTen());
            ps.setString(3, nhanVien.getTenDem());
            ps.setString(4, nhanVien.getHo());
            ps.setString(5, nhanVien.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            ps.setString(7, nhanVien.getDiaChi());
            ps.setString(8, nhanVien.getSoDienThoai());
            ps.setString(9, nhanVien.getMatKhau());
            ps.setString(10, nhanVien.getIdCH());
            ps.setString(11, nhanVien.getIdCV());
            ps.setString(12, nhanVien.getIdGuiBC());
            ps.setInt(13, nhanVien.getTrangThai());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            String query = "delete from NhanVien where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(String ma, NhanVien nhanVien) {
        try {
            String query = "update NhanVien set Ma=?,Ten=?,TenDem=?,Ho=?,GioiTinh=?,NgaySinh=?,DiaChi=?,Sdt=?,MatKhau=?,IdCH=?,IdCV=?,IdGuiBC=?,TrangThai=? where ma =? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nhanVien.getMa());
            ps.setString(2, nhanVien.getTen());
            ps.setString(3, nhanVien.getTenDem());
            ps.setString(4, nhanVien.getHo());
            ps.setString(5, nhanVien.getGioiTinh());
            ps.setDate(6, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            ps.setString(7, nhanVien.getDiaChi());
            ps.setString(8, nhanVien.getSoDienThoai());
            ps.setString(9, nhanVien.getMatKhau());
            ps.setString(10, nhanVien.getIdCH());
            ps.setString(11, nhanVien.getIdCV());
            ps.setString(12, nhanVien.getIdGuiBC());
            ps.setInt(13, nhanVien.getTrangThai());
            ps.setString(14, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteChucVuAndNhanVien(String idCV) {
        try {
            String query = "delete from NhanVien where IdCV =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCV);
            System.out.println("id" + " " + idCV);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCuaHangAndNhanVien(String idCH) {
        try {
            String query = "delete from NhanVien where idCH =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idCH);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean kiemTraTrungMa(String ma) {
        try {
            String query = "select ma from NhanVien where ma = ?";
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
    public String getTenNhanVienByIdNhanVien(String id) {
        try {
            String ten = null;
            String query = "select ten from NhanVien where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ten = rs.getString("Ten");
            }
            return ten;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getMaNhanVienByIdNhanVien(String id) {
        try {
            String ma = null;
            String query = "select Ma from NhanVien where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = rs.getString("Ma");
            }
            System.out.println("manv"+" "+ma);
            return ma;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getIdNhanVienByMaNhanVien(String ma) {
        try {
            String id = "";
            String query = "select Id from NhanVien where Ma = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
