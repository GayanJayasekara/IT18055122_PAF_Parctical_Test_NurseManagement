$(document).ready(function()
{
	$("#alertSuccess").hide();
	
	$("#alertError").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide(); 
	
	//Form validation-------------------
	var status = validateNurseForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	

	// If valid-------------------------
	
	//$("#formNurse").submit();
	
	
	var type = ($("#hidnurse_idSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
			{
				url : "NurseAPI",
				type : type,
				data : $("#formNurse").serialize(),
				dataType : "text",
				complete : function(response, status) {
					onNurseSaveComplete(response.responseText, status);
				}
			});
	
	
 });

	


function onNurseSaveComplete(response, status) {
	if (status == "success")
		{
			var resultSet = JSON.parse(response);
			
			if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully saved.");
				$("#alertSuccess").show();
				
				$("#divNurseGrid").html(resultSet.data);
				}else if (resultSet.status.trim() == "error")
					{
					$("#alertError").text(resultSet.data);
					$("#alertError").show();
					
					}
		}else if (status == "error")
		{
			$("#alertError").text("Error while saving.");
			$("#alertError").show();
		}else
			{
			$("#alertError").text("UnKnown error while saving..");
			$("#alertError").show();
			}
	
		$("#hidnurse_idSave").val("");
		$("#formNurse")[0].reset();
	
}

//(doctorID, doctorName, doctorAge, doctorSpe, doctorContact, doctorEmail)"

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidnurse_idSave").val($(this).closest("tr").find('#hidnurse_idUpdate').val());
	$("#nurse_name").val($(this).closest("tr").find('td:eq(0)').text());
	$("#nurse_age").val($(this).closest("tr").find('td:eq(1)').text());
	$("#nurse_tele").val($(this).closest("tr").find('td:eq(2)').text());
	$("#nurse_email").val($(this).closest("tr").find('td:eq(3)').text());
	$("#nurse_ward").val($(this).closest("tr").find('td:eq(4)').text());
});

// REMOVE=========================================================
$(document).on("click", ".btnRemove", function(event)
		{
			$.ajax(
					{
						url : "NurseAPI",
						type : "DELETE",
						data : "nurse_id=" + $(this).data("nurseid"),
						dataType : "text",
						complete : function(response, status)
						{
							onNurseDeleteComplete(response.responseText, status);
						}
					});
		});

function onNurseDeleteComplete(response, status) {
	if (status == "success")
		{
			var resultSet = JSON.parse(response);
			
			if (resultSet.status.trim() == "success")
				{
				$("#alertSuccess").text("Successfully Delete.");
				$("#alertSuccess").show();
				
				$("#divNurseGrid").html(resultSet.data);
				}else if (resultSet.status.trim() == "error")
					{
					$("#alertError").text(resultSet.data);
					$("#alertError").show();
					
					}
		}else if (status == "error")
		{
			$("#alertError").text("Error while deleting.");
			$("#alertError").show();
		}else
			{
			$("#alertError").text("UnKnown error while deleting..");
			$("#alertError").show();
			}
	
		$("#hidnurse_idSave").val("");
		$("#formNurse")[0].reset();
	
}

//CLIENT-MODEL================================================================
function validateNurseForm()
{
	// Name
	if ($("#nurse_name").val().trim() == "")
	{
		return "Insert Nurse name.";
	}
	
	// Age
	if ($("#nurse_age").val().trim() == "")
	{
		return "Insert age.";
	}

	
	// Specialization
	if ($("#nurse_tele").val().trim() == "")
	{
		return "Insert valid Telephone.";
	}
	
	// Contact Number
	if ($("#nurse_email").val().trim() == "")
	{
		return "Insert valid email.";
	}
	
	// Email
	if ($("#nurse_ward").val().trim() == "")
	{
		return "Insert ward.";
	}
	
	
	return true;
	}
