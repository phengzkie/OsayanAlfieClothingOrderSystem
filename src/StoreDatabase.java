import java.util.ArrayList;
import java.util.Date;
import java.lang.StringBuffer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class StoreDatabase
{
	private ClothesCollection clothes;
	private UsersCollection users;
	private StaffCollection staff;
	private OrderCollection orders;
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
		staff = new StaffCollection();
		orders = new OrderCollection();
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
		return(staff);
	}

	public OrderCollection getOrderCollection() {
		return(orders);
	}

	public boolean insertUserToDB(String... str) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO users ( username, password, firstname, lastname, email, number, address ) VALUES ( ?, ?, ?, ?, ?, ?, ? );");
			stmt.setString(1, str[0]);
			stmt.setString(2, str[1]);
			stmt.setString(3, str[2]);
			stmt.setString(4, str[3]);
			stmt.setString(5, str[4]);
			stmt.setString(6, str[5]);
			stmt.setString(7, str[6]);
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

	public boolean insertStaffToDB(String... str) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO staff ( firstname, lastname, number, email, address ) VALUES ( ?, ?, ?, ?, ? );");
			stmt.setString(1, str[0]);
			stmt.setString(2, str[1]);
			stmt.setString(3, str[2]);
			stmt.setString(4, str[3]);
			stmt.setString(5, str[4]);
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

	public boolean insertOrderToDB(String... str) {
		PreparedStatement stmt = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str[4]);
			stmt = conn.prepareStatement("INSERT INTO orders ( clothesid, userid, quantity, size, orderdate ) VALUES ( ?, ?, ?, ?, ? );");
			stmt.setInt(2, Integer.parseInt(str[0]));
			stmt.setInt(3, Integer.parseInt(str[1]));
			stmt.setInt(4, Integer.parseInt(str[2]));
			stmt.setString(5, str[3]);
			stmt.setDate(6, new java.sql.Date(date.getTime()));
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

	public boolean insertClotheToDB(String type, String... str) {
		PreparedStatement stmt = null;
		try {
			if("Shirt".equals(type)) {
				stmt = conn.prepareStatement("INSERT INTO clothes ( productname, type, color, design, price, gender ) VALUES ( ?, ?, ?, ?, ?, ? );");
				stmt.setString(1, str[0]);
				stmt.setString(2, str[1]);
				stmt.setString(3, str[2]);
				stmt.setString(4, str[3]);
				stmt.setBigDecimal(5, new BigDecimal(str[4]));
				stmt.setString(6, str[5]);
				stmt.executeUpdate();
			}
			if("Other".equals(type)) {
				stmt = conn.prepareStatement("INSERT INTO clothes ( productname, type, color, price, gender ) VALUES ( ?, ?, ?, ?, ? );");
				stmt.setString(1, str[0]);
				stmt.setString(2, str[1]);
				stmt.setString(3, str[2]);
				stmt.setBigDecimal(4, new BigDecimal(str[4]));
				stmt.setString(5, str[5]);
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
					String.valueOf(rs.getInt("userid")),
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("number"),
					rs.getString("address"),
					"user"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM staff;");
			while(rs.next()) {
				String[] str = {
					String.valueOf(rs.getInt("staffid")),
					rs.getString("firstname"),
					rs.getString("lastname"),
					rs.getString("email"),
					rs.getString("number"),
					rs.getString("address"),
					"staff"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM clothes;");
			while(rs.next()) {
				String[] str = {
					String.valueOf(rs.getInt("clothesid")),
					rs.getString("productname"),
					rs.getString("color"),
					String.valueOf(rs.getBigDecimal("price")),
					rs.getString("design"),
					rs.getString("gender"),
					rs.getString("type")
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM orders;");
			while(rs.next()) {
				String[] str = {
					String.valueOf(rs.getInt("orderid")),
					String.valueOf(rs.getInt("clothesid")),
					String.valueOf(rs.getInt("userid")),
					String.valueOf(rs.getInt("quantity")),
					rs.getString("size"),
					String.valueOf(rs.getDate("orderdate")),
					"order"
				};
				createObject(str);
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

	public void createObject(String... str) {
		int len = str.length-1;
		String d = str[len];
		switch(d) {
			case "user" :
				Users user = new Users(Integer.parseInt(str[0]), str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
				users.addUser(user);
				break;
			case "staff" :
				Staff s = new Staff(Integer.parseInt(str[0]), str[1], str[2], str[3], str[4], str[5]);
				staff.addStaff(s);
				break;
			case "Shirt" :
				Shirt shirt = new Shirt(Integer.parseInt(str[0]), str[1], str[6], str[2], new BigDecimal(str[3]), str[4], str[5]);
				clothes.addClothes(shirt);
				break;
			case "Other" :
				Other other = new Other(Integer.parseInt(str[0]), str[1], str[6], str[2], new BigDecimal(str[3]), str[5]);
				clothes.addClothes(other);
				break;
			case "order" :
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str[5]);
					Order order = new Order(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), str[4], date);
					orders.addOrder(order);
				}
				catch(Exception e) {}
		}
	}

	public boolean checkUser(String un, String pw) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean st = false;
		try{
			stmt = conn.prepareStatement("SELECT * FROM users where username = ? AND password = ?;");
			stmt.setString(1, un);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(st);
	}

	public boolean checkAvailability(String un, String em) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean st = false;
		try{
			stmt = conn.prepareStatement("SELECT * FROM users where username = ? OR email = ?;");
			stmt.setString(1, un);
			stmt.setString(2, em);
			rs = stmt.executeQuery();
			st = rs.next();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {};
			try { if (stmt != null) stmt.close(); } catch (Exception e) {};
		}
		return(st);
	}
}
