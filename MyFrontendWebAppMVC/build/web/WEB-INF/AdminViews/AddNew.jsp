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
    String firstname = request.getAttribute("firstname").toString();
    String lastname = request.getAttribute("lastname").toString();
    String username = request.getAttribute("username").toString();

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
                        <li class="breadcrumb-item active">Add New Account</li>

                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <form action="<%out.print(path);%>AdminAddNewUser" method="POST">
                                    <div class="panel panel-default">
                                        <div class="panel-heading"><h3>Add Doctor or Secretary Account</h3></div>
                                        <div class="panel-body">
                                            <label for="id">Select Doctor or Secretary</label>
                                            <select name="type" class="form-control" required="">
                                                <option value=""></option>
                                                <option value="doctor">Doctor</option>
                                                <option value="secretary">Secretary</option>
                                            </select>
                                            <br>
                                            <label for="id">Enter first name</label> <input type="text" class="form-control" value="<% out.print(firstname);%>" id="id" name="firstname" required="">
                                            <br>
                                            <label for="id">Enter last name</label> <input type="text" class="form-control" value="<% out.print(lastname);%>" id="id" name="lastname" required="">
                                            <br>
                                            <label for="id">Enter username:</label> <input type="text" class="form-control" value="<% out.print(username);%>" id="id" name="username" required="">
                                            <br>
                                            <label for="pin">Enter password:</label> <input type="password"  class="form-control" value="" id="pin" name="password" required="">
                                            <br>
                                            <label for="pin">Enter password again:</label> <input type="password"  class="form-control" value="" id="pin" name="password1" required="">

                                        </div>
                                        <div class="panel-footer">
                                            <p class="red" style="margin-top: 10px;"><% out.print(error);%></p>
                                            <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Add New User Account</button>
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
