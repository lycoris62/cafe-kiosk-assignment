package app.order;

import java.util.ArrayList;
import java.util.List;

import app.domain.Item;

/**
 * 장바구니 객체로
 */
public class Cart {

	private final List<Item> itemList = new ArrayList<>();

	public void add(Item item) {
		itemList.add(item);
	}

	public List<Item> getAllItems() {
		return new ArrayList<>(itemList);
	}

	public void clear() {
		itemList.clear();
	}

	public boolean isEmpty() {
		return itemList.isEmpty();
	}
}
