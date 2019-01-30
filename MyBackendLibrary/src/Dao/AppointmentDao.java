/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entities.Appointment;
import java.util.List;

/**
 *
 * @author Elis Roberts
 */
public interface AppointmentDao {
    public List<Appointment> getAppointments();
    public boolean saveAppointment(Appointment appointment);
    public boolean createAppointment(String user, String date, String doctor);
    public boolean attendAppointment(String user, String date, String doctor);
    public boolean deletAppointment(String user, String doctor);
}
