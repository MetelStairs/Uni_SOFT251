/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorControllers;

import Entities.Medicine;
import Model.MedicineModel;
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
public class AddMedicineController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        String path = request.getServletContext().getRealPath("");

        MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
        
        Medicine  m= new Medicine(0, name, type, description);
        mm.saveMedicine(m);
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/Doctor/Medicine"));

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
