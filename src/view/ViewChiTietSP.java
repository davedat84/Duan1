/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Interface.IChiTietSPRepository;
import Interface.INSXRepository;
import Repository.ChiTietSPRepository;
import Repository.DongSPRepository;
import Repository.MauSacRepository;
import Repository.NSXRepository;
import Repository.NhanVienRepository;
import Repository.SanPhamRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 *
 * @author Admin
 */
public class ViewChiTietSP extends javax.swing.JFrame {

    public ChiTietSPRepository iChiTietSP = new ChiTietSPRepository();
    public SanPhamRepository iSanPham = new SanPhamRepository();
    public MauSacRepository iMauSac = new MauSacRepository();
    public DongSPRepository iDongSP = new DongSPRepository();
    public NSXRepository iNSX = new NSXRepository();
    public NhanVienRepository iNhanVen = new NhanVienRepository();

    /**
     * Creates new form ViewChiTietSP
     */
    public ViewChiTietSP() {
        initComponents();
        loadTable(iChiTietSP.getListChiTietSP());
        cbbtenSP();
        cbbnsx();
        comboboxMauSac();
        comboboxDongSP();
        comboboxMaDongSP();
        comboboxMaMauSac();
        comboboxMaNSX();
        comboboxMaSP();
      
    }
// comboboxmanhanvien

    public void cbbMaNhanVien() {
        List<ViewModelNhanVien> list = iNhanVienService.getAll();
        for(ViewModelNhanVien viewModelNhanVien : list){
            String maNV = viewModelNhanVien.getMa();
            cbbMaNhanVien.addItem(maNV);
        }
    }

    // cbb tensp
    public void cbbtenSP() {
        List<ViewModelSanPham> list = iSanPhamService.getAll();
        for (ViewModelSanPham viewModelSanPham : list) {
            String tenSP = viewModelSanPham.getTen();
            cbbSP.addItem(tenSP);
        }
    }
// cbbnsx

    public void cbbnsx() {
        List<ViewModelNSX> list = iNSXService.getAll();
        for (ViewModelNSX viewModelNSX : list) {
            String tenNSX = viewModelNSX.getTen();
            cbbNSX.addItem(tenNSX);
        }
    }

    // mausac
    public void comboboxMauSac() {
        List<ViewModelMauSac> list = iMauSacService.getAll();
        for (ViewModelMauSac viewModelMauSac : list) {
            String tenMauSac = viewModelMauSac.getTen();
            cbbMauSac.addItem(tenMauSac);
        }
    }

    // dongSP
    public void comboboxDongSP() {
        List<ViewModelDongSP> list = iDongSPService.getAll();
        for (ViewModelDongSP viewModelDongSP : list) {
            String tenDongSP = viewModelDongSP.getTen();
            cbbDongSP.addItem(tenDongSP);
        }
    }

    // cbb maSP
    public void comboboxMaSP() {
        List<ViewModelSanPham> list = iSanPhamService.getAll();
        for (ViewModelSanPham viewModelSanPham : list) {
            String maSanPham = viewModelSanPham.getMa();
            cbbMaSP.addItem(maSanPham);
        }
    }

    // cbb maNSX
    public void comboboxMaNSX() {
        List<ViewModelNSX> list = iNSXService.getAll();
        for (ViewModelNSX viewModelNSX : list) {
            String maNSX = viewModelNSX.getMa();
            cbbMaNSX.addItem(maNSX);
        }
    }

    // cbb maMauSac
    public void comboboxMaMauSac() {
        List<ViewModelMauSac> list = iMauSacService.getAll();
        for (ViewModelMauSac viewModelMauSac : list) {
            String maMauSac = viewModelMauSac.getMa();
            cbbMaMauSac.addItem(maMauSac);
        }
    }

    // cbb DongSP
    public void comboboxMaDongSP() {
        List<ViewModelDongSP> list = iDongSPService.getAll();
        for (ViewModelDongSP viewModelDongSP : list) {
            String maDongSP = viewModelDongSP.getMa();
            cbbMaDongSP.addItem(maDongSP);
        }
    }

    // getdata
    public ViewModelChiTietSP getData() {
        ViewModelChiTietSP viewModelChiTietSP = new ViewModelChiTietSP();

// lấy ra tên đang được chọn
        String tenSP = cbbSP.getSelectedItem().toString();
        String tenNSX = cbbNSX.getSelectedItem().toString();
        String tenMauSac = cbbMauSac.getSelectedItem().toString();
        String tenDongSP = cbbDongSP.getSelectedItem().toString();

        String namBH = txtNamBH.getText();
        String soLuongTon = txtSoLuongTon.getText();
        String moTa = txtmoTa.getText();
        String giaBan = txtGiaBan.getText();
        String giaNhap = txtGiaNhap.getText();

        if (giaBan.trim().equals("") || giaNhap.trim().equals("") || namBH.trim().equals("") || soLuongTon.trim().equals("") || moTa.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "khong duoc rong");
            return null;
        }

