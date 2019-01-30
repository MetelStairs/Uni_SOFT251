<%-- 
    Document   : index
    Created on : Jan 16, 2019, 1:52:56 PM
    Author     : Elis Roberts
--%>

<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("patient") == null) {
        response.sendRedirect("Login");
    }else{
        response.sendRedirect("Patient");
    }
%>
