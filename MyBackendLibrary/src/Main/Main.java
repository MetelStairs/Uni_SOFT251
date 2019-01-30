/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Entities.Feedback;
import Entities.Medicine;
import Model.FeedbackModel;
import Model.MedicineModel;

/**
 *
 * @author Elis Roberts
 */
public class Main {

    public static void main(String[] args) {
        /*====================================================================================================
         Test UserModel
         */
        /*User admin = new User("Eric", "Murithi", "eric", "eric", "admin");
         User doctor = new User("Virginia", "Wangui", "virginia", "virginia", "doctor");
         User sec = new User("Bessy", "Mwendwa", "bessy", "bessy", "secretary");
         User pat = new User("Eric", "Murithi", "ericpat", "ericpat", "patient");
    
         UserModel um = new UserModel();
    
         System.out.println(um.deleteUser("ericpat"));
         //um.approveUser("ericpat", "bessy");*/
        /*
         End Test UserModel
         ====================================================================================================*/

        /*====================================================================================================
         Test RatingModel
         */
        /*RatingModel rm = new RatingModel();
         System.out.println("Ratings list \n"+rm.getRatings());
         Rating r = new Rating(1, "He did not do well", "eric", "doc eric");
         rm.saveRating(r);
         System.out.println("Ratings list \n"+rm.getRatings());
         rm.deletRating("eric", "doc eric");
         System.out.println("Ratings list \n"+rm.getRatings());
         rm.saveRating(r);
         System.out.println("Ratings list \n"+rm.getRatings()); */
        /*
         End Test RatingModel
         ====================================================================================================*/
        /*====================================================================================================
         Test AppointmentModel
         */
        /*AppointmentModel am = new AppointmentModel();
         System.out.println("Ratings list \n"+am.getAppointments());
         Appointment a = new Appointment("eric", "doc eric", "2019-01-16 13:00:00", "N");
         am.saveAppointment(a);
         System.out.println("Ratings list \n"+am.getAppointments());
         am.createAppointment("eric", "doc eric");
         System.out.println("Ratings list \n"+am.getAppointments());
         am.deletAppointment("eric", "doc eric");
         System.out.println("Ratings list \n"+am.getAppointments());
         am.saveAppointment(a);
         System.out.println("Ratings list \n"+am.getAppointments());*/
        /*
         End Test AppointmentModel
         ====================================================================================================*/
        /*====================================================================================================
         Test PrescriptionModel
         */
        /* PrescriptionModel pm = new PrescriptionModel();
         System.out.println("Ratings list \n"+pm.getPrescriptions());
         Prescription p = new Prescription("eric", "doc eric", "2019-01-16 13:00:00", "N");
         pm.savePrescription(p);
         System.out.println("Ratings list \n"+pm.getPrescriptions());
         pm.deletPrescription("eric", "doc eric");
         System.out.println("Ratings list \n"+pm.getPrescriptions());
         pm.savePrescription(p);
         System.out.println("Ratings list \n"+pm.getPrescriptions());
         */
        /*
         End Test PrescriptionModel
         ====================================================================================================*/
        /*====================================================================================================
         Test FeedbackModel
         */
        FeedbackModel fm = new FeedbackModel();
        System.out.println("Feedback List \n" + fm.getFeedBack());
        Feedback f = new Feedback("eric", "I was about to fire you");
        fm.saveFeedBack(f);
        System.out.println("Feedback List \n" + fm.getFeedBack());
        /*
         End Test FeedbackModel
         ====================================================================================================*/

        /*====================================================================================================
         Test FeedbackModel
         */
        MedicineModel mm = new MedicineModel();
        System.out.println("medicine List \n" + mm.getMedicines());
        Medicine  m= new Medicine(1, "eric", "j", "I was about to fire you");
        mm.stockMedicine(m);
        System.out.println("medicine List \n" + mm.getMedicines());
        /*
         End Test FeedbackModel
         ====================================================================================================*/

    }
}
