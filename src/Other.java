import java.math.BigDecimal;

public class Other extends Clothes
{
	final int ID;
	private String gender;

	public Other(int id, String pn, String t, String c, BigDecimal p, String g) {
		ID = id;
		setProductName(pn);
		setType(t);
		setColor(c);
		setPrice(p);
		gender = g;
	}

	public int getId() {
		return(ID);
	}

	public String getGender() {
		return(gender);
	}
}
