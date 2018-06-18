import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllClothesServlet extends HttpServlet
{
	ClothesCollection cc;

	public void init() throws ServletException {
		StoreDatabase sd = StoreDatabase.instance();
		cc = sd.getClothesCollection();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.println();
		out.close();
	}

	public void destroy() {
		cc = null;
	}
}
