package app.order;

import java.util.ArrayList;
import java.util.List;

import app.domain.Item;

/**
 * 총 판매 실적을 저장하는 객체
 */
public class SalesRecord {

	private final List<Item> salesRecord = new ArrayList<>();

	public void record(List<Item> orderList) {
		salesRecord.addAll(orderList);
	}

	public List<Item> getAllRecords() {
		return new ArrayList<>(salesRecord);
	}
}
