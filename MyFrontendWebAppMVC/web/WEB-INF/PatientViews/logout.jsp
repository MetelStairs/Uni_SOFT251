
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ;
    session.removeAttribute("patient");
    response.sendRedirect(path+"Login");
%>