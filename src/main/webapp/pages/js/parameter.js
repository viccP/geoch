/**
 * 
 */
$(function($) {

	//editables on first profile page
	/* $.fn.editable.defaults.mode = 'inline';
	$.fn.editableform.loading = "<div class='editableform-loading'><i class='ace-icon fa fa-spinner fa-spin fa-2x light-blue'></i></div>";
	$.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="ace-icon fa fa-check"></i></button>'
			+ '<button type="button" class="btn editable-cancel"><i class="ace-icon fa fa-times"></i></button>'; */

	//text editable
	$('.username').editable({
		type : 'text',
		name : 'username',
		url : function(val) {
			console.log(val)
		}
	});
	
	$(".chosen-select").chosen({
		disable_search : true,
		width : "10%"
	});
});