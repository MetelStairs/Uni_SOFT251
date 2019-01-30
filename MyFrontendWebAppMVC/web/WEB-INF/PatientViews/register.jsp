<%-- 
    Document   : register
    Created on : Jan 14, 2019, 1:35:56 PM
    Author     : Elis Roberts
--%>

<%@page import="java.io.File"%>
<%@page import="Entities.User"%>
<%@page import="Model.UserModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = request.getAttribute("error").toString();
    String firstname = request.getAttribute("firstname").toString(); 
    String lastname = request.getAttribute("lastname").toString(); 
    String username = request.getAttribute("username").toString(); 
    String path = request.getContextPath()+ File.separator;
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
                    <form action="<%out.print(path);%>PatientRegister" method="POST">
                        <div class="panel panel-default">
                            <div class="panel-heading"><h3>Register Patient Account</h3></div>
                            <div class="panel-body">
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
                                <button type="submit" class="btn btn-primary btn-block" id="ok" name="ok" value="OK">Register as Patient</button>
                                <br>
                                <div class="">
                                    <span class="pull-left">Have Account? <a href="Login">Login In</a></span>
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
