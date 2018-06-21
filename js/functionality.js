window.onload = ()=> {
	document.getElementById('add-staff').onclick = ()=> {
		let fn = document.getElementById('fname').value;
		let ln = document.getElementById('lname').value;
		let em = document.getElementById('email').value;
		let mb = document.getElementById('mobile').value;
		let ad = document.getElementById('add').value;
		console.log(fn);
		console.log(ln);
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = ()=> {
			if(rq.readyState == 4) {
				
			}
		}
		rq.open("POST", "/clothingorder/addstaff", true);
		rq.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		rq.send("fname="+fn+"&lname="+ln+"&email="+em+"&mobile="+mb+"&add="+ad);
	}
	document.getElementById('staff').onclick = ()=> {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4 && rq.status == 200) {
				let xmlDoc = rq.responseXML;
				let table="<tr><th>ID</th><th>Firstname</th><th>Lastname</th><th>Email</th><th>Number</th><th>Address</th></tr>";
				var xml = xmlDoc.getElementsByTagName("personnel");
				for (i = 0; i <xml.length; i++) {
					table += "<tr><td>" + xml[i].getElementsByTagName("id")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("firstname")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("lastname")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("email")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("number")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("address")[0].childNodes[0].nodeValue + "</td></tr>";
				}
				document.getElementById("container").innerHTML = "";
				document.getElementById("container-form").innerHTML = "";
				document.getElementById("container").innerHTML = table;
			}
		};
		rq.open("GET", "/clothingorder/staff", false);
		rq.send();
	}
	document.getElementById('users').onclick = ()=> {
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = function() {
			if(rq.readyState == 4 && rq.status == 200) {
				let xmlDoc = rq.responseXML;
				let table="<tr><th>ID</th><th>Username</th><th>Firstname</th><th>Lastname</th><th>Email</th><th>Number</th><th>Address</th></tr>";
				var xml = xmlDoc.getElementsByTagName("user");
				for (i = 0; i <xml.length; i++) {
					table += "<tr><td>" + xml[i].getElementsByTagName("id")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("username")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("firstname")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("lastname")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("email")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("number")[0].childNodes[0].nodeValue + "</td><td>" + xml[i].getElementsByTagName("address")[0].childNodes[0].nodeValue + "</td></tr>";
				}
				document.getElementById("container").innerHTML = "";
				document.getElementById("container-form").innerHTML = "";
				document.getElementById("container").innerHTML = table;
			}
		};
		rq.open("GET", "/clothingorder/users", false);
		rq.send();
	}
	document.getElementById('staff-div').onclick = ()=> {
		document.getElementById("container").innerHTML = "";
		document.getElementById("container-form").innerHTML = document.getElementById("form-staff-div").innerHTML;
	}
}
