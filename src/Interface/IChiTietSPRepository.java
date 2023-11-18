/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.ChiTietSP;
import java.util.ArrayList;
import Model.ChiTietSP;

/**
 *
 * @author Admin
 */
public interface IChiTietSPRepository {

    public ArrayList<ChiTietSP> getListChiTietSP();

    public boolean insert(ChiTietSP chiTietSP);

    public boolean delete(String id);


    public boolean update(String id, ChiTietSP chiTietSP);

//    public ArrayList<ViewModelChiTietSP> getFindByTen(String tenSanPham);
//    public void updateSoLuongChiTietSP(int soLuong ,String ma  );
//    public ViewModelChiTietSP finByMaSP(String maSP);
}
