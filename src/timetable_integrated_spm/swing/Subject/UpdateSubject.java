/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.swing.Subject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import timetable_integrated_spm.swing.lecturerDetails.HomeLecturers;
import timetable_integrated_spm.swing.sessions.HomeSessions;


/**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
public class UpdateSubject extends javax.swing.JFrame {

    private Connection connection;
    private PreparedStatement preparedStmt;
    private Subject subject;
    
    /**
     * Creates new form UpdateSubject
     */
    public UpdateSubject() {
        initComponents();
        dbconnect();
    }
    
    public UpdateSubject(Subject in_subject){
        initComponents();
        dbconnect();
        this.subject = in_subject;
        fillInputFields();
    }

    
    private void dbconnect(){
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:unidb;create=true";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateSubject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateSubject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
    }
    
    private void fillInputFields(){
        
        if(subject.getOffered_year_and_semester().contains("Year 1 Semester 1")){
            input_offeredYearAndSemester.setSelectedIndex(0);
        } else if(subject.getOffered_year_and_semester().contains("Year 1 Semester 2")){
            input_offeredYearAndSemester.setSelectedIndex(1);
        } else if(subject.getOffered_year_and_semester().contains("Year 2 Semester 1")){
            input_offeredYearAndSemester.setSelectedIndex(2);
        } else if(subject.getOffered_year_and_semester().contains("Year 2 Semester 2")){
            input_offeredYearAndSemester.setSelectedIndex(3);
        } else if(subject.getOffered_year_and_semester().contains("Year 3 Semester 1")){
            input_offeredYearAndSemester.setSelectedIndex(4);
        } else if(subject.getOffered_year_and_semester().contains("Year 3 Semester 2")){
            input_offeredYearAndSemester.setSelectedIndex(5);
        } else if(subject.getOffered_year_and_semester().contains("Year 4 Semester 1")){
            input_offeredYearAndSemester.setSelectedIndex(6);
        } else if(subject.getOffered_year_and_semester().contains("Year 4 Semester 2")){
            input_offeredYearAndSemester.setSelectedIndex(7);
        }
        
        input_subjectName.setText(subject.getSubject_name());
        input_subjectCode.setText(subject.getSubject_code());
        
        if( subject.getNumberOfLectureHours() == 1 ){
            input_lecture_hours.setSelectedIndex(0);
        } else if( subject.getNumberOfLectureHours() == 2 ){
            input_lecture_hours.setSelectedIndex(1);
        } else if( subject.getNumberOfLectureHours() == 3 ){
            input_lecture_hours.setSelectedIndex(2);
        } else if( subject.getNumberOfLectureHours() == 4 ){
            input_lecture_hours.setSelectedIndex(3);
        } else if( subject.getNumberOfLectureHours() == 5 ){
            input_lecture_hours.setSelectedIndex(4);
        } else if( subject.getNumberOfLectureHours() == 6 ){
            input_lecture_hours.setSelectedIndex(5);
        }
        
        if( subject.getNumberOfTutorialHours() == 1 ){
            input_tutorial_hours.setSelectedIndex(0);
        } else if( subject.getNumberOfTutorialHours() == 2 ){
            input_tutorial_hours.setSelectedIndex(1);
        } else if( subject.getNumberOfTutorialHours() == 3 ){
            input_tutorial_hours.setSelectedIndex(2);
        } else if( subject.getNumberOfTutorialHours() == 4 ){
            input_tutorial_hours.setSelectedIndex(3);
        }
        
        if( subject.getNumberOfLabHours() == 1 ){
            input_lab_hours.setSelectedIndex(0);
        } else if( subject.getNumberOfLabHours() == 2 ){
            input_lab_hours.setSelectedIndex(1);
        } else if( subject.getNumberOfLabHours() == 3 ){
            input_lab_hours.setSelectedIndex(2);
        } else if( subject.getNumberOfLabHours() == 4 ){
            input_lab_hours.setSelectedIndex(3);
        }
        
        if( subject.getNumberOfEvaluationHours() == 1 ){
            input_evaluation_hours.setSelectedIndex(0);
        } else if( subject.getNumberOfEvaluationHours() == 2 ){
            input_evaluation_hours.setSelectedIndex(1);
        } else if( subject.getNumberOfEvaluationHours() == 3 ){
            input_evaluation_hours.setSelectedIndex(2);
        } else if( subject.getNumberOfEvaluationHours() == 4 ){
            input_evaluation_hours.setSelectedIndex(3);
        } else if( subject.getNumberOfEvaluationHours() == 5 ){
            input_evaluation_hours.setSelectedIndex(4);
        } 
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btn_statisticsTab = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_studentTab = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btn_subjectTab = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btn_workingDaysTab = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btn_locationTab = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_lecturerTab = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        btn_sessionTab = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        input_subjectCode = new javax.swing.JTextField();
        input_evaluation_hours = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        input_subjectName = new javax.swing.JTextField();
        input_lecture_hours = new javax.swing.JComboBox<>();
        input_tutorial_hours = new javax.swing.JComboBox<>();
        input_lab_hours = new javax.swing.JComboBox<>();
        input_offeredYearAndSemester = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1600, 1000));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-group-of-projects-50.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 860, -1, -1));

        btn_statisticsTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_statisticsTab.setText("Statistics");
        btn_statisticsTab.setFocusPainted(false);
        btn_statisticsTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_statisticsTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_statisticsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 840, 420, 90));

        jLabel4.setBackground(new java.awt.Color(153, 102, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-lecturer-50.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 50, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-student-registration-50.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 590, -1, -1));

        btn_studentTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_studentTab.setText("Students");
        btn_studentTab.setFocusPainted(false);
        btn_studentTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_studentTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_studentTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 420, 90));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-love-book-50.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        btn_subjectTab.setBackground(new java.awt.Color(255, 51, 102));
        btn_subjectTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_subjectTab.setText("Subjects");
        btn_subjectTab.setFocusPainted(false);
        btn_subjectTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_subjectTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_subjectTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 420, 90));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-calendar-10-50.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, -1, -1));

        btn_workingDaysTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_workingDaysTab.setText("       Working days");
        btn_workingDaysTab.setFocusPainted(false);
        btn_workingDaysTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_workingDaysTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_workingDaysTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 420, 90));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-location-64.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 770, -1, 60));

        btn_locationTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_locationTab.setText("Location");
        btn_locationTab.setFocusPainted(false);
        btn_locationTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_locationTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_locationTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 420, 90));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(177, 122, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DASHBOARD");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 200, 130));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-home-50.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 70, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 420, 130));

        btn_lecturerTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_lecturerTab.setText("Lectures");
        btn_lecturerTab.setFocusPainted(false);
        btn_lecturerTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturerTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_lecturerTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 420, 90));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-stopwatch-64.png"))); // NOI18N
        jLabel18.setText("jLabel1");
        jLabel18.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 60, 60));

        btn_sessionTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_sessionTab.setText("Sessions");
        btn_sessionTab.setFocusPainted(false);
        btn_sessionTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sessionTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_sessionTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 420, 90));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 1000));

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 32)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SLIIT - Timetable Management System ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 1230, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setText("Number of Evaluation Hours");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 780, 380, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel6.setText("Offered Year and Semester");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 390, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setText("Subject Name ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 270, 50));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel13.setText("Subject Code");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 270, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel15.setText("Number of Lecture Hours");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, 400, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel16.setText("Number of Tutorial Hours");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, 350, 50));

        input_subjectCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_subjectCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_subjectCodeActionPerformed(evt);
            }
        });
        jPanel3.add(input_subjectCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 490, 190, 50));

        input_evaluation_hours.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_evaluation_hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jPanel3.add(input_evaluation_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 800, 80, 40));

        btn_update.setBackground(new java.awt.Color(255, 204, 0));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 900, 200, 50));

        btn_back.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-back-40.png"))); // NOI18N
        btn_back.setText(" Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 180, 70));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel17.setText("Number of Lab Hours");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 720, 290, 50));

        input_subjectName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_subjectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_subjectNameActionPerformed(evt);
            }
        });
        jPanel3.add(input_subjectName, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 420, 420, 50));

        input_lecture_hours.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_lecture_hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        jPanel3.add(input_lecture_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 590, 80, 40));

        input_tutorial_hours.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_tutorial_hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        input_tutorial_hours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_tutorial_hoursActionPerformed(evt);
            }
        });
        jPanel3.add(input_tutorial_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 660, 80, 40));

        input_lab_hours.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_lab_hours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jPanel3.add(input_lab_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 730, 80, 40));

        input_offeredYearAndSemester.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_offeredYearAndSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year 1 Semester 1", "Year 1 Semester 2", "Year 2 Semester 1", "Year 2 Semester 2", "Year 3 Semester 1", "Year 3 Semester 2", "Year 4 Semester 1", "Year 4 Semester 2" }));
        jPanel3.add(input_offeredYearAndSemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 360, 300, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_subjectCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_subjectCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_subjectCodeActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        String updated_offered_year_and_semester = String.valueOf(input_offeredYearAndSemester.getSelectedItem());
        String updated_subject_name = input_subjectName.getText();
        String updated_subject_code = input_subjectCode.getText();
        int updated_numberOfLectureHours = Integer.parseInt(String.valueOf(input_lecture_hours.getSelectedItem()));
        int updated_numberOfTutorialHours = Integer.parseInt(String.valueOf(input_tutorial_hours.getSelectedItem()));
        int updated_numberOfLabHours = Integer.parseInt(String.valueOf(input_lab_hours.getSelectedItem()));
        int updated_numberOfEvaluationHours = Integer.parseInt(String.valueOf(input_evaluation_hours.getSelectedItem()));
        
        if (!updated_subject_name.isEmpty() && !updated_subject_code.isEmpty()) {
            if (updated_subject_code.length() == 6) {
                try {
                    String query = "update subject "
                            + "set subject_code = ?, subject_name = ?, offeredYearandSemester = ?, numberOfLectureHours = ?, numberOfTutorialHours = ?, numberOfLabHours = ?, numberOfEvaluationHours = ? "
                            + "where subject_code = ?";

                    preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString(1, updated_subject_code);
                    preparedStmt.setString(2, updated_subject_name);
                    preparedStmt.setString(3, updated_offered_year_and_semester);
                    preparedStmt.setInt(4, updated_numberOfLectureHours);
                    preparedStmt.setInt(5, updated_numberOfTutorialHours);
                    preparedStmt.setInt(6, updated_numberOfLabHours);
                    preparedStmt.setInt(7, updated_numberOfEvaluationHours);
                    preparedStmt.setString(8, subject.getSubject_code());

                    // execute the preparedstatement
                    preparedStmt.execute();

                    connection.close();

                    JOptionPane.showMessageDialog(null, "Subject details updated successfully");

                    input_offeredYearAndSemester.setSelectedIndex(0);
                    input_subjectName.setText("");
                    input_subjectCode.setText("");

                    input_lecture_hours.setSelectedIndex(0);
                    input_tutorial_hours.setSelectedIndex(0);
                    input_lab_hours.setSelectedIndex(0);
                    input_evaluation_hours.setSelectedIndex(0);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                    System.err.println("Exception on Updating Subject Action");
                    Logger.getLogger(UpdateSubject.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error! \n Invalid subject code!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are Empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewSubject wnd_viewSubjects = new ViewSubject();
        wnd_viewSubjects.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void input_subjectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_subjectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_subjectNameActionPerformed

    private void input_tutorial_hoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_tutorial_hoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_tutorial_hoursActionPerformed

    private void btn_statisticsTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_statisticsTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_statisticsTabActionPerformed

    private void btn_studentTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_studentTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_studentTabActionPerformed

    private void btn_subjectTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subjectTabActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeSubjects wnd_homeSubjects = new HomeSubjects();
        wnd_homeSubjects.setVisible(true);
    }//GEN-LAST:event_btn_subjectTabActionPerformed

    private void btn_workingDaysTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_workingDaysTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_workingDaysTabActionPerformed

    private void btn_locationTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_locationTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_locationTabActionPerformed

    private void btn_lecturerTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturerTabActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeLecturers wnd_homeLecturer = new HomeLecturers();
        wnd_homeLecturer.setVisible(true);
    }//GEN-LAST:event_btn_lecturerTabActionPerformed

    private void btn_sessionTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sessionTabActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeSessions wnd_homeSessions = new HomeSessions();
        wnd_homeSessions.setVisible(true);
    }//GEN-LAST:event_btn_sessionTabActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateSubject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_lecturerTab;
    private javax.swing.JButton btn_locationTab;
    private javax.swing.JButton btn_sessionTab;
    private javax.swing.JButton btn_statisticsTab;
    private javax.swing.JButton btn_studentTab;
    private javax.swing.JButton btn_subjectTab;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_workingDaysTab;
    private javax.swing.JComboBox<String> input_evaluation_hours;
    private javax.swing.JComboBox<String> input_lab_hours;
    private javax.swing.JComboBox<String> input_lecture_hours;
    private javax.swing.JComboBox<String> input_offeredYearAndSemester;
    private javax.swing.JTextField input_subjectCode;
    private javax.swing.JTextField input_subjectName;
    private javax.swing.JComboBox<String> input_tutorial_hours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
