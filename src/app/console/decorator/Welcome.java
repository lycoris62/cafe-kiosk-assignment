package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.menu.Category;

public class Welcome extends ConsoleDecorator {

	private final String initMessage = """
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
				
		""";
	private final String titleFormat = "[ %s MENU ]\n";
	private final String mainFormat = "%d. %-20s | %s";

	public Welcome(Console console) {
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
		StringBuilder sb = new StringBuilder("\n");
		sb.append(initMessage);
		sb.append(String.format(titleFormat, "오십이도"));

		int sequence = 1;

		for (Category category : Category.values()) {
			sb.append(sequence++).append(". ")
				.append(category.toString())
				.append("\n");
		}

		sb.append("\n").append(String.format(titleFormat, "ORDER"));
		sb.append(String.format(mainFormat, sequence++, "Order", "장바구니를 확인 후 주문합니다."))
			.append("\n")
			.append(String.format(mainFormat, sequence, "Cancel", "진행중인 주문을 취소합니다."));

		System.out.println(sb);
	}

	private void validate(int input) {
		int menuCount = Category.values().length + 2;

		if (input < 0 || menuCount < input) {
			throw new IllegalArgumentException();
		}
	}
}
