/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.NSX;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface INSXRepository {
    public ArrayList<NSX> getListNSX();
    public boolean insert(NSX nsx);
    public boolean delete(String ma);
    public boolean update(String ma , NSX nsx);
    public String getTenNSXById(String idNSX);
    public String getIdNSXByTen(String ten);
    public boolean kiemTraMaTrung(String ma);
    
}
