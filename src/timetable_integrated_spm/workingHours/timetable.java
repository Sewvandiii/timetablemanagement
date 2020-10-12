/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.workingHours;

import Location.Loc_add;
import Location.Location;
import Statics.Stu_statics;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import timetable_integrated_spm.swing.Subject.HomeSubjects;
import timetable_integrated_spm.swing.lecturerDetails.AddLecturer;
import timetable_integrated_spm.swing.lecturerDetails.HomeLecturers;
import timetable_integrated_spm.swing.sessions.*;
import static timetable_integrated_spm.workingHours.TablesConst.con;
import util.RawHtmlRenderer;

/**
 *
 * @author Sewwandi
 */
public class timetable extends javax.swing.JFrame {

    private Connection con;
    private ArrayList<String> timeIntervals;
    String lecturers, tag, subject_name, subject_code, student_group_id, duration, number_of_students;
    ArrayList<String> GroupList = new ArrayList<String>(7);
    ArrayList<String> LecturerList = new ArrayList<String>(7);
    ArrayList<String> StudentList = new ArrayList<String>(7);
    ArrayList<String> TagsList = new ArrayList<String>(7);
    ArrayList<String> TotalData = new ArrayList<String>(7);
    ArrayList<String> sessionListForTimetable = new ArrayList<>();
    /**
     * Creates new form timetable
     */
    ArrayList<String> subjectCodes = new ArrayList<String>();
    ArrayList<String> groupID = new ArrayList<String>();
    private Connection connection;
    private Statement statement;

