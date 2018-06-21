import java.math.BigDecimal;

public class Shirt extends Clothes
{
	final int ID;
	private String design;
	private String gender;

	public Shirt(int id, String pn, String t, String c, BigDecimal p, String d, String g) {
		ID = id;
		setProductName(pn);
		setType(t);
		setColor(c);
		setPrice(p);
		design = d;
		gender = g;
	}

	public int getId() {
		return(ID);
	}

	public String getDesign() {
		return(design);
	}

	public String getGender() {
		return(gender);
	}
}
