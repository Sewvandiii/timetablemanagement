/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

/**
 *
 * @author acer
 */
public class RoomModel {
    
    private int id;
    private String tag;
    private String subject;
    private String lecturer;
    private String group;
    private String sessionStart;
    private String sessionEnd;
    private String room;
    private String sessionDate;

    public RoomModel(int id, String tag, String subject, String lecturer, String group, String sessionStart, String sessionEnd, String room, String sessionDate) {
        this.id = id;
        this.tag = tag;
        this.subject = subject;
        this.lecturer = lecturer;
        this.group = group;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
        this.room = room;
        this.sessionDate = sessionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(String sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(String sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }
    
    
    
}
