/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IKhachHangRepository {

    public ArrayList<KhachHang> getListKhachHang();

    public boolean insert(KhachHang khachHang);

    public boolean delete(String ma);

    public String getTenKhachHangByIdKhachHang(String id);

    public boolean update(String ma, KhachHang khachHang);

    public String getIdKhachHangByTen(String tenKhachHang);

    public String getMaKhachHangByIdKhachHang(String id);

    public boolean kiemTraMaTrung(String ma);

    public String getIdKhachHangByMaKhachHang(String ma);

}
