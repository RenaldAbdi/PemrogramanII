
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;


public class InputBuku extends javax.swing.JFrame {

    public InputBuku() {
        initComponents();
        Connect();
        LoadNoBuku();
        Fetch();
        
    }
    Connection con; //menghubungkan ke database
    PreparedStatement pst; //mengeksekusi kueri 
    ResultSet rs; //menampung data dari hasil kueri
    
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
    
    public void LoadNoBuku() {
        
        try {
            pst = con.prepareStatement("SELECT id_buku FROM buku");
            rs = pst.executeQuery();
            txtIDBukuCari.removeAllItems();
            while(rs.next()){
                txtIDBukuCari.addItem(rs.getString(1));
            }
            
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtJudul = new javax.swing.JTextField();
        txtPengarang = new javax.swing.JTextField();
        txtPenerbit = new javax.swing.JTextField();
        txtIDBuku = new javax.swing.JTextField();
        txtIDBukuCari = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        txtTahun = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Judul Buku:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 20));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Pengarang:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, 20));

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Tahun RIlis Buku:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 20));

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Penerbit:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, 20));

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Cari dengan ID Buku:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 20));

        txtJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJudulActionPerformed(evt);
            }
        });
        jPanel1.add(txtJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 186, -1));

        txtPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPengarangActionPerformed(evt);
            }
        });
        jPanel1.add(txtPengarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 186, -1));

        txtPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenerbitActionPerformed(evt);
            }
        });
        jPanel1.add(txtPenerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 186, -1));

        txtIDBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBukuActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 186, -1));

        txtIDBukuCari.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        txtIDBukuCari.setForeground(new java.awt.Color(102, 102, 102));
        txtIDBukuCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtIDBukuCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBukuCariActionPerformed(evt);
            }
        });
        jPanel1.add(txtIDBukuCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 102, -1));

        btnSearch.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(102, 102, 102));
        btnSearch.setText("CARI");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, -1));

        btnAdd.setBackground(new java.awt.Color(255, 204, 255));
        btnAdd.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(102, 102, 102));
        btnAdd.setText("TAMBAH");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 130, -1));

        btnUpdate.setBackground(new java.awt.Color(255, 204, 255));
        btnUpdate.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(102, 102, 102));
        btnUpdate.setText("PERBARUI");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 130, -1));

        btnDelete.setBackground(new java.awt.Color(255, 204, 255));
        btnDelete.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(102, 102, 102));
        btnDelete.setText("HAPUS");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 130, -1));

        btnClear.setBackground(new java.awt.Color(255, 204, 255));
        btnClear.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnClear.setForeground(new java.awt.Color(102, 102, 102));
        btnClear.setText("KOSONG");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 130, -1));

        btnHome.setBackground(new java.awt.Color(255, 204, 255));
        btnHome.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnHome.setForeground(new java.awt.Color(102, 102, 102));
        btnHome.setText("KEMBALI");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 130, -1));

        jTable1.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(102, 102, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Buku", "Judul", "Pengarang", "Tanggal Rilis", "Penerbit", "Stok"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 480, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kucing2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnExport.setBackground(new java.awt.Color(255, 204, 255));
        btnExport.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        btnExport.setForeground(new java.awt.Color(102, 102, 102));
        btnExport.setText("EKSPOR KE CSV");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel1.add(btnExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("ID Buku:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 20));

        jLabel10.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Stok");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        txtStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStokActionPerformed(evt);
            }
        });
        jPanel1.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 186, -1));

        txtTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTahunActionPerformed(evt);
            }
        });
        jPanel1.add(txtTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJudulActionPerformed

    private void txtPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPengarangActionPerformed

    private void txtPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPenerbitActionPerformed

    private void txtIDBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBukuActionPerformed

    private void txtIDBukuCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBukuCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBukuCariActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        try {
            // TODO add your handling code here
            
            String id_buku = txtIDBukuCari.getSelectedItem().toString(); 
            pst = con.prepareStatement("SELECT * FROM buku WHERE id_buku=?");
            pst.setString(1, id_buku);
            rs = pst.executeQuery();
            
            if (rs.next() == true){
                txtJudul.setText(rs.getString(2));
                txtPengarang.setText(rs.getString(3));
                txtTahun.setText(rs.getString(4));
                txtPenerbit.setText(rs.getString(5));
                txtIDBuku.setText(rs.getString(6));
                txtStok.setText(rs.getString(7));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        
        if (txtJudul.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Judul harus diisi!");
        } else if(txtPengarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Pengarang harus diisi!");
        } else if(txtTahun.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Tahun harus diisi!");
        } else if(txtPenerbit.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Penerbit harus diisi!");
        } else if(txtIDBuku.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID Buku harus diisi!");
        } else if(txtStok.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Stok Buku harus diisi!");
        } else {
           
            try {
                // TODO add your handling code here:

                        String judul = txtJudul.getText();
                        String pengarang = txtPengarang.getText();
                        String tahun = txtTahun.getText();
                        String penerbit = txtPenerbit.getText();
                        String id_buku = txtIDBuku.getText();
                        String stok = txtStok.getText();
                        String id_bukucari = txtIDBukuCari.getSelectedItem().toString();
                        
                        pst = con.prepareStatement("UPDATE buku SET judul=?,pengarang=?,tahun=?,penerbit=?,id_buku=?,stok=? WHERE id_buku=?");
                        
                        pst.setString(1,judul);
                        pst.setString(2,pengarang);
                        pst.setString(3,tahun);
                        pst.setString(4,penerbit);
                        pst.setString(5,id_buku);
                        pst.setString(6,stok);
                        pst.setString(7,id_bukucari);
                        
                        int k = pst.executeUpdate();
                        if (k == 1) {
                            JOptionPane.showMessageDialog(this,"Data telah diperbarui!!!");
                            txtJudul.setText("");
                            txtPengarang.setText("");
                            txtTahun.setText("");
                            txtPenerbit.setText("");
                            txtIDBuku.setText("");
                            txtStok.setText("");
                            txtJudul.requestFocus();
                            Fetch();
                            LoadNoBuku();
                        }
                        
            } catch (SQLException ex) {
                Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (txtJudul.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Judul harus diisi!");
        } else if(txtPengarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Pengarang harus diisi!");
        } else if(txtTahun.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Tahun harus diisi!");
        } else if(txtPenerbit.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Penerbit harus diisi!");
        } else if(txtIDBuku.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"ID Buku harus diisi!");
        } else if(txtStok.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Stok Buku harus diisi!");
        } else {
        
        try {
            // TODO add your handling code here:
           
            String judul = txtJudul.getText();
            String pengarang = txtPengarang.getText();
            String tahun = txtTahun.getText();
            String penerbit = txtPenerbit.getText();
            String id_buku = txtIDBuku.getText();
            String stok = txtStok.getText();
            
            pst = con.prepareStatement("INSERT INTO buku (judul,pengarang,tahun,penerbit,id_buku,stok) VALUES (?,?,?,?,?,?)");
            pst.setString(1,judul);
            pst.setString(2,pengarang);
            pst.setString(3,tahun);
            pst.setString(4,penerbit);
            pst.setString(5,id_buku);
            pst.setString(6,stok);
            
            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this,"Data telah ditambahkan!");
                txtJudul.setText("");
                txtPengarang.setText("");
                txtTahun.setText("");
                txtPenerbit.setText("");
                txtIDBuku.setText("");
                txtStok.setText("");
                Fetch();
                LoadNoBuku();
            } else {
                JOptionPane.showMessageDialog(this,"Data gagal ditambahkan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String id_buku = txtIDBukuCari.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM buku WHERE id_buku=?");
            pst.setString(1,id_buku);
            
            int k = pst.executeUpdate();
            if (k == 1) {
                JOptionPane.showMessageDialog(this,"Data telah dihapus!!!");
                txtJudul.setText("");
                txtPengarang.setText("");
                txtTahun.setText("");
                txtPenerbit.setText("");
                txtIDBuku.setText("");
                txtStok.setText("");
                txtJudul.requestFocus();
                Fetch();
                LoadNoBuku();
            } else {
                JOptionPane.showMessageDialog(this,"Data tidak berhasil dihapus!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
                txtJudul.setText("");
                txtPengarang.setText("");
                txtTahun.setText("");
                txtPenerbit.setText("");
                txtIDBuku.setText("");
                txtStok.setText("");
                txtJudul.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        String filename = "C:\\Users\\Renald\\Downloads\\DataBuku.csv";
        
        try {
            FileWriter fw = new FileWriter(filename);
            pst = con.prepareStatement("SELECT * FROM buku");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append(',');
                fw.append(rs.getString(4));
                fw.append(',');
                fw.append(rs.getString(5));
                fw.append(',');
                fw.append(rs.getString(6));
                fw.append('\n');
            }
            JOptionPane.showMessageDialog(this,"CSV File telah diekspor!!!");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InputBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        
        HomepagePegawai HPegawai = new HomepagePegawai();
        HPegawai.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStokActionPerformed

    private void txtTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTahunActionPerformed

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
            java.util.logging.Logger.getLogger(InputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIDBuku;
    private javax.swing.JComboBox<String> txtIDBukuCari;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPenerbit;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
