/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.CuaHang;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public interface ICuaHangRepository {
    public ArrayList<CuaHang> listGetCuaHang();
    public boolean insert(CuaHang cuaHang);
    public boolean delete(String ma);
    public boolean update(String ma, CuaHang cuaHang);
    public boolean kiemTraMaTrung(String ma);
    public String getTenCuaHangById(String id);
    public String getIdByTenCuaHang(String ten);
    public String getIdByMa(String ma);
    public boolean kiemTraTenTrung(String ten);
}
