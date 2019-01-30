/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecretaryControllers;

import Entities.Medicine;
import Entities.User;
import Model.MedicineModel;
import Model.UserModel;
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
public class OrderMedicineController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String name = request.getParameter("name").trim();

        String path = request.getServletContext().getRealPath("");

        MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
        
        Medicine  m= new Medicine(quantity, name, "", "");
        mm.stockMedicine(m);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Secretary/Medicine"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
