package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.container.Cart;

public class OrderProcess extends ConsoleDecorator {

	public OrderProcess(Console console) {
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
		Cart cart = Cart.getInstance();
		cart.showAllOrders();
	}

	private void validate(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException();
		}
	}
}