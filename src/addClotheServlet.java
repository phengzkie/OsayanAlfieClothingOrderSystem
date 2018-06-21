import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class addClotheServlet extends HttpServlet
{
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST request from html na may tamang value");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String pn = request.getParameter("prodname");
		String t = request.getParameter("type");
		String c = request.getParameter("color");
		String d = request.getParameter("design");
		String p = request.getParameter("price");
		String g = request.getParameter("gender");
		String[] str = {pn, t, c, d, p, g};
		if(sd.insertClotheToDB(t, str)) {
			out.println("Clothe Added");
		}
		else {
			out.println("Adding Clothe Failed");
		}
		out.close();
	}

	public void destroy() {
		sd = null;
	}
}
