/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

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
public class ViewController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        //String uri = request.getAttribute("javax.servlet.forward.request_uri").toString();
        request.setAttribute("error", "");
        request.setAttribute("firstname", "");
        request.setAttribute("lastname", "");
        request.setAttribute("username", "");
        request.setAttribute("message", "");
        request.setAttribute("name", "");
        request.setAttribute("description", "");
        request.setAttribute("quantity", "");
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        switch (uri) {
            case "/Login": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/login.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Register": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/register.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Logout": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/logout.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/Logout": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/logout.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/Logout": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/logout.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/Logout": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/logout.jsp");
                rd.forward(request, response);
                break;
            }
            
            
            case "/DoctorRatings": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/DoctorRatings.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/RateDoctor": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/RateDoctor.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/RequestAppointment": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/RequestAppointment.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/History": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/History.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/Appointments": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/Appointments.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/Prescriptions": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/Prescriptions.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/Terminate": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/Terminate.jsp");
                rd.forward(request, response);
                break;
            }
            
            case "/Admin": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/index.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/Login": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/login.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/Register": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/register.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/Doctors": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/Doctors.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/Secretaries": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/Secretaries.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/DoctorRatings": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/DoctorRatings.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/AddNew": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/AddNew.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/GiveFeedBack": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/GiveFeedback.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/DoctorFeedbacks": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/DoctorFeedbacks.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Admin/ConfirmDelete": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/AdminViews/ConFirmDelete.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/index.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/Login": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/login.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/ViewAppointments": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/Appointments.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/ViewPrescriptions": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/Prescriptions.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/Medicine": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/Medicine.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/CreateMedicine": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/CreateMedicine.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/Prescribe": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/Prescribe.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Doctor/PatientHistory": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/DoctorViews/PatientHistory.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/index.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/Login": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/login.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/ApproveAccounts": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/ApproveAccounts.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/ViewAppointmentRequests": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/ViewAppointmentRequests.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/Medicine": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/Medicine.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/CreateAppointment": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/CreateAppointment.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/GiveMedicine": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/GiveMedicine.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/OrderMedicine": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/OrderMedicine.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/RemovePatients": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/RemovePatients.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/TerminateRequests": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/TerminateRequests.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/TerminatePatient": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/TerminatePatient.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Secretary/RemovePatient": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/SecretaryViews/RemovePatient.jsp");
                rd.forward(request, response);
                break;
            }
            case "/Patient": {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/index.jsp");
                rd.forward(request, response);
                break;
            }
            default: {
                RequestDispatcher rd = request.getRequestDispatcher(
                        "/WEB-INF/PatientViews/index.jsp");
                rd.forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
