package app.io.console.decorator;

import app.io.console.Console;
import app.io.console.ConsoleDecorator;
import app.menu.Category;
import app.menu.CategoryMenu;

public class Purchase extends ConsoleDecorator {

	private final int categoryNumber;
	private final int itemNumber;

	public Purchase(Console console, int categoryNumber, int itemNumber) {
		super(console);
		this.categoryNumber = categoryNumber;
		this.itemNumber = itemNumber;
	}

	@Override
	public int request() {
		showPurchaseCheck(categoryNumber, itemNumber);
		int input = super.request();
		validate(input);

		return input;
	}

	private void showPurchaseCheck(int categoryNumber, int itemNumber) {
		StringBuilder sb = new StringBuilder("\n");
		CategoryMenu selectedItem = Category.getCategoryItems(categoryNumber).get(itemNumber - 1);
		sb.append(selectedItem.toString()).append("\n")
			.append("위 메뉴를 장바구니에 추가하시겠습니까?\n")
			.append("1. 확인\t\t\t2. 취소");
		System.out.println(sb);
	}

	private void validate(int input) {
		if (input < 1 || 2 < input) {
			throw new IllegalArgumentException();
		}
	}
}
