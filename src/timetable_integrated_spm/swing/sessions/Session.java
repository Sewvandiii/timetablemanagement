/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.swing.sessions;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jayagoda N.M.  -  IT17184304
 */
public class Session {
    static ArrayList<String> lecturers_arrl;
    public static ArrayList<String> session_string_arr = new ArrayList<String>(); 
    String lecturers, tag, subject_name, subject_code, student_group_id;
    int duration, number_of_students;
    

    public Session(String lecturers, String tag, String subject_name, String subject_code, String student_group_id, int duration, int number_of_students) {
        this.lecturers = lecturers;
        this.tag = tag;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.student_group_id = student_group_id;
        this.duration = duration;
        this.number_of_students = number_of_students;
        
    }
    
  

    public String getLecturers() {
        return lecturers;
    }

    public void setLecturers(String lecturers) {
        this.lecturers = lecturers;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getStudent_group_id() {
        return student_group_id;
    }

    public void setStudent_group_id(String student_group_id) {
        this.student_group_id = student_group_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(int number_of_students) {
        this.number_of_students = number_of_students;
    }
    
}
