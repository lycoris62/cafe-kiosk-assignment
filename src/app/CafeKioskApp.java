package app;

import app.domain.Category;
import app.menu.MenuController;
import app.menu.MenuView;
import app.order.Cart;
import app.order.OrderController;
import app.order.OrderView;
import app.order.SalesRecord;

public final class CafeKioskApp {

	private static final MenuController menuController = new MenuController(new MenuView());
	private static final OrderController orderController = new OrderController(new OrderView(), new Cart(), new SalesRecord());

	private static final int SALES_RECORD_NUMBER = 0;
	private static final int MENU_START_NUMBER = 1;
	private static final int MENU_END_NUMBER = Category.size();
	private static final int ORDER_NUMBER = Category.size() + 1;
	private static final int ORDER_CANCEL_NUMBER = Category.size() + 2;

	private CafeKioskApp() {}

	public static void run() {
		while (true) {
			int menuNumber = menuController.getMenuNumber();

			if (menuNumber == SALES_RECORD_NUMBER) {
				orderController.showAllSalesRecord();
			} else if (MENU_START_NUMBER <= menuNumber && menuNumber <= MENU_END_NUMBER) {
				int productNumber = menuController.getProductNumber(menuNumber);
				orderController.putCart(menuNumber, productNumber);
			} else if (menuNumber == ORDER_NUMBER) {
				orderController.order();
			} else if (menuNumber == ORDER_CANCEL_NUMBER) {
				orderController.cancelOrder();
			}
		}
	}
}
