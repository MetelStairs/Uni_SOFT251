/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorControllers;

import Entities.User;
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
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String page = "/WEB-INF/AdminViews/login.jsp";
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String path = request.getServletContext().getRealPath("");
        UserModel um = new UserModel(path + File.separator + "DATAFILE");
        String error = "";
        User user = um.loginUser(username, password);
        request.setAttribute("doctor", user);
        if (user != null) {
            if (user.getType().equals("doctor")) {
                request.getSession().setAttribute("doctor", user);
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Doctor"));
            } else {
                error = "You dont have permision to doctor patient portal";
                request.setAttribute("error", error);
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            }
        } else {
            error = "Could not login. Try again!";
            request.setAttribute("error", error);
            request.setAttribute("username", username);
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
