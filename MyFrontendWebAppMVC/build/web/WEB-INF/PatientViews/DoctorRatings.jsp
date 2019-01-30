<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

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
    if (session.getAttribute("patient") == null) {
        response.sendRedirect(path+"Login");
    } else {
        loggedInUser = (User) session.getAttribute("patient");
    }
    path = request.getServletContext().getRealPath("");
    RatingModel rm = new RatingModel(path + File.separator + "DATAFILE");
    
    List<Rating> list = rm.getRatings();

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
                        <li class="breadcrumb-item active">Doctors' Ratings</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Doctors' Ratings</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Patient</th>
                                            <th>Doctor</th>
                                            <th>Rating</th>
                                            <th>Message</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Patient</th>
                                            <th>Doctor</th>
                                            <th>Rating</th>
                                            <th>Message</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (Rating rating : list) {
                                        %>
                                        <tr>
                                            <td><%out.print(rating.getUser());%></td>
                                            <td><%out.print(rating.getDoctor());%></td>
                                            <td><%out.print(rating.getRate());%></td>
                                            <td><%out.print(rating.getMessage());%></td>
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
