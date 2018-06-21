window.onload = ()=> {
	document.getElementById('register').onclick = ()=> {
		let un = document.getElementById('username').value;
		let pw = document.getElementById('password').value;
		let fn = document.getElementById('fname').value;
		let ln = document.getElementById('lname').value;
		let em = document.getElementById('email').value;
		let mb = document.getElementById('mobile').value;
		let ad = document.getElementById('add').value;
		let rq = new XMLHttpRequest();
		console.log(un);
		console.log(fn);
		rq.onreadystatechange = ()=> {
			if(rq.readyState == 4) {
				
			}
		}
		rq.open("POST", "/clothingorder/adduser", true);
		rq.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		rq.send("username="+un+"&password="+pw+"&fname="+fn+"&lname="+ln+"&email="+em+"&mobile="+mb+"&add="+ad);
	}
}
