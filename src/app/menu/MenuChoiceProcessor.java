package app.menu;

import java.util.List;

public class MenuChoiceProcessor {

	public Order choose(int categoryNumber, int itemNumber) {
		CategoryMenu categoryMenu = Category.getCategoryItems(categoryNumber).get(itemNumber - 1);
		Item item = new Item(categoryMenu);

		return new Order(List.of(item));
	}
}
