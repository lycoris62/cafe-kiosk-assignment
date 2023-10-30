package app.command.implement;

import app.command.Command;
import app.console.Console;
import app.console.ConsoleFactory;
import app.container.Cart;

public class OrderCancelCommand extends Command {

	private static final int ORDER_CANCEL_AGREE_NUMBER = 1;

	public OrderCancelCommand() {
	}

	@Override
	public void execute() {
		Console console = ConsoleFactory.getOrderCancel();
		int checkNumber = console.request();
		checkOrderCancel(checkNumber);
	}

	private void checkOrderCancel(int checkNumber) {
		if (checkNumber == ORDER_CANCEL_AGREE_NUMBER) {
			clearCart();
			System.out.println("진행하던 주문이 취소되었습니다.\n");
		}
	}

	private void clearCart() {
		Cart cart = Cart.getInstance();
		cart.clear();
	}
}
