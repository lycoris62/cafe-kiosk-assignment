package app.menu;

public class Item extends MenuItem {

	private final int price;

	public Item(Product product) {
		super(product.getMenuName(), product.getDescription());
		this.price = product.getPrice();
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%-15s | ₩ %2.1f | %s", name, price / 1000.0, description);
	}
}
