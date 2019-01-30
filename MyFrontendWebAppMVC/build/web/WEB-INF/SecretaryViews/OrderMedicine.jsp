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
    String path = request.getContextPath() + File.separator;
    User loggedInUser = new User();
    if (session.getAttribute("secretary") == null) {
        response.sendRedirect(path+"Secretary/Login");
    } else {
        loggedInUser = (User) session.getAttribute("secretary");
    }
    
    path = request.getServletContext().getRealPath("");
    MedicineModel mm = new MedicineModel(path + File.separator + "DATAFILE");
    List<Medicine> medicines = mm.getMedicines();
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
                                <h1>Patient Management System</h1>
                                <form action="<%out.print(path);%>OrderMedicine" method="GET">
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h3>Stock Medicine/h3></div>
                                        <div class="panel-body">
                                            <label for="type">Select Medicine</label> 
                                            <select name="name" id="type" class="form-control" required="">
                                                <option value=""></option>
                                                <%for(Medicine medicine : medicines){
                                                    %>
                                                    <option value="<%out.println(medicine.getName());%>">
                                                    <%out.print(medicine.getName()+" type = "+medicine.getType());%>
                                                    </option>
                                                    <%
                                                }%>
                                            </select>
                                            <label for="q">Enter quantity</label> 
                                            <input type="text" class="form-control" value="" id="q" name="quantity" required="">
                                            <br>
                                            
                                        </div>
                                        <div class="panel-footer">
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
