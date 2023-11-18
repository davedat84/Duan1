/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.NhanVien;
import java.util.ArrayList;


/**
 *
 * @author Admin
 */
public interface INhanVienRepository {

    public ArrayList<NhanVien> listGetNhanVien();

    public String getIdNhanVienByTen(String tenNhanVien);

    public String getTenNhanVienByIdNhanVien(String id);

    public boolean insert(NhanVien nhanVien);
// đây là xoá thông tin ở bảng NhanVien thôi

    public boolean delete(String ma);

    public boolean update(String ma, NhanVien nhanVien);
    // nếu xoá khoá chính của bảng CH và CV thì cũng xoá luôn thông tin ở bảng NhanVien

    public void deleteChucVuAndNhanVien(String idCV);

    public void deleteCuaHangAndNhanVien(String idCH);

    public String getMaNhanVienByIdNhanVien(String id);

    public boolean kiemTraTrungMa(String ma);
    public String getIdNhanVienByMaNhanVien(String ma);
}