        try {
            int namBHInt = Integer.parseInt(namBH);
            viewModelChiTietSP.setNamBH(namBHInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sai dinh dang");
            return null;
        }

        int soLuongTonInt = Integer.parseInt(soLuongTon);
        double giaBanDouble = Double.parseDouble(giaBan);
        double giaNhapDouble = Double.parseDouble(giaNhap);
        viewModelChiTietSP.setMauSac(tenMauSac);
        viewModelChiTietSP.setNsx(tenNSX);
        viewModelChiTietSP.setSanPham(tenSP);
        viewModelChiTietSP.setDongDP(tenDongSP);

        viewModelChiTietSP.setSoLuongTon(soLuongTonInt);
        viewModelChiTietSP.setGiaBan(giaBanDouble);
        viewModelChiTietSP.setGiaNhap(giaNhapDouble);
        viewModelChiTietSP.setMoTa(moTa);
        return viewModelChiTietSP;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbbSP = new javax.swing.JComboBox<>();
        cbbDongSP = new javax.swing.JComboBox<>();
        cbbNSX = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        txtmoTa = new javax.swing.JTextField();
        txtNamBH = new javax.swing.JTextField();
        txtSoLuongTon = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbbMaSP = new javax.swing.JComboBox<>();
        cbbMaNSX = new javax.swing.JComboBox<>();
        cbbMaMauSac = new javax.swing.JComboBox<>();
        cbbMaDongSP = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietSP = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cbbMaNhanVien = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("tensp");

        jLabel2.setText("tennsx");

        jLabel3.setText("namBH");

        jLabel4.setText("tenMauSac");

        jLabel5.setText("tenDongSP");

        jLabel6.setText("soLuongTon");

        jLabel7.setText("moTa");

        jLabel8.setText("giaBan");

        jLabel9.setText("giaNhap");

        cbbDongSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDongSPActionPerformed(evt);
            }
        });

        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        jLabel10.setText("maDongSP");

        jLabel11.setText("maSP");

        jLabel12.setText("maNSX");

        jLabel13.setText("maMauSac");

        tblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiTietSP);

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

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setText("maNV");

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbDongSP, 0, 137, Short.MAX_VALUE)
                                    .addComponent(cbbNSX, 0, 137, Short.MAX_VALUE)
                                    .addComponent(cbbMauSac, 0, 137, Short.MAX_VALUE)
                                    .addComponent(txtNamBH))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbMaSP, 0, 128, Short.MAX_VALUE)
                                            .addComponent(cbbMaNSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbMaMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbbMaDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnSua)
                                        .addGap(37, 37, 37)
                                        .addComponent(jButton3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton1))))
                            .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel4)
                    .addContainerGap(885, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(jLabel5)
                    .addContainerGap(885, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(297, 297, 297)
                    .addComponent(jLabel11)
                    .addContainerGap(643, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cbbMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbbMaNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbbMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cbbMaDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtmoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(111, 111, 111)
                    .addComponent(jLabel4)
                    .addContainerGap(710, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(jLabel5)
                    .addContainerGap(667, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jLabel11)
                    .addContainerGap(772, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbDongSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDongSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbDongSPActionPerformed

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMauSacActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ViewModelChiTietSP viewModelChiTietSP = getData();
        if (viewModelChiTietSP == null) {
            return;
        }
          cbbMaNhanVien();
        JOptionPane.showMessageDialog(this, iChiTietSPService.insert(viewModelChiTietSP));
        loadTable(iChiTietSPService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tblChiTietSP.getSelectedRow();
        String id = tblChiTietSP.getValueAt(row, 0).toString();
        JOptionPane.showMessageDialog(this, iChiTietSPService.delete(id));
        loadTable(iChiTietSPService.getAll());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSPMouseClicked
        int row = tblChiTietSP.getSelectedRow();
        String tenMS = tblChiTietSP.getValueAt(row, 4).toString();
        cbbMauSac.setSelectedItem(tenMS);


    }//GEN-LAST:event_tblChiTietSPMouseClicked
    public void loadTable(ArrayList<ViewModelChiTietSP> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblChiTietSP.getModel();
        defaultTableModel.setRowCount(0);
        for (ViewModelChiTietSP viewModelChiTietSP : list) {
            defaultTableModel.addRow(new Object[]{
                viewModelChiTietSP.getId(), viewModelChiTietSP.getMauSac(), viewModelChiTietSP.getNsx(), viewModelChiTietSP.getSanPham(), viewModelChiTietSP.getMauSac(), viewModelChiTietSP.getGiaBan(), viewModelChiTietSP.getGiaNhap(), viewModelChiTietSP.getSoLuongTon(), viewModelChiTietSP.getNamBH()
            });
        }
    }

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
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChiTietSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChiTietSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbDongSP;
    private javax.swing.JComboBox<String> cbbMaDongSP;
    private javax.swing.JComboBox<String> cbbMaMauSac;
    private javax.swing.JComboBox<String> cbbMaNSX;
    private javax.swing.JComboBox<String> cbbMaNhanVien;
    private javax.swing.JComboBox<String> cbbMaSP;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNSX;
    private javax.swing.JComboBox<String> cbbSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblChiTietSP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtSoLuongTon;
    private javax.swing.JTextField txtmoTa;
    // End of variables declaration//GEN-END:variables
}
