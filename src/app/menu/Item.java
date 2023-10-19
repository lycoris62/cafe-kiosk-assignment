package app.menu;

public class Item extends MenuItem{

	private final int price;

	public Item(String name, String description, int price) {
		super(name, description);
		this.price = price;
	}
}
