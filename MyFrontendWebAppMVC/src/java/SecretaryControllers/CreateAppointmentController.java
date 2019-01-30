/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryControllers;

import Entities.User;
import Model.AppointmentModel;
import Model.UserModel;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elis Roberts
 */
public class CreateAppointmentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String patient = request.getParameter("patient");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");

        String path = request.getServletContext().getRealPath("");
        AppointmentModel am = new AppointmentModel(path + File.separator + "DATAFILE");

       am.createAppointment(patient, date, doctor);
        
        response.sendRedirect(request.getContextPath() + "/Secretary/ViewAppointmentRequests");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
