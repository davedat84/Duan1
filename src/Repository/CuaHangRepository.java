/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.CuaHang;
import Interface.ICuaHangRepository;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ulits.DBConnect;

/**
 *
 * @author Admin
 */
public class CuaHangRepository implements ICuaHangRepository {

    private static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<CuaHang> listGetCuaHang() {
        ArrayList<CuaHang> list = new ArrayList();
        try {
            String query = "select * from CuaHang";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                String diaChi = rs.getString("DiaChi");
                String thanhPho = rs.getString("ThanhPho");
                String quocGia = rs.getString("QuocGia");
                CuaHang cuaHang = new CuaHang(id, ma, ten, diaChi, thanhPho, quocGia);
                list.add(cuaHang);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(CuaHang cuaHang) {
        try {
            String query = "insert into CuaHang(Ma,Ten,DiaChi,ThanhPho,QuocGia) values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cuaHang.getMa());
            ps.setString(2, cuaHang.getTen());
            ps.setString(3, cuaHang.getDiaChi());
            ps.setString(4, cuaHang.getThanhPho());
            ps.setString(5, cuaHang.getQuocGia());
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
            String query = "delete from CuaHang where ma =?";
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
    public boolean update(String ma, CuaHang cuaHang) {
        try {
            String query = "update CuaHang set Ma =?,Ten =?, DiaChi =?, ThanhPho = ?, QuocGia =? where ma = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cuaHang.getMa());
            ps.setString(2, cuaHang.getTen());
            ps.setString(3, cuaHang.getDiaChi());
            ps.setString(4, cuaHang.getThanhPho());
            ps.setString(5, cuaHang.getQuocGia());
            ps.setString(6, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean kiemTraMaTrung(String ma) {
        try {
            String query = "select ma from CuaHang where ma =?";
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
    public String getTenCuaHangById(String id) {
        String ten = "";
        try {
            String query = "select Ten from CuaHang where id =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ten = rs.getString("Ten");
            }
            return ten;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getIdByTenCuaHang(String ten) {
        String id = null;
        try {
            String query = "select id from cuahang where ten =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("Id");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public String getIdByMa(String ma) {
        String id = null;
        try {
            String query = "select id from cuahang where ma =?";
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

    @Override
    public boolean kiemTraTenTrung(String ten) {
        try {
            String query = "select ten from CuaHang where ten =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true; // ten đã tồn tại 
            } else {
                return false; // ten chưa tồn tại 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
