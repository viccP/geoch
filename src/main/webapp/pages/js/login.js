/**
 * 
 */
$(function(){
	$('#loginForm').bootstrapValidator({
		fields: {
			loginId: {
                validators: {
                    notEmpty: {
                        message: '请输入用户名'
                    },
                    regexp: {
                        regexp: /^.*$/,
                        message: '用户名或密码错误'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '请输入登录密码'
                    } 
                }
            }
        },
        submitHandler: function(validator, form, submitButton) {
        		var loginId = $("#loginForm input[name=loginId]").val();
        		var password = $.md5($("#loginForm input[name=password]").val());
			$.ajax({
				url : $.cxt+"/index/login",
				type : "POST",
				async : false,
				dataType: "json",
				data:{"loginId":loginId,"password":password},
				success : function(data) {
					if(data.code == 0){
						location.href =$.cxt+'/pages/main.jsp';
					}
					else if(data.code == 1){
						validator.updateStatus("loginId", 'INVALID', "regexp");
					}
					
					$('#submitBtn').removeAttr("disabled");
				}
			});
        }
	});
});