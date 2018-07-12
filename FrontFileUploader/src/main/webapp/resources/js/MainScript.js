function resetForm(){
	$('#btnSendFile').prop('disabled',true);
	$('input[name="upload_file"]').val(null);
	$('input[name="upload_file"]').next(".custom-file-label").attr('data-content', 'Choose File');
	$('input[name="upload_file"]').next(".custom-file-label").text('Choose File');
}

function uploadFile() {
	var file = $('input[name="upload_file"').get(0).files[0];

	let formData = new FormData();
	formData.append('file', file);

	$.ajax({
		url : "http://localhost:8080/LabSecFileUploaderService/labsec/challenge/upload-file",
		type : 'POST',
		data : formData,
		// Options to configure jQuery for avoid process content-type. (let default multipart)
		cache : false,
		contentType : false,
		processData : false,
		success : function(data) {
			alert("The computed base64 encode of SHA-256 hash of uploaded file is: \n " + data);
			resetForm();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Error processing file: ' + textStatus);
			resetForm();
		},
	});
}

$(document).ready(

function() {
	// Disable Button before choose a file 
	$('#btnSendFile').prop('disabled',true);
	
	// Event handlers
	$('#btnSendFile').click(uploadFile);
	$('input[name="upload_file"]').change(function () {
		  var fieldVal = $(this).val();

		  // Removing the fake path added by default in Chrome
		  fieldVal = fieldVal.replace("C:\\fakepath\\", "");
		  
		  if (fieldVal != undefined || fieldVal != "") {
		    $(this).next(".custom-file-label").attr('data-content', fieldVal);
		    $(this).next(".custom-file-label").text(fieldVal);
		    $('#btnSendFile').prop('disabled',false);
		  }
		  else{
			  $('#btnSendFile').prop('disabled',true);
		  }
		});
	
});