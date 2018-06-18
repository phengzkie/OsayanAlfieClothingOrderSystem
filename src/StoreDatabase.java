import java.util.ArrayList;
import java.lang.StringBuffer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

public class StoreDatabase
{
	private ClothesCollection clothes;
	private UsersCollection users;
	private StaffCollection staffs;
	Connection conn;
	static StoreDatabase _instance = null;

	public static StoreDatabase instance() {
		if(_instance == null) {
			_instance = new StoreDatabase();
		}
		return(_instance);
	}

	public StoreDatabase() {
		clothes = new ClothesCollection();
		users = new UsersCollection();
		staffs = new StaffCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/clothingstoredb?user=alfie&password=alfie123&serverTimezone=UTC&useSSL=false");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		getFromDB(conn);
	}

	public UsersCollection getUsersCollection() {
		return(users);
	}

	public ClothesCollection getClothesCollection() {
		return(clothes);
	}

	public StaffCollection getStaffCollection() {
		return(staffs);
	}

	public void addUsers(Users user) {
		if(insertUsersToDB(user)) {
			users.addUsers(user);
		}
	}

	boolean insertUsersToDB(Users user) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO users ( username, password, firstname, lastname, email, number, address ) VALUES ( ?, ?, ?, ?, ?, ?, ? );");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setString(6, user.getNumber());
			stmt.setString(7, user.getAddress());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public void addStaff(Staff staff) {
		if(insertStaffToDB(staff)) {
			staffs.addStaff(staff);
		}
	}

	boolean insertStaffToDB(Staff staff) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO staff ( firstname, lastname, number, email, address ) VALUES ( ?, ?, ?, ?, ? );");
			stmt.setString(2, staff.getFirstName());
			stmt.setString(3, staff.getLastName());
			stmt.setString(4, staff.getNumber());
			stmt.setString(5, staff.getEmail());
			stmt.setString(6, staff.getAddress());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public void addClothes(Clothes clothe) {
		if(insertClothesToDB(clothe)) {
			clothes.addClothes(clothe);
		}
	}

	boolean insertClothesToDB(Clothes clothe) {
		PreparedStatement stmt = null;
		try {
			if(clothe instanceof Shirt) {
				Shirt shirt = (Shirt)clothe;
				stmt = conn.prepareStatement("INSERT INTO shirts ( type, color, design, price, quantity, size, gender ) VALUES ( ?, ?, ?, ?, ?, ?, ? );");
				stmt.setString(1, shirt.getType());
				stmt.setString(2, shirt.getColor());
				stmt.setString(3, shirt.getDesign());
				stmt.setBigDecimal(4, shirt.getPrice());
				stmt.setInt(5, shirt.getQuantity());
				stmt.setString(6, shirt.getSize());
				stmt.setString(7, shirt.getGender());
				stmt.executeUpdate();
			}
			if(clothe instanceof Other) {
				Other other = (Other)clothe;
				stmt = conn.prepareStatement("INSERT INTO others ( productname, type, color, price, quantity, size, gender ) VALUES ( ?, ?, ?, ?, ?, ?, ? );");
				stmt.setString(1, other.getProductName());
				stmt.setString(2, other.getType());
				stmt.setString(3, other.getColor());
				stmt.setBigDecimal(4, other.getPrice());
				stmt.setInt(5, other.getQuantity());
				stmt.setString(6, other.getSize());
				stmt.setString(7, other.getGender());
				stmt.executeUpdate();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return(false);
		}
		finally {
			try { if(stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(true);
	}

	public boolean getFromDB(Connection conn) {
		ResultSet rs = null;
		boolean v = false;
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users;");
			while(rs.next()) {
				String[] str = {
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("number"),
					rs.getString("address"),
				};
				Users u = new Users(rs.getInt("userid"), str[0], str[1], str[2], str[3], str[4], str[5], str[6]);
				users.addUsers(u);
			}
			rs = stmt.executeQuery("SELECT * FROM staff;");
			while(rs.next()) {
				String[] str = {
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("number"),
					rs.getString("email"),
					rs.getString("address")
				};
				Staff s = new Staff(rs.getInt("staffid"), str[0], str[1], str[2], str[3], str[4]);
				staffs.addStaff(s);
			}
			rs = stmt.executeQuery("SELECT * FROM clothes;");
			while(rs.next()) {
				String[] str = {
					rs.getString("productname"),
					rs.getString("type"),
					rs.getString("color"),
					rs.getString("design"),
					rs.getString("size"),
					rs.getString("gender")
				};
				Shirt s = new Shirt(rs.getInt("clothesid"), str[0], str[1], str[2], rs.getBigDecimal("price"), rs.getInt("quantity"), str[3], str[4], str[5]);
				clothes.addClothes(s);
				Other o = new Other(rs.getInt("clothesid"), str[0], str[1], str[2], rs.getBigDecimal("price"), rs.getInt("quantity"), str[4], str[5]);
				clothes.addClothes(o);
			}
			v = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(v);
	}
}
