package app.command.implement;

import app.command.Command;
import app.container.Cart;
import app.container.SalesRecord;

public class OrderCommand extends Command {

	private static int waitingNumber = 1;

	public OrderCommand() {
		this.console = consoleFactory.getOrderProcess();
	}

	@Override
	public void execute() {
		Cart cart = Cart.getInstance();
		SalesRecord salesRecord = SalesRecord.getInstance();

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

		salesRecord.record(cart.getAllOrders());
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
