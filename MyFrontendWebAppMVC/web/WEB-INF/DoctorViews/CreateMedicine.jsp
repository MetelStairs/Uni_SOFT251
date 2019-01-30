<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.Medicine"%>
<%@page import="Model.MedicineModel"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.UserModel"%>
<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String path = request.getContextPath()+ File.separator ;
    User loggedInUser = new User();
    if (session.getAttribute("doctor") == null) {
        response.sendRedirect(path+"Doctor/Login");
    } else {
        loggedInUser = (User) session.getAttribute("doctor");
    }
    String error = request.getAttribute("error").toString();
    String name = request.getAttribute("name").toString();
    String description = request.getAttribute("description").toString();
    
    path = request.getServletContext().getRealPath("");
    MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
    List<Medicine> list = mm.getMedicines();
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
                        <li class="breadcrumb-item active">Overview</li>
                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <form action="<%out.print(path);%>AddMedicine" method="POST">
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h3>Stock Medicine</h3></div>
                                        <div class="panel-body">
                                            <label for="name">Enter name:</label> 
                                            <input type="text" class="form-control" value="<% out.print(name);%>" id="name" name="name" required="">
                                            <br>
                                            <label for="type">Select Type:</label> 
                                            <select name="type" id="type" class="form-control" required="">
                                                <option value=""></option>
                                                <option value="Antibiotics">Antibiotics</option>
                                                <option value="Analgesics">Analgesics</option>
                                                <option value="Antipyretics">Antipyretics</option>
                                                <option value="Antiseptics">Antiseptics</option>
                                            </select>
                                            <br>
                                        <label for="dec">Description:</label> 
                                        <textarea class="form-control" maxlength="250" rows="3" required="" id="desc" name="description"><% out.print(description);%></textarea>

                                        </div>
                                        <div class="panel-footer">
                                            <p class="red" style="margin-top: 10px;"><% out.print(error);%></p>
                                            <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Add Medicine</button>
                                        </div>
                                        <br>
                                    </div>

                                </form>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->
                </div>
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
