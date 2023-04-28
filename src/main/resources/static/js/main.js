		function disableOption(value, select1, select2, select3, select4,
				select5, select6) {
			$('#' + select1 + ' option[value="' + value + '"]').prop(
					'disabled', true);
			$('#' + select2 + ' option[value="' + value + '"]').prop(
					'disabled', true);
			$('#' + select3 + ' option[value="' + value + '"]').prop(
					'disabled', true);
			$('#' + select4 + ' option[value="' + value + '"]').prop(
					'disabled', true);
			$('#' + select5 + ' option[value="' + value + '"]').prop(
					'disabled', true);
			$('#' + select6 + ' option[value="' + value + '"]').prop(
					'disabled', true);
		}
		function enableAll() {
			$("select option").prop("disabled", false);
		}

		$(document).ready(
				function() {
					$("select.select1").change(
							function() {
								var selectedVal = $(this).val();
								$("select:not(.select1) option").prop(
										"disabled", false);
								$(
										"select:not(.select1) option[value='"
												+ selectedVal + "']").prop(
										"disabled", true);
							});
					$("#resetBtn").click(function() {
						enableAll();
					});
				});