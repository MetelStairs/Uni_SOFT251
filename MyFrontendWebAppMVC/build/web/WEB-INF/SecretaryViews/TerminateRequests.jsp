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
    if (session.getAttribute("secretary") == null) {
        response.sendRedirect(path+"Secretary/Login");
    } else {
        loggedInUser = (User) session.getAttribute("secretary");
    }
    path = request.getServletContext().getRealPath("");
    UserModel um = new UserModel(path + File.separator + "DATAFILE");
    List<User> list = um.getUsers();
    List<User> terminate = new ArrayList<User>();
    for (User user : list) {
        if (user.getType().equals("patient") && user.getTerminate().equals("Y")) {
            terminate.add(user);
        }
    }

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
                    <div class="card mb-3">
                        <div class="card-header">
                            <i class="fas fa-table"></i>
                            Patient Accounts not Approved</div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                            <th>Approve</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                            <th>Approve</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <%                                            for (User user : terminate) {
                                        %>
                                        <tr>
                                            <td><%out.print(user.getFirstName());%></td>
                                            <td><%out.print(user.getLastName());%></td>
                                            <td><%out.print(user.getUsername());%></td>
                                            <td><a class="btn btn-success" href="TerminatePatient?username=<%out.println(user.getUsername());%>">Terminate</a></td>
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
