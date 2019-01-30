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
    path = request.getServletContext().getRealPath("")+ File.separator ;
    UserModel um = new UserModel(path + "DATAFILE");
    
    User userToRemove = um.getUser(request.getParameter("username")); //(User)request.getAttribute("user"); 

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
                        <li class="breadcrumb-item active">Delete User Account</li>
                        
                    </ol>

                    <!-- DataTables Example -->
                    <div class="mb-3">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-sm-12 col-md-6">
                                <div class="alert alert-danger">
                                    <h2>Are you sure to delete this account (<%out.print(userToRemove.getType());%>)?</h2><br>
                                        <b>First Name : <%out.print(userToRemove.getFirstName());%> <br> <br>
                                        Last Name : <%out.print(userToRemove.getLastName());%> <br> <br>
                                        Username : <%out.print(userToRemove.getUsername());%><br> <br></b>
                                        
                                    <form action="<%out.print(path);%>AdminDeleteUser" method="POST">
                                        <input type="hidden" name="username" value="<%out.print(userToRemove.getUsername());%>"/>
                                    <button type="submit" class="btn btn-danger btn-block" id="ok" name="ok" value="OK">Delete User Account</button>
                                </form>
                                    
                                    </div>
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
