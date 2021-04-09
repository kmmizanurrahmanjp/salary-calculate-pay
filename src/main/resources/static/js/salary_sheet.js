$(document)
		.ready(
				function() {
					$('#message').hide();
					formCoboLoad();

					$('#generateSalarySheet')
							.click(
									function() {
										var empId = $(
												'#employeeIdForSalarySheet')
												.val();
										if (empId == "" || empId == 0) {
											$('#message').html(
													'Insert Employee Id');
											$('#message').show();
											$('#message').hide(3000);
											return;
										}
										$
												.ajax({
													url : "api/salary/sheet/"
															+ empId,
													method : "GET",
													dataType : "json",
													success : function(data) {
														console.log(data);
														$('#salarySheetInfo')
																.empty();
														$(data)
																.each(
																		function(
																				index,
																				element) {
																			var today = new Date();
																			var date = today
																					.getDate()
																					+ '-'
																					+ (today
																							.getMonth() + 1)
																					+ '-'
																					+ today
																							.getFullYear();

																			$(
																					'#salarySheetInfo')
																					.html(
																							'<tr>'
																									+ '<td>Company</td>'
																									+ '<td>IBCS-PRIMAX Software(Bangladesh) Limited</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Employee Name</td>'
																									+ '<td>'
																									+ element.employeeId
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Employee Name</td>'
																									+ '<td>'
																									+ element.name
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Grade</td>'
																									+ '<td>'
																									+ element.gradeName
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Basic Salary</td>'
																									+ '<td>'
																									+ element.basicSalary
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>House Rent (20%)</td>'
																									+ '<td>'
																									+ element.houseRent
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Medical Allowance (15%)</td>'
																									+ '<td>'
																									+ element.medicalAllowance
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Gross Salary</td>'
																									+ '<td>'
																									+ element.grossSalary
																									+ '</td>'
																									+ '</tr>'
																									+ '<tr>'
																									+ '<td>Date</td>'
																									+ '<td>'
																									+ date
																									+ '</td>'
																									+ '</tr>');

																		})

													},
													error : function(error) {
														if (empId == "") {
															$('#message')
																	.html(
																			'Invalid Employee Id');
															$('#message')
																	.show();
															$('#message').hide(
																	3000);
															return;
														}
													}
												})

									})

				})

function formCoboLoad() {

	$.ajax({
		url : "api/employee",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var employeeIdField = $('#employeeIdForSalarySheet');
			employeeIdField.empty();
			employeeIdField
					.append('<option value="0">Select Employee</option>');
			$(data)
					.each(
							function(index, element) {

								for (var i = 0; i < element.data.length; i++) {
									
									employeeIdField.append("<option value='"
											+ element.data[i].employeeId + "'>"
											+ element.data[i].employeeId
											+ "</option>");
								}

							})
		},
		error : function(error) {
		}
	})

}
