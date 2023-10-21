package app.command.implement;

import app.command.Command;
import app.container.Cart;
import app.io.console.Console;

public class OrderCancelCommand extends Command {

	public OrderCancelCommand(Console console) {
		this.console = console;
	}

	@Override
	public void execute() {
		int checkNumber = console.request();
		if (checkNumber == 1) {
			Cart cart = Cart.getInstance();
			cart.clear();
			System.out.println("진행하던 주문이 취소되었습니다.\n");
		}
	}
}
