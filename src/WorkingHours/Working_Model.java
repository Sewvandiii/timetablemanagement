/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkingHours;

/**
 *
 * @author Sewwandi
 */
public class Working_Model {
    
    private int id;
    private String noWorkingHours;
    private String wokingDays;
    private String workingTime;
    private String timeSlot;
    
     public Working_Model(String noWorkingHours, String wokingDays, String workingTime, String timeSlot, int id) {
        this.id = id;
        this.noWorkingHours = noWorkingHours;
        this.wokingDays = wokingDays;
        this.workingTime = workingTime;
        this.timeSlot = timeSlot;
    }

     public int getId(){
         return id;
     }
     
    /**
     * @return the noWorkingHours
     */
    public String getNoWorkingHours() {
        return noWorkingHours;
    }

    /**
     * @param noWorkingHours the noWorkingHours to set
     */
    public void setNoWorkingHours(String noWorkingHours) {
        this.noWorkingHours = noWorkingHours;
    }

    /**
     * @return the wokingDays
     */
    public String getWokingDays() {
        return wokingDays;
    }

    /**
     * @param wokingDays the wokingDays to set
     */
    public void setWokingDays(String wokingDays) {
        this.wokingDays = wokingDays;
    }

    /**
     * @return the workingTime
     */
    public String getWorkingTime() {
        return workingTime;
    }

    /**
     * @param workingTime the workingTime to set
     */
    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    /**
     * @return the timeSlot
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
    
}
