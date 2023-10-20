package app.io.console.decorator;

import app.io.console.Console;
import app.io.console.ConsoleDecorator;
import app.menu.Category;

public class CategoryMenu extends ConsoleDecorator {

	private final String initMessage = """
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
				
		""";
	private final String titleFormat = "[ %s MENU ]\n";
	private int categoryNumber;

	public CategoryMenu(Console console, int categoryNumber) {
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

		for (app.menu.CategoryMenu item : Category.getCategoryItems(categoryNumber)) {
			sb.append(sequence++).append(". ")
				.append(item.toString())
				.append("\n");
		}

		sb.deleteCharAt(sb.length() - 1);

		System.out.println(sb);
	}

	private void validate(int input) {
		int categoryCount = Category.values().length;

		if (input < 0 || categoryCount < input) {
			throw new IllegalArgumentException();
		}
	}
}
