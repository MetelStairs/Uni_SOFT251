/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientControllers;

import Entities.Appointment;
import Entities.Rating;
import Entities.User;
import Model.AppointmentModel;
import Model.RatingModel;
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
public class BookAppointmentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String path = request.getServletContext().getRealPath("");
        AppointmentModel am = new AppointmentModel(path + File.separator + "DATAFILE");

        User loggedInUser = (User) request.getSession().getAttribute("patient");
        String date = request.getParameter("date");
        Appointment p = new Appointment(loggedInUser.getUsername(), "", date, "", "");
        
        am.saveAppointment(p);
        
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Appointments"));
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
