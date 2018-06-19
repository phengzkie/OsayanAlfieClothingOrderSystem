import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet
{
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		System.out.println(un);
		System.out.println(pw);
		if(sd.checkUser(un, pw)) {
			// RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			// rs.forward(request, response);
			System.out.println("Nakalogin na");
		}
		else {
			out.println("Username or Password incorrect");
			System.out.println("Mali");
			// RequestDispatcher rs = request.getRequestDispatcher("index.html");
			// rs.include(request, response);
		}
	}

	public void destroy() {
		sd = null;
	}
}
