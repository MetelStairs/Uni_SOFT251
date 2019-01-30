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
        response.sendRedirect(path + "Login");
    } else {
        loggedInUser = (User) session.getAttribute("patient");
    }
    path = request.getServletContext().getRealPath("");
    RatingModel rm = new RatingModel(path + File.separator + "DATAFILE");

    List<Rating> list = rm.getRatings();
    path = request.getContextPath() + File.separator;

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
                        <li class="breadcrumb-item active">Request Appointment</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <form action="<%out.print(path);%>BookAppointment" method="POST">
                                    <label for="date">Select Date:</label>
                                    <input type="text" class="form-control" id="date" name="date">
                                    <input type="hidden" value="<%out.print(loggedInUser.getUsername());%>"/>
                                    <br>
                                    <button type="submit"  class="btn btn-success btn-block">Send Request</button>
                                </form>
                            </div>
                        </div>
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
