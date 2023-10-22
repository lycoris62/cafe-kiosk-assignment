package app.container;

import java.util.ArrayList;
import java.util.List;

import app.menu.Item;
import app.menu.Order;

public class SalesRecord {

	private final List<Order> salesRecord = new ArrayList<>();
	private static SalesRecord INSTANCE;

	private SalesRecord() {
	}

	public static SalesRecord getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new SalesRecord();
		}
		return INSTANCE;
	}

	public void record(List<Order> orderList) {
		salesRecord.addAll(orderList);
	}

	public void showAllRecord() {
		System.out.println("\n[ 총 판매금액 현황 ]");
		System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n\n", getTotalPrice() / 1000.0);
		System.out.println("[ 총 판매상품 목록 현황 ]");
		System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
		showAllSalesRecord();
		System.out.println("\n1. 돌아가기");
	}

	private int getTotalPrice() {
		return salesRecord.stream()
			.mapToInt(order -> order.getItemList().get(0).getPrice())
			.sum();
	}

	private void showAllSalesRecord() {
		for (Order order : salesRecord) {
			for (Item item : order.getItemList()) {
				System.out.println("- " + item);
			}
		}
	}
}
