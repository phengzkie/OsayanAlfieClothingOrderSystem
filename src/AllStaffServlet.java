import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllStaffServlet extends HttpServlet
{
	StaffCollection sc;
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
		sc = sd.getStaffCollection();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml");
		StringBuffer sb = new StringBuffer("<staff>");
		for (int i = 0; i < sc.getStaffCount(); i++) {
			Staff staff = sc.getStaffByIndex(i);
			sb.append("<personnel><id>");
			sb.append(staff.getId() + "</id>");
			sb.append("<firstname>" + staff.getFirstName() + "</firstname>");
			sb.append("<lastname>" + staff.getLastName() + "</lastname>");
			sb.append("<email>" + staff.getEmail() + "</email>");
			sb.append("<number>" + staff.getNumber() + "</number>");
			sb.append("<address>" + staff.getAddress() + "</address></personnel>");
		}
		sb.append("</staff>");
		out.println(sb.toString());
		out.close();
	}

	public void destroy() {
		sc = null;
		sd = null;
	}
}
