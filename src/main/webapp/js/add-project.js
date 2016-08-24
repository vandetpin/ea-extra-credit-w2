$(Document).ready(function(){
	
	$( "form" ).submit(function( event ) {
		event.preventDefault();
		
		var resource1 = $('#task-1-resource').val().split(",").map(function(r){
			return {description : r};
		});
		var resource2 = $('#task-1-resource').val().split(",").map(function(r){
			return {description : r};
		});
		var project = {
				imageUrl : $("#imageUrl").val(),
				description : $('#description').val(),
				status : $("#status").val(),
				expectedStartDate : $('#expectedStartDate').val(),
				expectedEndDate : $("#expectedEndDate").val(),
				location : $('#location').val(),
				tasks :[{
					description : $('#task-1-description').val(),
					status : $("#task-1-status").val(),
					timeFrame : $('#task-1-timeFrame').val(),
					resources : resource1
				},{
					description : $('#task-2-description').val(),
					status : $("#task-2-status").val(),
					timeFrame : $('#task-2-timeFrame').val(),
					resources : resource2
				}]
		
		};	
		
		// Send the data using post
		$.ajax({
			  url: "projects",
			  type:"POST",
			  data: JSON.stringify(project),
			  contentType:"application/json"
			}).done(function(url){
				window.location.replace(url);
			});
	});
	
});
