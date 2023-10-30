package app.order;

import java.util.LinkedHashMap;
import java.util.Map;

import app.domain.Item;
import app.domain.Product;

public class OrderView {

	private static final String totalPriceFormat = """
			   
			[ Total ]
			W %.1f
			
			""";

	public void showAskingAddCartMessage(Product product) {
		System.out.println();
		System.out.println(product);
		System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
		System.out.println("1. 확인            2. 취소");
	}

	public void showAddSuccessMessage(String itemName) {
		System.out.println(itemName + " 가 장바구니에 추가되었습니다.");
	}

	public void showEmptyCartMessage() {
		System.out.println("장바구니가 비어있습니다.");
	}

	public void showAllItemsInCart(Cart cart) {
		System.out.println("아래와 같이 주문 하시겠습니까?\n");
		System.out.println("[ Orders ]");
		showItemWithCount(cart);
		System.out.printf(totalPriceFormat, getTotalPrice(cart) / 1000.0);
		System.out.println("1. 주문\t\t\t2. 메뉴판");
	}

	private void showItemWithCount(Cart cart) {
		Map<Item, Integer> itemCountMap = getItemCountMap(cart);
		itemCountMap.forEach((item, itemCount) -> System.out.println(item.toStringWithCount(itemCount)));
	}

	private Map<Item, Integer> getItemCountMap(Cart cart) {
		Map<Item, Integer> itemCountMap = new LinkedHashMap<>();
		cart.getAllItems()
			.forEach(item -> itemCountMap.compute(item, (kind, count) -> count == null ? 1 : count + 1));

		return itemCountMap;
	}

	private int getTotalPrice(Cart cart) {
		return cart.getAllItems()
			.stream()
			.mapToInt(Item::getPrice)
			.sum();
	}

	public void showOrderFinishMessage(int waitingNumber) {
		System.out.println("주문이 완료되었습니다!\n");
		System.out.printf("""
			대기번호는 [ %d ] 번 입니다.
			(3초후 메뉴판으로 돌아갑니다.)
			""", waitingNumber);
	}

	public void showOrderCancelMessage() {
		System.out.println("진행하던 주문을 취소하시겠습니까?");
		System.out.println("1. 확인\t\t\t2. 취소");
	}

	public void showOrderCancelSuccessMessage() {
		System.out.println("진행하던 주문이 취소되었습니다.\n");
	}

	public void showAllRecord(SalesRecord salesRecord) {
		System.out.println("\n[ 총 판매금액 현황 ]");
		System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n", getTotalPrice(salesRecord) / 1000.0);
		System.out.println("[ 총 판매상품 목록 현황 ]");
		System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
		showAllSalesRecord(salesRecord);
		System.out.println("\n1. 돌아가기");
	}

	private int getTotalPrice(SalesRecord salesRecord) {
		return salesRecord.getAllRecords()
			.stream()
			.mapToInt(Item::getPrice)
			.sum();
	}

	private void showAllSalesRecord(SalesRecord salesRecord) {
		salesRecord.getAllRecords()
			.stream()
			.map(record -> "- " + record)
			.forEach(System.out::println);
	}
}
