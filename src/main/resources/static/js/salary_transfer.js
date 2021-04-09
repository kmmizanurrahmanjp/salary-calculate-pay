$(document).ready(function() {
	$('#message').hide();
	formCoboLoad();
	getEmployeeForPaidSalary();

	$('#transferBalance').click(function() {
		var employeeId = $('#employeeIdFoBalanceTransfer').val();
		if (employeeId == "" || employeeId == null || employeeId == 0) {
			$('#message').html('Insert Employee Id');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}

		$.ajax({
			url : "/api/salary/balence/transfar/by/employee/" + employeeId,
			method : "PUT",
			data : null,
			contentType : 'application/json; charset=utf-8',
			success : function() {
				$('#message').html('Successfull');
				$('#message').show();
				$('#message').hide(3000);
				getEmployeeForPaidSalary();
			},
			error : function(error) {
				alert(error);
			}
		})
	})
})

// Select All employee paid salary list
function getEmployeeForPaidSalary() {
	$.ajax({
		url : "api/employee/paid/salary/list",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data.length);
			var tableHead = $('#employeePaidSalaryList thead');
			tableHead.empty();
			tableHead.append('<tr>' + '<th>Employee ID</th>'
					+ '<th>Employee Name</th>' + '<th>Grade/Rank</th>'
					+ '<th>Gross Salary</th>' + '<th>Balance</th>' + '</tr>');

			var tableBody = $('#employeePaidSalaryList tbody');
			tableBody.empty();
			$(data).each(
					function(index, element) {
						tableBody.append('<tr>' + '<td>' + element.employeeId
								+ '</td>' + '<td>' + element.name + '</td>'
								+ '<td>' + element.gradeName + '</td>' + '<td>'
								+ element.grossSalary + '</td>' + '<td>'
								+ element.balance + '</td>' + '</tr>');
					})

		}
	})
}

function formCoboLoad() {

	$.ajax({
		url : "api/employee/unpaid/salary/list",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var employeeIdField = $('#employeeIdFoBalanceTransfer');
			employeeIdField.empty();
			employeeIdField
					.append('<option value="0">Select Employee</option>');
			$(data).each(
					function(index, element) {
						console.log(element);
						console.log(element.employeeId);
						employeeIdField.append("<option value='"
								+ element.employeeId + "'>"
								+ element.employeeId + "</option>");
					})
		},
		error : function(error) {
		}
	})

}

function onChangeEmpId(id) {
	$.ajax({
		url : "/api/employee/" + id,
		method : "GET",
		dataType : "json",
		success : function(data) {
			$('#employeeNameFoBalanceTransfer').empty();
			$('#employeeNameFoBalanceTransfer').append(
					'<label>' + data.data.name + '</label>');
		}
	})
}
