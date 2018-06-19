import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllUsersServlet extends HttpServlet
{
	UsersCollection uc;
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
		uc = sd.getUsersCollection();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml");
		StringBuffer sb = new StringBuffer("<users>");
		for (int i = 0; i < uc.getUsersCount(); i++) {
			Users users = uc.getUsersByIndex(i);
			sb.append("<username>" + users.getUsername() + "</username>");
			sb.append("<firstname>" + users.getFirstName() + "</firstname>");
			sb.append("<lastname>" + users.getLastName() + "</lastname>");
			sb.append("<email>" + users.getEmail() + "</email>");
			sb.append("<number>" + users.getNumber() + "</number>");
			sb.append("<address>" + users.getAddress() + "</address></user>");
		}
		sb.append("</users>");
		out.println(sb.toString());
		out.close();
	}

	public void destroy() {
		uc = null;
		sd = null;
	}
}
