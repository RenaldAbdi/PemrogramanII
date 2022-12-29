import java.sql.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



public class DatabaseBook extends javax.swing.JFrame {
    
                
    public DatabaseBook(){
            initComponents();
            Connect();
            Fetch();
            cariData();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/itbrary_db", "root", "");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM buku");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id_buku"));
                    v2.add(rs.getString("judul"));
                    v2.add(rs.getString("pengarang"));
                    v2.add(rs.getString("tahun"));
                    v2.add(rs.getString("penerbit"));
                    v2.add(rs.getString("stok"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void cariData(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM buku WHERE judul LIKE '%" + txtSearch.getText() + "%'");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();

            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id_buku"));
                    v2.add(rs.getString("judul"));
                    v2.add(rs.getString("pengarang"));
                    v2.add(rs.getString("tahun"));
                    v2.add(rs.getString("penerbit"));
                    v2.add(rs.getString("stok"));
                }
                df.addRow(v2);
            }
            jTable1.setModel(df);
        } catch (Exception e) {
            System.out.println("Cari Data Error");
        }finally{
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnMengembalikanBuku = new javax.swing.JButton();
        btnMeminjamBuku = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 470, 30));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Buku", "Judul", "Pengarang", "Tahun", "Penerbit", "Stok"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 740, 190));

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel8.setText("Cari Berdasarkan Judul Buku:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 260, 30));

        btnBack.setBackground(new java.awt.Color(153, 204, 255));
        btnBack.setText("KEMBALI");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        btnMengembalikanBuku.setBackground(new java.awt.Color(153, 204, 255));
        btnMengembalikanBuku.setText("MENGEMBALIKAN BUKU");
        btnMengembalikanBuku.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMengembalikanBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMengembalikanBukuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMengembalikanBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 360, 30));

        btnMeminjamBuku.setBackground(new java.awt.Color(153, 204, 255));
        btnMeminjamBuku.setText("MEMINJAM BUKU");
        btnMeminjamBuku.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMeminjamBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMeminjamBukuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMeminjamBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 360, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/5C33F6 (3).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        HomepageMahasiswa hp = new HomepageMahasiswa();
        hp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
        cariData();
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        cariData();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnMengembalikanBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMengembalikanBukuActionPerformed
        // TODO add your handling code here:
        mahasiswaPengembalian mhspengembalian = new mahasiswaPengembalian();
        mhspengembalian.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMengembalikanBukuActionPerformed

    private void btnMeminjamBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMeminjamBukuActionPerformed
        // TODO add your handling code here:
        mahasiswaPeminjaman mhspeminjaman = new mahasiswaPeminjaman();
        mhspeminjaman.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMeminjamBukuActionPerformed

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
            java.util.logging.Logger.getLogger(DatabaseBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatabaseBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnMeminjamBuku;
    private javax.swing.JButton btnMengembalikanBuku;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}