
public class HomepagePeminjaman extends javax.swing.JFrame {

    public HomepagePeminjaman() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnDBPeminjaman = new javax.swing.JButton();
        btnDBPengembalian = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 217, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(153, 102, 255));
        btnBack.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 51));
        btnBack.setText("Beranda");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 110, 30));

        btnDBPeminjaman.setBackground(new java.awt.Color(153, 102, 255));
        btnDBPeminjaman.setFont(new java.awt.Font("Gill Sans MT", 0, 13)); // NOI18N
        btnDBPeminjaman.setForeground(new java.awt.Color(255, 255, 51));
        btnDBPeminjaman.setText("DATA PEMINJAMAN BUKU");
        btnDBPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBPeminjamanActionPerformed(evt);
            }
        });
        jPanel1.add(btnDBPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 230, 45));

        btnDBPengembalian.setBackground(new java.awt.Color(153, 102, 255));
        btnDBPengembalian.setFont(new java.awt.Font("Gill Sans MT", 0, 13)); // NOI18N
        btnDBPengembalian.setForeground(new java.awt.Color(255, 255, 51));
        btnDBPengembalian.setText("DATA PENGEMBALIAN BUKU");
        btnDBPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBPengembalianActionPerformed(evt);
            }
        });
        jPanel1.add(btnDBPengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 230, 45));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan itbrary.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan logobuku.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 470, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDBPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBPeminjamanActionPerformed
        //membuat constructor baru yang digunakan untuk pindah ke page database peminjaman
        databasepeminjaman dbpeminjaman = new databasepeminjaman(); 
        dbpeminjaman.setVisible(true); //membuka page peminjaman
        this.setVisible(false); //menutup hp yang sekarang
    }//GEN-LAST:event_btnDBPeminjamanActionPerformed

    private void btnDBPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBPengembalianActionPerformed
        //membuat constructor baru yang digunakan untuk pindah ke page database pengembalian
        databasepengembalian dbpengembalian = new databasepengembalian();
        dbpengembalian.setVisible(true); //membuka page pengembalian
        this.setVisible(false); //menutup hp yang sekarang
    }//GEN-LAST:event_btnDBPengembalianActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //membuat constructor baru yang digunakan untuk pindah ke hp pegawai
        HomepagePegawai hpegawai = new HomepagePegawai(); 
        hpegawai.setVisible(true); //membuka page hp pegawai
        this.setVisible(false); //menutup hp yang sekarang
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(HomepagePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomepagePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomepagePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomepagePeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomepagePeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDBPeminjaman;
    private javax.swing.JButton btnDBPengembalian;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
