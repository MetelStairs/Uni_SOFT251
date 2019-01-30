/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorControllers;

import Entities.Appointment;
import Entities.Medicine;
import Entities.Prescription;
import Entities.User;
import Model.AppointmentModel;
import Model.MedicineModel;
import Model.PrescriptionModel;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elis Roberts
 */
public class PrescribePatientController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        User loggedInUser = (User) request.getSession().getAttribute("doctor");
        String doctor = loggedInUser.getUsername();
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String medicine = request.getParameter("medicine");
        String quantity = request.getParameter("quantity");
        String dose = request.getParameter("dose");
        String notes = request.getParameter("notes");

        String path = request.getServletContext().getRealPath("");

        PrescriptionModel pm = new PrescriptionModel(path + File.separator + "DATAFILE");
        
        Prescription  p = new Prescription(name, doctor, date, medicine, quantity, dose, notes);
        
        pm.savePrescription(p);
        MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
        Medicine m  = new Medicine();
        m.setName(name);
        m.setQuanity(-Integer.parseInt(quantity));
        mm.updateMedicine(m);
        
        AppointmentModel am = new AppointmentModel(path + File.separator + "DATAFILE");
        Appointment a = new Appointment();
        am.attendAppointment(name, date, doctor);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Doctor/ViewPrescriptions"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
