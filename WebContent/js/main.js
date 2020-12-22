$(document).on("change", "#select-genre", function() {
                var genreValue = $( "#select-genre" ).val();
				var genre = {"genre" : genreValue};
				$.post("ControlListerLivresParTheme", genre)
				    .done(function(reponse) {
					    $("#list-livres").empty();
						var result = JSON.parse(reponse);
						let table = document.createElement("table");
						let contentHTML = ""
						let counter = 1;
						result.forEach( (item) =>{
							contentHTML += (`
								<tr>
						            <td><input type="radio" name="livre_id" id="livre-${counter}" value="${item.id}" /></td>
						            <td> <label for="livre-${counter}"> ${item.titre} </label> </td>
						        </tr>
						     `);
							counter++;
						});
						table.innerHTML = contentHTML;
						let parent = document.getElementById("list-livres");
					 	parent.append(table);
               		 });
            });

let menuEntries = document.querySelectorAll(".menu-trigger");

menuEntries.forEach((item) => {
	item.addEventListener("click", toggleMenu);
});


function toggleMenu(event) {
	let element = event.target;
	console.log("####");
	console.log(element);
	
	let links = element.nextElementSibling;
	if (links.style.display === "block") {
    	links.style.display = "none";
	} else {
		links.style.display = "block";
    }
}
