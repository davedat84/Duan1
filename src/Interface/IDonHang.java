/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.DonHang;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public interface IDonHang {
//    public ArrayList<HoaDon> getListHD();

    public ArrayList<DonHang> getListHoaDon();

    public boolean insert(DonHang hoaDon);

    public boolean delete(String id);

    public String getMaHoaDonByIdHoaDon(String id);

    public boolean kiemTraMaTrung(String ma);

    public String getIdHDCTByMaHDCT(String ma);

    public boolean update(String id, DonHang hoaDon);
//    public ArrayList<ViewModelHoaDon> getTimKiemByTen(int tenTinhTrang);

//    public void updateHoaDon(int so,String maHoaDon );
//    public int  checkTinhTrang(String maHD);
}
