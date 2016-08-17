$(document).ready(function() {
	$(":checkbox").change(function() {
		var cnt = $("#person").val();

		if (cnt == $(":checkbox:checked").length) {
			$(":checkbox:not(:checked)").attr("disabled", "disabled");
		}

		else {
			$(":checkbox").removeAttr("disabled");
		}
	});

	$("#person").change(function() {
		$(":checkbox").removeAttr("checked");
		$(":checkbox").removeAttr("disabled");		
	});
});