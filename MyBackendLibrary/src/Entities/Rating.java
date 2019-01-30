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
public class Rating {
    
    private int rate;
    private String message;
    private String user;
    private String doctor;

    public Rating() {
    }

    public Rating(int rate, String message, String user, String doctor) {
        this.rate = rate;
        this.message = message;
        this.user = user;
        this.doctor = doctor;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public String toString() {
        return "Rating{" + "rate=" + rate + ", message=" + message + ", user=" + user + ", doctor=" + doctor + '}';
    }
        
}
