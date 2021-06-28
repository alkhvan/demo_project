
function getJson(meta) {
	return meta.json();
}

function getTxtFromJsonUndPackInsHTML(myjson) {
//	var tabelle = document.getElementById("tid001");
	var t_header = document.getElementById("thid001");
    var t_body = document.getElementById("tbid001");
	var i = 0;
	for (var laufvariable of myjson.personen) {
    		// new element in the table
    		t_body.insertAdjacentHTML("beforeend",
    		"<tr>"
    			+ `<td> ${++i}</td>`
    			+ "<td>" + laufvariable.id + "</td>"
    		//	+ "<td>" + laufvariable.id + "</td>"
    			+ "<td><img src='" + getImg(laufvariable.salutation) + "'></td>"
    			+ "<td>" + laufvariable.salutation + "</td>"
    			+ "<td>" + laufvariable.name + "</td>"
    			+ "<td>" + laufvariable.surname +"</td>"
    			+ "<td>" + laufvariable.birthdate +"</td>"
    			+ "<td>" + laufvariable.email + "</td>"
    		+ "</tr>")
}
}


function getImg(salutation) {
	switch (salutation) {
		case "Mr":
			return 'images/david.png';
		case "Mrs":
		case "Miss":
			return 'images/women.png';
		default:
			return 'images/frage.png';
	}
}

function createPerson(event) {   // bei event-click
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");
	var id = document.getElementById("id0012").value;
	var salutation = document.getElementById("salutation").value;
	var name = document.getElementById("name").value;
	var surname = document.getElementById("surname").value;
	var email = document.getElementById("email").value;
	var date = document.getElementById("birthdate").value;


	var jsonDataString = `{"id":"${id}","salutation":"${salutation}","name":"${name}","surname":"${surname}","email":"${email}","birthdate":"${date}"}`;
	console.log(jsonDataString);

	fetch("http://localhost:63342/json/person", {
		method: 'POST',
		body: jsonDataString,
		headers: {
			'Content-Type': 'application/json'
        }
	});
	refreshClick();
}





function removePerson (event){
event.preventDefault();
var id = document.getElementById("id0012").value;
    console.log(id);
    fetch(`http://localhost:63342/json/person/${id}`, {
        		method: 'DELETE'
        	});
refreshClick();
	}

function updatePerson (event){
event.preventDefault();
    var id = document.getElementById("id0012").value;
	var salutation = document.getElementById("salutation").value;
	var name = document.getElementById("name").value;
	var surname = document.getElementById("surname").value;
	var email = document.getElementById("email").value;
	var date = document.getElementById("birthdate").value;

	var jsonDataString = `{"id":"${id}","salutation":"${salutation}","name":"${name}","surname":"${surname}","email":"${email}","birthdate":"${date}"}`;
	console.log(jsonDataString);
    fetch(`http://localhost:63342/json/person`, {
    		method: 'PUT' ,
    		body: jsonDataString,
    		headers: {
    			'Content-Type': 'application/json'
    			}
    		});
refreshClick();
	}

function removeAllPerson (event){
    event.preventDefault();
    fetch(`http://localhost:63342/json/person/deleteAll`, {
            		method: 'DELETE'
            	});
    refreshClick();
    	}


//POST
var input = document.getElementById("button");
input.addEventListener("click",createPerson);

//DELETE
var input = document.getElementById("buttonremove");
input.addEventListener("click",removePerson);

//UPDATE
var input = document.getElementById("buttonupdate");
input.addEventListener("click",updatePerson);

//DELETE ALL
var input = document.getElementById("buttonclear");
input.addEventListener("click",removeAllPerson);

function refreshPersons(){
fetch("http://localhost:63342/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonUndPackInsHTML)
}

refreshPersons();


function refreshClick() {
	document.getElementById("tbid001").innerHTML="";
	refreshPersons();
}