$(document).ready(function() {

	$('#message').hide();
	getAllEmployee();
	formCoboLoad();

	var employee = {};
	var bankAccount = {}
	var dynamicURL = "";
	var methodName = "";

	$('#addEmployee').click(function() {
		employee.name = $('#employeeName').val();
		if (employee.name == "") {
			$('#message').html('Insert Employee');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}
		employee.mobile = $('#mobile').val();
		if (employee.mobile == "") {
			$('#message').html('Insert Mobile');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}
		employee.gradeId = $('#gradeId').val();
		if (employee.gradeId == 0 || employee.gradeId == "") {
			$('#message').html('Insert grade');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}
		employee.address = $('#address').val();
		if (employee.address == "") {
			$('#message').html('Insert Address');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}

		bankAccount.employeeAccountNo = $('#accountNo').val();
		bankAccount.accountName = $('#accountName').val();
		if (bankAccount.accountName == "") {
			$('#message').html('Insert Account Name');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}

		bankAccount.accountTypeId = $('#accountTypeId').val();
		if (bankAccount.accountTypeId == 0 || bankAccount.accountTypeId == "") {
			$('#message').html('Insert account type');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}
		bankAccount.bankId = $('#bankId').val();
		if (bankAccount.bankId == 0 || bankAccount.bankId == "") {
			$('#message').html('Insert Bank');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}
		bankAccount.branchId = $('#branchId').val();
		if (bankAccount.branchId == 0 || bankAccount.branchId == "") {
			$('#message').html('Insert Branch');
			$('#message').show();
			$('#message').hide(3000);
			return;
		}

		employee.bankAccount = bankAccount;

		var employeeId = $('#employeeId').val();
		if (employeeId) {
			dynamicURL = "api/employee/" + employeeId;
			methodName = "PUT";
		} else {
			dynamicURL = "api/employee/";
			methodName = "POST";
		}
		var employeeObj = JSON.stringify(employee);
		$.ajax({
			url : dynamicURL,
			method : methodName,
			data : employeeObj,
			contentType : 'application/json; charset=utf-8',
			success : function() {
				$('#message').html('Successfull');
				$('#message').show();
				$('#message').hide(3000);
				getAllEmployee();
				resetEmployee();
			},
			error : function(error) {
				alert(error);
			}
		})
	})
})

// Select All Employee
function getAllEmployee() {
	$
			.ajax({
				url : "api/employee",
				method : "GET",
				dataType : "json",
				success : function(data) {
					var tableBody = $('#employeeList tbody');
					tableBody.empty();
					$(data)
							.each(
									function(index, element) {
										var gradeId;
										for (var i = 0; i < element.data.length; i++) {
											tableBody
													.append('<tr>' + '<td>'
															+ element.data[i].employeeId
															+ '</td>'
															+ '<td>'
															+ element.data[i].name
															+ '</td>'
															+ '<td>'
															+ element.data[i].gradeName
															+ '</td>'
															+ '<td>'
															+ element.data[i].mobile
															+ '</td>'
															+ '<td>'
															+ element.data[i].address
															+ '</td>'
															+ '<td>'
															+ element.data[i].bankAccount.employeeAccountNo
															+ '</td>'
															+ '<td>'
															+ element.data[i].bankAccount.accountName
															+ '</td>'
															+ '<td>'
															+ element.data[i].bankAccount.bankName
															+ '</td>'
															+ '<td>'
															+ element.data[i].bankAccount.branchName
															+ '</td>'
															+ '<td><button onclick = "loadDataForUpdate('
															+ element.data[i].employeeId
															+ ')">Update</button></td>'
															+ '<td><button onclick = "deleteEmployee('
															+ element.data[i].employeeId
															+ ')">Delete</button></td>'
															+ '</tr>');
										}
									})
				}
			})
}

// Load commo box data
function formCoboLoad() {

	$.ajax({
		url : "api/init/grade",
		method : "GET",
		dataType : "json",
		success : function(data) {
			var gradeNameField = $('#gradeId');
			gradeNameField.empty();
			gradeNameField
					.append('<option value="0">Select Grade/Rank</option>');
			$(data).each(
					function(index, element) {
						var gradeId = element.gradeId;
						var gradeName = element.gradeName;
						gradeNameField.append("<option value='" + gradeId
								+ "'>" + gradeName + "</option>");
					})
		},
		error : function(error) {
		}
	})

	$.ajax({
		url : "api/init/bank/account/type",
		method : "GET",
		dataType : "json",
		success : function(data) {
			var accountTypeNameField = $('#accountTypeId');
			accountTypeNameField.empty();
			accountTypeNameField
					.append('<option value="0">Select Account Type</option>');
			$(data).each(
					function(index, element) {
						var accountTypeId = element.accountTypeId;
						var accountTypeName = element.accountTypeName;
						accountTypeNameField.append("<option value='"
								+ accountTypeId + "'>" + accountTypeName
								+ "</option>");
					})
		},
		error : function(error) {
		}
	})

	$.ajax({
		url : "api/init/bank",
		method : "GET",
		dataType : "json",
		success : function(data) {
			var bankField = $('#bankId');
			bankField.empty();
			bankField.append('<option value="0">Select Bank</option>');
			$(data).each(
					function(index, element) {
						var bankId = element.bankId;
						var bankName = element.bankName;
						bankField.append("<option value='" + bankId + "'>"
								+ bankName + "</option>");
					})
		},
		error : function(error) {
		}
	})

	$.ajax({
		url : "api/init/branch",
		method : "GET",
		dataType : "json",
		success : function(data) {
			var branchField = $('#branchId');
			branchField.empty();
			branchField.append('<option value="0">Select Branch</option>');
			$(data).each(
					function(index, element) {
						var branchId = element.branchId;
						var branchName = element.branchName;
						branchField.append("<option value='" + branchId + "'>"
								+ branchName + "</option>");
					})
		},
		error : function(error) {
		}
	})
}

