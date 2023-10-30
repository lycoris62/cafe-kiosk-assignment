package app.domain;

import java.util.List;

public class Order {

	private final List<Item> itemList;

	public Order(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Item> getItemList() {
		return itemList;
	}
}
