package app.command.implement;

import app.command.Command;
import app.container.Cart;

public class OrderCancelCommand extends Command {

	public OrderCancelCommand() {
		this.console = consoleFactory.getOrderCancel();
	}

	@Override
	public void execute() {
		int checkNumber = this.console.request();
		if (checkNumber == 1) {
			Cart cart = Cart.getInstance();
			cart.clear();
			System.out.println("진행하던 주문이 취소되었습니다.\n");
		}
	}
}
