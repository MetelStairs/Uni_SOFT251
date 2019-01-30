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
public class TerminateAccountController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String path = request.getServletContext().getRealPath("");
        User loggedInUser = (User) request.getSession().getAttribute("patient");
        
        UserModel um = new UserModel(path + File.separator + "DATAFILE");
        um.terminateAccount(loggedInUser);
        request.getSession().removeAttribute("patient");
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Register"));
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
