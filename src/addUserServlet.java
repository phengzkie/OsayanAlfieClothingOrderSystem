import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addUserServlet extends HttpServlet
{
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST request from html na may tamang value");
		Users user = new Users(1, request.getParameter("username"), request.getParameter("password"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email"), request.getParameter("mobile"), request.getParameter("add"));
		sd.addUser(user);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.close();
	}

	public void destroy() {
		sd = null;
	}
}
