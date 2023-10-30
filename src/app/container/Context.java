package app.container;

import app.menu.MenuController;
import app.menu.MenuView;
import app.order.Cart;
import app.order.OrderController;
import app.order.OrderView;
import app.order.SalesRecord;

public final class Context {

	private Context() {}

	private static final MenuView menuView = new MenuView();
	private static final MenuController menuController = new MenuController(menuView);

	private static final OrderView orderView = new OrderView();
	private static final Cart cart = new Cart();
	private static final SalesRecord salesRecord = new SalesRecord();
	private static final OrderController orderController = new OrderController(orderView, cart, salesRecord);

	public static MenuController getMenuController() {
		return menuController;
	}

	public static OrderController getOrderController() {
		return orderController;
	}
}
