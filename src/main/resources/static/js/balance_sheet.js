$(document).ready(function() {

	getTotalBalance();
})

// Select total Balance
function getTotalBalance() {
	$.ajax({
		url : "api/bank/account/show/balence",
		method : "GET",
		dataType : "json",
		success : function(data) {
			console.log(data.length);
			var accountBody = $('#balanceAccountInfo');
			accountBody.empty();

			$(data).each(
					function(index, element) {
						var today = new Date();
						var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
						accountBody.html('<tr>' + '<td>Account No</td>'
								+ '<td>'
								+ element.companyAccountNo
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Account Name</td>'
								+ '<td>'
								+ element.accountName
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Bank</td>'
								+ '<td>'
								+ element.bankName
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Branch</td>'
								+ '<td>'
								+ element.branchName
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Account Type</td>'
								+ '<td>'
								+ element.accountType
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Total Paid Amount</td>'
								+ '<td>'
								+ element.totalPaidAmount
								+ '</td>'
								+ '</tr>'
								+ '<tr>'
								+ '<td>Total Remain Balance</td>'
								+ '<td>'
								+ element.balence + '</td>' + '</tr>'
								+ '<tr>'
								+ '<td>Date</td>'
								+ '<td>'
								+ date + '</td>' + '</tr>');

					})

		}
	})
}