    public timetable() throws PrinterException {
        initComponents();
        dbconnect();
//        subjectCodes.add("IT1011");
//        subjectCodes.add("IT1012");
//        groupID.add("Y3S2.02");
//        groupID.add("Y3S3.02");

        show_sessions(TotalData);
        sessionListForTimetable = sessionValueList();
        System.out.println("Session for time table :" + sessionListForTimetable.get(0));
        System.out.println("values" + sessionListForTimetable.size());
        //take the size of the sessions array
        int size_sessions = sessionListForTimetable.size();

        DefaultTableModel model1 = (DefaultTableModel) session_table.getModel();

        session_table.getColumnModel().getColumn(7).setCellRenderer(new RawHtmlRenderer());

//        Object[] row = new Object[size_sessions + 4];
//
//        row[2] = sessionListForTimetable.get(0);
//        model1.addRow(row);
        //Timeslot
        model1.setValueAt("8.30", 0, 0);
        model1.setValueAt("9.30", 1, 0);
        model1.setValueAt("10.30", 2, 0);
        model1.setValueAt("11.30", 3, 0);
        model1.setValueAt("12.30", 4, 0);
        model1.setValueAt("1.30", 5, 0);
        model1.setValueAt("2.30", 6, 0);
        model1.setValueAt("3.30", 7, 0);
        model1.setValueAt("4.30", 8, 0);

        //Adding sessions
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Lecture<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 0, 1);
        model1.setValueAt("<html><h5>Kasun Kumara<br>Practical<br>"
                + "Software Project Management<br>8<br>Y1.S1.IT.03</h5></html>", 1, 2);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Tutorial<br>"
                + "Software Project Management<br>5<br>Y3.S1.SE.01.01</h5></html>", 2, 1);
        model1.setValueAt("<html><h5>Kasun Kumara<br>Lecture<br>"
                + "Software Project Management<br>6<br>Y4.S1.IM.01.1</h5></html>", 0, 3);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Practical<br>"
                + "Software Project Management<br>5<br>Y3.S1.SE.01.02</h5></html>", 5, 5);
        model1.setValueAt("<html><h5>Kasun kumara<br>Tutorial<br>"
                + "Software Project Management<br>4<br>Y1.S1.IT.01</h5></html>", 0, 6);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Practical<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.03</h5></html>", 1, 5);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Lecture<br>"
                + "Software Project Management<br>7<br>Y1.S1.IT.01</h5></html>", 2, 6);
        model1.setValueAt("<html><h5>Kasun Kumara<br>Lecture<br>"
                + "Software Project Management<br>8<br>Y1.S1.SE.01.1</h5></html>", 4, 4);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Practical<br>"
                + "Software Project Management<br>9<br>Y1.S1.SE.01.2</h5></html>", 6, 3);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Tutorial<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 3, 4);
        model1.setValueAt("<html><h5>Kasun Kumara<br>Tutorial<br>"
                + "Software Project Management<br>7<br>Y1.S1.IM.01</h5></html>", 4, 6);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Practical<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 7, 2);
        model1.setValueAt("<html><h5>Kasun Kumara<br>Lecture<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 5, 2);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Practical<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 4, 1);
        model1.setValueAt("<html><h5>Prasanna Gamage<br>Tutorial<br>"
                + "Software Project Management<br>6<br>Y1.S1.IT.01</h5></html>", 8, 5);

        /*Adding new over*/
    }

    private void dbconnect() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        session_table = new javax.swing.JTable();
        printbtn = new javax.swing.JButton();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nav_WorkingHours = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        kButton3 = new keeptoo.KButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/class.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("working hours & days");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 960, 80));

        session_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Timeslot", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ));
        session_table.setRowHeight(100);
        jScrollPane1.setViewportView(session_table);
        if (session_table.getColumnModel().getColumnCount() > 0) {
            session_table.getColumnModel().getColumn(7).setResizable(false);
            session_table.getColumnModel().getColumn(7).setHeaderValue("Sunday");
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 900, -1));

        printbtn.setBackground(new java.awt.Color(51, 0, 255));
        printbtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        printbtn.setForeground(new java.awt.Color(255, 255, 255));
        printbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/icons8-timetable-30.png"))); // NOI18N
        printbtn.setText("   Print");
        printbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printbtnActionPerformed(evt);
            }
        });
        jPanel2.add(printbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 720, 250, 50));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, 50));

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/icons8-timetable-30.png"))); // NOI18N
        jButton1.setText("  Timetables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 250, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-menu-30.png"))); // NOI18N
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-lecturer-30_1.png"))); // NOI18N
        jButton2.setText("   Lecturers");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 250, 60));

        jButton3.setBackground(new java.awt.Color(151, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-male-30_1.png"))); // NOI18N
        jButton3.setText("  Students");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 250, 60));

        jButton4.setBackground(new java.awt.Color(153, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-30.png"))); // NOI18N
        jButton4.setText("  Subjects");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 250, 60));

        jButton5.setBackground(new java.awt.Color(153, 0, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-location-30.png"))); // NOI18N
        jButton5.setText("  Location");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 250, 60));

        nav_WorkingHours.setBackground(new java.awt.Color(102, 0, 255));
        nav_WorkingHours.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nav_WorkingHours.setForeground(new java.awt.Color(255, 255, 255));
        nav_WorkingHours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-clock-settings-30.png"))); // NOI18N
        nav_WorkingHours.setText("Working hours");
        nav_WorkingHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nav_WorkingHoursActionPerformed(evt);
            }
        });
        kGradientPanel1.add(nav_WorkingHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 250, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel3.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cheburashka-70.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 0, 102));
        jLabel10.setText("Location");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Building Name");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Room Number");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Room Type");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kButton3.setText("UPdate");
        kButton3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        kButton3.setkEndColor(new java.awt.Color(0, 204, 51));
        kButton3.setkStartColor(new java.awt.Color(0, 255, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE))))
                .addGap(105, 105, 105))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        kGradientPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1110, 800));

        jButton7.setBackground(new java.awt.Color(51, 0, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/icons8-room-30.png"))); // NOI18N
        jButton7.setText("  Sessions");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, 60));

        jButton8.setBackground(new java.awt.Color(51, 0, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-graph-30.png"))); // NOI18N
        jButton8.setText("   Statics");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 250, 60));

        jPanel2.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 800));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<String> sessionValueList() {
        ArrayList<String> sessionValueList = new ArrayList<>();
        try {
            String query = "SELECT * FROM sessionsValues";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String sessionVal = rs.getString("sessions");
                sessionValueList.add(sessionVal);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex + "Exception occured in sessionList method");
            Logger.getLogger(ViewSession.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sessionValueList;
    }

    public void show_sessions(ArrayList<String> totalData) throws PrinterException {
        try {
            getData();
            System.out.println("TotoalData: " + TotalData.toString());
        } catch (Exception ex) {
            System.out.println("Exception Caught");
            ex.printStackTrace();
        }
        for (String total : totalData) {
            System.out.println("Inside the ;llop");
            System.out.println(total);
        }

        String table_cols[] = {"lecturers", "tag", "subject_name", "subject_code", "student_group_id", "duration", "number_of_students"};
        String time_intervals[] = {"8.30", "9.30", "10.30", "11.30", "12.30", "1.30", "2.30", "3.30", "4.30"};
        DefaultTableModel tableModel = (DefaultTableModel) session_table.getModel();
//         DefaultTableModel tableModel = new DefaultTableModel(table_cols, 0);
//         Object[] obj = {"we", "wee", "weer", "weerr", "weerrr", "weerrrr", "wweerrr"};

        for (String session : sessionListForTimetable) {
            System.out.println(session);
        }

        for (int i = 0; i < sessionListForTimetable.size(); i++) {

            System.out.println(time_intervals[i]);

        }
        for (int i = 0; i < sessionListForTimetable.size(); i++) {
            String concat = subjectCodes.get(i) + "\n " + groupID.get(i);
            tableModel.addRow(new Object[]{time_intervals[i], concat, sessionListForTimetable.get(i), "Col4", "Col5", "Col6", "Col7", "Col8"});
        }

//        String table_cols[] = timetable_integrated_spm.swing.getTableCols());
//        timeIntervals = new ArrayList<String>();
//        timeIntervals.add("8.30");
//        timeIntervals.add("9.30");
//        timeIntervals.add("10.30");
//        timeIntervals.add("11.30");
//        timeIntervals.add("12.30");
//        timeIntervals.add("1.30");
//        timeIntervals.add("2.30");
//        timeIntervals.add("3.30");
//        timeIntervals.add("4.30");
////        
//        DefaultTableModel model = (DefaultTableModel) session_table.getModel();
//        Object[] row = new Object[8];
//        for (int i = 0; i < timeIntervals.size() ; i++) { // col
//                model.setValueAt(timeIntervals.get(i), i, 0);       
//        }
//        System.out.println("Sesion ArrayList data : " + Session.session_string_arrList.get(0));
//        for (int i = 0; i < Session.session_string_arrList.size(); i++) {
//                row[1] = Session.session_string_arrList.get(i);
//                row[2] = Session.session_string_arrList.get(i);
//                row[3] = Session.session_string_arrList.get(i);
//                row[4] = Session.session_string_arrList.get(i);
//                row[5] = Session.session_string_arrList.get(i);
//                row[6] = Session.session_string_arrList.get(i);
//                row[7] = Session.session_string_arrList.get(i);
//                row[8] = Session.session_string_arrList.get(i);
//                
//                model.addRow(row);
//        }
    }

    public void getData() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        String URL = "jdbc:derby:unidb;create=true";

        con = DriverManager.getConnection(URL);

       //Array list
       String lecturers, tag, subject_name, subject_code, student_group_id,duration, number_of_students;
       ArrayList<String> GroupList = new ArrayList<String>(7);
       ArrayList<String> LecturerList = new ArrayList<String>(7);
       ArrayList<String> StudentList = new ArrayList<String>(7);
       ArrayList<String> TagsList = new ArrayList<String>(7);
       ArrayList<String> TotalData = new ArrayList<String>(7);
        try {
            String lecturerQuery = "SELECT lecturer_fname, lecturer_lname FROM lecturer";
            String tagsQuery = "SELECT tag FROM tags";
            String studentsQuery = "SELECT groupId FROM students";
            String subjectsQuery = "SELECT subject_name FROM subject";

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM lecturer");
            while (rs.next()) {
                System.out.println(rs.getString("lecturer_fname"));
                LecturerList.add(rs.getString("lecturer_fname") + rs.getString("lecturer_lname"));
            }
//            ResultSet rsl = statement.executeQuery(lecturerQuery);
//            while(rs1.next()){
//               LecturerList.add(rs1.getString("lecturer_fname")+rs1.getString("lecturer_lname"));
//            }
//            
            ResultSet rst = statement.executeQuery(tagsQuery);
            while (rst.next()) {
                TagsList.add(rst.getString("tag"));
            }
//            
            ResultSet rs_subj = statement.executeQuery(subjectsQuery);
            while (rs_subj.next()) {
                StudentList.add(rs_subj.getString("groupId"));
            }
//           
//            
            ResultSet rs_stud = statement.executeQuery(studentsQuery);
            while (rs_stud.next()) {
                GroupList.add(rs_stud.getString("subject_name"));
            }

        } catch (SQLException e) {
            System.err.println("Exception in lecturer_name_ComboBox : AddSessions");
            Logger.getLogger(AddLecturer.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println(LecturerList.toString());
        for (int i = 0; i < 2; i++) {
            TotalData.add((LecturerList.get(i) + TagsList.get(i)).toString());
        }
    }

    private void printbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printbtnActionPerformed
        try {
            // TODO add your handling code here:
            session_table.print();
        } catch (PrinterException ex) {
            Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Timetable_dashboard wnd_timetableDash = new Timetable_dashboard();
        wnd_timetableDash.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeLecturers wnd_homelecturer = new HomeLecturers();
        wnd_homelecturer.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeSubjects wnd_homesubjects = new HomeSubjects();
        wnd_homesubjects.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nav_WorkingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nav_WorkingHoursActionPerformed
        try {
            try {
                // TODO add your handling code here:
                new Working().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Working.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Working.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();

        //        new View_working().setVisible(true);
        //        this.setVisible(false);
        //        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        //        this.dispose();

    }//GEN-LAST:event_nav_WorkingHoursActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        HomeSessions wnd_homeSessions = new HomeSessions();
        wnd_homeSessions.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            new Loc_add().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Stu_statics().setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(timetable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new timetable().setVisible(true);
                } catch (PrinterException ex) {
                    Logger.getLogger(timetable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KButton kButton3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JButton nav_WorkingHours;
    private javax.swing.JButton printbtn;
    private javax.swing.JTable session_table;
    // End of variables declaration//GEN-END:variables
}
