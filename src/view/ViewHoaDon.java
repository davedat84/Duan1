/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.HoaDon;
import domainmodel.KhachHang;
import domainmodel.NhanVien;
import iservice.IHoaDonService;
import iservice.IKhachHangSerivce;
import iservice.INhanVienService;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import viewmodel.ViewModelHoaDon;
import viewmodel.ViewModelKhachHang;
import viewmodel.ViewModelNhanVien;

/**
 *
 * @author Admin
 */
public class ViewHoaDon extends javax.swing.JFrame {

    public IHoaDonService iHoaDonService = new HoaDonService();
    public IKhachHangSerivce iKhachHangSerivce = new KhachHangService();
    public INhanVienService iNhanVienService = new NhanVienService();

    /**
     * Creates new form ViewHoaDon
     */
    public ViewHoaDon() {
        initComponents();
        loadTable(iHoaDonService.getAll());
        loadComBoBoxKhachHang();
        loadComBoBoxNhanVien();
    }

    public void loadTable(ArrayList<ViewModelHoaDon> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblHoaDonForm.getModel();
        defaultTableModel.setRowCount(0);
        for (ViewModelHoaDon viewModelHoaDon : list) {
            defaultTableModel.addRow(new Object[]{
                viewModelHoaDon.getTenKH(), viewModelHoaDon.getTenNV(), viewModelHoaDon.getMa(), viewModelHoaDon.getNgayTao(), viewModelHoaDon.getNgayThanhToan(), viewModelHoaDon.getNgayShip(), viewModelHoaDon.getNgayNhan(), viewModelHoaDon.getTinhTrang() == 0 ? "Thanh toán" : "Huỷ", viewModelHoaDon.getTenNguoiNhan(), viewModelHoaDon.getDiaChi(), viewModelHoaDon.getSoDienThoai(), viewModelHoaDon.getId()
            });
        }

    }

    public ViewModelHoaDon getData() {
        ViewModelHoaDon viewModelHoaDon = new ViewModelHoaDon();
        String ma = txtMa.getText();
        String ngayTao = txtNgayTao.getText();
        String ngayThanhToan = txtNgayThanhToan.getText();
        String ngayShip = txtNgayShip.getText();
        String ngayNhan = txtNgayNhan.getText();
        String tenNguoiNhan = txtTenNguoiNhan.getText();
        String diaChi = txtDiaChi.getText();
        String soDienThoai = txtSDT.getText();
        // check validate
        if (ma.trim().equals("") || ngayTao.trim().equals("") || ngayShip.trim().equals("") || ngayNhan.trim().equals("") || ngayThanhToan.trim().equals("") || tenNguoiNhan.trim().equals("") || soDienThoai.trim().equals("") || diaChi.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Không được rỗng");
            return null;
        }
        try {
            LocalDate localDate = LocalDate.parse(ngayTao);
            viewModelHoaDon.setNgayTao(java.sql.Date.valueOf(localDate));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chua dung dinh dang ngay tạo");
            return null;
        }
        // ngày tạo 
        try {
            LocalDate localDate = LocalDate.parse(ngayTao);
            viewModelHoaDon.setNgayTao(java.sql.Date.valueOf(localDate));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chua dung dinh dang ngày tạo");
            return null;
        }
// ngày thanh toán 
        try {
            LocalDate localDate = LocalDate.parse(ngayThanhToan);
            viewModelHoaDon.setNgayThanhToan(java.sql.Date.valueOf(localDate));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chua dung dinh dang ngày thanh toán");
            return null;
        }
        // ngày ship 
        try {
            LocalDate localDate = LocalDate.parse(ngayShip);
            viewModelHoaDon.setNgayShip(java.sql.Date.valueOf(localDate));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chua dung dinh dang ngày ship");
            return null;
        }
        // ngày nhận 
        try {
            LocalDate localDate = LocalDate.parse(ngayNhan);
            viewModelHoaDon.setNgayNhan(java.sql.Date.valueOf(localDate));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "chua dung dinh dang ngày nhận");
            return null;
        }

        if (rdoThanhToan.isSelected()) {
            viewModelHoaDon.setTinhTrang(0);
        } else if (rdoHuy.isSelected()) {
            viewModelHoaDon.setTinhTrang(1);
        }

        // lấy ra tên theo combobox
        String tenKhachHang = cbbKhachHang.getSelectedItem().toString();
        String tenNhanVien = cbbNhanVien.getSelectedItem().toString();
        // lấy tên ra id 
        String idKhachHang = iKhachHangSerivce.getIdByTenKhachHang(tenKhachHang);
        String idNhanVien = iNhanVienService.getIdNhanVienByTenNhanVien(tenNhanVien);
        // thêm vào 
        viewModelHoaDon.setTenKH(idKhachHang);
        viewModelHoaDon.setTenNV(idNhanVien);
        viewModelHoaDon.setMa(ma);
        viewModelHoaDon.setTenNguoiNhan(tenNguoiNhan);
        viewModelHoaDon.setDiaChi(diaChi);
        viewModelHoaDon.setSoDienThoai(soDienThoai);

