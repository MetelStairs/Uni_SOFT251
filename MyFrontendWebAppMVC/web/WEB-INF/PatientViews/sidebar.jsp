<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ; %>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<%out.print(path);%>">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>RateDoctor">
            <i class="fas fa-fw fa-star"></i>
            <span>Rate a Doctor</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>DoctorRatings">
            <i class="fas fa-fw fa-star"></i>
            <span>View Doctor's Ratings</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>RequestAppointment">
            <i class="fas fa-fw fa-book"></i>
            <span>Request Appointment</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>History">
            <i class="fas fa-fw fa-list"></i>
            <span>View History</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Appointments">
            <i class="fas fa-fw fa-list"></i>
            <span>View Appointment</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Prescriptions">
            <i class="fas fa-fw fa-list"></i>
            <span>View Prescriptions</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Terminate">
            <i class="fas fa-fw fa-user-alt"></i>
            <span>Terminate Account</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Logout">
            <i class="fas fa-fw fa-sign-out-alt"></i>
            <span>Logout</span></a>
    </li>
</ul>