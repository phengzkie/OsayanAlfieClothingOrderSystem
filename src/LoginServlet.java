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
		response.setContentType("text/html");
		String un = request.getParameter("username");
		String pw = request.getParameter("password");
		System.out.println(un);
		System.out.println(pw);
		System.out.println(request.getRequestURI());
		if(sd.checkUser(un, pw)) {
			System.out.println("naka login na");
			out.print("Welcome, " + un);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userdashboard.html");
			dispatcher.forward( request, response );
		}
		else {
			out.println("Username or Password incorrect");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
			dispatcher.forward( request, response );
		}
		out.close();
	}

	public void destroy() {
		sd = null;
	}
}
