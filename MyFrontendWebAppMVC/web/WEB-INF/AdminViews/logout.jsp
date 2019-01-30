
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ;
    session.removeAttribute("admin");
    response.sendRedirect(path+"Admin/Login");
%>