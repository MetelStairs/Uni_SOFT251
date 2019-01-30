<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ; %>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<%out.print(path);%>Doctor">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Doctor/ViewAppointments">
            <i class="fas fa-fw fa-star"></i>
            <span>My Appointments</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Doctor/ViewPrescriptions">
            <i class="fas fa-fw fa-star"></i>
            <span>My Prescriptions</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Doctor/Medicine">
            <i class="fas fa-fw fa-star"></i>
            <span>Medicine</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Doctor/CreateMedicine">
            <i class="fas fa-fw fa-star"></i>
            <span>Create Medicine</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Doctor/Logout">
            <i class="fas fa-fw fa-sign-out-alt"></i>
            <span>Logout</span></a>
    </li>
</ul>