import java.math.BigDecimal;

public class Clothes
{
	private String productname;
	private String type;
	private String color;
	private BigDecimal price;
	private int quantity;

	public String getProductName() {
		return(productname);
	}

	public void setProductName(String pn) {
		productname = pn;
	}

	public String getType() {
		return(type);
	}

	public void setType(String t) {
		type = t;
	}

	public String getColor() {
		return(color);
	}

	public void setColor(String c) {
		color = c;
	}

	public BigDecimal getPrice() {
		return(price);
	}

	public void setPrice(BigDecimal p) {
		price = p;
	}

	public int getQuantity() {
		return(quantity);
	}

	public void setQuantity(int q) {
		quantity = q;
	}
}
