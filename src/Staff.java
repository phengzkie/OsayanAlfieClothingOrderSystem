public class Staff
{
	final int ID;
	private String firstname;
	private String lastname;
	private String email;
	private String number;
	private String address;

	public Staff(int id, String fn, String ln, String e, String n, String add) {
		ID = id;
		firstname = fn;
		lastname = ln;
		email = e;
		number = n;
		address = add;
	}

	public int getId() {
		return(ID);
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
