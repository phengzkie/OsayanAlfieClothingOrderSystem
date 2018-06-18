public class Users
{
	final int ID;
	private String firstname;
	private String username;
	private String password;
	private String lastname;
	private String email;
	private String number;
	private String address;

	public Users(int id, String un, String pw, String fn, String ln, String e, String n, String add) {
		ID = id;
		username = un;
		password = pw;
		firstname = fn;
		lastname = ln;
		email = e;
		number = n;
		address = add;
	}
	public String getUsername() {
		return(username);
	}

	public String getPassword() {
		return(password);
	}

	public String getFirstName() {
		return(firstname);
	}

	public String getLastName() {
		return(lastname);
	}

	public String getEmail() {
		return(email);
	}

	public String getNumber() {
		return(number);
	}

	public String getAddress() {
		return(address);
	}
}
