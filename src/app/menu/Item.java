package app.menu;

public class Item extends MenuItem {

	private final int price;

	public Item(CategoryMenu categoryMenu) {
		super(categoryMenu.getMenuName(), categoryMenu.getDescription());
		this.price = categoryMenu.getPrice();
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%-15s | ₩ %2.1f | %s", name, price / 1000.0, description);
	}
}
