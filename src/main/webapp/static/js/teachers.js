$(document).ready(function() {
	$('#btn').on("click", function(e) {
		//e.preventDefault()
 		fetchTeachersFromJSON()
 	})
 })
 
function fetchTeachersFromJSON() {
    let lastname = $('#searchInput').val().trim()
    
    let xhr = new XMLHttpRequest();
    xhr.open('GET', `/teachers-webapp-jsp-mysql/teachersrest?lastname=${lastname}`, true);
   
    xhr.timeout = 5000
    xhr.ontimeout = (e) => onAPIError()
      
    xhr.onreadystatechange = function() {
		
	    if (xhr.readyState == 4) 
	    {		   
	        if (xhr.status == 200) {           
	            handleResults(JSON.parse(xhr.responseText))       
	        } else {
	            alert('ERROR');
	        }
	    } 
     }
	 
	 xhr.send()  
}


function onAPIError() {
	alert("On API Error")
}

function handleResults(response) {
    let teachersList = response;
   
    if (jQuery.isEmptyObject(response)) {
    	$(".teachers-list").html("No teacher was found");
    } else {   
	    let output = "<tr><th>Id</th><th>Όνομα</th><th>Επώνυμο</th></tr>";
	
	    for (let teacher of teachersList) {
	        output += "<tr><td>"
	        + teacher.id
	        + "</td><td>"
	        + teacher.fname
	        + "</td><td>"
	        + teacher.sname
	        + "</td></tr>";
	    }
	
	    $(".teachers-list").html(output);
    }
}