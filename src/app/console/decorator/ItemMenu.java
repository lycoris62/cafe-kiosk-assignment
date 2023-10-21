package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.menu.Category;
import app.menu.Product;

public class ItemMenu extends ConsoleDecorator {

	private final String initMessage = """
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
				
		""";
	private final String titleFormat = "[ %s MENU ]\n";
	private int categoryNumber;

	public ItemMenu(Console console, int categoryNumber) {
		super(console);
		this.categoryNumber = categoryNumber;
	}

	@Override
	public int request() {
		showCategoryMenu(categoryNumber);
		int input = super.request();
		validate(input);

		return input;
	}

	private void showCategoryMenu(int categoryNumber) {
		StringBuilder sb = new StringBuilder("\n");
		sb.append(initMessage);
		sb.append(String.format(titleFormat, "오십이도"));

		int sequence = 1;

		for (Product item : Category.getCategoryItems(categoryNumber)) {
			sb.append(sequence++).append(". ")
				.append(item.toString())
				.append("\n");
		}

		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
	}

	private void validate(int input) {
		int categoryCount = Category.getCategorySize(categoryNumber);

		if (input < 0 || categoryCount < input) {
			throw new IllegalArgumentException();
		}
	}
}
