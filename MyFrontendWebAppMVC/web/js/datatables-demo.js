// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable();
  $('#appointments').DataTable();
  $('#prescriptions').DataTable();
  $('#date').datepicker({format: 'DD MM yyyy'}).datepicker("setDate", new Date());
});
