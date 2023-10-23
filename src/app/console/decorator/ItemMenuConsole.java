package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.menu.Category;

public class ItemMenuConsole extends ConsoleDecorator {

	private final String initMessage = """
  
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
		""";
	private int categoryNumber;

	public ItemMenuConsole(Console console, int categoryNumber) {
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
		System.out.println(initMessage);
		System.out.printf("[ %s MENU ]\n", Category.getCategoryName(categoryNumber));
		Category.showCategoryProduct(categoryNumber);
	}

	private void validate(int input) {
		int categoryCount = Category.getCategorySize(categoryNumber);

		if (input < 0 || categoryCount < input) {
			throw new IllegalArgumentException();
		}
	}
}
