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
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elis Roberts
 */
public class AdminDeleteUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String path = request.getServletContext().getRealPath("");
        UserModel um = new UserModel(path + File.separator + "DATAFILE");
        String username = request.getParameter("username");
        um.deleteUser(username);
        
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Admin"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
