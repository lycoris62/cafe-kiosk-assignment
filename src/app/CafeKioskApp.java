package app;

import app.console.BaseConsole;
import app.console.decorator.WelcomeConsole;
import app.handler.Handler;
import app.handler.implement.OrderCancelHandler;
import app.handler.implement.OrderHandler;
import app.handler.implement.PurchaseHandler;
import app.handler.implement.SalesRecordHandler;

public class CafeKioskApp {

	private CafeKioskApp() {}

	public static void run() {
		while (true) {
			WelcomeConsole welcomeConsole = new WelcomeConsole(new BaseConsole());
			int menuNumber = welcomeConsole.request();

			Handler rootHandler = settingHandler();
			rootHandler.handle(menuNumber);
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
