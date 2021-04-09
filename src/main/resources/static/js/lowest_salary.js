$(document).ready(function() {

	$('#message').hide();
	getAllBasicSalary();

	$('#addSalary').click(function() {
		var param = $('#lowestSalary').val();
		var URL = "/api/salary/add/basic/lowest/grade";

		if (param == "" || param == null || param == 0) {
			$('#message').html('Insert Salary');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}

		$.post(URL, {
			lowestGradeBasicSalary : param
		}, function(returnedData) {
			console.log(returnedData);
			$('#message').html('Successfull');
			$('#message').show();
			$('#message').hide(3000);
			getAllBasicSalary();
		}).fail(function() {
			console.log("error");
		});

	})
})

// Select All basic salary
function getAllBasicSalary() {
	$.ajax({
		url : "api/salary/show/basic/lowest/grade",
		method : "GET",
		dataType : "json",
		success : function(data) {
			var tableBody = $('#basicSalaryList tbody');
			tableBody.empty();
			$(data).each(
					function(index, element) {
						tableBody.append('<tr>' + '<td>Grade-'
								+ element.gradeId + '</td>' + '<td>'
								+ element.basicSalary + '</td>' + '<td>'
								+ element.houseRent + '</td>' + '<td>'
								+ element.medicalAllowance + '</td>' + '<td>'
								+ element.grossSalary + '</td>' + '</tr>');
					})

		}
	})
}
