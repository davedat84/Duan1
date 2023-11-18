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
import Model.ChucVu;
import Interface.IChucVuRepository;

/**
 *
 * @author Admin
 */
public class ChucVuRepository implements IChucVuRepository {

    private static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<ChucVu> getListChucVu() {
        try {
            ArrayList<ChucVu> list = new ArrayList<>();
            String query = "select Id,Ma,Ten from ChucVu";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                ChucVu chucVu = new ChucVu(id, ma, ten);
                list.add(chucVu);
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chưa select thành công ở repository");
            return null;
        }
    }

    @Override
    // insert 
    public boolean insert(ChucVu chucVu) {
        try {
            String query = "insert into ChucVu (ma, ten) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chucVu.getMa());
            ps.setString(2, chucVu.getTen());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Chưa insert thành công ở repository");
            return false;
        }
    }

    @Override
    // delete 
    public boolean delete(String ma) {
        try {
            String query = "delete from ChucVu where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chưa delete thành công ở repository");
            return false;

        }

    }

    @Override
    // update 
    public boolean update(String ma, ChucVu chucVu) {
        try {
            String query = "update ChucVu set ma = ? , ten =? where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chucVu.getMa());
            ps.setString(2, chucVu.getTen());
            ps.setString(3, ma);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua update duoc o repository");
            return false;
        }

    }

    @Override
    public boolean kiemTraMaTrung(String ma) {
        try {
            String query = "select ma from chucVu where ma=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true; // mã đã tồn tại 
            } else {
                return false; // mã chưa tồn tại 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getTenChucVuById(String id) {
        String ten = "";
        try {
            String query = "select Ten from ChucVu where id =?";
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
    public String getIdChucVuByTen(String ten) {
        String id = null;
        try {
            String query = "select id from chucvu where ten =?";
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
    public String getIdChucVuByMa(String ma) {
        String id = null;
        try {
            String query = "select id from chucvu where ma =?";
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
            String query = "select ten from ChucVu where ten =?";
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
