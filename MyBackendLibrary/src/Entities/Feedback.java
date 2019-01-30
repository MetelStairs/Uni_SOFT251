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
public class Feedback {
    
    private String doctor;
    private String feedback;

    public Feedback() {
    }

    public Feedback(String doctor, String feedback) {
        this.doctor = doctor;
        this.feedback = feedback;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "FeedBack{" + "doctor=" + doctor + ", feedback=" + feedback + '}';
    }
    
}
