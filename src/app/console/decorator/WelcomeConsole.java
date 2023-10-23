package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.menu.Category;

public class WelcomeConsole extends ConsoleDecorator {

	private final String initMessage = """
  
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
		""";

	public WelcomeConsole(Console console) {
		super(console);
	}

	@Override
	public int request() {
		showMainMenu();
		int input = super.request();
		validate(input);

		return input;
	}

	private void showMainMenu() {
		System.out.println(initMessage);
		System.out.println("[ 오십이도 MENU ]");

		Category.showCategory();

		System.out.println("[ ORDER MENU ]\n");
		System.out.printf(String.format("%d. %-20s | %-20s\n", Category.size() + 1, "Order", "장바구니를 확인 후 주문합니다."));
		System.out.printf(String.format("%d. %-20s | %-20s\n", Category.size() + 2, "Cancel", "진행중인 주문을 취소합니다."));
	}

	private void validate(int input) {
		int menuCount = Category.values().length + 2;

		if (input < 0 || menuCount < input) {
			throw new IllegalArgumentException();
		}
	}
}
