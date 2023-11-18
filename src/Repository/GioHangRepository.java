/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.GioHang;
import Interface.IGioHangRepository;
import Ulits.DBConnect;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Admin
 */
public class GioHangRepository implements IGioHangRepository {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<GioHang> getAll() {
        ArrayList<GioHang> list = new ArrayList();
        try {
            String query = "select* from GioHang";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idKH = rs.getString("IdKH");
                String idNV = rs.getString("IdNV");
                String ma = rs.getString("Ma");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String diaChi = rs.getString("DiaChi");
                String sdt = rs.getString("Sdt");
                int tinhTrang = rs.getInt("TinhTrang");
                GioHang gioHang = new GioHang(id, idKH, idNV, ma, ngayTao, ngayThanhToan, tenNguoiNhan, diaChi, diaChi, tinhTrang);
                list.add(gioHang);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
    public boolean insert(GioHang gioHang) {
        try {
            String query = "insert into GioHang(IdKH,IdNV,Ma,NgayTao,NgayThanhToan,TenNguoiNhan,DiaChi,Sdt,TinhTrang) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, gioHang.getIdKH());
            ps.setString(2, gioHang.getIdNV());
            ps.setString(3, gioHang.getMa());
            ps.setDate(4, new java.sql.Date(gioHang.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(gioHang.getNgayThanhToan().getTime()));
            ps.setString(6, gioHang.getTenNguoiNhan());
            ps.setString(7, gioHang.getDiaChi());
            ps.setString(8, gioHang.getSoDienThoai());
            ps.setInt(9, gioHang.getTinhTrang());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
