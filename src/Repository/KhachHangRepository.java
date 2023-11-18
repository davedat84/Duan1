/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.KhachHang;
import Interface.IKhachHangRepository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ulits.DBConnect;

/**
 *
 * @author Admin
 */
public class KhachHangRepository implements IKhachHangRepository {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<KhachHang> getListKhachHang() {
        try {
            ArrayList<KhachHang> list = new ArrayList();
            String query = " select * from KhachHang";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String tenDem = rs.getString("TenDem");
                String ho = rs.getString("Ho");
                Date ngaySinh = rs.getDate("NgaySinh");
                String soDienThoai = rs.getString("Sdt");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                String matKhau = rs.getString("MatKhau");
                KhachHang khachHang = new KhachHang(id, ma, ten, tenDem, ho, ngaySinh, soDienThoai, diaChi, thanhPho, quocGia, matKhau);
                list.add(khachHang);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(KhachHang khachHang) {
        try {
            String query = "insert into KhachHang(Ma, Ten ,TenDem,Ho,NgaySinh,Sdt,DiaChi,ThanhPho,QuocGia,MatKhau) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, khachHang.getMa());
            ps.setString(2, khachHang.getTen());
            ps.setString(3, khachHang.getTenDem());
            ps.setString(4, khachHang.getHo());
            ps.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            ps.setString(6, khachHang.getSoDienThoai());
            ps.setString(7, khachHang.getDiaChi());
            ps.setString(8, khachHang.getThanhPho());
            ps.setString(9, khachHang.getQuocGia());
            ps.setString(10, khachHang.getMatKhau());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(String ma) {
        try {
            String query = "delete from KhachHang where ma  = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(String ma, KhachHang khachHang) {
        try {
            String query = "update KhachHang set Ma=? ,Ten =?,TenDem =?,Ho=?,NgaySinh=?,Sdt=?,DiaChi=?,ThanhPho=?,QuocGia=?,MatKhau=? where ma = ? ";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, khachHang.getMa());
            ps.setString(2, khachHang.getTen());
            ps.setString(3, khachHang.getTenDem());
            ps.setString(4, khachHang.getHo());
            ps.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            ps.setString(6, khachHang.getSoDienThoai());
            ps.setString(7, khachHang.getDiaChi());
            ps.setString(8, khachHang.getThanhPho());
            ps.setString(9, khachHang.getQuocGia());
            ps.setString(10, khachHang.getMatKhau());
            ps.setString(11, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public String getIdKhachHangByTen(String tenKhachHang) {
        try {
            String id = "";
            String query = "select Id from KhachHang where Ten = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenKhachHang);
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
    public boolean kiemTraMaTrung(String ma) {
        try {
            String query = "select ma from KhachHang where ma =?";
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
    public String getTenKhachHangByIdKhachHang(String id) {
        try {
            String ten = null;
            String query = "select ten from KhachHang where Id = ?";
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
    public String getMaKhachHangByIdKhachHang(String id) {
        try {
            String ma = null;
            String query = "select ma from KhachHang where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = rs.getString("Ma");
            }
            return ma;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getIdKhachHangByMaKhachHang(String ma) {
         try {
            String id = "";
            String query = "select Id from KhachHang where Ma = ?";
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


