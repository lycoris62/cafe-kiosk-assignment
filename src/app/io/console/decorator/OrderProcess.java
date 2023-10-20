package app.io.console.decorator;

import java.util.List;

import app.io.console.Console;
import app.io.console.ConsoleDecorator;
import app.menu.Item;
import app.menu.Order;

public class OrderProcess extends ConsoleDecorator {

	private final List<Order> cart;

	public OrderProcess(Console console, List<Order> cart) {
		super(console);
		this.cart = cart;
	}

	@Override
	public int request() {
		showMessage();
		int input = super.request();
		validate(input);

		return input;
	}

	private void showMessage() {
		int totalPrice = cart.stream()
			.mapToInt(order -> order.getItemList().get(0).getPrice())
			.sum();

		StringBuilder sb = new StringBuilder();
		sb.append("아래와 같이 주문 하시겠습니까?\n\n").append("[ Orders ]\n");
		for (Order order : cart) {
			for (Item item : order.getItemList()) {
				sb.append(item.toString()).append("\n");
			}
		}

		sb.append(String.format("""

			[ Total ]
			W %.1f

			""", totalPrice / 1000.0));

		sb.append("1. 주문\t\t\t2. 메뉴판");
		System.out.println(sb);
	}

	private void validate(int input) {
		if (input != 1 && input != 2) {
			throw new IllegalArgumentException();
		}
	}
}