/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.DonHangChiTiet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IDonHangChiTiet {
    public ArrayList<DonHangChiTiet> getAll();
    public boolean insert(DonHangChiTiet  hoaDonChiTiet);
    
}
