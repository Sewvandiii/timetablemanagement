/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagement;

<<<<<<< HEAD
import Statics.Stu_statics;
=======

import WorkingHours.Working;
>>>>>>> 342d3b3... Updated derby database - complete sprint1
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thili
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        home_locationButton = new javax.swing.JButton();
        btn_statics = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
<<<<<<< HEAD
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        home_locationButton1 = new javax.swing.JButton();
        btn_statics1 = new javax.swing.JButton();
=======
        workingHours = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
>>>>>>> 342d3b3... Updated derby database - complete sprint1

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TimeTable Management system");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-male-user-40.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-notification-40.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cheburashka-70.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Timetable Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setSelectionColor(new java.awt.Color(204, 204, 204));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-property-35.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jButton1.setBackground(new java.awt.Color(204, 0, 255));
        jButton1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-student-male-70.png"))); // NOI18N
        jButton1.setText("STUDENTs");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        home_locationButton.setBackground(new java.awt.Color(204, 0, 255));
        home_locationButton.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        home_locationButton.setForeground(new java.awt.Color(255, 255, 255));
        home_locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-location-70.png"))); // NOI18N
        home_locationButton.setText("Location");
        home_locationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_locationButtonActionPerformed(evt);
            }
        });

        btn_statics.setBackground(new java.awt.Color(204, 0, 255));
        btn_statics.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        btn_statics.setForeground(new java.awt.Color(255, 255, 255));
        btn_statics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-graph-70.png"))); // NOI18N
        btn_statics.setText("statics");
        btn_statics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_staticsActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 0, 255));
        jButton4.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-physics-book-70.png"))); // NOI18N
        jButton4.setText("SUBJECTs");

<<<<<<< HEAD
        jButton5.setBackground(new java.awt.Color(204, 0, 255));
        jButton5.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-time-machine-70.png"))); // NOI18N
        jButton5.setText("Woking hours");
=======
        workingHours.setBackground(new java.awt.Color(204, 0, 255));
        workingHours.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        workingHours.setForeground(new java.awt.Color(255, 255, 255));
        workingHours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-time-machine-70.png"))); // NOI18N
        workingHours.setText("Woking hours");
        workingHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workingHoursActionPerformed(evt);
            }
        });
>>>>>>> 342d3b3... Updated derby database - complete sprint1

        jButton7.setBackground(new java.awt.Color(204, 0, 255));
        jButton7.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-training-70.png"))); // NOI18N
        jButton7.setText("LECTURERs");

<<<<<<< HEAD
        home_locationButton1.setBackground(new java.awt.Color(204, 0, 255));
        home_locationButton1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        home_locationButton1.setForeground(new java.awt.Color(255, 255, 255));
        home_locationButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-room-70.png"))); // NOI18N
        home_locationButton1.setText("Rooms");
        home_locationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_locationButton1ActionPerformed(evt);
            }
        });

        btn_statics1.setBackground(new java.awt.Color(204, 0, 255));
        btn_statics1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        btn_statics1.setForeground(new java.awt.Color(255, 255, 255));
        btn_statics1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_icons/icons8-planner-70.png"))); // NOI18N
        btn_statics1.setText("Session");
        btn_statics1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statics1ActionPerformed(evt);
            }
        });

=======
>>>>>>> 342d3b3... Updated derby database - complete sprint1
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(162, 162, 162)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                            .addGap(163, 163, 163)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(home_locationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(home_locationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
=======
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(home_locationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 7, Short.MAX_VALUE)
                                .addGap(163, 163, 163)))))
>>>>>>> 342d3b3... Updated derby database - complete sprint1
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_statics, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_statics1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
=======
                        .addComponent(workingHours, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_statics, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
>>>>>>> 342d3b3... Updated derby database - complete sprint1
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
<<<<<<< HEAD
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_locationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_statics, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_locationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_statics1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
=======
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workingHours, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_locationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_statics, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
>>>>>>> 342d3b3... Updated derby database - complete sprint1
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jLabel11)
                        .addGap(42, 42, 42)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
<<<<<<< HEAD
                .addGap(35, 35, 35))
=======
                .addGap(52, 52, 52))
>>>>>>> 342d3b3... Updated derby database - complete sprint1
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 990));
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 840));
>>>>>>> 342d3b3... Updated derby database - complete sprint1

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_staticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_staticsActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        new Stu_statics().setVisible(true);
        this.setVisible(false); 
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
        this.dispose();
    }//GEN-LAST:event_btn_staticsActionPerformed

    private void home_locationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_locationButtonActionPerformed
        try {
            // TODO add your handling code here:

            new Location.Loc_add().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
=======
      
    }//GEN-LAST:event_btn_staticsActionPerformed

    private void home_locationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_locationButtonActionPerformed
        // TODO add your handling code here:
          
       
    }//GEN-LAST:event_home_locationButtonActionPerformed

    private void workingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workingHoursActionPerformed
        try {
            try {
                // TODO add your handling code here:

                new WorkingHours.Working().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
>>>>>>> 342d3b3... Updated derby database - complete sprint1
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false); 
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE); 
        this.dispose(); 
<<<<<<< HEAD
    }//GEN-LAST:event_home_locationButtonActionPerformed

    private void home_locationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_locationButton1ActionPerformed
        try {
            // TODO add your handling code here:
            new Room.Rooms().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_home_locationButton1ActionPerformed

    private void btn_statics1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statics1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_statics1ActionPerformed
=======
    }//GEN-LAST:event_workingHoursActionPerformed
>>>>>>> 342d3b3... Updated derby database - complete sprint1

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_statics;
<<<<<<< HEAD
    private javax.swing.JButton btn_statics1;
    private javax.swing.JButton home_locationButton;
    private javax.swing.JButton home_locationButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
=======
    private javax.swing.JButton home_locationButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
>>>>>>> 342d3b3... Updated derby database - complete sprint1
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
<<<<<<< HEAD
=======
    private javax.swing.JButton workingHours;
>>>>>>> 342d3b3... Updated derby database - complete sprint1
    // End of variables declaration//GEN-END:variables
}
