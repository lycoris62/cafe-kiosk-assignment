package app.container;

import java.util.ArrayList;
import java.util.List;

import app.menu.Item;
import app.menu.Order;

public class Cart {

	private final List<Order> cart = new ArrayList<>();
	private static Cart INSTANCE;
	private final String totalPriceFormat = """
			   
			[ Total ]
			W %.1f
			
			""";

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
		System.out.println("아래와 같이 주문 하시겠습니까?\n");
		System.out.println("[ Orders ]");
		showAllItemInCart();
		System.out.printf(totalPriceFormat, getTotalPrice() / 1000.0);
		System.out.println("1. 주문\t\t\t2. 메뉴판");
	}

	private void showAllItemInCart() {
		for (Order order : cart) {
			for (Item item : order.getItemList()) {
				System.out.println(item);
			}
		}
	}

	private int getTotalPrice() {
		return cart.stream()
			.mapToInt(order -> order.getItemList().get(0).getPrice())
			.sum();
	}
}
