/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.ChucVu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import iservice.IChucVuService;
import java.util.ArrayList;
import service.ChucVuService;
import viewmodel.ViewModelChucVu;

/**
 *
 * @author Admin
 */
public class ViewChucVu extends javax.swing.JFrame {

    private IChucVuService iChucVuService = new ChucVuService();

    /**
     * Creates new form ViewChucVu
     */
    public ViewChucVu() {
        initComponents(); // hàm khởi tạo giao diện bắt buộc khai đầu 
        loadTable(iChucVuService.getAll());
    }
    // lưu ý trong java không thể truyền vào 1 hàm mà phải truyền tham số cụ thể 

    public void loadTable(List<ViewModelChucVu> list) {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tblChucVuFrom.getModel();
        defaultTableModel.setRowCount(0);
        for (ViewModelChucVu viewModelChucVu : list) {
            defaultTableModel.addRow(new Object[]{
                viewModelChucVu.getMa(), viewModelChucVu.getTen()
            });
        }
    }

    public ViewModelChucVu getData() {
        ViewModelChucVu viewModelChucVu = new ViewModelChucVu();
        String ma = txtMa.getText();;
        viewModelChucVu.setMa(ma);
        String ten = txtTen.getText();
        viewModelChucVu.setMa(ma);
        viewModelChucVu.setTen(ten);
        return viewModelChucVu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChucVuFrom = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ChucVu");

        jLabel2.setText("Mã");

        jLabel3.setText("Tên");

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

        tblChucVuFrom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên"
            }
        ));
        tblChucVuFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChucVuFromMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChucVuFrom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTen))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnSua)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ViewModelChucVu viewModelChucVu = getData();
        JOptionPane.showMessageDialog(this, iChucVuService.insert(viewModelChucVu));
        loadTable(iChucVuService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblChucVuFrom.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để xoá");
            return;
        }
        String ma = tblChucVuFrom.getValueAt(row, 0).toString();
        JOptionPane.showMessageDialog(this, iChucVuService.deleteChucVuAndNhanVien(ma));
        loadTable(iChucVuService.getAll());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        ViewModelChucVu viewModelChucVu = getData();
        int row = tblChucVuFrom.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng để update");
            return;
        }
       
        String ma = tblChucVuFrom.getValueAt(row, 0).toString();
        JOptionPane.showMessageDialog(this,iChucVuService.update(ma, viewModelChucVu));
        loadTable(iChucVuService.getAll());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblChucVuFromMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChucVuFromMouseClicked
        int row = tblChucVuFrom.getSelectedRow();
        String ma = tblChucVuFrom.getValueAt(row, 0).toString();
        String ten = tblChucVuFrom.getValueAt(row, 1).toString();
        txtMa.setText(ma);
        txtTen.setText(ten);
    }//GEN-LAST:event_tblChucVuFromMouseClicked

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
            java.util.logging.Logger.getLogger(ViewChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewChucVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewChucVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChucVuFrom;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
