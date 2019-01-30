<%@page import="java.io.File"%>
<% String path = request.getContextPath()+ File.separator ; %>
<ul class="sidebar navbar-nav">
    <li class="nav-item active">
        <a class="nav-link" href="<%out.print(path);%>Secretary">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span>
        </a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/ApproveAccounts">
            <i class="fas fa-fw fa-star"></i>
            <span>Approve Accounts</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/ViewAppointmentRequests">
            <i class="fas fa-fw fa-star"></i>
            <span>View Appointment Requests</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/Medicine">
            <i class="fas fa-fw fa-book"></i>
            <span>Medicine</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/OrderMedicine">
            <i class="fas fa-fw fa-list"></i>
            <span>Order Medicine</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/RemovePatients">
            <i class="fas fa-fw fa-user-alt"></i>
            <span>Remove Patients</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/TerminateRequests">
            <i class="fas fa-fw fa-user-alt"></i>
            <span>Terminate Patient Requests</span></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<%out.print(path);%>Secretary/Logout">
            <i class="fas fa-fw fa-sign-out-alt"></i>
            <span>Logout</span></a>
    </li>
</ul>