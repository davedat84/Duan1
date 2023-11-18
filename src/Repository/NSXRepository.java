/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulits.DBConnect;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.NSX;
import Interface.INSXRepository;

/**
 *
 * @author Admin
 */
public class NSXRepository implements INSXRepository {

    public static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// load 

    @Override
    public ArrayList<NSX> getListNSX() {
        ArrayList<NSX> list = new ArrayList<>();

        try {
            String query = "select * from NSX";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                NSX nsx = new NSX(id, ma, ten);
                list.add(nsx);
                System.out.println("da them thanh cong repository");
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua select thanh cong o repository");
            return null;
        }
    }

    // insert 
    @Override
    public boolean insert(NSX nsx) {
        try {
            String query = "insert into NSX(ma , ten) values(?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nsx.getMa());
            ps.setString(2, nsx.getTen());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua insert thanh cong o repository");
            return false;

        }
    }

    // delete 
    @Override
    public boolean delete(String ma) {
        try {
            String query = "DELETE ChiTietSP WHERE IdNsx IN ( SELECT id FROM NSX WHERE NSX.Ma = ?)\n"
                    + "		DELETE NSX WHERE NSX.ma= ?";
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
// update 

    @Override
    public boolean update(String ma, NSX nsx) {
        try {
            String query = "update NSX set ten = ? where ma =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nsx.getTen());
            ps.setString(2, ma);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "chua update thanh cong o repository");
            return false;

        }
    }

    @Override
    public String getTenNSXById(String idNSX) {
        try {
            String ten = null;
            String query = "select Ten from NSX where Id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, idNSX);
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
    public String getIdNSXByTen(String tenNSX) {
        try {
            String id = null;
            String query = "select id from NSX where ten =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, tenNSX);
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
    public boolean kiemTraMaTrung(String ma) {
        try {
            String query = "select ma from NSX where ma =?";
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
