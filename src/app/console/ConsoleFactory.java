package app.console;

import app.console.decorator.Purchase;
import app.console.input.ScannerInput;
import app.console.decorator.ItemMenu;
import app.console.decorator.OrderCancel;
import app.console.decorator.OrderProcess;
import app.console.decorator.Record;
import app.console.decorator.Welcome;

public class ConsoleFactory {

	private final Console baseConsole;

	public ConsoleFactory() {
		this.baseConsole = new BaseConsole(new ScannerInput());
	}

	public Console getWelcome() {
		return new Welcome(baseConsole);
	}

	public Console getRecord() {
		return new Record(baseConsole);
	}

	public Console getOrderCancel() {
		return new OrderCancel(baseConsole);
	}

	public Console getOrderProcess() {
		return new OrderProcess(baseConsole);
	}

	public Console getCategoryMenu(int categoryNumber) {
		return new ItemMenu(baseConsole, categoryNumber);
	}

	public Console getPurchase(int categoryNumber, int itemNumber) {
		return new Purchase(baseConsole, categoryNumber, itemNumber);
	}
}
