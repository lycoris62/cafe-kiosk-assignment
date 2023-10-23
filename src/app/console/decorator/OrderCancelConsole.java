package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;

public class OrderCancelConsole extends ConsoleDecorator {

	public OrderCancelConsole(Console console) {
		super(console);
	}

	@Override
	public int request() {
		showMessage();
		int input = super.request();
		validate(input);

		return input;
	}

	private void showMessage() {
		System.out.println("진행하던 주문을 취소하시겠습니까?");
		System.out.println("1. 확인\t\t\t2. 취소");
	}

	private void validate(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException();
		}
	}
}
