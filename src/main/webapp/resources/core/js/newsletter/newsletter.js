function submit() {
	const newsletterForm = document.forms['newsletterForm'];
	const name = newsletterForm['name'].value
	const email = newsletterForm['email'].value;
	
	if(name && email) {
		$.ajax({
			type: 'POST',
			contentType: 'application/json',
			url: 'saveEmail',
			data: JSON.stringify({
				name: name, 
				email: email
			}),
			dataType: 'json',
			async: true,
			timeout: 10000,
			beforeSend: function() {
				showLoading();
		    },
			success: function(response) {
				hideLoading();
				if(response && response.status === 'SUCCESS') {
					showOk();
				} else {
					showError();
				}
			},
			error: function(e) {
				showError();
				console.log('ERROR: ', e);
			},
		});
	}
}

function showLoading() {
	$('#ok').hide();
	$('#error').hide();
	$('#loading').show();
}
function showOk() {
	$('#loading').hide();
	$('#ok').show();
}
function showError() {
	$('#loading').hide();
	$('#error').show();
}
function hideLoading() {
	$('#loading').hide();
}
function hideOk() {
	$('#ok').hide();
}
function hideError() {
	$('#error').hide();
}