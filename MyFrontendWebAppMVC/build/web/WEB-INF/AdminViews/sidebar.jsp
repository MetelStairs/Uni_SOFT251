<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ; %>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<%out.print(path);%>Admin">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Admin/Doctors">
            <i class="fas fa-fw fa-user"></i>
            <span>Doctors</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Admin/Secretaries">
            <i class="fas fa-fw fa-user"></i>
            <span>Secretaries</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Admin/DoctorRatings">
            <i class="fas fa-fw fa-list"></i>
            <span>View Doctor's Ratings</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Admin/DoctorFeedbacks">
            <i class="fas fa-fw fa-list"></i>
            <span>View Doctor's Feedbacks</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Admin/Logout">
            <i class="fas fa-fw fa-sign-out-alt"></i>
            <span>Logout</span></a>
    </li>
</ul>