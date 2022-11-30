$( document ).ready(function() {
    
    console.log("Import thanh Cong");
    
    $('#modalCreateUser .btn-ok').click(function(){
        console.log("Click OK");
        saveCreateUser();
    });
    
    
    
    
});

function saveCreateUser() {
	
	var formData = new FormData();
	formData.append('email', $("#emailUser").val());
	formData.append('firstName', $("#firstNameUser").val());
	formData.append('lastName', $("#lastNameUser").val());
	formData.append('password', $("#passwordUser").val());
	
	$.ajax({
		url : window.location.href + 'users/create_user',
	        type : "POST",
	        contentType : false,
	        data : formData,
	        /*enctype : 'multipart/form-data',*/
	        async : true,
	        cache : false,
	        processData : false,
	        beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeaderName, csrfValue);
			},
	        success : function(result) {
	        	console.log("OK POST");
	        },
	})
	
}