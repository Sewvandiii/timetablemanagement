/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable_integrated_spm.swing.Subject;

/**
 *
 * @author  Jayagoda N.M.  -  IT17184304
 */
public class Subject {
    
    private String subject_code, subject_name, offered_year_and_semester;
    private int numberOfLectureHours, numberOfTutorialHours, numberOfLabHours, numberOfEvaluationHours;

    public Subject(String subject_code, String subject_name, String offered_year_and_semester, int numberOfLectureHours, int numberOfTutorialHours, int numberOfLabHours, int numberOfEvaluationHours) {
        this.subject_code = subject_code;
        this.subject_name = subject_name;
        this.offered_year_and_semester = offered_year_and_semester;
        this.numberOfLectureHours = numberOfLectureHours;
        this.numberOfTutorialHours = numberOfTutorialHours;
        this.numberOfLabHours = numberOfLabHours;
        this.numberOfEvaluationHours = numberOfEvaluationHours;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getOffered_year_and_semester() {
        return offered_year_and_semester;
    }

    public void setOffered_year_and_semester(String offered_year_and_semester) {
        this.offered_year_and_semester = offered_year_and_semester;
    }

    public int getNumberOfLectureHours() {
        return numberOfLectureHours;
    }

    public void setNumberOfLectureHours(int numberOfLectureHours) {
        this.numberOfLectureHours = numberOfLectureHours;
    }

    public int getNumberOfTutorialHours() {
        return numberOfTutorialHours;
    }

    public void setNumberOfTutorialHours(int numberOfTutorialHours) {
        this.numberOfTutorialHours = numberOfTutorialHours;
    }

    public int getNumberOfLabHours() {
        return numberOfLabHours;
    }

    public void setNumberOfLabHours(int numberOfLabHours) {
        this.numberOfLabHours = numberOfLabHours;
    }

    public int getNumberOfEvaluationHours() {
        return numberOfEvaluationHours;
    }

    public void setNumberOfEvaluationHours(int numberOfEvaluationHours) {
        this.numberOfEvaluationHours = numberOfEvaluationHours;
    }
    
}
