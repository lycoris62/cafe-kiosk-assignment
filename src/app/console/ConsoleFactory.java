package app.console;

import app.console.decorator.ItemMenuConsole;
import app.console.decorator.OrderCancelConsole;
import app.console.decorator.OrderProcessConsole;
import app.console.decorator.PurchaseConsole;
import app.console.decorator.RecordConsole;
import app.console.decorator.WelcomeConsole;

public class ConsoleFactory {

	private static final Console baseConsole = new BaseConsole();

	public ConsoleFactory() {
	}

	public static Console getWelcome() {
		return new WelcomeConsole(baseConsole);
	}

	public static Console getRecord() {
		return new RecordConsole(baseConsole);
	}

	public static Console getOrderCancel() {
		return new OrderCancelConsole(baseConsole);
	}

	public static Console getOrderProcess() {
		return new OrderProcessConsole(baseConsole);
	}

	public static Console getCategoryMenu(int categoryNumber) {
		return new ItemMenuConsole(baseConsole, categoryNumber);
	}

	public static Console getPurchase(int categoryNumber, int itemNumber) {
		return new PurchaseConsole(baseConsole, categoryNumber, itemNumber);
	}
}
