package app.io.console;

import java.util.List;

import app.io.console.decorator.ItemMenu;
import app.io.console.decorator.OrderCancel;
import app.io.console.decorator.OrderProcess;
import app.io.console.decorator.Purchase;
import app.io.console.decorator.Record;
import app.io.console.decorator.Welcome;
import app.io.input.Input;
import app.menu.Order;

public class ConsoleFactory {

	private final Console baseConsole;

	public ConsoleFactory(Input input) {
		this.baseConsole = new BaseConsole(input);
	}

	public Console getWelcome() {
		return new Welcome(baseConsole);
	}

	public Console getRecord(List<Order> salesRecord) {
		return new Record(baseConsole, salesRecord);
	}

	public Console getOrderCancel() {
		return new OrderCancel(baseConsole);
	}

	public Console getOrderProcess(List<Order> cart) {
		return new OrderProcess(baseConsole, cart);
	}

	public Console getCategoryMenu(int categoryNumber) {
		return new ItemMenu(baseConsole, categoryNumber);
	}

	public Console getPurchase(int categoryNumber, int itemNumber) {
		return new Purchase(baseConsole, categoryNumber, itemNumber);
	}
}
