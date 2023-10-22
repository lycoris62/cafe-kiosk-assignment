package app.command.implement;

import app.command.Command;
import app.container.Cart;

public class OrderCancelCommand extends Command {

	private final int ORDER_CANCEL_AGREE_NUMBER = 1;

	public OrderCancelCommand() {
		this.console = consoleFactory.getOrderCancel();
	}

	@Override
	public void execute() {
		int checkNumber = this.console.request();
		checkOrderCancel(checkNumber);
	}

	private void checkOrderCancel(int checkNumber) {
		if (checkNumber == ORDER_CANCEL_AGREE_NUMBER) {
			putCart();
			System.out.println("진행하던 주문이 취소되었습니다.\n");
		}
	}

	private void putCart() {
		Cart cart = Cart.getInstance();
		cart.clear();
	}
}
