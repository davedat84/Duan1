/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Model.MauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IMauSacRepository {
    public ArrayList<MauSac> getListMauSac();
    boolean insert(MauSac mauSac);
    boolean delete(String ma);
    boolean update(String ma , MauSac mauSac);
    
    public String getTenMauSacById(String idMauSac);
    
    public String getIdMauSacByTenMauSac(String ten);
}
