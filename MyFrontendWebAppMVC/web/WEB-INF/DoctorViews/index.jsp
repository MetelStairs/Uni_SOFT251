<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.Medicine"%>
<%@page import="Model.MedicineModel"%>
<%@page import="Entities.Appointment"%>
<%@page import="Model.AppointmentModel"%>
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
    AppointmentModel am = new AppointmentModel(path + File.separator + "DATAFILE");
    
    List<Appointment> list = am.getAppointments();
    List<Appointment> myAppointment = new ArrayList<Appointment>();
    for(Appointment p : list){
        if(p.getDoctor().equals(loggedInUser.getUsername()) && 
                p.getCreated().equals("Y") && !p.getAttended().equals("Y")){
            myAppointment.add(p);
        }
    }
    
    MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
    List<Medicine> medicines = mm.getMedicines();
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
                        <li class="breadcrumb-item active">My Appointments</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            My Appointments</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Patient</th>
                                            <th>Date</th>
                                            <th>Created</th>
                                            <th>Attended</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Patient</th>
                                            <th>Date</th>
                                            <th>Created</th>
                                            <th>Attended</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (Appointment appointment : myAppointment) {
                                        %>
                                        <tr>
                                            <td><%out.print(appointment.getUser());%></td>
                                            <td><%out.print(appointment.getDate());%></td>
                                            <td><%out.print(appointment.getCreated());%></td>
                                            <td><%
                                            if(appointment.getAttended().equals("Y")){
                                                out.print("Y");
                                            }else{
                                               %>
                                               <a href="Prescribe?username=<%out.println(appointment.getUser());%>&date=<%out.println(appointment.getDate());%>" class="btn btn-primary btn-sm" id="ok" name="ok">Prescribe</a>

                                               <%
                                            }
                                            %></td>
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
                                    
                                     <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Medicine List</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Medicine Name</th>
                                            <th>Quantity</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Medicine Name</th>
                                            <th>Quantity</th>
                                            <th>Type</th>
                                            <th>Description</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (Medicine medicine : medicines) {
                                        %>
                                        <tr>
                                            <td><%out.print(medicine.getName());%></td>
                                            <td><%out.print(medicine.getQuanity());%></td>
                                            <td><%out.print(medicine.getType());%></td>
                                            <td><%out.print(medicine.getDescription());%></td>
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
