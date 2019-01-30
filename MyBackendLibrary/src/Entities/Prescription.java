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
public class Prescription {
    private String user;
    private String doctor;
    private String date;
    private String medicine;
    private String quantity;
    private String dose;
    private String notes;

    public Prescription() {
    }

    public Prescription(String user, String doctor, String date, String medicine, String quantity, String dose, String notes) {
        this.user = user;
        this.doctor = doctor;
        this.date = date;
        this.medicine = medicine;
        this.quantity = quantity;
        this.dose = dose;
        this.notes = notes;
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

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Prescription{" + "user=" + user + ", doctor=" + doctor + ", date=" + date + ", medicine=" + medicine + ", quantity=" + quantity + ", dose=" + dose + ", notes=" + notes + '}';
    }

}
