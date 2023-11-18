/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.DonHangChiTiet;
import static Repository.GioHangRepository.connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Ulits.DBConnect;
import Interface.IDonHangChiTiet;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietRepository implements IDonHangChiTiet {

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DonHangChiTiet> getAll() {
        ArrayList<DonHangChiTiet> listHoaDonChiTiets = new ArrayList<>();
        try {
            String query = "select * from HoaDonChiTiet";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idHoaDon = rs.getString("IdHoaDon");
                String idChiTietSP = rs.getString("IdChiTietSP");
                int soLuong = rs.getInt("SoLuong");
                double donGia = rs.getDouble("DonGia");
                DonHangChiTiet hoaDonChiTiet = new DonHangChiTiet(idHoaDon, idChiTietSP, soLuong, donGia);
                listHoaDonChiTiets.add(hoaDonChiTiet);
            }
            return listHoaDonChiTiets;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(DonHangChiTiet hoaDonChiTiet) {
        try {
            String query = " insert into HoaDonChiTiet  values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, hoaDonChiTiet.getIdHoaDon());
            ps.setString(2, hoaDonChiTiet.getIdChiTietSP());
            ps.setInt(3, hoaDonChiTiet.getSoLuong());
            ps.setDouble(4, hoaDonChiTiet.getDonGia());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
