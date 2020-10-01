/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.swing.lecturerDetails;

/**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
class Lecturer {
    private String lecturer_fname, lecturer_lname, empId, faculty, department, center, building;
    private int academicRank;

    public Lecturer( String lecturer_fname, String lecturer_lname, String empId, String faculty, String department, String center, 
            String building, int rank ) {
        this.lecturer_fname = lecturer_fname;
        this.lecturer_lname = lecturer_lname;
        this.empId = empId;
        this.faculty = faculty;
        this.department = department;
        this.center = center;
        this.building = building;
        this.academicRank = rank;
    }

    public String getLecturer_fname() {
        return lecturer_fname;
    }

    public void setLecturer_fname(String lecturer_fname) {
        this.lecturer_fname = lecturer_fname;
    }

    public String getLecturer_lname() {
        return lecturer_lname;
    }

    public void setLecturer_lname(String lecturer_lname) {
        this.lecturer_lname = lecturer_lname;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(int academicRank) {
        this.academicRank = academicRank;
    }
}