        return viewModelHoaDon;
    }

    public void loadComBoBoxKhachHang() {
        ArrayList<ViewModelKhachHang> listKhachHang = iKhachHangSerivce.getAll();
        for (ViewModelKhachHang viewModelKhachHang : listKhachHang) {
            cbbKhachHang.addItem(viewModelKhachHang.getTen());
        }
    }

    public void loadComBoBoxNhanVien() {
        ArrayList<ViewModelNhanVien> listNhanVien = iNhanVienService.getAll();
        for (ViewModelNhanVien viewModelNhanVien : listNhanVien) {
            cbbNhanVien.addItem(viewModelNhanVien.getTen());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbbNhanVien = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNgayThanhToan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayShip = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNgayNhan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTenNguoiNhan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonForm = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        rdoThanhToan = new javax.swing.JRadioButton();
        rdoHuy = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hoá Đơn");

        jLabel2.setText("Tên KH");

        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên NV");

        jLabel4.setText("Ma");

        jLabel5.setText("NgayTao");

        jLabel6.setText("NgayThanhToan");

        jLabel7.setText("NgayShip");

        jLabel8.setText("NgayNhan");

        jLabel10.setText("TenNguoiNhan");

        jLabel11.setText("DiaChi");

        jLabel12.setText("Sdt");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblHoaDonForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên KH", "Tên NV", "Mã", "Ngày Tạo", "Ngày Thanh Toán", "Ngày Ship", "Ngày Nhận", "Tình Trạng", "Tên Người Nhận", "Địa Chỉ", "SĐT", "ID"
            }
        ));
        tblHoaDonForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonFormMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDonForm);

        jLabel13.setText("Tình Trạng");

        buttonGroup1.add(rdoThanhToan);
        rdoThanhToan.setText("Thanh Toán");

        buttonGroup1.add(rdoHuy);
        rdoHuy.setSelected(true);
        rdoHuy.setText("Huỷ");
        rdoHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel12))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbKhachHang, 0, 132, Short.MAX_VALUE)
                    .addComponent(cbbNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMa)
                    .addComponent(txtNgayTao)
                    .addComponent(txtNgayThanhToan)
                    .addComponent(txtSDT))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtNgayShip)
                            .addComponent(txtNgayNhan)
                            .addComponent(txtTenNguoiNhan)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoHuy)))
                .addContainerGap(422, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa)
                        .addComponent(jLabel10)
                        .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(rdoThanhToan)
                    .addComponent(rdoHuy))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ViewModelHoaDon viewModelHoaDon = getData();
        if (viewModelHoaDon == null) {
            return;
        }
       
        JOptionPane.showMessageDialog(this, iHoaDonService.insert(viewModelHoaDon));
        loadTable(iHoaDonService.getAll());

    }//GEN-LAST:event_btnThemActionPerformed

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblHoaDonForm.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xoá");
            return;
        }
        ArrayList<ViewModelHoaDon> list = iHoaDonService.getAll();
        ViewModelHoaDon viewModelHoaDon = list.get(row);
        JOptionPane.showMessageDialog(this, iHoaDonService.delete(viewModelHoaDon.getId()));
        loadTable(iHoaDonService.getAll());

    }//GEN-LAST:event_btnXoaActionPerformed

    private void rdoHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHuyActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblHoaDonForm.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để sủa");
            return;
        }
        String id = tblHoaDonForm.getValueAt(row, 11).toString();
        ViewModelHoaDon viewModelHoaDon = getData();
        System.out.println("id" + " " + id);
        JOptionPane.showMessageDialog(this, iHoaDonService.update(id, viewModelHoaDon));
        loadTable(iHoaDonService.getAll());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblHoaDonFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonFormMouseClicked
        int row = tblHoaDonForm.getSelectedRow();
        String tenKH = tblHoaDonForm.getValueAt(row, 0).toString();
        String tenNV = tblHoaDonForm.getValueAt(row, 1).toString();
        String ma = tblHoaDonForm.getValueAt(row, 2).toString();
        String ngayTao = tblHoaDonForm.getValueAt(row, 3).toString();
        String ngayThanhToan = tblHoaDonForm.getValueAt(row, 4).toString();
        String ngayShip = tblHoaDonForm.getValueAt(row, 5).toString();
        String ngayNhan = tblHoaDonForm.getValueAt(row, 6).toString();
        String tinhTrang = tblHoaDonForm.getValueAt(row, 7).toString();
        String tenNguoiNhan = tblHoaDonForm.getValueAt(row, 8).toString();
        String diaChi = tblHoaDonForm.getValueAt(row, 9).toString();
        String sdt = tblHoaDonForm.getValueAt(row, 10).toString();
        String id = tblHoaDonForm.getValueAt(row, 11).toString();

        cbbKhachHang.setSelectedItem(tenKH);
        cbbNhanVien.setSelectedItem(tenNV);
        txtMa.setText(ma);
        txtNgayTao.setText(ngayTao);
        txtNgayNhan.setText(ngayNhan);
        txtNgayThanhToan.setText(ngayThanhToan);
        txtNgayShip.setText(ngayShip);
        if (tinhTrang.equals("Thanh toán")) {
            rdoThanhToan.setSelected(true);
        } else {
            rdoHuy.setSelected(true);
        }
        txtTenNguoiNhan.setText(tenNguoiNhan);
        txtDiaChi.setText(diaChi);
        txtSDT.setText(sdt);

    }//GEN-LAST:event_tblHoaDonFormMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoHuy;
    private javax.swing.JRadioButton rdoThanhToan;
    private javax.swing.JTable tblHoaDonForm;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayNhan;
    private javax.swing.JTextField txtNgayShip;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNgayThanhToan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNguoiNhan;
    // End of variables declaration//GEN-END:variables
}
