$( document ).ready(function() {
    
    console.log("Import thanh Cong");
    
    $('#modalCreateUser .btn-ok').click(function(){
        console.log("Click OK");
        saveCreateUser();
    });
    
    
    // validateForm();
    
    addEventListener('DOMContentLoaded', function () {
        // Mong muốn của chúng ta
        Validator({
          form: '#formCreateUser',
          formGroupSelector: '.form-group',
          errorSelector: '.form-message',
          rules: [
            Validator.isRequired('#fullname', 'Vui lòng nhập tên đầy đủ của bạn'),
            Validator.isRequired('#firstNameUser', 'First name is required!!!'),
            Validator.isEmail('#email'),
            Validator.minLength('#password', 6),
            Validator.isRequired('#password_confirmation'),
            Validator.isConfirmed('#password_confirmation', function () {
              return document.querySelector('#form-1 #password').value;
            }, 'Mật khẩu nhập lại không chính xác')
          ],
          onSubmit: function (data) {
            // Call API
            console.log(data);
          }
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
};


$('#formCreateUser').on('hidden.bs.modal', function (e) {
  $(this)
    .find("input,textarea,select")
       .val('')
       .end()
    .find("input[type=checkbox], input[type=radio]")
       .prop("checked", "")
       .end();
       
  $('form#formCreateUser ')[0].reset();
})

$('#formCreateUser').on('hide.bs.modal', function (e) {
  $(this)
    .find("input,textarea,select")
       .val('')
       .end()
    .find("input[type=checkbox], input[type=radio]")
       .prop("checked", "")
       .end();
       
  $('form#formCreateUser ')[0].reset();
})

$('#formCreateUser').on('hidden.bs.modal', function(e) {
    console.log('test 1');
});



/*$('form#formCreateUser').on('hide.bs.modal', function(e) {
    console.log('test hide');
});

$('form#formCreateUser').on('hidden.bs.modal', function(e) {
    console.log('test hidden.bs.modal');
});*/


/*$(document).on('hide.bs.modal', '#formCreateUser', function(e) {
	 console.log('test hidden.bs.modal');
})*/



  