<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.Feedback"%>
<%@page import="Model.FeedbackModel"%>
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
    if (session.getAttribute("admin") == null) {
        response.sendRedirect(path+"Admin/Login");
    } else {
        loggedInUser = (User) session.getAttribute("admin");
    }
    path = request.getServletContext().getRealPath("");
    FeedbackModel fm = new FeedbackModel(path + File.separator + "DATAFILE");
    
    List<Feedback> list = fm.getFeedBack();

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
                        <li class="breadcrumb-item active">Doctors' Admin Feedback</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Doctors' Admin Feedback</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Doctor</th>
                                            <th>Feedback</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Doctor</th>
                                            <th>Feedback</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (Feedback feedback : list) {
                                        %>
                                        <tr>
                                            <td><%out.print(feedback.getDoctor());%></td>
                                            <td><%out.print(feedback.getFeedback());%></td>
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
