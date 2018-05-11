import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items = new ArrayList<CartItem>();
	private int size;

	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	public void addItem(CartItem item) {
		this.items.add(item);
		size++;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public void addToCart(Hotel item, String start, String end, double price){
		CartItem cartitem = new CartItem();
		cartitem.setId(item.getHotelId());
		cartitem.setName(item.getHotelName());
		cartitem.setImage(item.getImage());
		cartitem.setRatings(item.getRatings());
		cartitem.setStart(start);
		cartitem.setEnd(end);
		cartitem.setPrice(price);
		items.add(cartitem);
		size++;
	}
}
