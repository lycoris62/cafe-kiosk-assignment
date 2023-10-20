package app.command;

import java.util.List;

import app.io.console.Console;
import app.menu.Order;

public class OrderCommand extends Command {

	private final List<Order> cart;
	private final List<Order> salesRecord;
	private static int waitingNumber = 1;

	public OrderCommand(Console console, List<Order> cart, List<Order> salesRecord) {
		this.console = console;
		this.cart = cart;
		this.salesRecord = salesRecord;
	}

	@Override
	public void execute() {
		if (cart.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
			return;
		}

		int checkNumber = console.request();

		if (checkNumber == 2) {
			return;
		}

		System.out.println("주문이 완료되었습니다!\n");
		System.out.printf("""
						대기번호는 [ %d ] 번 입니다.
						(3초후 메뉴판으로 돌아갑니다.)
						""", waitingNumber++);

		salesRecord.addAll(cart);
		cart.clear();
		waitForThreeSeconds();
	}

	private void waitForThreeSeconds() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
	}
}
