package app.command.implement;

import java.util.List;

import app.command.Command;
import app.io.console.Console;
import app.menu.Order;

public class OrderCancelCommand extends Command {

	private final List<Order> cart;

	public OrderCancelCommand(Console console, List<Order> cart) {
		this.console = console;
		this.cart = cart;
	}

	@Override
	public void execute() {
		int checkNumber = console.request();
		if (checkNumber == 1) {
			cart.clear();
			System.out.println("진행하던 주문이 취소되었습니다.\n");
		}
	}
}
