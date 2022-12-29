
import javax.swing.JOptionPane;

public class LogPage extends javax.swing.JFrame {

    public static String username;
    public static String password;
    public LogPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jToggleButton_Masuk = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jToggleButton_Mahasiswa1 = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(100, 100));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(100, 100));
        jPanel2.setLayout(null);

        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-10, 90, 347, 325);

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(62, 11, 0, 0);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Nama Pengguna :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(340, 150, 120, 17);

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Kata Sandi :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 210, 70, 17);

        user.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        user.setMinimumSize(new java.awt.Dimension(64, 22));
        user.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFocusGained(evt);
            }
        });
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel1.add(user);
        user.setBounds(340, 170, 210, 30);

        pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFocusGained(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(340, 230, 210, 31);

        jToggleButton_Masuk.setBackground(new java.awt.Color(108, 74, 182));
        jToggleButton_Masuk.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jToggleButton_Masuk.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton_Masuk.setText("MASUK");
        jToggleButton_Masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton_MasukMouseClicked(evt);
            }
        });
        jToggleButton_Masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_MasukActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton_Masuk);
        jToggleButton_Masuk.setBounds(340, 280, 210, 35);

        jLabel11.setFont(new java.awt.Font("Gill Sans MT", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("atau masuk sebagai");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(400, 320, 100, 15);

        jToggleButton_Mahasiswa1.setBackground(new java.awt.Color(108, 74, 182));
        jToggleButton_Mahasiswa1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jToggleButton_Mahasiswa1.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton_Mahasiswa1.setText("MAHASISWA");
        jToggleButton_Mahasiswa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_Mahasiswa1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton_Mahasiswa1);
        jToggleButton_Mahasiswa1.setBounds(340, 340, 210, 35);

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Gill Sans MT", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("tentang aplikasi");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9);
        jLabel9.setBounds(410, 380, 80, 20);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage.png"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 600, 440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton_MasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_MasukActionPerformed
        String Username=user.getText(); 
        String Password=pass.getText();
        if(Username.contains("IT-brary05") && Password.contains("2R2A")){
            user.setText("");
            pass.setText("");
            HomepagePegawai anb = new HomepagePegawai();
            anb.setVisible(true);
            this.setVisible(false);
        }
        
        else if (Username.contains("Renald21") && Password.contains("21April")){
            user.setText("");
            pass.setText("");
            HomepagePegawai anb = new HomepagePegawai();
            anb.setVisible(true);
            this.setVisible(false);
        }
        
        else if (Username.contains("Rahma20") && Password.contains("20Juni")){
            user.setText("");
            pass.setText("");
            HomepagePegawai anb = new HomepagePegawai();
            anb.setVisible(true);
            this.setVisible(false);
        }
        
        else if (Username.contains("Ana27") && Password.contains("27Oktober")){
            user.setText("");
            pass.setText("");
            HomepagePegawai anb = new HomepagePegawai();
            anb.setVisible(true);
            this.setVisible(false);
        }
        
        else if (Username.contains("Anya28") && Password.contains("28Februari")){
            user.setText("");
            pass.setText("");
            HomepagePegawai anb = new HomepagePegawai();
            anb.setVisible(true);
            this.setVisible(false);
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Nama pengguna atau kata sandi yang Anda masukkan salah. Silahkan coba lagi.", "Login Error", JOptionPane.ERROR_MESSAGE);
            pass.setText(null);
            user.setText(null);
        }
    }//GEN-LAST:event_jToggleButton_MasukActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void jToggleButton_MasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton_MasukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton_MasukMouseClicked

    private void userFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFocusGained
        // TODO add your handling code here:
        user.setText("");
    }//GEN-LAST:event_userFocusGained

    private void passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFocusGained
        // TODO add your handling code here:
        pass.setText("");
    }//GEN-LAST:event_passFocusGained

    private void jToggleButton_Mahasiswa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_Mahasiswa1ActionPerformed
        // TODO add your handling code here:
        HomepageMahasiswa anb = new HomepageMahasiswa();
        anb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jToggleButton_Mahasiswa1ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        AboutApp anb = new AboutApp();
        anb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    /** 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton_Mahasiswa1;
    private javax.swing.JToggleButton jToggleButton_Masuk;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
