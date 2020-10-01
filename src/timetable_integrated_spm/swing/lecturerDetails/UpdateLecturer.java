/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.swing.lecturerDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import timetable_integrated_spm.swing.Subject.HomeSubjects;
import timetable_integrated_spm.swing.sessions.HomeSessions;

/**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
public class UpdateLecturer extends javax.swing.JFrame {

    private Connection connection;
    private PreparedStatement preparedStmt;
    private Lecturer lecturer;
    
    /**
     * Creates new form UpdateLecturer
     */
    public UpdateLecturer() {
        initComponents();
        dbconnect();
    }

    public UpdateLecturer(Lecturer in_lecturer) {
        initComponents();
        dbconnect();
        this.lecturer = in_lecturer;
        fillInputFields();
    }
    
    private void fillInputFields(){
        
        input_lect_fname.setText(lecturer.getLecturer_fname());
        input_lect_lname.setText(lecturer.getLecturer_lname());
        input_lect_empId.setText(lecturer.getEmpId());
        
        if(lecturer.getFaculty().contains("Computing")){
            input_faculty.setSelectedIndex(0);
        } else if(lecturer.getFaculty().contains("Engineering")){
            input_faculty.setSelectedIndex(1);
        }else if(lecturer.getFaculty().contains("Business")){
            input_faculty.setSelectedIndex(2);
        }else if(lecturer.getFaculty().contains("Humanities & Sciences")){
            input_faculty.setSelectedIndex(3);
        }
        
        if(lecturer.getDepartment().contains("Department Of Information Technology")){
            input_department.setSelectedIndex(0);
        } else if (lecturer.getDepartment().contains("Department of Computer Science & Software Engineering")){
            input_department.setSelectedIndex(1);
        } else if (lecturer.getDepartment().contains("Department of Electrical & Electronic Engineering")){
            input_department.setSelectedIndex(2);
        } else if (lecturer.getDepartment().contains("Department Of Business Management")){
            input_department.setSelectedIndex(3);
        }
        
        if (lecturer.getCenter().contains("Malabe")){
            input_center.setSelectedIndex(0);
        } else if (lecturer.getCenter().contains("Metro")){
            input_center.setSelectedIndex(1);
        } else if (lecturer.getCenter().contains("Matara")){
            input_center.setSelectedIndex(2);
        } else if (lecturer.getCenter().contains("Kandy")){
            input_center.setSelectedIndex(3);
        } else if (lecturer.getCenter().contains("Kurunagala")){
            input_center.setSelectedIndex(4);
        } else if (lecturer.getCenter().contains("Jaffna")){
            input_center.setSelectedIndex(5);
        } 
        
        if(lecturer.getBuilding().contains("Main Building")){
            input_building.setSelectedIndex(0);
        } else if (lecturer.getBuilding().contains("New Building" )) {
            input_building.setSelectedIndex(1);
        } else if (lecturer.getBuilding().contains("D-block" )) {
            input_building.setSelectedIndex(2);
        }
        
        if(lecturer.getAcademicRank() == 1){
            input_rank.setSelectedIndex(0);
        } else if(lecturer.getAcademicRank() == 2){
            input_rank.setSelectedIndex(1);
        } else if(lecturer.getAcademicRank() == 3){
            input_rank.setSelectedIndex(2);
        } else if(lecturer.getAcademicRank() == 4){
            input_rank.setSelectedIndex(3);
        } else if(lecturer.getAcademicRank() == 5){
            input_rank.setSelectedIndex(4);
        } else if(lecturer.getAcademicRank() == 6){
            input_rank.setSelectedIndex(5);
        } else if(lecturer.getAcademicRank() == 7){
            input_rank.setSelectedIndex(6);
        }
    }
    
    private void dbconnect(){
        final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
        final String JDBC_URL = "jdbc:derby:unidb;create=true";
        
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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
        jLabel17 = new javax.swing.JLabel();
        btn_sessionTab = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        input_lect_lname = new javax.swing.JTextField();
        input_lect_fname = new javax.swing.JTextField();
        input_lect_empId = new javax.swing.JTextField();
        input_faculty = new javax.swing.JComboBox<>();
        input_rank = new javax.swing.JComboBox<>();
        input_department = new javax.swing.JComboBox<>();
        input_center = new javax.swing.JComboBox<>();
        input_building = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

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

        btn_lecturerTab.setBackground(new java.awt.Color(255, 51, 102));
        btn_lecturerTab.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N
        btn_lecturerTab.setText("Lectures");
        btn_lecturerTab.setFocusPainted(false);
        btn_lecturerTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturerTabActionPerformed(evt);
            }
        });
        jPanel1.add(btn_lecturerTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 420, 90));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-stopwatch-64.png"))); // NOI18N
        jLabel17.setText("jLabel1");
        jLabel17.setPreferredSize(new java.awt.Dimension(50, 50));
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 60, 60));

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
        jLabel1.setText("Academic Rank");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 770, 270, 50));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel6.setText("Lecturer Name ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 270, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel7.setText("Employee ID");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 270, 50));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel13.setText("Faculty");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 270, 50));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel14.setText("Department");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 270, 50));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel15.setText("Center");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, 270, 50));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel16.setText("Building");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 700, 270, 50));

        input_lect_lname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(input_lect_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 350, 280, 50));

        input_lect_fname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(input_lect_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 350, 280, 50));

        input_lect_empId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_lect_empId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_lect_empIdActionPerformed(evt);
            }
        });
        jPanel3.add(input_lect_empId, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 280, 50));

        input_faculty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_faculty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computing", "Engineering", "Business", "Humanities & Sciences" }));
        input_faculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_facultyActionPerformed(evt);
            }
        });
        jPanel3.add(input_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, 340, 40));

        input_rank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_rank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Professor", "Assitant Professor", "Senior Lecturer(HG)", "Senior Lecturer", "Lecturer", "Assistant Lecturer", "Instructor" }));
        jPanel3.add(input_rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 780, 340, 40));

        input_department.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Department Of Information Technology", "Department of Computer Science & Software Engineering", "Department of Electrical & Electronic Engineering", "Department Of Business Management" }));
        jPanel3.add(input_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, 570, 40));

        input_center.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_center.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Malabe", "Metro", "Matara", "Kandy", "Kurunagala", "Jaffna" }));
        input_center.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_centerActionPerformed(evt);
            }
        });
        jPanel3.add(input_center, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 640, 340, 40));

        input_building.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        input_building.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main Building", "New Building", "D-block" }));
        jPanel3.add(input_building, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 710, 340, 40));

        btn_update.setBackground(new java.awt.Color(255, 204, 0));
        btn_update.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel3.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 900, 200, 50));

        btn_back.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/codejava/images/icons8-back-40.png"))); // NOI18N
        btn_back.setText(" Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel3.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 180, 70));

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

    private void input_lect_empIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_lect_empIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_lect_empIdActionPerformed

    private void input_facultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_facultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_facultyActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        String updated_lect_fname = input_lect_fname.getText();
        String updated_lect_lname = input_lect_lname.getText();
        String updated_lect_empID = input_lect_empId.getText();
        String updated_faculty = String.valueOf(input_faculty.getSelectedItem());
        String updated_department = String.valueOf(input_department.getSelectedItem());
        String updated_center = String.valueOf(input_center.getSelectedItem());
        String updated_building = String.valueOf(input_building.getSelectedItem());
        String updated_rank = String.valueOf(input_rank.getSelectedItem());
        int level = 5;
        
       if( updated_rank == "Professor" ){
            level = 1;
        } else if( updated_rank == "Assitant Professor" ){
            level = 2;
        } else if( updated_rank == "Senior Lecturer(HG)" ){
            level = 3;
        } else if( updated_rank == "Senior Lecturer" ){
            level = 4;
        } else if( updated_rank == "Lecturer" ){
            level = 5;
        } else if( updated_rank == "Assistant Lecturer" ){
            level = 6;
        } else if( updated_rank == "Instructor" ){
            level = 7;
        }
       
        if (!updated_lect_fname.isEmpty() && !updated_lect_lname.isEmpty() && !updated_lect_empID.isEmpty()) {
            if (updated_lect_empID.length() == 6) {
                try {
                    String query = "update lecturer "
                            + "set lecturer_fname = ?, lecturer_lname = ?, employeeId = ?, faculty = ?, department = ?, center = ?, building = ?, level = ?"
                            + "where employeeId = ?";

                    preparedStmt = connection.prepareStatement(query);
                    preparedStmt.setString(1, updated_lect_fname);
                    preparedStmt.setString(2, updated_lect_lname);
                    preparedStmt.setString(3, updated_lect_empID);
                    preparedStmt.setString(4, updated_faculty);
                    preparedStmt.setString(5, updated_department);
                    preparedStmt.setString(6, updated_center);
                    preparedStmt.setString(7, updated_building);
                    preparedStmt.setInt(8, level);
                    preparedStmt.setString(9, lecturer.getEmpId());

                    // execute the preparedstatement
                    preparedStmt.execute();

                    connection.close();

                    JOptionPane.showMessageDialog(null, "Lecturer details updated successfully");

                    input_lect_fname.setText("");
                    input_lect_lname.setText("");
                    input_lect_empId.setText("");
                    input_faculty.setSelectedIndex(0);
                    input_department.setSelectedIndex(0);
                    input_center.setSelectedIndex(0);
                    input_building.setSelectedIndex(0);
                    input_rank.setSelectedIndex(0);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Something went wrong! Please try again.");
                    System.err.println("Exception on Update Action");
                    Logger.getLogger(UpdateLecturer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error! \n Employee ID should be a 6 digit number !", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "One or more fields are empty!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ViewLecturer wnd_viewLecturer = new ViewLecturer();
        wnd_viewLecturer.setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

    private void input_centerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_centerActionPerformed
        // TODO add your handling code here:
        String center = String.valueOf(input_center.getSelectedItem());
        if (!center.isEmpty()) {
            try {
                String query = "SELECT building FROM center_building WHERE center = ?";
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, center);

                input_building.removeAllItems();
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    input_building.addItem(rs.getString(1));
                }

            } catch (SQLException ex) {
                System.err.println("Exception in the building ComboBox pplaon");
                Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_input_centerActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateLecturer().setVisible(true);
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
    private javax.swing.JComboBox<String> input_building;
    private javax.swing.JComboBox<String> input_center;
    private javax.swing.JComboBox<String> input_department;
    private javax.swing.JComboBox<String> input_faculty;
    private javax.swing.JTextField input_lect_empId;
    private javax.swing.JTextField input_lect_fname;
    private javax.swing.JTextField input_lect_lname;
    private javax.swing.JComboBox<String> input_rank;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
