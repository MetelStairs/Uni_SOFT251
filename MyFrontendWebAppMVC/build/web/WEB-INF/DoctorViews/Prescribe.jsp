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
    String username = request.getParameter("username").toString();
    String date = request.getParameter("date").toString();
    
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
                        <li class="breadcrumb-item active">Attend to Patient</li>
                        
                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <form action="<%out.print(path);%>PrescribePatient" method="POST">
                                    <div class="panel panel-default">
                                            <a style="float: right;" href="PatientHistory?username=<%out.print(username);%>">Patient History</a>
                                        <div class="panel-heading"><h3>Attend to Patient </h3>
                                        </div>
                                        <div class="panel-body">
                                            <input type="text" class="form-control" value="<% out.print(username);%>" id="name" name="name" required="" readonly="">
                                            <br>
                                            <input type="text" class="form-control" value="<% out.print(date);%>" id="date" name="date" required="" readonly="">
                                            <br>
                                            <label for="medicine">Select Medicine:</label> 
                                            <select id="medicine" name="medicine" class="form-control" required="">
                                                <option value=""></option>
                                                <%for(Medicine medicine : list){
                                                    %>
                                                    <option value="<%out.println(medicine.getName());%>">
                                                    <%out.print(medicine.getName());%>
                                                    </option>
                                                    <%
                                                }%>
                                            </select>
                                            <br>
                                            <label for="quantity">Quantity</label>
                                            <input type="text" class="form-control" id="quantity" name="quantity" required="">
                                            <label for="dose">Dose</label>
                                            <input type="text" class="form-control" id="dose" name="dose" required="">
                                        <label for="notes">Notes</label> 
                                        <textarea class="form-control" maxlength="250" rows="3" required="" id="notes" name="description"></textarea>

                                        </div>
                                        <div class="panel-footer">
                                            <p class="red" style="margin-top: 10px;"><% out.print(error);%></p>
                                            <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Give Prescription</button>
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
