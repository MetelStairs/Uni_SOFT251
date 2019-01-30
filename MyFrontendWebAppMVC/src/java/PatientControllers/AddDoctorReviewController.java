/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientControllers;

import Entities.Feedback;
import Entities.Rating;
import Entities.User;
import Model.FeedbackModel;
import Model.RatingModel;
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
public class AddDoctorReviewController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String path = request.getServletContext().getRealPath("");
        RatingModel rm = new RatingModel(path + File.separator + "DATAFILE");

        int rate = Integer.parseInt(request.getParameter("rate"));
        User loggedInUser = (User) request.getSession().getAttribute("patient");
        String doctor = request.getParameter("doctor");
        String message = request.getParameter("message");
        Rating r = new Rating(rate, message, loggedInUser.getUsername(), doctor);
        
        rm.saveRating(r);
        
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/DoctorRatings"));
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
