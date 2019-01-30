<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.Prescription"%>
<%@page import="Model.PrescriptionModel"%>
<%@page import="Model.RatingModel"%>
<%@page import="Entities.Rating"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.UserModel"%>
<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String path = request.getContextPath() + File.separator;
    User loggedInUser = new User();
    if (session.getAttribute("doctor") == null) {
        response.sendRedirect(path+"Doctor/Login");
    } else {
        loggedInUser = (User) session.getAttribute("doctor");
    }
    path = request.getServletContext().getRealPath("");
    PrescriptionModel pm = new PrescriptionModel(path + File.separator + "DATAFILE");
    
    List<Prescription> list = pm.getPrescriptions();
    List<Prescription> myPrescription = new ArrayList<Prescription>();
    String username = request.getParameter("username");
    for(Prescription p : list){
        if(p.getUser().equals(username)){
            myPrescription.add(p);
        }
    }

%>

<html lang="en">

    <jsp:include page="head.jsp" />

    <body id="page-top">

        <jsp:include page="nav.jsp" />

        <div id="wrapper">

            <!-- Sidebar -->
            <jsp:include page="sidebar.jsp" />

            <div id="content-wrapper">

                <div class="container-fluid">

                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Dashboard</a>
                        </li>
                        <li class="breadcrumb-item active">My Prescriptions</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            My Prescriptions</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Doctor</th>
                                            <th>Date</th>
                                            <th>Medicine</th>
                                            <th>Quantity</th>
                                            <th>Dose</th>
                                            <th>Notes</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Doctor</th>
                                            <th>Date</th>
                                            <th>Medicine</th>
                                            <th>Quantity</th>
                                            <th>Dose</th>
                                            <th>Notes</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (Prescription presciption : myPrescription) {
                                        %>
                                        <tr>
                                            <td><%out.print(presciption.getDoctor());%></td>
                                            <td><%out.print(presciption.getDate());%></td>
                                            <td><%out.print(presciption.getMedicine());%></td>
                                            <td><%out.print(presciption.getQuantity());%></td>
                                            <td><%out.print(presciption.getDose());%></td>
                                            <td><%out.print(presciption.getNotes());%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="card-footer small text-muted">Updated now</div>
                    </div>

                </div>
                <!-- /.container-fluid -->

                <!-- Sticky Footer -->
                <footer class="sticky-footer">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright © Patient Management System. 2019</span>
                        </div>
                    </div>
                </footer>

            </div>
            <!-- /.content-wrapper -->

        </div>
        <!-- /#wrapper -->
        <jsp:include page="footer.jsp" />

    </body>

</html>
