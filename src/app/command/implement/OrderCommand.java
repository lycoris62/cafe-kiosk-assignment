package app.command.implement;

import app.command.Command;
import app.container.Cart;
import app.container.SalesRecord;

public class OrderCommand extends Command {

	private static int waitingNumber = 1;
	private final int ORDER_CANCEL_NUMBER = 2;

	public OrderCommand() {
		this.console = consoleFactory.getOrderProcess();
	}

	@Override
	public void execute() {
		Cart cart = Cart.getInstance();
		SalesRecord salesRecord = SalesRecord.getInstance();

		if (isCartEmpty(cart)) {
			return;
		}
		if (confirmOrderCancel()) {
			return;
		}

		orderFinishProcess(salesRecord, cart);
	}

	private boolean confirmOrderCancel() {
		int checkNumber = console.request();
		return checkNumber == ORDER_CANCEL_NUMBER;
	}

	private boolean isCartEmpty(Cart cart) {
		if (cart.isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
			return true;
		}
		return false;
	}

	private void showOrderFinishMessage() {
		System.out.println("주문이 완료되었습니다!\n");
		System.out.printf("""
						대기번호는 [ %d ] 번 입니다.
						(3초후 메뉴판으로 돌아갑니다.)
						""", waitingNumber++);
	}

	private void orderFinishProcess(SalesRecord salesRecord, Cart cart) {
		showOrderFinishMessage();
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
