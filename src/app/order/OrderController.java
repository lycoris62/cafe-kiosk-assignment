package app.order;

import app.domain.Category;
import app.domain.Item;
import app.domain.Product;
import app.util.InputUtil;

/**
 * 주문 관련 요청을 처리하는 객체
 */
public class OrderController {

	private final Cart cart; // 장바구니
	private final SalesRecord salesRecord; // 총 판매 실적
	private final OrderView orderView; // 주문 관련 화면 담당
	private static int waitingNumber = 1; // 주문 번호

	private static final int PURCHASE_AGREE_NUMBER = 1;
	private static final int ORDER_CANCEL_NUMBER = 2;
	private static final int ORDER_CANCEL_AGREE_NUMBER = 1;

	public OrderController(OrderView orderView, Cart cart, SalesRecord salesRecord) {
		this.orderView = orderView;
		this.cart = cart;
		this.salesRecord = salesRecord;
	}

	/**
	 * 카테고리 번호와 상품 번호를 받아 장바구니에 추가하는 메서드.
	 * 구매 미동의 시 장바구니에 추가 안 함
	 *
	 * @param categoryNumber
	 * @param productNumber
	 */
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

	/**
	 * 주문 처리 메서드. 장바구니가 비거나 주문 취소 입력 시 주문 처리 안 함.
	 */
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

	/**
	 * 주문 취소 메서드.
	 * 주문 취소 동의를 입력해야 주문 취소.
	 */
	public void cancelOrder() {
		orderView.showOrderCancelMessage();

		int checkNumber = InputUtil.readOrderCancelCheckNumber();
		if (checkNumber == ORDER_CANCEL_AGREE_NUMBER) {
			cart.clear();
			orderView.showOrderCancelSuccessMessage();
		}
	}

	/**
	 * 총 판매 실적 출력 메서드.
	 * 1을 입력 받아야 메인 화면으로 돌아감.
	 */
	public void showAllSalesRecord() {
		orderView.showAllRecord(salesRecord);

		InputUtil.readReturnMenuCheckNumber();
	}
}
