/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminControllers;

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
public class AdminAddNewUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String page = "/WEB-INF/AdminViews/register.jsp";
        String path = request.getServletContext().getRealPath("");
        UserModel um = new UserModel(path + File.separator + "DATAFILE");
        String error = "";

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        String type = request.getParameter("type");
        if (password.equals(password1)) {
            User u = new User(firstname, lastname, username, password, type);
            u.setApproved("Y");
            u.setApproved("self");
            boolean save = um.saveUser(u);
            if (save) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Admin/AddNew"));
            } else {
                error = "Account not created. Try again.";
                request.setAttribute("error", error);
                request.setAttribute("firstname", firstname);
                request.setAttribute("lastname", lastname);
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            }
        } else {
            error = "Password mismatch. Try again.";
            request.setAttribute("error", error);
            request.setAttribute("firstname", firstname);
            request.setAttribute("lastname", lastname);
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
