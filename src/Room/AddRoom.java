/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

import Location.Loc_add;
import Location.Location_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import timetablemanagement.*;
import util.dbConnect;

/**
 *
 * @author Thili
 */
public class AddRoom extends javax.swing.JFrame {

    /**
     * Creates new form Rooms
     */
    private Connection con;

    public AddRoom() throws ClassNotFoundException, SQLException {
        initComponents();
        this.setLocationRelativeTo(null);

        dbConnect dbc = dbConnect.getDatabaseConnection();
        con = dbc.getConnection();

    }

    public void getSessionDetails(String day, String start, String end) {

//        String query = "select lecture_name,subject,student_group from sessiontable where session_day = '" + day + "' and session_start = '" + start + "' and session_end = '" + end + "'";
        String query1 = "select PARALLELSESSIONDETAILSID from PARALLELSESSIONDETAILS where startingtime ='" + start + "' and endtime ='" + end + "' and day='" + day + "'";

//        JOptionPane.showMessageDialog(null, query);
        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs1 = st.executeQuery(query1);
            if (rs1.first()) {
//                JOptionPane.showMessageDialog(null, rs1.getInt("PARALLELSESSIONDETAILSID"));
                String query2 = "select SESSIONID from PARALLELSESSIONS where PARALLELSESSIONID =" + rs1.getInt("PARALLELSESSIONDETAILSID");

                ResultSet rs2 = st.executeQuery(query2);
                if (rs2.first()) {
                    String query3 = "select lecture_name,subject,student_group,tag from sessiontable where id=" + rs2.getInt("SESSIONID");
                    ResultSet rs3 = st.executeQuery(query3);
                    if (rs3.first()) {
                        combo_group.setSelectedItem(rs3.getString("student_group"));
                        combo_lecturer.setSelectedItem(rs3.getString("lecture_name"));
                        combo_tag.setSelectedItem(rs3.getString("tag"));
                        txt_module.setText(rs3.getString("subject"));
                    } else {
                        System.out.println("There are no rows in SESSIONTABLE table.");
                    }
                } else {
                    System.out.println("There are no rows in PARALLELSESSIONS table.");
                }

            } else {
                System.out.println("There are no rows in PARALLELSESSIONDETAILS table.");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getRoom(int index) {

        combo_room_tag.removeAllItems();
        combo_room_subject.removeAllItems();

        String tag = "";
        switch (index) {
            case 1:
                tag = "Lecture";
                break;
            case 2:
                tag = "Lab";
                break;
            case 3:
                tag = "Lecture";
                break;
            case 4:
                tag = "Evaluation";
                break;
            default:
                tag = "";
                break;
        }

        String query = "select room from locationtable where room_type = '" + tag + "'";

        Statement st;
        ResultSet rs;

        if (txt_module.getText().contains("Game Development")) {
            query = "select room from locationtable where room = 'IM'";
        }

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                combo_room_tag.addItem(rs.getString("room"));
                combo_room_subject.addItem(rs.getString("room"));
                combo_room_group.addItem(rs.getString("room"));
                combo_room_lecturer.addItem(rs.getString("room"));
                combo_room_session.addItem(rs.getString("room"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void setRoom() {

        if (combo_tag.getSelectedItem() == combo_tag_session.getSelectedItem() && combo_tag.getSelectedItem() == combo_tag_subject.getSelectedItem()) {

            try {
                // TODO add your handling code here:

                if (combo_tag.getSelectedIndex() == 0 || combo_room_tag.getSelectedItem() == "") {
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields.");

                } else {

                    String tag = combo_tag.getSelectedItem().toString();
                    String subject = txt_module.getText();
                    String lecturer = combo_lecturer.getSelectedItem().toString();
                    String group = combo_group.getSelectedItem().toString();
                    String session_start = txt_session_start.getText();
                    String session_end = txt_session_end.getText();
                    String room = combo_room_tag.getSelectedItem().toString();
                    String session_date = combo_session_date.getSelectedItem().toString();
                    String status = " ";

                    String query_session = "select session_start,session_end,session_date from roomtable where session_start='" + session_start + "' and session_end='" + session_end + "' and session_date='" + session_date + "'and room='"+room+"'";
                    Statement st_session = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ResultSet rs1 = st_session.executeQuery(query_session);
                    if (rs1.first()) {
                        JOptionPane.showMessageDialog(null, "this session is already creadted.");
                        
                    } else {
                        String query = "insert into roomtable(tag, subject, lecturer, group_, session_start, session_end, status, room, session_date) values ('" + tag + "','" + subject + "','" + lecturer + "','" + group + "','" + session_start + "','" + session_end + "','" + status + "','" + room + "','" + session_date + "')";
//                        JOptionPane.showMessageDialog(null, query);

                        Statement st = con.createStatement();
    //                  PreparedStatement st = con.prepareStatement(query);
    //                  st.setString(1, tag);
    //                  st.setString(2, subject);
    //                  st.setString(3, lecturer);
    //                  st.setString(4, group);
    //                  st.setString(5, session_start);
    //                  st.setString(6, session_end);
    //                  st.setString(7, status);
    //                  st.setString(8, room);
    //                  st.setString(9, session_date);

                        if ((st.executeUpdate(query)) == 1) {
                            JOptionPane.showMessageDialog(null, "New Room Succefully Added.");
                        } else {
                            JOptionPane.showMessageDialog(null, "New Room Adding Failed");
                        }

                    }

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "New Room Adding Failed");
                Logger.getLogger(Loc_add.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please Fill All Fields.");
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
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        kButton3 = new keeptoo.KButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        combo_tag = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        combo_room_tag = new javax.swing.JComboBox<>();
        btn_tag_next = new keeptoo.KButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_module = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        combo_tag_subject = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        combo_room_subject = new javax.swing.JComboBox<>();
        btn_subject_next = new keeptoo.KButton();
        btn_lecturer_next2 = new keeptoo.KButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btn_lecturer_next = new keeptoo.KButton();
        jLabel33 = new javax.swing.JLabel();
        combo_room_lecturer = new javax.swing.JComboBox<>();
        combo_lecturer = new javax.swing.JComboBox<>();
        btn_lecturer_next5 = new keeptoo.KButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        combo_room_group = new javax.swing.JComboBox<>();
        combo_group = new javax.swing.JComboBox<>();
        btn_group_next = new keeptoo.KButton();
        btn_lecturer_next3 = new keeptoo.KButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        combo_tag_session = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        combo_room_session = new javax.swing.JComboBox<>();
        combo_session_date = new javax.swing.JComboBox<>();
        btn_lecturer_next4 = new keeptoo.KButton();
        txt_session_end = new javax.swing.JTextField();
        txt_session_start = new javax.swing.JTextField();
        btn_add_room = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel2.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cheburashka-70.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("ADD rooms");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 617, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1030, 89));

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DASHBOARD");
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 170, 50));

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/icons8-timetable-30.png"))); // NOI18N
        jButton1.setText("  Timetables");
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 700, 250, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-menu-30.png"))); // NOI18N
        kGradientPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-lecturer-30_1.png"))); // NOI18N
        jButton2.setText("   Lecturers");
        jButton2.setBackground(new java.awt.Color(204, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 250, 60));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-student-male-30_1.png"))); // NOI18N
        jButton3.setText("  Students");
        jButton3.setBackground(new java.awt.Color(151, 51, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-book-30.png"))); // NOI18N
        jButton4.setText("  Subjects");
        jButton4.setBackground(new java.awt.Color(153, 0, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 250, 60));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-location-30.png"))); // NOI18N
        jButton5.setText("  Location");
        jButton5.setBackground(new java.awt.Color(153, 0, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 250, 60));

        jButton6.setBackground(new java.awt.Color(102, 0, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-clock-settings-30.png"))); // NOI18N
        jButton6.setText("Working hours");
        kGradientPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 250, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        kGradientPanel3.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel3.setkStartColor(new java.awt.Color(204, 204, 204));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-cheburashka-70.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 102));
        jLabel3.setText("Location");

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Building Name");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Room Number");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Room Type");

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
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE))))
                .addGap(105, 105, 105))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new_icons/icons8-room-30.png"))); // NOI18N
        jButton7.setText("   Rooms");
        jButton7.setBackground(new java.awt.Color(51, 0, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 250, 60));

        jButton8.setBackground(new java.awt.Color(51, 0, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-graph-30.png"))); // NOI18N
        jButton8.setText("   Statics");
        kGradientPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 250, 60));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 800));

        jTabbedPane1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jTabbedPane1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTabbedPane1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tag Type");

        combo_tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag", "Lecture", "Lab", "Tutorial", "Evaluation" }));
        combo_tag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tagItemStateChanged(evt);
            }
        });
        combo_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tagActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Allocated Room");

        combo_room_tag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Room" }));
        combo_room_tag.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_room_tagItemStateChanged(evt);
            }
        });
        combo_room_tag.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_room_tagFocusGained(evt);
            }
        });
        combo_room_tag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_room_tagMouseClicked(evt);
            }
        });
        combo_room_tag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_room_tagActionPerformed(evt);
            }
        });

        btn_tag_next.setText("Next");
        btn_tag_next.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_tag_next.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_tag_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tag_nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_tag, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE)
                    .addComponent(combo_room_tag, 0, 297, Short.MAX_VALUE))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tag_next, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(btn_tag_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TAG", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Tag Type");

        txt_module.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moduleActionPerformed(evt);
            }
        });
        txt_module.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_moduleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_moduleKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Module Name");

        combo_tag_subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag", "Lecture", "Lab", "Tutorial", "Evaluation" }));
        combo_tag_subject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tag_subjectItemStateChanged(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Allocated Room");

        combo_room_subject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Room" }));
        combo_room_subject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_room_subjectItemStateChanged(evt);
            }
        });
        combo_room_subject.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_room_subjectFocusGained(evt);
            }
        });

        btn_subject_next.setText("Next");
        btn_subject_next.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_subject_next.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_subject_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_subject_nextActionPerformed(evt);
            }
        });

        btn_lecturer_next2.setText("Previous");
        btn_lecturer_next2.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_lecturer_next2.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_lecturer_next2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturer_next2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_module, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_tag_subject, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE)
                    .addComponent(combo_room_subject, 0, 297, Short.MAX_VALUE))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lecturer_next2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_subject_next, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tag_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_module, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_subject_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lecturer_next2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("SUBJECT", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Lecturer");

        btn_lecturer_next.setText("Next");
        btn_lecturer_next.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_lecturer_next.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_lecturer_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturer_nextActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Allocated Room");

        combo_room_lecturer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Room" }));

        combo_lecturer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Lecturer", "Thilini", "Pasan", "Kushnara" }));

        btn_lecturer_next5.setText("Previous");
        btn_lecturer_next5.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_lecturer_next5.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_lecturer_next5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturer_next5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lecturer_next5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_lecturer_next, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_lecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_lecturer_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lecturer_next5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("LECTURER", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("Group ID");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setText("Allocated Room");

        combo_room_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Room" }));

        combo_group.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Group", "Y3S2.8", "Y3S2.9", "Y3S2.10", "Y3S2.11", "Y3S2.12" }));

        btn_group_next.setText("Next");
        btn_group_next.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_group_next.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_group_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_group_nextActionPerformed(evt);
            }
        });

        btn_lecturer_next3.setText("Previous");
        btn_lecturer_next3.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_lecturer_next3.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_lecturer_next3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturer_next3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_room_group, 0, 297, Short.MAX_VALUE)
                    .addComponent(combo_group, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lecturer_next3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_group_next, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_group, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_group, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_group_next, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lecturer_next3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("GROUP", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 153)));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setText("Tag Type");

        combo_tag_session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Tag", "Lecture", "Lab", "Tutorial", "Evaluation" }));
        combo_tag_session.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tag_sessionItemStateChanged(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("Session");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("Session Start");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("Session End");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("Allocated Room");

        combo_room_session.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Relevent Room" }));

        combo_session_date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Day", "Monday", "Tuestday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        combo_session_date.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_session_dateItemStateChanged(evt);
            }
        });

        btn_lecturer_next4.setText("Previous");
        btn_lecturer_next4.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_lecturer_next4.setkEndColor(new java.awt.Color(51, 0, 153));
        btn_lecturer_next4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lecturer_next4ActionPerformed(evt);
            }
        });

        txt_session_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_session_endActionPerformed(evt);
            }
        });

        txt_session_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_session_startActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_lecturer_next4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_tag_session, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE)
                                    .addComponent(combo_room_session, 0, 297, Short.MAX_VALUE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_session_date, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_session_end, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_session_start, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jSeparator5))
                        .addGap(105, 105, 105))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tag_session, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_room_session, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_session_start))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_session_end))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_session_date, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btn_lecturer_next4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("SESSION", jPanel8);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 770, 440));

        btn_add_room.setText("ADD");
        btn_add_room.setFont(new java.awt.Font("Algerian", 1, 18)); // NOI18N
        btn_add_room.setkEndColor(new java.awt.Color(51, 51, 255));
        btn_add_room.setkStartColor(new java.awt.Color(255, 0, 255));
        btn_add_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_roomActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 550, 760, 53));

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

    private void combo_tag_sessionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tag_sessionItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tag_sessionItemStateChanged

    private void btn_lecturer_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturer_nextActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btn_lecturer_nextActionPerformed

    private void combo_tag_subjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tag_subjectItemStateChanged
        // TODO add your handling code here:
        getRoom(combo_tag_subject.getSelectedIndex());
    }//GEN-LAST:event_combo_tag_subjectItemStateChanged

    private void txt_moduleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moduleKeyReleased
        // TODO add your handling code here:
        getRoom(combo_tag_subject.getSelectedIndex());
    }//GEN-LAST:event_txt_moduleKeyReleased

    private void txt_moduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moduleActionPerformed

    private void combo_tagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tagItemStateChanged
        // TODO add your handling code here:
        getRoom(combo_tag.getSelectedIndex());
    }//GEN-LAST:event_combo_tagItemStateChanged

    private void btn_add_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_roomActionPerformed
        // TODO add your handling code here:
        setRoom();

    }//GEN-LAST:event_btn_add_roomActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void combo_room_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_room_tagActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_room_tagActionPerformed

    private void combo_tagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tagActionPerformed

    private void btn_tag_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tag_nextActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_tag_nextActionPerformed

    private void btn_subject_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subject_nextActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btn_subject_nextActionPerformed

    private void btn_group_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_group_nextActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btn_group_nextActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jTabbedPane1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_jTabbedPane1AncestorAdded

    private void jTabbedPane1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTabbedPane1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1AncestorMoved

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here: 
        combo_room_lecturer.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_subject.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_session.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_group.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_tag_subject.setSelectedItem(combo_tag.getSelectedItem().toString());
        combo_tag_session.setSelectedItem(combo_tag.getSelectedItem().toString());
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void combo_room_subjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_room_subjectItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_room_subjectItemStateChanged

    private void combo_room_subjectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_room_subjectFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_room_subjectFocusGained

    private void combo_room_tagItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_room_tagItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_room_tagItemStateChanged

    private void combo_room_tagFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_room_tagFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_room_tagFocusGained

    private void txt_moduleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moduleKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_moduleKeyTyped

    private void btn_lecturer_next2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturer_next2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btn_lecturer_next2ActionPerformed

    private void btn_lecturer_next3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturer_next3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btn_lecturer_next3ActionPerformed

    private void btn_lecturer_next4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturer_next4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btn_lecturer_next4ActionPerformed

    private void btn_lecturer_next5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lecturer_next5ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_lecturer_next5ActionPerformed

    private void combo_room_tagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_room_tagMouseClicked
        // TODO add your handling code here:
        combo_room_lecturer.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_subject.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_session.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_room_group.setSelectedItem(combo_room_tag.getSelectedItem().toString());
        combo_tag_subject.setSelectedItem(combo_tag.getSelectedItem().toString());
        combo_tag_session.setSelectedItem(combo_tag.getSelectedItem().toString());
    }//GEN-LAST:event_combo_room_tagMouseClicked

    private void combo_session_dateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_session_dateItemStateChanged
        // TODO add your handling code here:
        if (txt_session_start.getText().toString().isEmpty() && txt_session_end.getText().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please first session start and end time must be filled.");
        } else {
            getSessionDetails(combo_session_date.getSelectedItem().toString(), txt_session_start.getText().toString(), txt_session_end.getText().toString());
        }


    }//GEN-LAST:event_combo_session_dateItemStateChanged

    private void txt_session_startInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_session_startInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_startInputMethodTextChanged

    private void txt_session_endInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_session_endInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_endInputMethodTextChanged

    private void txt_session_startMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_session_startMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_startMouseReleased

    private void txt_session_endMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_session_endMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_endMouseReleased

    private void txt_session_startPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_session_startPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_startPropertyChange

    private void txt_session_startFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_session_startFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_startFocusGained

    private void txt_session_startKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_session_startKeyReleased
        // TODO add your handling code here
    }//GEN-LAST:event_txt_session_startKeyReleased

    private void txt_session_endFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_session_endFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_endFocusGained

    private void txt_session_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_session_startMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_session_startMouseExited

    private void txt_session_startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_session_startMouseClicked
        // TODO add your handling code here:
        getSessionDetails(combo_session_date.getSelectedItem().toString(), txt_session_start.getText().toString(), txt_session_end.getText().toString());
    }//GEN-LAST:event_txt_session_startMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            // TODO add your handling code here:
            new Rooms().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txt_session_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_session_endActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_endActionPerformed

    private void txt_session_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_session_startActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_session_startActionPerformed

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
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddRoom().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddRoom.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btn_add_room;
    private keeptoo.KButton btn_group_next;
    private keeptoo.KButton btn_lecturer_next;
    private keeptoo.KButton btn_lecturer_next2;
    private keeptoo.KButton btn_lecturer_next3;
    private keeptoo.KButton btn_lecturer_next4;
    private keeptoo.KButton btn_lecturer_next5;
    private keeptoo.KButton btn_subject_next;
    private keeptoo.KButton btn_tag_next;
    private javax.swing.JComboBox<String> combo_group;
    private javax.swing.JComboBox<String> combo_lecturer;
    private javax.swing.JComboBox<String> combo_room_group;
    private javax.swing.JComboBox<String> combo_room_lecturer;
    private javax.swing.JComboBox<String> combo_room_session;
    private javax.swing.JComboBox<String> combo_room_subject;
    private javax.swing.JComboBox<String> combo_room_tag;
    private javax.swing.JComboBox<String> combo_session_date;
    private javax.swing.JComboBox<String> combo_tag;
    private javax.swing.JComboBox<String> combo_tag_session;
    private javax.swing.JComboBox<String> combo_tag_subject;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private keeptoo.KButton kButton3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private javax.swing.JTextField txt_module;
    private javax.swing.JTextField txt_session_end;
    private javax.swing.JTextField txt_session_start;
    // End of variables declaration//GEN-END:variables
}
