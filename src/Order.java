import java.util.Date;

public class Order
{
	final int ID;
	private int clothesid;
	private int userid;
	private int quantity;
	private String size;
	private Date orderdate;

	public Order(int id, int cid, int uid, int q, String s, Date od) {
		ID = id;
		clothesid = cid;
		userid = uid;
		quantity = q;
		size = s;
		orderdate = od;
	}

	public int getId() {
		return(ID);
	}

	public int getClothesId() {
		return(clothesid);
	}

	public void setClothesId(int cid) {
		clothesid = cid;
	}

	public int getUserId() {
		return(userid);
	}

	public void setUserId(int uid) {
		userid = uid;
	}

	public int getQuantity() {
		return(quantity);
	}

	public void setQuantity(int q) {
		quantity = q;
	}

	public String getSize() {
		return(size);
	}

	public void setSize(String s) {
		size = s;
	}

	public Date getOrderDate() {
		return(orderdate);
	}

	public void setOrderDate(Date od) {
		orderdate = od;
	}
}
