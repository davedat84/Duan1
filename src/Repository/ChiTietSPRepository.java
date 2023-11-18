/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Ulits.DBConnect;
import Model.ChiTietSP;
import Model.DongSP;
import Model.MauSac;
import Model.NSX;
import Model.SanPham;
import Interface.IChiTietSPRepository;
import Interface.IDongSPRepository;
import Interface.IMauSacRepository;
import Interface.INSXRepository;
import Interface.ISanPhamRepository;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Model.ChiTietSP;

/**
 *
 * @author Admin
 */
public class ChiTietSPRepository implements IChiTietSPRepository {

    private static Connection connection = null;

    static {
        try {
            connection = DBConnect.getConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<ChiTietSP> getListChiTietSP() {
        try {
            ArrayList<ChiTietSP> listChiTietSP = new ArrayList<>();
            String query = "select * from ChiTietSP";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("Id");
                String idSP = rs.getString("IdSP");
                String idNSX = rs.getString("IdNsx");
                String idMauSac = rs.getString("IdMauSac");
                String idDongSP = rs.getString("IdDongSP");
                int namBH = rs.getInt("NamBH");
                String moTa = rs.getString("MoTa");
                int soLuongTon = rs.getInt("SoLuongTon");
                double giaNhap = rs.getDouble("GiaNhap");
                double giaBan = rs.getDouble("GiaBan");
                ChiTietSP chiTietSP = new ChiTietSP(id, idSP, idNSX, idMauSac, idDongSP, namBH, moTa, soLuongTon, giaNhap, giaBan);
                listChiTietSP.add(chiTietSP);

            }
            return listChiTietSP;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(ChiTietSP chiTietSP) {
        try {
            String query = "insert into ChiTietSP(IdSP,IdNsx,IdMauSac,IdDongSP,NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chiTietSP.getIdSP());
            ps.setString(2, chiTietSP.getIdNSX());
            ps.setString(3, chiTietSP.getIdMauSac());
            ps.setString(4, chiTietSP.getIdDongSP());
            ps.setInt(5, chiTietSP.getNamBH());
            ps.setString(6, chiTietSP.getMoTa());
            ps.setInt(7, chiTietSP.getSoLuongTon());
            ps.setDouble(8, chiTietSP.getGiaNhap());
            ps.setDouble(9, chiTietSP.getGiaBan());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chua insert thanh cong");
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try {
            String query = "delete from ChiTietSP where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(String id, ChiTietSP chiTietSP) {
        try {
            String query = "update ChiTietSP set IdSP =? , IdNsx=? ,IdMauSac=? ,IdDongSP=? ,NamBH=? ,MoTa=? ,SoLuongTon=? ,GiaNhap=? ,GiaBan=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chiTietSP.getIdSP());
            ps.setString(2, chiTietSP.getIdNSX());
            ps.setString(3, chiTietSP.getIdMauSac());
            ps.setString(4, chiTietSP.getIdDongSP());
            ps.setInt(5, chiTietSP.getNamBH());
            ps.setString(6, chiTietSP.getMoTa());
            ps.setInt(7, chiTietSP.getSoLuongTon());
            ps.setDouble(8, chiTietSP.getGiaNhap());
            ps.setDouble(9, chiTietSP.getGiaBan());
            ps.setString(10, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
//
//    @Override
//    public ArrayList<ViewModelChiTietSP> getFindByTen(String tenSanPham) {
//        ArrayList<ViewModelChiTietSP> listViewModelChiTietSPs = new ArrayList();
//        try {
//            String query = "select chitietsp.Id as 'id', SanPham.MA as 'masp' , SanPham.Ten as'TenSp',NSX.ten as'Tennsx', MauSac.ten as 'tenmausac', DongSP.Ten as'tenDongSP', ChiTietSP.NamBH, ChiTietSP.SoLuongTon, ChiTietSP.MoTa, ChiTietSP.GiaNhap, ChiTietSP.GiaBan\n"
//                    + "                                   FROM ChiTietSP JOIN SanPham ON SanPham.Id = ChiTietSP.IdSP\n"
//                    + "                                				JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id\n"
//                    + "                                 				JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id\n"
//                    + "                                    				JOIN NSX ON ChiTietSP.IdNsx = NSX.Id  where SanPham.Ten = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, tenSanPham);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String masp = rs.getString("masp");
//                String tensp = rs.getString("tensp");
//                String tennsx = rs.getString("tennsx");
//                String tenmausac = rs.getString("tenmausac");
//                String tendongsp = rs.getString("tendongsp");
//                int namBh = rs.getInt("namBh");
//                int soLuongTon = rs.getInt("soLuongTon");
//                BigDecimal giaNhap = rs.getBigDecimal("giaNhap");
//                BigDecimal giaBan = rs.getBigDecimal("giaBan");
//                String moTa = rs.getString("moTa");
//                ViewModelChiTietSP viewModelChiTietSP = new ViewModelChiTietSP(id, masp, tensp, tennsx, tenmausac, tendongsp, namBh, moTa, soLuongTon, giaNhap, giaBan);
//                System.out.println("select" + viewModelChiTietSP);
//                listViewModelChiTietSPs.add(viewModelChiTietSP);
//            }
//            return listViewModelChiTietSPs;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public void updateSoLuongChiTietSP(int soLuong, String id) {
//        try {
//            String query = "UPDATE ChiTietSP  SET SoLuongTon = ? WHERE id = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, soLuong);
//            ps.setString(2, id);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public ViewModelChiTietSP finByMaSP(String maSP) {
//
//        try {
//            String query = "select chitietsp.Id as 'id', SanPham.MA as 'masp' , SanPham.Ten as'TenSp',NSX.ten as'Tennsx', MauSac.ten as 'tenmausac', DongSP.Ten as'tenDongSP', ChiTietSP.NamBH, ChiTietSP.SoLuongTon, ChiTietSP.MoTa, ChiTietSP.GiaNhap, ChiTietSP.GiaBan\n"
//                    + "                                   FROM ChiTietSP JOIN SanPham ON SanPham.Id = ChiTietSP.IdSP\n"
//                    + "                                				JOIN DongSP ON ChiTietSP.IdDongSP = DongSP.Id\n"
//                    + "                                 				JOIN MauSac ON ChiTietSP.IdMauSac = MauSac.Id\n"
//                    + "                                    				JOIN NSX ON ChiTietSP.IdNsx = NSX.Id  where SanPham.Ma = ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, maSP);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String ma = rs.getString("masp");
//                String tenSP = rs.getString("TenSp");
//                String tennsx = rs.getString("tennsx");
//                String tenmausac = rs.getString("tenmausac");
//                String tendongsp = rs.getString("tendongsp");
//                int namBh = rs.getInt("namBh");
//                int soLuongTon = rs.getInt("soLuongTon");
//                BigDecimal giaNhap = rs.getBigDecimal("giaNhap");
//                BigDecimal giaBan = rs.getBigDecimal("giaBan");
//                String moTa = rs.getString("moTa");
//                ViewModelChiTietSP viewModelChiTietSP = new ViewModelChiTietSP(id, ma, tenSP, tennsx, tenmausac, tendongsp, namBh, moTa, soLuongTon, giaNhap, giaBan);
//                return viewModelChiTietSP;
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return null;
//
//    }

 
}
