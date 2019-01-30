/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminControllers;

import Entities.Feedback;
import Entities.User;
import Model.FeedbackModel;
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
public class AdminAddFeedbackController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String page = "/WEB-INF/AdminViews/register.jsp";
        String path = request.getServletContext().getRealPath("");
        FeedbackModel fm = new FeedbackModel(path + File.separator + "DATAFILE");
        String error;

        String username = request.getParameter("username");
        String message = request.getParameter("message");
            Feedback feedback = new Feedback(username, message);
            
            boolean save = fm.saveFeedBack(feedback);
            if (save) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Admin/DoctorFeedbacks"));
            } else {
                error = "Account not created. Try again.";
                request.setAttribute("error", error);
                request.setAttribute("username", username);
                request.setAttribute("message", message);
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
