/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String id;

    public SanPham(String id, String maSach, String tenSach, String soLuong, double giaBan, String ngayThem, String danhMuc, boolean trangThai) {
        this.id = id;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.ngayThem = ngayThem;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
    }
    private String maSach ;
    private String tenSach ;
    private String soLuong ;
    private double giaBan;
    private String ngayThem;
    private String danhMuc;
    private boolean trangThai;

    public SanPham() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   
    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(String ngayThem) {
        this.ngayThem = ngayThem;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", ngayThem=" + ngayThem + ", danhMuc=" + danhMuc + ", trangThai=" + trangThai + '}';
    }

      
    
}
