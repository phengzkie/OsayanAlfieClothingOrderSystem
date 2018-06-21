window.onload = ()=> {
	document.getElementById('login').onclick = ()=> {
		let un = document.getElementById('username').value;
		let pw = document.getElementById('password').value;
		let rq = new XMLHttpRequest();
		console.log(un);
		console.log(pw);
		rq.onreadystatechange = ()=> {
			if(rq.readyState == 4) {

			}
		}
		rq.open("GET", "/clothingorder/login?username="+un+"&password="+pw, true);
		rq.send();
	}
}
