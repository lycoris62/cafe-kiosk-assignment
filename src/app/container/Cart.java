package app.container;

import java.util.ArrayList;
import java.util.List;

import app.menu.Item;
import app.menu.Order;

public class Cart {

	private final List<Order> cart = new ArrayList<>();
	private static Cart INSTANCE;

	private Cart() {}

	public static Cart getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Cart();
		}
		return INSTANCE;
	}

	public void put(Order order) {
		cart.add(order);
	}

	public void clear() {
		cart.clear();
	}

	public boolean isEmpty() {
		return cart.isEmpty();
	}

	public List<Order> getAllOrders() {
		return new ArrayList<>(cart);
	}

	public void showAllOrders() {
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
}
