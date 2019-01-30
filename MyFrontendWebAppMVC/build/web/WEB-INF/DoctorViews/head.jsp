<%@page import="java.io.File"%>
<%String path = request.getContextPath()+ File.separator ;%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PMS Doctor - Dashboard</title>

    <!-- Bootstrap core CSS-->
    <link href="<%out.print(path);%>vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="<%out.print(path);%>vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="<%out.print(path);%>vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%out.print(path);%>css/sb-admin.css" rel="stylesheet">

</head>