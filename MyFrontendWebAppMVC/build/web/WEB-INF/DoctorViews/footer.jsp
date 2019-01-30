<%@page import="java.io.File"%>
<%String path = request.getContextPath()+ File.separator ;%>
<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<!-- Bootstrap core JavaScript-->
<script src="<%out.print(path);%>vendor/jquery/jquery.min.js"></script>
<script src="<%out.print(path);%>vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="<%out.print(path);%>vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Page level plugin JavaScript-->
<script src="<%out.print(path);%>vendor/chart.js/Chart.min.js"></script>
<script src="<%out.print(path);%>vendor/datatables/jquery.dataTables.js"></script>
<script src="<%out.print(path);%>vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- Custom scripts for all pages-->
<script src="<%out.print(path);%>js/sb-admin.min.js"></script>

<!-- Demo scripts for this page-->
<script src="<%out.print(path);%>js/datatables-demo.js"></script>
