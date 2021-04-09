$(document).ready(
		function() {

			$('#message').hide();
			getTotalBalance();

			$('#addBalance').click(
					function() {
						var companyBalance = $('#companyBalance').val();
						var URL = "/api/bank/account/add/balence";

						if (companyBalance == "" || companyBalance == null
								|| companyBalance == 0) {
							$('#message').html('Insert Balance');
							$('#message').show();
							$('#message').hide(3000);
							return;
						}

						$.post(URL, {
							balence : companyBalance
						}, function(returnedData) {
							console.log(returnedData);
							$('#message').html('Successfull');
							$('#message').show();
							$('#message').hide(3000);
							getTotalBalance();
						}).fail(function() {
							$('#message').html('Balance Allrady Added');
							$('#message').show();
							$('#message').hide(3000);
						});

					})

			$('#updateBalance').click(
					function() {
						var companyBalance = $('#companyBalance').val();
						var URL = "/api/bank/account/increment/balence";

						if (companyBalance == "" || companyBalance == null
								|| companyBalance == 0) {
							$('#message').html('Insert Balance');
							$('#message').show();
							$('#message').hide(3000);
							return;
						}

						$.post(URL, {
							balence : companyBalance
						}, function(returnedData) {
							console.log(returnedData);
							$('#message').html('Successfull');
							$('#message').show();
							$('#message').hide(3000);
							getTotalBalance();
						}).fail(function() {
							$('#message').html('Insert Balance First');
							$('#message').show();
							$('#message').hide(3000);
						});

					})
		})

// Select total Balance
function getTotalBalance() {
	$.ajax({
		url : "api/bank/account/show/balence",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data.length);
			if (data.length == 0 ) {
				$('#addBalance').show();
				$('#updateBalance').hide();
			} else {
				$('#addBalance').hide();
				$('#updateBalance').show();
			}
			var tableBody = $('#balanceList tbody');
			tableBody.empty();
			$(data).each(
					function(index, element) {
						tableBody.append('<tr>' + '<td>'
								+ element.companyAccountNo + '</td>' + '<td>'
								+ element.balence + '</td>' + '<td>'
								+ element.totalPaidAmount + '</td>' + '</tr>');
					})

		}
	})
}
