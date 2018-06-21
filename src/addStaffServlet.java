import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addStaffServlet extends HttpServlet
{
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST request from html na may tamang value");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String em = request.getParameter("email");
		String mn = request.getParameter("mobile");
		String add = request.getParameter("add");
		String[] str = {fn, ln, em, mn, add};
		if(sd.insertStaffToDB(str)) {
			out.println("Staff Added");
			System.out.println("na add na staff");
		}
		else {
			out.println("Adding Staff Failed");
		}
		out.close();
	}

	public void destroy() {
		sd = null;
	}
}
