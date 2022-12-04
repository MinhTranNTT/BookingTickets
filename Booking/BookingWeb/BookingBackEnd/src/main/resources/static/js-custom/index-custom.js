$( document ).ready(function() {
    
    $('#modalCreateUser .btn-ok').click(function(){
        console.log("Click OK");
        saveCreateUser();
    });
    
    $('#modalCreateUser .btn-clx').click(function(){
        console.log("Click CLX");
        $('#formCreateUser')[0].reset();
    });
    
    $('#btn-create-user').click(function(){
        initDataRolesInForm();
    });
    
    // validateForm();
    
    addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
        Validator({
          form: '#formCreateUser',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isRequired('#firstNameUser', 'First name is required!!!'),
            Validator.isRequired('#lastNameUser', 'Last name is required!!!'),
            
            Validator.isEmail('#emailUser'),
            Validator.minLength('#passwordUser', 6),
            
            
            Validator.isRequired('#password_confirmation'),
            Validator.isConfirmed('#password_confirmation', function () {
              return document.querySelector('#form-1 #password').value;
            }, 'Mật khẩu nhập lại không chính xác')
          ]
        });


        /*Validator({
          form: '#form-2',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isEmail('#email'),
            Validator.minLength('#password', 6),
          ],
          onSubmit: function (data) {
            // Call API
            console.log(data);
          }
        });*/
      	console.log("MID");  
      })
      
      console.log("END");
      

});

function saveCreateUser() {
	
	var selected = [];
	$('#chk-role .checkbox input[type="checkbox"]:checked').each(function() {
	    selected.push($(this).attr('id'));
	});
	
	var formData = new FormData();
	formData.append('email', $("#emailUser").val());
	formData.append('firstName', $("#firstNameUser").val());
	formData.append('lastName', $("#lastNameUser").val());
	formData.append('password', $("#passwordUser").val());
	//formData.append('strRoles', JSON.stringify());
	strRoles = selected.toString();
	
	$.ajax({
		url : window.location.href + 'users/create_user' + '?strRoles=' + strRoles,
	        type : "POST",
	        contentType : false,
	        data : formData,
	        enctype : 'multipart/form-data',
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
};

function initDataRolesInForm() {
	$.ajax({
		url : window.location.href + 'users/data_role',
	        type : "POST",
	        beforeSend: function(xhr) {
				xhr.setRequestHeader(csrfHeaderName, csrfValue);
			},
	        success : function(data) {
		
				if (data != "400") {
					data = JSON.parse(data);
					var s = '';
					
					for (var i=0; i < data.listRoles.length; i++) {
						s += `<div class="checkbox checkbox-circle">
									<input id="${data.listRoles[i].id}" type="checkbox">
									<label class="f-bold-l f-italic" for="${data.listRoles[i].id}">${data.listRoles[i].name}</label>
									<span>${data.listRoles[i].description}</span>
								</div>`;
					}
					$('#chk-role').html(s);
					console.log("OK POST ROLE");
				} else {
					console.log("INIT DATA NOT WORK");	
				}
	        	
	        },
	})
}
  