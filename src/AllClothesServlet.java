import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AllClothesServlet extends HttpServlet
{
	ClothesCollection cc;
	StoreDatabase sd;

	public void init() throws ServletException {
		sd = StoreDatabase.instance();
		cc = sd.getClothesCollection();
	}
	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/xml");
		StringBuffer sb = new StringBuffer("<clothes>");
		for (int i = 0; i < cc.getClothesCount(); i++) {
			Clothes clothes = cc.getClothesByIndex(i);
			if(clothes instanceof Shirt) {
				Shirt s = (Shirt)clothes;
				sb.append("<shirts><productname>");
				sb.append(clothes.getProductName() + "</productname>");
				sb.append("<type>" + clothes.getType() + "</type>");
				sb.append("<color>" + clothes.getColor() + "</color>");
				sb.append("<price>" + clothes.getPrice() + "</price>");
				sb.append("<design>" + s.getDesign() + "</design>");
				sb.append("<gender>" + s.getGender() + "</gender></shirts>");
			}
			else if(clothes instanceof Other) {
				Other o = (Other)clothes;
				sb.append("<others><productname>");
				sb.append(clothes.getProductName() + "</productname>");
				sb.append("<type>" + clothes.getType() + "</type>");
				sb.append("<color>" + clothes.getColor() + "</color>");
				sb.append("<price>" + clothes.getPrice() + "</price>");
				sb.append("<gender>" + o.getGender() + "</gender></others>");
			}
		}
		sb.append("</clothes>");
		out.println(sb.toString());
		out.close();
	}

	public void destroy() {
		cc = null;
		sd = null;
	}
}
