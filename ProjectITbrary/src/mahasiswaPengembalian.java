
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import com.itextpdf.text.BaseColor;


public class mahasiswaPengembalian extends javax.swing.JFrame {


    public mahasiswaPengembalian() {
        initComponents();
        Connect();
        Fetch();
    }

    Connection con;
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
            pst = con.prepareStatement("SELECT * FROM peminjaman");
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
                    v2.add(rs.getString("nim"));
                    v2.add(rs.getString("namamahasiswa"));
                    v2.add(rs.getString("tanggalpeminjaman"));
                    v2.add(rs.getString("tanggalpengembalian"));
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    private void PrintPDF() {
        String filename = "C:\\Users\\Renald\\Downloads\\RiwayatPeminjaman.pdf";
        if (txtNIMCetak.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"NIM yang ingin dicari harus diisi!");
        } else {
            try {
                // TODO add your handling code here:
                String nimcetak = txtNIMCetak.getText();

                Document PDFreport = new Document();
                PdfWriter.getInstance(PDFreport, new FileOutputStream(filename));
                pst = con.prepareStatement("SELECT * FROM pengembalian where nim=?");
                pst.setString(1, nimcetak);
                rs = pst.executeQuery();

                PDFreport.open();
                Paragraph paragraph1 = new Paragraph("BUKTI PENGEMBALIAN BUKU");
                paragraph1.setAlignment(Element.ALIGN_CENTER);
                Paragraph paragraph2 = new Paragraph("                       ");
                PdfPTable PDFTable = new PdfPTable(7);


                PDFreport.add(paragraph1);
                PDFreport.add(paragraph2);

                PdfPCell table_cell;

                table_cell = new PdfPCell(new Phrase("No Pengembalian"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("ID Buku"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("Judul"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("NIM"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("Nama Mahasiswa"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("Tgl Peminjaman"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                table_cell = new PdfPCell(new Phrase("Tgl Pengembalian"));
                table_cell.setBackgroundColor(BaseColor.GRAY);
                table_cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                PDFTable.addCell(table_cell);

                while(rs.next()) {
                    String nopengembalian = rs.getString("nopengembalian");
                    table_cell = new PdfPCell(new Phrase(nopengembalian));
                    PDFTable.addCell(table_cell);

                    String id_buku = rs.getString("id_buku");
                    table_cell = new PdfPCell(new Phrase(id_buku));
                    PDFTable.addCell(table_cell);

                    String nim = rs.getString("nim");
                    table_cell = new PdfPCell(new Phrase(nim));
                    PDFTable.addCell(table_cell);

                    String judul = rs.getString("judul");
                    table_cell = new PdfPCell(new Phrase(judul));
                    PDFTable.addCell(table_cell);

                    String namamahasiswa = rs.getString("namamahasiswa");
                    table_cell = new PdfPCell(new Phrase(namamahasiswa));
                    PDFTable.addCell(table_cell);

                    String tanggalpeminjaman = rs.getString("tanggalpeminjaman");
                    table_cell = new PdfPCell(new Phrase(tanggalpeminjaman));
                    PDFTable.addCell(table_cell);

                    String tanggalpengembalian = rs.getString("tanggalpengembalian");
                    table_cell = new PdfPCell(new Phrase(tanggalpengembalian));
                    PDFTable.addCell(table_cell);
                }

                JOptionPane.showMessageDialog(this,"PDF File telah diekspor!!!");
                PDFreport.add(PDFTable);
                PDFreport.close();

            } catch (SQLException ex) {
                Logger.getLogger(mahasiswaPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(mahasiswaPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(mahasiswaPengembalian.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Date getTanggalFromTable(JTable table, int kolom) {
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try {
            tanggal = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
            
        } catch (ParseException ex) {
            Logger.getLogger(mahasiswaPeminjaman.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return tanggal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTglPeminjaman = new com.toedter.calendar.JDateChooser();
        txtTglPengembalian = new com.toedter.calendar.JDateChooser();
        txtJudul = new javax.swing.JTextField();
        txtIDBuku = new javax.swing.JTextField();
        txtNamaMHS = new javax.swing.JTextField();
        txtNIM = new javax.swing.JTextField();
        txtNIMCetak = new javax.swing.JTextField();
        btnMengembalikan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Buku", "Judul", "ID Mahasiswa", "Nama", "Tanggal Peminjaman", "Tanggal Pengembalian"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 340, 190));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel2.setText("Cari NIM untuk cetak:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 150, 30));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel4.setText("Nama");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 30));

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel5.setText("ID Buku");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 80, 30));

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel6.setText("Judul");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 30));

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel7.setText("Tanggal Peminjaman");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 30));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel3.setText("Tanggal Pengembalian");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel8.setText("ID Mahasiswa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, 30));
        getContentPane().add(txtTglPeminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 272, 200, 30));
        getContentPane().add(txtTglPengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 30));
        getContentPane().add(txtJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 200, 30));
        getContentPane().add(txtIDBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 200, 30));
        getContentPane().add(txtNamaMHS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 200, 30));
        getContentPane().add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 200, 30));
        getContentPane().add(txtNIMCetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 190, 30));

        btnMengembalikan.setBackground(new java.awt.Color(102, 255, 102));
        btnMengembalikan.setText("MENGEMBALIKAN");
        btnMengembalikan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMengembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMengembalikanActionPerformed(evt);
            }
        });
        getContentPane().add(btnMengembalikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 170, 30));

        btnBatal.setBackground(new java.awt.Color(255, 102, 102));
        btnBatal.setText("BATAL");
        btnBatal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 170, 30));

        btnBack.setBackground(new java.awt.Color(153, 204, 255));
        btnBack.setText("KEMBALI");
        btnBack.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        btnPrint.setBackground(new java.awt.Color(255, 255, 102));
        btnPrint.setText("Cetak Bukti Pengembalian");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 340, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/4.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
                txtNIM.setText("");
                txtNamaMHS.setText("");
                txtIDBuku.setText("");
                txtJudul.setText("");
                txtTglPeminjaman.setDate(null);
                txtTglPengembalian.setDate(null);
                txtNIM.requestFocus();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        DatabaseBook db = new DatabaseBook();
        db.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMengembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMengembalikanActionPerformed
        // TODO add your handling code here:
        
        
            
        if (txtNIM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"NIM harus diisi!");
        } else if(txtNamaMHS.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Nama harus diisi!");
        } else if(txtIDBuku.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID Buku harus diisi!");
        } else if(txtJudul.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Judul Buku harus diisi!");
        } else if(txtTglPeminjaman.getDate() == null){
            JOptionPane.showMessageDialog(this,"Tanggal Peminjaman harus diisi!");
        } else if(txtTglPengembalian.getDate() == null){
            JOptionPane.showMessageDialog(this,"Tanggal Pengembalian harus diisi!");
        } else {
            
        String tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tglpeminjaman = String.valueOf(fm.format(txtTglPeminjaman.getDate()));
            String tglpengembalian = String.valueOf(fm.format(txtTglPengembalian.getDate()));
        
        try {
            // TODO add your handling code here:
            
            String nim = txtNIM.getText();
            String namamahasiswa = txtNamaMHS.getText();
            String id_buku = txtIDBuku.getText();
            String judul = txtJudul.getText();
            String tanggalpeminjaman = tglpeminjaman;
            String tanggalpengembalian = tglpengembalian;
            
            pst = con.prepareStatement("UPDATE buku SET stok = stok+1 WHERE id_buku=?");
            pst.setString(1, id_buku);
            pst.executeUpdate();
            pst.close();
            
            pst = con.prepareStatement("INSERT INTO pengembalian (id_buku,nim,judul,namamahasiswa,tanggalpeminjaman,tanggalpengembalian) VALUES (?,?,?,?,?,?)");
            pst.setString(1,id_buku);
            pst.setString(2,nim);
            pst.setString(3,judul);
            pst.setString(4,namamahasiswa);
            pst.setString(5,tanggalpeminjaman);
            pst.setString(6,tanggalpengembalian);
            
            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this,"Data telah ditambahkan! Anda telah mengembalikan buku!");
                txtNIM.setText("");
                txtNamaMHS.setText("");
                txtIDBuku.setText("");
                txtJudul.setText("");
                txtTglPeminjaman.setDate(null);
                txtTglPengembalian.setDate(null);
                txtNIM.requestFocus();
                Fetch();
                
            } else {
                JOptionPane.showMessageDialog(this,"Data gagal ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnMengembalikanActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());
        
        String id_buku = jTable1.getValueAt(baris, 0).toString();
        txtIDBuku.setText(id_buku);
        
        String judul = jTable1.getValueAt(baris, 1).toString();
        txtJudul.setText(judul);
        
        String nim = jTable1.getValueAt(baris, 2).toString();
        txtNIM.setText(nim);
        
        String namamahasiswa = jTable1.getValueAt(baris, 3).toString();
        txtNamaMHS.setText(namamahasiswa);
        
        txtTglPeminjaman.setDate(getTanggalFromTable(jTable1, 4));
        
        txtTglPengembalian.setDate(getTanggalFromTable(jTable1, 5));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        PrintPDF();
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(mahasiswaPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mahasiswaPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mahasiswaPengembalian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnMengembalikan;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIDBuku;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNIMCetak;
    private javax.swing.JTextField txtNamaMHS;
    private com.toedter.calendar.JDateChooser txtTglPeminjaman;
    private com.toedter.calendar.JDateChooser txtTglPengembalian;
    // End of variables declaration//GEN-END:variables
}
