function uploadFile(){
	var file = $('input[name="upload_file"').get(0).files[0];
	 
	  var formData = new FormData();
	  formData.append('file', file);
	 
	  $.ajax({
	      url: "http://localhost:8080/LabSecFileUploaderService/labsec/challenge/upload-file",
	      type: 'POST',
	      xhr: function() {  // Custom XMLHttpRequest
	        var myXhr = $.ajaxSettings.xhr();
	        return myXhr;
	      },
	      // beforeSend: beforeSendHandler,
	      success: function(data) {
	        alert('successfully uploaded file with '+data+' lines');
	      },
	      // Form data
	      data: formData,
	      //Options to tell jQuery not to process data or worry about content-type.
	      cache: false,
	      contentType: false,
	      processData: false
	    });
//	alert('jquery click ok');
//	
//	var file = $('input[name="upload_file"').get(0).files[0];
//	var formData = new FormData();
//	formData.append('file', file);
//	$.ajax({
//	  url : 'http://localhost:8080/LabSecFileUploaderService/labsec/challenge/upload-file',
//	  type : 'POST',
//	  data : formData,
//	  cache : false,
//	  contentType : false,
//	  processData : false,
//	  success : function(data, textStatus, jqXHR) {
//	    var userObj = JSON.parse(jqXHR.responseText);
//	    alert(userObj);
//	  },
//	  error : function(jqXHR, textStatus, errorThrown) {
//	    alert(textStatus);
//	  }
//	});
}

$(document).ready(
		
	function(){
		$('#btnSendFile').click(uploadFile);
	}
);