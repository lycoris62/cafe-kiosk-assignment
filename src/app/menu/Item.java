package app.menu;

import java.util.Objects;

public class Item extends Menu {

	private final int price;

	public Item(Product product) {
		super(product.getMenuName(), product.getDescription());
		this.price = product.getPrice();
	}

	public int getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof Item item) {
			return isPropertyEqualed(item);
		}

		return false;
	}

	private boolean isPropertyEqualed(Item item) {
		if (!item.getName().equals(this.name)){
			return false;
		}
		if (!item.getDescription().equals(this.description)){
			return false;
		}
		return item.getPrice() == this.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, description, price);
	}

	@Override
	public String toString() {
		return String.format("%-15s | ₩ %2.1f | %s", name, price / 1000.0, description);
	}

	public String toStringWithCount(int itemCount) {
		return String.format("%-15s | ₩ %3.1f | %2d개 | %-20s", name, price / 1000.0, itemCount, description);
	}
}