// delete employee
function deleteEmployee(id) {
	$.ajax({
		url : 'api/employee/' + id,
		method : 'DELETE',
		success : function() {
			alert('record has been deleted');
			getAllEmployee();
		},
		error : function(error) {
			alert(error);
		}
	})
}

// set from data for update oparation
function loadDataForUpdate(id) {
	$.ajax({
		url : 'api/employee/' + id,
		method : 'GET',
		dataType : 'json',
		success : function(data) {
			$('#employeeId').val(data.data.employeeId);
			$('#employeeName').val(data.data.name);
			$('#mobile').val(data.data.mobile);

			$("#gradeId").empty();
			$("#gradeId").append(
					"<option value='" + data.data.gradeId + "'>"
							+ data.data.gradeName + "</option>");

			$.ajax({
				url : "api/init/grade",
				method : "GET",
				dataType : "json",
				success : function(data) {
					$(data).each(
							function(index, element) {
								$("#gradeId").append(
										"<option value='" + element.gradeId
												+ "'>" + element.gradeName
												+ "</option>");
							})
				}
			})

			$('#address').val(data.data.address);
			$('#accountNo').val(data.data.bankAccount.employeeAccountNo);
			$('#accountName').val(data.data.bankAccount.accountName);

			$("#accountTypeId").empty();
			$("#accountTypeId").append(
					"<option value='" + data.data.bankAccount.accountTypeId
							+ "'>" + data.data.bankAccount.accountTypeName
							+ "</option>");

			$.ajax({
				url : "api/init/bank/account/type",
				method : "GET",
				dataType : "json",
				success : function(data) {
					$(data).each(
							function(index, element) {
								$("#accountTypeId").append(
										"<option value='"
												+ element.accountTypeId + "'>"
												+ element.accountTypeName
												+ "</option>");
							})
				}
			})

			$("#bankId").empty();
			$("#bankId").append(
					"<option value='" + data.data.bankAccount.bankId + "'>"
							+ data.data.bankAccount.bankName + "</option>");

			$.ajax({
				url : "api/init/bank",
				method : "GET",
				dataType : "json",
				success : function(data) {
					$(data).each(
							function(index, element) {
								$("#bankId").append(
										"<option value='" + element.bankId
												+ "'>" + element.bankName
												+ "</option>");
							})
				}
			})

			$("#branchId").empty();
			$("#branchId").append(
					"<option value='" + data.data.bankAccount.branchId + "'>"
							+ data.data.bankAccount.branchName + "</option>");

			var bankId = data.data.bankAccount.bankId;
			$.ajax({
				url : "api/init/branch/bank/" + bankId,
				method : "GET",
				dataType : "json",
				success : function(data) {
					$(data).each(
							function(index, element) {
								$("#branchId").append(
										"<option value='" + element.branchId
												+ "'>" + element.branchName
												+ "</option>");
							})
				}
			})

			// getAllEmployee();
		}
	})
}

// Reser Employee from data
function resetEmployee() {
	$('#employeeId').val('');
	$('#employeeName').val('');
	$('#mobile').val('');
	$("#gradeId").empty();
	$('#gradeId').append('<option value="0">Select Grade/Rank</option>');
	$('#address').val('');
	$('#accountNo').val('');
	$('#accountName').val('');
	$("#accountTypeId").empty();
	$('#accountTypeId')
			.append('<option value="0">Select Account Type</option>');
	$("#bankId").empty();
	$('#bankId').append('<option value="0">Select Bank</option>');
	$("#branchId").empty();
	$('#branchId').append('<option value="0">Select Branch</option>');
}

// Change branch accroding to bank
function onChangeBank(id) {
	$.ajax({
		url : "api/init/branch/bank/" + id,
		method : "GET",
		dataType : "json",
		success : function(data) {
			var branchField = $('#branchId');
			branchField.empty();
			$(data).each(
					function(index, element) {
						var branchId = element.branchId;
						var branchName = element.branchName;
						branchField.append("<option value='" + branchId + "'>"
								+ branchName + "</option>");
					})
		},
		error : function(error) {
		}
	})
}