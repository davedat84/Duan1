/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulits.DBConnect;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.DongSP;
import Interface.IDongSPRepository;

/**
 *
 * @author Admin
 */
public class DongSPRepository implements IDongSPRepository {

    private static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // load 

    @Override
    public List<DongSP> getListDongSP() {
        try {
            List<DongSP> list = new ArrayList<>();
            String query = "select * from DongSP";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                DongSP dongSP = new DongSP(id, ma, ten);
                list.add(dongSP);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Chưa select thành công ở repository");
            return null;
        }

    }

    @Override
    // insert 
    public boolean insert(DongSP dongSP) {
        try {
            String query = "insert into DongSP(ma, ten) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, dongSP.getMa());
            ps.setString(2, dongSP.getTen());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Chưa insert thành công ở repository");
            return false;
        }
    }

    @Override
    // delete 
    public boolean delete(String ma) {
        try {
            String query = "DELETE ChiTietSP WHERE IdDongSP IN ( SELECT id FROM DongSP WHERE DongSP.Ma = ?)\n"
                    + "		DELETE DongSP WHERE DongSP.ma= ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.setString(2, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Chưa delete thành công ở repository");
            return false;

        }

    }

    @Override
    // update 
    public boolean update(String ma, DongSP dongSP) {
        try {
            String query = "update DongSP set  ten = ? where ma = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, dongSP.getTen());
            ps.setString(2, ma);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Chưa update thành công ở repository");
            return false;

        }

    }

    @Override
    public String getTenDongSPById(String idDongSP) {
        try {
            String ten = null;
            String query = "select Ten from DongSP where Id =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idDongSP);
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
    public String getIdDongSPByTen(String tenDongSP) {
        try {
            String id = null;
            String query = "select id from DongSP where ten = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenDongSP);
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

    @Override
    public boolean getKiemTraMaTrung(String ma) {

        try {
            String query = "select ma from DongSP where ma =?";
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

}
