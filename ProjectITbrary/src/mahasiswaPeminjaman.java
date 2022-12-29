
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class mahasiswaPeminjaman extends javax.swing.JFrame {

    public mahasiswaPeminjaman() {
        initComponents();
        Connect();
        Fetch();
    }
    
    java.sql.Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/itbrary_db", "root", "");
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

            DefaultTableModel df = (DefaultTableModel)jTable2.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("id_buku"));
                    v2.add(rs.getString("judul"));
                }
                df.addRow(v2);
            }
    
            } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtTanggalPeminjaman = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNIM = new javax.swing.JTextField();
        txtNamaMHS = new javax.swing.JTextField();
        txtIDBuku = new javax.swing.JTextField();
        txtJudul = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnAddPeminjaman = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtTanggalPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 460, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Buku", "Judul"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 460, 110));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel2.setText("ID Mahasiswa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 130, 30));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel3.setText("Tanggal Peminjaman");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 190, 20));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel4.setText("Nama");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 80, 20));

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel5.setText("ID Buku");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 80, 20));

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel7.setText("Judul");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 60, 20));
        jPanel1.add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 460, -1));
        jPanel1.add(txtNamaMHS, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 460, -1));
        jPanel1.add(txtIDBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 460, -1));
        jPanel1.add(txtJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 460, -1));

        btnBack.setBackground(new java.awt.Color(153, 204, 255));
        btnBack.setText("KEMBALI");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        btnBatal.setBackground(new java.awt.Color(255, 102, 102));
        btnBatal.setText("BATAL");
        btnBatal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 190, 40));

        btnAddPeminjaman.setBackground(new java.awt.Color(102, 255, 102));
        btnAddPeminjaman.setText("MEMINJAM");
        btnAddPeminjaman.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPeminjamanActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 190, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLabel8.getAccessibleContext().setAccessibleParent(jPanel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
                txtNIM.setText("");
                txtNamaMHS.setText("");
                txtIDBuku.setText("");
                txtJudul.setText("");
                txtTanggalPeminjaman.setDate(null);
                txtNIM.requestFocus();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        DatabaseBook db = new DatabaseBook();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPeminjamanActionPerformed

        if (txtNIM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"NIM harus diisi!");
        } else if(txtNamaMHS.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Nama harus diisi!");
        } else if(txtIDBuku.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID Buku harus diisi!");
        } else if(txtJudul.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"judul Buku harus diisi!");
        } else if(txtTanggalPeminjaman.getDate() == null){
            JOptionPane.showMessageDialog(this,"Tanggal Peminjaman harus diisi!");
        } else {
            
            String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(txtTanggalPeminjaman.getDate()));
        
            
        try {
            // TODO add your handling code here:
            
            String id_buku = txtIDBuku.getText();
            String nim = txtNIM.getText();
            String judul = txtJudul.getText();
            String namamahasiswa = txtNamaMHS.getText();
            String tanggalpeminjaman = tanggal;
            
            pst = con.prepareStatement("UPDATE buku SET stok = stok-1 WHERE id_buku=?");
            pst.setString(1, id_buku);
            pst.executeUpdate();
            pst.close();
                               
            pst = con.prepareStatement("INSERT INTO peminjaman (id_buku,nim,judul,namamahasiswa,tanggalpeminjaman,tanggalpengembalian) VALUES (?,?,?,?,?,DATE_ADD(tanggalpeminjaman, INTERVAL 1 WEEK))");
            pst.setString(1,id_buku);
            pst.setString(2,nim);
            pst.setString(3,judul);
            pst.setString(4,namamahasiswa);
            pst.setString(5,tanggalpeminjaman);
            
            
            int k = pst.executeUpdate();
            if (k == 1) {
                
                JOptionPane.showMessageDialog(this,"Data telah ditambahkan! Anda telah meminjam buku! Harap kembalikan 7 Hari setelah peminjaman");
                txtNIM.setText("");
                txtNamaMHS.setText("");
                txtIDBuku.setText("");
                txtJudul.setText("");
                txtTanggalPeminjaman.setDate(null);
                txtNIM.requestFocus();
                
            } else {
                JOptionPane.showMessageDialog(this,"Data gagal ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnAddPeminjamanActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.rowAtPoint(evt.getPoint());
        
        String id_buku = jTable2.getValueAt(baris, 0).toString();
        txtIDBuku.setText(id_buku);
        
        String judul = jTable2.getValueAt(baris, 1).toString();
        txtJudul.setText(judul);
    }//GEN-LAST:event_jTable2MouseClicked

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
            java.util.logging.Logger.getLogger(mahasiswaPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mahasiswaPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPeminjaman;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBatal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtIDBuku;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNamaMHS;
    private com.toedter.calendar.JDateChooser txtTanggalPeminjaman;
    // End of variables declaration//GEN-END:variables
}
