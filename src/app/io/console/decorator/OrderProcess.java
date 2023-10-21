package app.io.console.decorator;

import app.container.Cart;
import app.io.console.Console;
import app.io.console.ConsoleDecorator;

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