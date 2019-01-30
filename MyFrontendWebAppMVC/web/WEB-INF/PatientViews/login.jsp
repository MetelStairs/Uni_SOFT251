<%-- 
    Document   : login
    Created on : Jan 16, 2019, 2:08:03 PM
    Author     : Elis Roberts
--%>

<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = request.getAttribute("error").toString();
    String username = request.getAttribute("username").toString(); 
    String path = request.getContextPath()+ File.separator ;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=0,viewport-fit=cover">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/css.css">

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-sm-12 col-md-6">
                    <h1>Patient Management System</h1>
                    <form action="<%out.print(path);%>PatientLogin" method="POST">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3>Enter username + password</h3></div>
                            <div class="panel-body">
                                <label for="id">Enter username:</label> 
                                <input type="text" class="form-control" value="<% out.print(username);%>" id="id" name="username" required="">
                                <br>
                                <label for="pin">Enter password:</label> <input type="password"  class="form-control" value="" id="pin" name="password" required="">

                            </div>
                            <div class="panel-footer">
                                <p class="red" style="margin-top: 10px;"><% out.print(error);%></p>
                                <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Login In as Patient</button>
                                <br>
                                <div class="">
                                    <span class="pull-left">New here? <a href="Register">Register</a></span>
                                    <div class="pull-right">
                                        <span>Admin <a href="Admin">Login</a></span><br>
                                        <span>Doctor <a href="Doctor">Login</a></span><br>
                                        <span>Secretary <a href="Secretary">Login</a></span><br>
                                    </div>
                                    <br>
                                    <br>
                                </div>
                                <br>
                            </div>
                        </div>   

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
