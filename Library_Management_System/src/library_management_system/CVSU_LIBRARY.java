
package library_management_system;

import java.awt.Color;
import javax.swing.JOptionPane;

public class CVSU_LIBRARY extends javax.swing.JFrame {

    int me=110;
    
    public CVSU_LIBRARY() {
        initComponents();
        setLocationRelativeTo(null);
        panel.setBackground(new Color(0,0,0,95));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbody = new javax.swing.JPanel();
        cvsu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        student = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        user = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainbody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cvsu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><center>Cavite State University<br>Bacoor Campus</center></html>");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), " Library Management System ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 20), new java.awt.Color(255, 255, 255))); // NOI18N
        cvsu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 50, 470, 150));

        panel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );

        cvsu.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 45, 495, 165));

        jPanel1.setBackground(new java.awt.Color(250, 100, 100));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        student.setForeground(new java.awt.Color(255, 255, 255));
        student.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        student.setText("Student");
        student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentMousePressed(evt);
            }
        });
        jPanel1.add(student, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 30));

        cvsu.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 240, 80, 30));

        jPanel2.setBackground(new java.awt.Color(100, 100, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Kartika", 0, 12)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("Admin/Librarian");
        user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userMousePressed(evt);
            }
        });
        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 95, 30));

        cvsu.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 285, 95, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/color/bluepink.png"))); // NOI18N
        cvsu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 355));

        mainbody.add(cvsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 527, 355));

        getContentPane().add(mainbody, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 527, 355));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMousePressed
        JOptionPane.showMessageDialog(null, "Wait for any momment!", "Message", 1);
        new user().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_studentMousePressed

    private void userMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMousePressed
        JOptionPane.showMessageDialog(null, "Wait for any momment!", "Message", 1);
        new login404().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userMousePressed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CVSU_LIBRARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CVSU_LIBRARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CVSU_LIBRARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CVSU_LIBRARY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CVSU_LIBRARY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cvsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mainbody;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel student;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
