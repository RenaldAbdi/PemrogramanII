
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class databasepengembalian extends javax.swing.JFrame {
    //mendeklarasikan method yang ada di file java
    public databasepengembalian() {
        initComponents();
        Connect();
        Fetch();
        cariData();
    }
    //mengganti nama variabel
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    //menghubungkan ke database mysql yang bernama itbrary_db
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
    //menampilkan data-data yang ada pada db yang dihubungkan
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM pengembalian"); //memasukkan query untuk menampilkan data dari tabel pengembalian
            rs = pst.executeQuery(); //mengeksekusi query yang diinginkan
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount(); //mengembalikan nilai int yang merupakan jumlah kolom di dalam tabel data

            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0); //menentukan ulang jumlah baris di model
            while (rs.next()) {
                Vector v2 = new Vector(); //membuat vektor baru
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("nim"));
                    v2.add(rs.getString("namamahasiswa"));
                    v2.add(rs.getString("id_buku"));
                    v2.add(rs.getString("judul"));
                    v2.add(rs.getString("tanggalpeminjaman"));
                    v2.add(rs.getString("tanggalpengembalian"));
                }
                df.addRow(v2); //menambahkan kolom yang ada pada db ke tabel java
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //mencari data-data yang ada pada db yang dihubungkan
    public void cariData(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM pengembalian WHERE nim LIKE '%" + txtNIM.getText() + "%'"); //memasukkan query untuk menampilkan data dari tabel pengembalian
            rs = pst.executeQuery(); //mengeksekusi query yang diinginkan
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount(); //mengembalikan nilai int yang merupakan jumlah kolom di dalam tabel data.

            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0); //menentukan ulang jumlah baris di model
            while (rs.next()) {
                Vector v2 = new Vector(); //membuat vektor baru
                for (int a = 1; a <= q; a++) {
                    v2.add(rs.getString("nim"));
                    v2.add(rs.getString("namamahasiswa"));
                    v2.add(rs.getString("id_buku"));
                    v2.add(rs.getString("judul"));
                    v2.add(rs.getString("tanggalpeminjaman"));
                    v2.add(rs.getString("tanggalpengembalian"));
                }
                df.addRow(v2); //menambahkan kolom yang ada pada db ke tabel java
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

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNIM = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 232, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBackground(new java.awt.Color(255, 170, 221));
        btnBack.setText("BERANDA");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 126, -1, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 51, 255));
        jLabel2.setText("ID Mahasiswa   :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 134, 30));

        txtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIMActionPerformed(evt);
            }
        });
        txtNIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNIMKeyReleased(evt);
            }
        });
        jPanel1.add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 580, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Mahasiswa", "Nama Mahasiswa", "ID Buku", "Judul", "Tanggal Peminjaman", "Tanggal Pengembalian"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 205, 730, 140));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan pengembalian.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 775, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIMActionPerformed
        cariData(); //mengeksekusi dari method cari data 
    }//GEN-LAST:event_txtNIMActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        HomepagePeminjaman hppeminjaman = new HomepagePeminjaman(); //membuat constructor baru yang digunakan untuk pindah ke hp peminjaman
        hppeminjaman.setVisible(true); //membuka hp peminjaman
        this.setVisible(false); //menutup page yang sekarang
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNIMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIMKeyReleased
        cariData(); //mengeksekusi dari method cari data secara tanpa perlu button 
    }//GEN-LAST:event_txtNIMKeyReleased

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
            java.util.logging.Logger.getLogger(databasepengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databasepengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databasepengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databasepengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databasepengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNIM;
    // End of variables declaration//GEN-END:variables
}
