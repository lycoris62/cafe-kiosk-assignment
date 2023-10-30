package app.order;

import app.domain.Category;
import app.domain.Item;
import app.domain.Product;
import app.util.InputUtil;

public class OrderController {

	private final Cart cart;
	private final SalesRecord salesRecord;
	private final OrderView orderView;
	private static int waitingNumber = 1;

	private static final int PURCHASE_AGREE_NUMBER = 1;
	private static final int ORDER_CANCEL_NUMBER = 2;
	private static final int ORDER_CANCEL_AGREE_NUMBER = 1;

	public OrderController(OrderView orderView, Cart cart, SalesRecord salesRecord) {
		this.orderView = orderView;
		this.cart = cart;
		this.salesRecord = salesRecord;
	}

	public void putCart(int categoryNumber, int productNumber) {
		Product product = Category.getItem(categoryNumber, productNumber);
		int checkNumber = getAddCartCheckNumber(product);

		if (checkNumber == PURCHASE_AGREE_NUMBER) {
			Item item = new Item(product);
			cart.add(item);
			orderView.showAddSuccessMessage(item.getName());
		}
	}

	private int getAddCartCheckNumber(Product product) {
		orderView.showAskingAddCartMessage(product);

		return InputUtil.readAddCartCheckNumber();
	}

	public void order() {
		if (cart.isEmpty()) {
			orderView.showEmptyCartMessage();
			return;
		}

		orderView.showAllItemsInCart(cart);
		int checkNumber = InputUtil.readOrderCheckNumber();

		if (checkNumber == ORDER_CANCEL_NUMBER) {
			return;
		}

		salesRecord.record(cart.getAllItems());
		cart.clear();
		orderView.showOrderFinishMessage(waitingNumber++);
		waitForThreeSeconds();
	}

	private void waitForThreeSeconds() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
	}

	public void cancelOrder() {
		orderView.showOrderCancelMessage();

		int checkNumber = InputUtil.readOrderCancelCheckNumber();
		if (checkNumber == ORDER_CANCEL_AGREE_NUMBER) {
			cart.clear();
			orderView.showOrderCancelSuccessMessage();
		}
	}

	public void showAllSalesRecord() {
		orderView.showAllRecord(salesRecord);

		InputUtil.readReturnMenuCheckNumber();
	}
}
