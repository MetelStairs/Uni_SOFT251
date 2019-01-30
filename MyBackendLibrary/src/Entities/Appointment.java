/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Elis Roberts
 */
public class Appointment {
    private String user;
    private String doctor;
    private String date;
    private String created;
    private String attended;

    public Appointment() {
    }

    public Appointment(String user, String doctor, String date, String created, String attended) {
        this.user = user;
        this.doctor = doctor;
        this.date = date;
        this.created = created;
        this.attended = attended;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getAttended() {
        return attended;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    @Override
    public String toString() {
        return "Appointment{" + "user=" + user + ", doctor=" + doctor + ", date=" + date + ", created=" + created + ", attended=" + attended + '}';
    }

}
