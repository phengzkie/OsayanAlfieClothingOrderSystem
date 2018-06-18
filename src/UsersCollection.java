import java.util.ArrayList;

public class UsersCollection
{
	ArrayList<Users> users;

	public UsersCollection() {
		users = new ArrayList<Users>();
	}

	public void addUsers(Users user) {
		users.add(user);
	}

	public void removeUsers(Users user) {
		users.remove(user);
	}

	public ArrayList<Users> getAllUsers() {
		return(users);
	}

	public Users getUsersByIndex(int n) {
		return(users.get(n));
	}

	public int getUsersCount() {
		return(users.size());
	}
}
