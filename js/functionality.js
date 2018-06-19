window.onload = ()=> {
	var hreflogin = document.getElementById('href-login');
	hreflogin.onclick = ()=> {
		document.getElementById("login-form").style.display = 'inline';
	};
	var hrefsignup = document.getElementById('href-signup');
	hrefsignup.onclick = ()=> {
		document.getElementById("signup-form").style.display = 'inline';
	};
	var login = document.getElementById('login');
	login.onclick = ()=> {
		let un = document.getElementById('username').value;
		let pw = document.getElementById('password').value;
		let rq = new XMLHttpRequest();
		rq.onreadystatechange = ()=> {
			if(rq.readyState == 4) {

			}
		}
		rq.open("GET", "/clothingorder/login?username="+un+"&password="+pw, true);
		rq.send();
	};
	var signup = document.getElementById('signup');
	signup.onclick = ()=> {
		let un = document.getElementById('username').value;
		let pw = document.getElementById('password').value;
		let fn = document.getElementById('fname').value;
		let ln = document.getElementById('lname').value;
		let em = document.getElementById('email').value;
		let mb = document.getElementById('mobile').value;
		let ad = document.getElementById('add').value;
		let rq = new XMLHttpRequest();
		console.log(un);
		rq.onreadystatechange = ()=> {
			if(rq.readyState == 4) {

			}
		}
		rq.open("POST", "/clothingorder/signup", true);
		rq.send("?username="+un+"&password="+pw+"&fname="+fn+"&lname="+ln+"&email="+em+"&mobile="+mb+"&add="+ad);
	};
}