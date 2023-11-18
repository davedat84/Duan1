/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.DongSP;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IDongSPRepository {
    public List<DongSP> getListDongSP();
    public boolean insert(DongSP dongSP);
    public boolean delete(String ma);
    public boolean update(String ma , DongSP dongSP);
    public String getTenDongSPById(String idDongSP);
    public String getIdDongSPByTen(String tenDongSP);
    public boolean getKiemTraMaTrung(String ma);
}
