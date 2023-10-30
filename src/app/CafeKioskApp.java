package app;

import app.handler.Handler;
import app.handler.implement.OrderCancelHandler;
import app.handler.implement.OrderHandler;
import app.handler.implement.PurchaseHandler;
import app.handler.implement.SalesRecordHandler;
import app.menu.MenuController;
import app.menu.MenuView;
import app.order.Cart;
import app.order.OrderController;
import app.order.OrderView;
import app.order.SalesRecord;

public class CafeKioskApp {

	private static final MenuController menuController = new MenuController(new MenuView());
	private static final OrderController orderController = new OrderController(new OrderView(), new Cart(), new SalesRecord());

	private CafeKioskApp() {}

	public static void run() {
		while (true) {
			// WelcomeConsole welcomeConsole = new WelcomeConsole(new BaseConsole());
			// int menuNumber = welcomeConsole.request();
			//
			Handler rootHandler = settingHandler();
			// rootHandler.handle(menuNumber);

			// MenuController menuController = new MenuController(new MenuView());
			// OrderController orderController = new OrderController(new OrderView(), new Cart());
			int menuNumber = menuController.getMenuNumber();

			if (menuNumber == 0) {
				orderController.showAllSalesRecord();
			} else if (1 <= menuNumber && menuNumber <= 5) {
				int productNumber = menuController.getProductNumber(menuNumber);
				orderController.putCart(menuNumber, productNumber);
			} else if (menuNumber == 6) {
				orderController.order();
			} else if (menuNumber == 7) {
				orderController.cancelOrder();
			}
		}
	}

	private static Handler settingHandler() {
		Handler rootHandler = new SalesRecordHandler();
		rootHandler
			.setNext(new PurchaseHandler())
			.setNext(new OrderHandler())
			.setNext(new OrderCancelHandler());
		return rootHandler;
	}
}
