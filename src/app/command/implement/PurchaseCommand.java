package app.command.implement;

import java.util.List;

import app.command.Command;
import app.console.Console;
import app.console.ConsoleFactory;
import app.container.Cart;
import app.menu.Category;
import app.menu.Product;
import app.menu.Item;
import app.menu.Order;

public class PurchaseCommand extends Command {

	private final int categoryNumber;
	private final int PURCHASE_AGREE_NUMBER = 1;

	public PurchaseCommand(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Override
	public void execute() {
		int itemNumber = getItemNumber();
		int purchaseNumber = getCheckNumber(itemNumber);
		checkPurchase(purchaseNumber, itemNumber);
	}

	private void checkPurchase(int purchaseNumber, int itemNumber) {
		if (purchaseNumber == PURCHASE_AGREE_NUMBER) {
			Order order = orderProcess(itemNumber);
			putCart(order);
		}
	}

	private void showAllOrderedItem(Order order) {
		for (Item item : order.getItemList()) {
			System.out.println(item.getName() + " 가 장바구니에 추가되었습니다.");
		}
	}

	private int getItemNumber() {
		Console console = ConsoleFactory.getCategoryMenu(categoryNumber);
		return console.request();
	}

	private int getCheckNumber(int itemNumber) {
		Console console = ConsoleFactory.getPurchase(categoryNumber, itemNumber);
		return console.request();
	}

	private Order createOrder(int itemNumber) {
		Product product = Category.getItem(categoryNumber, itemNumber);
		Item item = new Item(product);
		return new Order(List.of(item));
	}

	private Order orderProcess(int itemNumber) {
		Order order = createOrder(itemNumber);
		showAllOrderedItem(order);
		return order;
	}

	private void putCart(Order order) {
		Cart cart = Cart.getInstance();
		cart.put(order);
	}
}
