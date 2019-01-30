<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

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
    String error = request.getAttribute("error").toString();
    String doctor = request.getParameter("username").toString();
    String message = request.getAttribute("message").toString();

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
                        <li class="breadcrumb-item active">Give Feedback</li>

                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <form action="<%out.print(path);%>AdminAddFeedBack" method="POST">
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h3>Give Feedback</h3></div>
                                        <div class="panel-body">
                                            <label for="id">Doctor:</label> 
                                            <input type="text" class="form-control" value="<% out.print(doctor);%>" id="id" name="username" required="" readonly="">
                                            <br>
                                            <label for="id">Feedback</label> 
                                            <textarea class="form-control" required="" name="message" rows="3"><% out.print(message);%></textarea>
                                            
                                        </div>
                                        <div class="panel-footer">
                                            <p class="red" style="margin-top: 10px;"><% out.print(error);%></p>
                                            <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Send Feedback</button>
                                        </div>
                                    </div>   

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
