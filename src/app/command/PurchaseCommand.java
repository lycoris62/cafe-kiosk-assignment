package app.command;

import java.util.List;

import app.io.console.decorator.ConsoleFactory;
import app.menu.Category;
import app.menu.CategoryMenu;
import app.menu.Item;
import app.menu.Order;

public class PurchaseCommand extends Command {

	private final int categoryNumber;
	private final ConsoleFactory consoleFactory;
	private final List<Order> cart;

	public PurchaseCommand(ConsoleFactory consoleFactory, int categoryNumber, List<Order> cart) {
		this.consoleFactory = consoleFactory;
		this.categoryNumber = categoryNumber;
		this.cart = cart;
	}

	@Override
	public void execute() {
		console = consoleFactory.getCategoryMenu(categoryNumber);
		int itemNumber = console.request();

		console = consoleFactory.getPurchase(categoryNumber, itemNumber);
		int purchaseNumber = console.request();

		if (purchaseNumber == 1) {
			CategoryMenu categoryMenu = Category.getCategoryItems(categoryNumber).get(itemNumber - 1);
			Item item = new Item(categoryMenu);
			Order order = new Order(List.of(item));

			System.out.println(order.getItemList().get(0).getName() + " 가 장바구니에 추가되었습니다.");

			cart.add(order);
		}
	}
}
