<%-- 
    Document   : index
    Created on : Dec 8, 2018, 4:56:26 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.Appointment"%>
<%@page import="Model.AppointmentModel"%>
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
    if (session.getAttribute("secretary") == null) {
        response.sendRedirect(path + "Secretary/Login");
    } else {
        loggedInUser = (User) session.getAttribute("secretary");
    }
    path = request.getServletContext().getRealPath("");
    UserModel um = new UserModel(path + File.separator + "DATAFILE");
    List<User> users = um.getUsers();
    List<User> doctors = new ArrayList<User>();
    for (User user : users) {
        if (user.getType().equals("doctor")) {
            doctors.add(user);
        }
    }
    
    path = request.getContextPath() + File.separator;
%>

<html lang="en">

    <jsp:include page="head.jsp" />
        <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

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
                        <li class="breadcrumb-item active">Create Appointment</li>
                    </ol>

                    <div class=" mb-3">
                        <div class="row">
                            <div class="col-lg-3"></div>
                            <div class="col-lg-6 home listing-big">
                                <h4 class="heading" >Select available doctor</h4>
                                <div class="your-review">
                                    <form method="POST" action="<%out.println(path);%>CreateAppointment" id="Review_Form">
                                        <p class="p-rate">Select Doctor:</p>
                                        <select name="doctor" id="doctor" class="form-control" required="">
                                            <option value=""></option>
                                            <%                                    for (User user : doctors) {
                                            %>
                                            <option value="<%out.print(user.getUsername());%>">
                                                <%out.print(user.getFirstName() + " " + user.getLastName());%>
                                            </option>
                                            <%
                                                }
                                            %>
                                        </select>
                                        <p class="p-rate">Select Patient</p>
                                        <input type="text" name="patient" value="<%out.print(request.getParameter("username"));%>" readonly="" required=""/>
                                        <p class="p-rate">Select Date</p>
                                        <input type="text" name="date" value="<%out.print(request.getParameter("date"));%>" readonly="" required=""/>
                                        <br><br>
                                        <button class="btn btn-xs btn-block btn-primary">Create Appointment</button>
                                    </form>
                                </div>

                                <hr class="line">

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
