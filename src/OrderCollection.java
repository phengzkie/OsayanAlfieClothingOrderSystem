import java.util.ArrayList;

public class OrderCollection
{
	private ArrayList<Order> orders;

	public OrderCollection() {
		orders = new ArrayList<Order>();
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void removeOrder(Order order) {
		orders.remove(order);
	}

	public ArrayList<Order> getAllOrders() {
		return(orders);
	}

	public Order getOrderByIndex(int n) {
		return(orders.get(n));
	}

	public int getOrderCount() {
		return(orders.size());
	}
}
