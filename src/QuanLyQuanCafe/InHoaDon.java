/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuanLyQuanCafe;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

/**
 *
 * @author namduong
 */
public class InHoaDon extends javax.swing.JFrame {
    /**
     * Creates new form InHoaDon
     */
    String thanhTien = menu.thanhTien;
    String thueHoaDon = menu.thueHoaDon;
    String tongCong = menu.tongCong;
    float khuyenMai = menu.khuyenMai;
    float tienKhuyenMai = khuyenMai * (Integer.parseInt(thanhTien.substring(0, thanhTien.length()-2)));
//    float tienKhuyenMai = 0;
    public InHoaDon() {
//        printPDF();
        initComponents();
        String hours = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String days = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        String mot = "	              UIT Coffee\n" +
                "                 47 Xa lộ Hà Nội, Phường Linh Trung\n" +
                "                            Thủ Đức, Hồ Chí Minh\n" +
                "     ******************************************************\n" +
                "	               HOÁ ĐƠN     \n     ";
        String hai = mot + hours + "                                               " + days +
                "\n     ******************************************************\n";
        String ba = hai + menu.hoaDon + "\n\t\t     Thành tiền:\t" + menu.thanhTien + 
                "\n\t\t     Khuyến mãi:" + tienKhuyenMai +
                "\n\t\t     Thuế:\t" + menu.thueHoaDon + 
                "\n\t\t     Tổng cộng:\t" + menu.tongCong +
                "\n     ******************************************************\n" +
                "\t               Cảm ơn!\n\t             Hẹn gặp lại!";
        txtBill.setText(ba);
        
        JPanel[] panel = {btnThanhToan};
        for (int i = 0; i < panel.length; i++) {
            panel[i].setBackground(new Color(0,0,0,0));
        }
    }
    
    public void printPDF() {
        Rectangle pagesize = new Rectangle(300, 400);
        Document document = new Document(pagesize);
        document.setMargins(0,0,0,0);
        String hours = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String days = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        try {
            PdfWriter.getInstance(document, new FileOutputStream("../QuanLyQuanCafe/src/bills/HoaDon_" + menu.ID_HD + ".pdf"));
            document.open();
            Paragraph header = new Paragraph(
                    "UIT Coffee\n" +
                    "47 Xa lo Ha Noi, Phuong Linh Trung\n" +
                    "Thuc Duc, Ho Chi Minh\n" +
                    "-----------------------------------------------\n" +
                    "HOA DON");
            Paragraph time = new Paragraph(hours + 
                    "                          " + days + 
                    "\n-----------------------------------------------");
            Paragraph content = new Paragraph(menu.hoaDon);
            Paragraph content2 = new Paragraph(
                    "\nThanh tien: " + thanhTien + 
                    "\nKhuyen mai: " + tienKhuyenMai + 
                    "\nThue: " + thueHoaDon + 
                    "\nTong cong: " + tongCong);
            Paragraph footer = new Paragraph(
                    "-----------------------------------------------" +
                    "\nCam on!\nHen gap lai!");
            header.setAlignment(Element.ALIGN_CENTER);
            header.setSpacingAfter(15);
            
            time.setAlignment(Element.ALIGN_CENTER);
            
            content.setAlignment(Element.ALIGN_LEFT);
            content.setIndentationLeft(45);
            
            content2.setAlignment(Element.ALIGN_RIGHT);
            content2.setIndentationRight(55);
            
            footer.setAlignment(Element.ALIGN_CENTER);
            
            document.add(new Paragraph(header));
            document.add(new Paragraph(time));
            document.add(new Paragraph(content));
            document.add(new Paragraph(content2));
            document.add(new Paragraph(footer));
            
            document.close();

        } catch (DocumentException | FileNotFoundException e) {
        }
        this.dispose();
        JOptionPane.showMessageDialog(this, "Hoá đơn đã được in vào file PDF!");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBill = new javax.swing.JTextArea();
        btnThanhToan = new QuanLyQuanCafe.RoundedDecoration(20);
        jLabel67 = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(33, 38, 54));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel15.setBackground(new java.awt.Color(33, 38, 54));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        txtBill.setEditable(false);
        txtBill.setColumns(20);
        txtBill.setRows(5);
        txtBill.setText("\t            UIT Coffee\n               47 Xa lộ Hà Nội, Phường Linh Trung\n                           Thủ Đức, Hồ Chí Minh\n     ******************************************************\n\t             HOÁ ĐƠN\n\n\n");
        txtBill.setAutoscrolls(false);
        txtBill.setBorder(null);
        txtBill.setDragEnabled(false);
        txtBill.setFocusTraversalKeysEnabled(false);
        txtBill.setFocusable(false);
        txtBill.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(txtBill);

        btnThanhToan.setBackground(new java.awt.Color(251, 52, 90));
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("In Hoá Đơn");

        javax.swing.GroupLayout btnThanhToanLayout = new javax.swing.GroupLayout(btnThanhToan);
        btnThanhToan.setLayout(btnThanhToanLayout);
        btnThanhToanLayout.setHorizontalGroup(
            btnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThanhToanLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel67)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        btnThanhToanLayout.setVerticalGroup(
            btnThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThanhToanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        printPDF();
    }//GEN-LAST:event_btnThanhToanMouseClicked

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
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnThanhToan;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtBill;
    // End of variables declaration//GEN-END:variables
}
