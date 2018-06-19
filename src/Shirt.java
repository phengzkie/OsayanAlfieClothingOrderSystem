import java.math.BigDecimal;

public class Shirt extends Clothes
{
	final int ID;
	private String design;
	private String size;
	private String gender;

	public Shirt(int id, String pn, String t, String c, BigDecimal p, int q, String d, String s, String g) {
		ID = id;
		setProductName(pn);
		setType(t);
		setColor(c);
		setPrice(p);
		setQuantity(q);
		design = d;
		size = s;
		gender = g;
	}

	public int getId() {
		return(ID);
	}

	public String getDesign() {
		return(design);
	}

	public String getSize() {
		return(size);
	}

	public String getGender() {
		return(gender);
	}
}
