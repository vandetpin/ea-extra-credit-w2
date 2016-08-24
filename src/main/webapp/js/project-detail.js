function onRemove(projectId) {
	$.ajax({
		  url: "projects/" + projectId,
		  type:"DELETE",
		}).done(function(url){
			window.location.replace(url);
		});
}
