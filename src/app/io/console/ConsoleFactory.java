package app.io.console;

import app.io.console.decorator.ItemMenu;
import app.io.console.decorator.OrderCancel;
import app.io.console.decorator.OrderProcess;
import app.io.console.decorator.Purchase;
import app.io.console.decorator.Record;
import app.io.console.decorator.Welcome;
import app.io.input.ScannerInput;

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
