/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface IChucVuRepository {

    public ArrayList<ChucVu> getListChucVu();

    public boolean insert(ChucVu chucVu);

    public boolean delete(String ma);

    public boolean update(String ma, ChucVu chucVu);

    public boolean kiemTraMaTrung(String ma);

    public String getTenChucVuById(String id);

    public String getIdChucVuByTen(String ten);

    public String getIdChucVuByMa(String ma);

    public boolean kiemTraTenTrung(String ten);

}
