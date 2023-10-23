package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.menu.Category;
import app.menu.Product;

public class PurchaseConsole extends ConsoleDecorator {

	private final int categoryNumber;
	private final int itemNumber;

	public PurchaseConsole(Console console, int categoryNumber, int itemNumber) {
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
		Product selectedItem = Category.getItem(categoryNumber, itemNumber);
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
