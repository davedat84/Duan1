/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulits.DBConnect;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.MauSac;
import Interface.IMauSacRepository;

/**
 *
 * @author Admin
 */
public class MauSacRepository implements IMauSacRepository {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<MauSac> getListMauSac() {
        try {
            ArrayList<MauSac> list = new ArrayList<>();
            String query = "select * from MauSac";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                MauSac mauSac = new MauSac(id, ma, ten);
                list.add(mauSac);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua select thanh cong o repository");
            return null;
        }
    }

    @Override
    public boolean insert(MauSac mauSac) {
        try {
            String query = "insert into MauSac(ma , ten) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua insert thanh cong o repository");
            return false;
        }
    }

    @Override
    public boolean delete(String ma) {
        try {
            String query = "DELETE ChiTietSP WHERE IdMauSac IN ( SELECT id FROM MauSac WHERE MauSac.Ma = ?)\n"
                    + "		DELETE MauSac WHERE MauSac.ma= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.setString(2, ma);

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua delete thanh cong o repository");
            return false;
        }
    }

    @Override

    public boolean update(String ma, MauSac mauSac) {
        try {
            String query = "update mausac set  ten =? where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, mauSac.getTen());
            ps.setString(2, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " chua update thanh cong o repository");
            return false;
        }
    }

    @Override
    public String getTenMauSacById(String idMauSac) {
        String ten = null;

        try {
            String query = "select Ten from MauSac where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idMauSac);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ten = rs.getString("Ten");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ten;
    }

    @Override
    public String getIdMauSacByTenMauSac(String tenMauSac) {
        try {
            String id = null;
            String query = "select id from MauSac where Ten  = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenMauSac);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString("id");
            }
            return id;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
