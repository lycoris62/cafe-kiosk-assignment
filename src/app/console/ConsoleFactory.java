package app.console;

import app.console.decorator.ItemMenu;
import app.console.decorator.OrderCancel;
import app.console.decorator.OrderProcess;
import app.console.decorator.Purchase;
import app.console.decorator.Record;
import app.console.decorator.Welcome;

public class ConsoleFactory {

	private static final Console baseConsole = new BaseConsole();

	public ConsoleFactory() {
	}

	public static Console getWelcome() {
		return new Welcome(baseConsole);
	}

	public static Console getRecord() {
		return new Record(baseConsole);
	}

	public static Console getOrderCancel() {
		return new OrderCancel(baseConsole);
	}

	public static Console getOrderProcess() {
		return new OrderProcess(baseConsole);
	}

	public static Console getCategoryMenu(int categoryNumber) {
		return new ItemMenu(baseConsole, categoryNumber);
	}

	public static Console getPurchase(int categoryNumber, int itemNumber) {
		return new Purchase(baseConsole, categoryNumber, itemNumber);
	}
}
