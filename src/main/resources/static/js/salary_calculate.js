$(document).ready(function() {

	getAllEmployeeSalary();
})

// Select All employee salary
function getAllEmployeeSalary() {
	$.ajax({
		url : "api/salary/calculate",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data.length);
			var tableBody = $('#allemployeeSalaryList tbody');
			tableBody.empty();
			$(data).each(
					function(index, element) {
						tableBody.append('<tr>' + '<td>' + element.employeeId
								+ '</td>' + '<td>' + element.name + '</td>'
								+ '<td>' + element.gradeName + '</td>' + '<td>'
								+ element.basicSalary + '</td>' + '<td>'
								+ element.houseRent + '</td>' + '<td>'
								+ element.medicalAllowance + '</td>' + '<td>'
								+ element.grossSalary + '</td>' + '</tr>');
					})

		}
	})
}
