/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulits.DBConnect;
import java.util.List;
import Model.SanPham;
import Interface.ISanPhamRepository;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SanPhamRepository implements ISanPhamRepository {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<SanPham> getListSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        try {
            String query = "select * from sanpham";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma sach");
                String ten = rs.getString("Ten sach");
                String soLuong = rs.getString("So luong");
                String giaBan = rs.getString("Gia ban");
                String ngayThem = rs.getString("Ngay them");
                String danhMuc = rs.getString("Danh muc");
                String trangThai = rs.getString("Trang thai");

                SanPham sanPham = new SanPham(id, ma, ten, soLuong, 0, ngayThem, danhMuc, true);
                list.add(sanPham);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua select thanh cong o repository");
            return null;
        }
    }

    @Override
    public boolean insert(SanPham sanPham) {
        try {
            String query = " Insert into SanPham(ma , ten)  values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, sanPham.getMaSach());
            ps.setString(2, sanPham.getTenSach());
            ps.setString(3, sanPham.getSoLuong());
            ps.setDouble(4, sanPham.getGiaBan());
            ps.setString(5, sanPham.getNgayThem());
            ps.setString(6, sanPham.getDanhMuc());
            ps.setBoolean(7, sanPham.isTrangThai());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua insert thanh cong o repository");
            return false;
        }

    }

    @Override
    public boolean deleteSanPhamAndChiTietSP(String ma) {
        try {
            String query = "delete * from SanPham where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua delete  thanh cong o repository");
            return false;
        }
    }

    @Override
    public boolean update(String ma, SanPham sanPham) {
        try {
            String query = " update SanPham set ma= ?, ten = ? where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, sanPham.getMaSach());
            ps.setString(2, sanPham.getTenSach());
            ps.setString(3, sanPham.getSoLuong());
            ps.setDouble(4, sanPham.getGiaBan());
            ps.setString(5, sanPham.getNgayThem());
            ps.setString(6, sanPham.getDanhMuc());
            ps.setBoolean(7, sanPham.isTrangThai());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua update thanh cong o repository");
            return false;

        }
    }

    // tìm mã 
//    public String getByMa(String ma){
//        try {
//            String query ="select ma from SanPham where ma =?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            ps.setString(1, ma);
//           
//            while (rs.next()) {                
//                return rs.getString("ma");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,"Chua tim duoc ma");
//           
//        }
//         return null ;
//    }
    @Override
    public String getTenSanPhamById(String idSanPham) {
        try {
            String ten = null;
            String query = "select ten from SanPham where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idSanPham);
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
    public String idSanPhamByTen(String tenSP) {
        String id = null;
        try {
            String query = " select id from SanPham where ten = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
            return id;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chua lay duoc id cua SanPham");
            return null;
        }
    }

    @Override
    public String getMaSPByIdSp(String idSP) {
        String ma = null;
        try {
            String query = "select ma from SanPham where id =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ma = rs.getString("ma");
            }
            return ma;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean kiemTraMaTrung(String ma) {

        try {
            String query = "select Ma from SanPham where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeQuery();
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
    public String getIdByMaSanPham(String ma) {
        String id = null;
        try {
            String query = "select id from SanPham where ma =?";
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
